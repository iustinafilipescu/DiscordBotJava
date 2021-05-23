package commands;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UserInfo extends Command {

    private final EventWaiter waiter;

    public UserInfo(EventWaiter waiter){
        super.name = "user-info";
        super.help = "Get some information about a user";
        super.aliases = new String[]{"userinfo"};
        super.category = new Category("Members");
        super.cooldown = 10;
        super.arguments = "[name]";
        this.waiter = waiter;
    }

    @Override
    protected void execute(CommandEvent event) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        event.reply("Ok! Now, give me the name of a user. Like this @name");

        waiter.waitForEvent(GuildMessageReceivedEvent.class, e -> e.getAuthor().equals(event.getAuthor()) && e.getChannel().equals(event.getChannel()), e -> {
            //First argument is the event we are waiting for. Second is the condition that is checked when the event is triggered. Third is the code that will be run with the event and condition is fulfilled.
            try{
                Member name = e.getMessage().getMentionedMembers().get(0); //This time we grab the name from the waiter event because thats where we are getting the name from
                EmbedBuilder eb = new EmbedBuilder()
                        .setColor(Color.magenta)
                        .setThumbnail("http://pixelartmaker.com/art/1f41a07add48569.png")
                        .setAuthor("Information on " + name.getUser().getName(), "http://www.google.com", name.getUser().getAvatarUrl())
                        .setDescription(name.getUser().getName() + " joined on " + name.getTimeJoined().format(fmt) + " :clock: ")
                        .addField("Status:", name.getOnlineStatus().toString(), true)
                        .addField("Roles:", getRolesAsString(name.getRoles()), true)
                        .addField("Nickname: ", name.getNickname() == null ? "No Nickname" : name.getNickname(), true);
                event.reply(eb.build());
                event.reply(event.getAuthor().getAsMention() + " there you go");
            }catch (IndexOutOfBoundsException ex){
                System.out.println("Exception Occured");
                event.reply("You need to provide the name as a mention.");
            }
        }, 30, TimeUnit.SECONDS, () -> event.reply("You did not give me a name to search. Try again.")); //Last 3 arguments specify how long to wait for the event and what to do if they never respond
    }

    //Get roles for the user
    private String getRolesAsString(List rolesList){
        String roles;
        if (!rolesList.isEmpty()){
            Role tempRole = (Role) rolesList.get(0);
            roles = tempRole.getName();
            for (int i = 1; i < rolesList.size(); i++){
                tempRole = (Role) rolesList.get(i);
                roles = roles + ", " + tempRole.getName();
            }
        }else{
            roles = "No Roles";
        }
        return roles;
    }
}