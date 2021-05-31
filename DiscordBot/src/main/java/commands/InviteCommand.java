package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;


public class InviteCommand extends Command {

    public InviteCommand() {

        this.name="invite";
        super.category = new Category("Members");
        this.help="Gives an invite link to user";
    }

    @Override
    protected void execute(CommandEvent e) {
        if (e.getArgs().equalsIgnoreCase("")) {
            int timeString = 3600;
            String message = e.getMessage().getContentRaw();
            if(message.contains("-invite") && message.length()==7) {

                e.getChannel().sendMessage("Hey " + e.getAuthor().getName() + "! You want to invite someone? Cool!").queue();
                e.getChannel().sendMessage("Give them this invite link: " + e.getGuild().getDefaultChannel().createInvite().setMaxAge(timeString).complete().getUrl()).queue();
                e.getChannel().sendMessage("This invite expires in: " + timeString / 60 + " minutes!").queue();

            }

        }
    }
}
