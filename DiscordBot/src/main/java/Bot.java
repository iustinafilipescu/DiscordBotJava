import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import commands.HelloCommand;
import commands.ImageCommand;
import commands.InviteCommand;
import commands.ServerInfo;
import events.UserInfoCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Bot {
    public static void main(String[] args) throws LoginException {
        JDA jda =  JDABuilder.createDefault("ODM2ODkzMTkxODQ3NjczOTMy.YIknhQ.9_WoCxhmu0nT3-JNTDDi-dWPQks").build();


        jda.addEventListener(new UserInfoCommand());

        CommandClientBuilder builder = new CommandClientBuilder();
       builder.setOwnerId("836893191847673932");
        builder.setPrefix("-");
        builder.setHelpWord("helpme");
        builder.addCommand(new ServerInfo());
        builder.addCommand(new HelloCommand());
        builder.addCommand(new InviteCommand());
        builder.addCommand(new ImageCommand());

        CommandClient client =builder.build();

        jda.addEventListener(client);

    }
}
