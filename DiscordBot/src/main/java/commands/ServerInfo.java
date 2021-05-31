package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class ServerInfo extends Command {

    public ServerInfo() {
        this.name="serverinfo";
        this.aliases=new String[]{"server"};
        this.help="Gives information about the server";
        super.category = new Category("About server and users");

    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        if (commandEvent.getArgs().equalsIgnoreCase("")) {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(Color.RED);
            eb.setAuthor(commandEvent.getGuild().getName());
            eb.setThumbnail("https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/147573378/original/4e1e7dbfb6bcf24d2c7d0ad51eef1f2ea366d6a2/design-and-help-with-discord-server.png");
            eb.addField("Server Owner: ", commandEvent.getGuild().getOwner().getEffectiveName(), true);
            eb.addField("Member Count:", Integer.toString(commandEvent.getGuild().getMemberCount()), true);
            eb.setDescription(" **Invite Link:** \n" + "https://discord.gg/aX6YT5c");


            commandEvent.getChannel().sendMessage(eb.build()).queue();

        }
    }
}
