package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.json.JSONArray;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;
import javax.annotation.Nonnull;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.URL;


public class MemeCommand  extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event)
    {
        String[] args= event.getMessage().getContentRaw().split(" ");
        JSONParser parser=new JSONParser();
        String postLink="";
        String title="";
        String url="";

        if(args[0].equalsIgnoreCase("-meme"))
        {
            try {
                URL memeURL= new URL("https://meme-api.herokuapp.com/gimme");
                BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(memeURL.openConnection().getInputStream()));

                String lines;

                while((lines = bufferedReader.readLine())!=null)
                {
                    JSONArray array =new JSONArray();
                    array.put(parser.parse(lines));

                    for(Object o : array)
                    {
                        JSONObject jsonObject = (JSONObject) o;
                        postLink=(String) jsonObject.get("postlink");
                        title=(String) jsonObject.get("title");
                        url=(String) jsonObject.get("url");
                    }
                }
                bufferedReader.close();

                event.getMessage().delete().queue();
                EmbedBuilder builder=new EmbedBuilder().setTitle(title, postLink).setImage(url).setColor(Color.ORANGE);
                event.getChannel().sendMessage(builder.build()).queue();
            } catch (IOException | ParseException e) {
                event.getChannel().sendMessage("Something went wrong").queue();
                e.printStackTrace();
            }

        }
    }
}
