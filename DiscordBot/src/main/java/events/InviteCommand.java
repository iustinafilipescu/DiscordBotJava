package events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class InviteCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent e) {
        int timeString = 3600;
        String[] message = e.getMessage().getContentRaw().split(" ");
        if (message[0].equalsIgnoreCase("-invite") && message.length == 1) {
            e.getChannel().sendMessage("To use -invite do: -invite create").queue();
        } else if (message.length >= 2 && message[0].equalsIgnoreCase("-invite") && message[1].equalsIgnoreCase("create")) {
            e.getChannel().sendMessage("Hey " + e.getAuthor().getName() + "! You want to invite someone? Cool!").queue();
            e.getChannel().sendMessage("Give them this invite link: " + e.getChannel().createInvite().setMaxAge(timeString).complete().getUrl()).queue();
            e.getChannel().sendMessage("This invite expires in: " + timeString / 60 + " minutes!").queue();
        }
    }
}
