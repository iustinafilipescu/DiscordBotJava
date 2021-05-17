package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class HelloCommand extends Command {

    public HelloCommand() {

        this.name="hello";

        this.help="Says hello to the user";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        if (commandEvent.getArgs().equalsIgnoreCase("")) {
            commandEvent.reply("Hello " + commandEvent.getMember().getUser().getName() + " !");
        }
    }
}
