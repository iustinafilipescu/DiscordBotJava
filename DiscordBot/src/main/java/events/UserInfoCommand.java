package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserInfoCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent e) {
        //Current date and time, used for footer on embededbuilder
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String[] message = e.getMessage().getContentRaw().split(" ");
        if (message.length == 1 && message[0].equalsIgnoreCase("-user")){
            e.getChannel().sendMessage("To get a users info, type -user [name]").queue(); //how to use command
        }else if(message.length > 1 && message[0].equalsIgnoreCase("-user")){
            String userName="";
            if(message.length>2) {
               userName = message[1] + " " + message[2];
            }else if(message.length==2) {
                userName = message[1];
            }
            User user = e.getGuild().getMembersByName(userName, true).get(0).getUser(); //Gets user as object so we can grab info from it for embed
            String avatar = e.getGuild().getMembersByName(userName, true).get(0).getUser().getAvatarUrl(); //gets url of user avatar so we can put in embed
            EmbedBuilder avatarEmbed = new EmbedBuilder(); //Creates the embed.
            //Sets the contents of the embed
            avatarEmbed.setTitle(userName + "'s Info:", e.getGuild().getIconUrl());
            avatarEmbed.setColor(Color.GREEN);
            avatarEmbed.addField("Name", user.getName(), true);
            avatarEmbed.addField("Online Status", e.getGuild().getMembersByName(userName, true).get(0).getOnlineStatus().toString(), true);
            avatarEmbed.addField("Avatar: ", "The Avatar is below, " + e.getMember().getAsMention(), true);
            avatarEmbed.setImage(avatar);
            avatarEmbed.setFooter("Request made at " + formatter.format(date), e.getGuild().getIconUrl());
            //
            e.getChannel().sendMessage(avatarEmbed.build()).queue(); //Send the embed as a message
        }


    }
}
