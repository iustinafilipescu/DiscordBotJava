package events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HelloEvent extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        String messageSent=event.getMessage().getContentRaw();
        if(messageSent.equalsIgnoreCase("-hello") && !event.getMember().getUser().isBot())
        {
            event.getChannel().sendMessage("Hello "+ event.getMember().getUser().getName()+" !").queue();
        }
    }
}
