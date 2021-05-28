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
import java.net.URL;

public class GameDevRSS extends Command
{

    public GameDevRSS()
    {

        this.name = "GameDev";
        this.aliases = new String[]{"game dev","gamedev","game development","gamedevelopment","GameDevelopment"};
        this.help = "shows most 5 recent Game Development related news";
    }

    @Override
    protected void execute(CommandEvent event)
    {
        FeedFetcher fetcher = new HttpURLFeedFetcher();
        try {
            SyndFeed feed=fetcher.retrieveFeed(new URL("http://feeds.feedburner.com/GamasutraFeatureArticles/"));
            int count=5;
            for(Object o: feed.getEntries())
            {
                SyndEntry entry = (SyndEntry) o;
                EmbedBuilder eb = new EmbedBuilder();
                eb.setColor(Color.RED);
                eb.setAuthor(event.getGuild().getName());
                eb.setThumbnail("https://cdn-images-1.medium.com/max/2600/1*jMDG7pTIaVeP5bQnE1RuXg.png");
                eb.addField("Title: ", entry.getTitle(), true);
                eb.addField("Link: ", entry.getLink(), true);
                eb.setDescription("Topic: " + "Game Development");

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