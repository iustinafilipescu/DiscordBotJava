package RSS;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;



import com.rometools.fetcher.FeedFetcher;
import com.rometools.fetcher.FetcherException;
import com.rometools.fetcher.impl.HttpURLFeedFetcher;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WebRSS extends Command
{

    public WebRSS()
    {

        this.name = "Web";
        this.aliases = new String[]{"web","webdev","web development","Web Development","WebDev"};
        this.help = "shows most 5 recent Web Development related news";
    }

    @Override
    protected void execute(CommandEvent event)
    {
        FeedFetcher fetcher = new HttpURLFeedFetcher();
        try {
            SyndFeed feed=fetcher.retrieveFeed(new URL("https://www.smashingmagazine.com/feed"));
            int count=5;
            for(Object o: feed.getEntries())
            {
                SyndEntry entry = (SyndEntry) o;
                EmbedBuilder eb = new EmbedBuilder();
                eb.setColor(Color.RED);
                eb.setAuthor(event.getGuild().getName());
                eb.setThumbnail("https://seo-trench.com/wp-content/uploads/2019/11/12-Websites-You-Should-Check-Out-to-Learn-Web-Development-Fast.png");
                eb.addField("Title: ", entry.getTitle(), true);
                eb.addField("Link: ", entry.getLink(), true);
                eb.setDescription("Topic: " + "Web Development");

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