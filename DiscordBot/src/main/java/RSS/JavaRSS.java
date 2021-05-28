package RSS;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;


import java.awt.*;
import java.io.IOException;
import java.net.URL;

import com.rometools.fetcher.FeedFetcher;
import com.rometools.fetcher.FetcherException;
import com.rometools.fetcher.impl.HttpURLFeedFetcher;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import net.dv8tion.jda.api.EmbedBuilder;

public class JavaRSS extends Command
{

    public JavaRSS()
    {

        this.name = "java";
        this.aliases = new String[]{"Java","JAVA"};
        this.help = "shows most 5 recent java related news";
    }

    @Override
    protected void execute(CommandEvent event)
    {
        FeedFetcher fetcher = new HttpURLFeedFetcher();
        try {
            SyndFeed feed=fetcher.retrieveFeed(new URL("https://www.infoworld.com/category/java/index.rss"));
                int count=5;
            for(Object o: feed.getEntries())
            {
                SyndEntry entry = (SyndEntry) o;
                EmbedBuilder eb = new EmbedBuilder();
                eb.setColor(Color.RED);
                eb.setAuthor(event.getGuild().getName());
                eb.setThumbnail("https://cdn.vox-cdn.com/thumbor/RDHsHveVmCuRNSihyeWC0GAulH0=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/12797069/java_logo_640.1419968352.jpg");
                eb.addField("Title: ", entry.getTitle(), true);
                eb.addField("Link: ", entry.getLink(), true);
                eb.setDescription("Topic: " + "Java");

                event.getChannel().sendMessage(eb.build()).queue();
                count--;
                if(count==0)
                    break;

            }
            feed.getTitle();
        feed.getLink();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (FeedException e) {
            e.printStackTrace();
        } catch (FetcherException e) {
            e.printStackTrace();
        }




    }

}