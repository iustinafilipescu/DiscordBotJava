import rss.*;
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import commands.*;

import music.JoinCommand;
import music.PlayCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Bot {
    public static void main(String[] args) throws LoginException {
        JDA jda =  JDABuilder.createDefault("ODM2ODkzMTkxODQ3NjczOTMy.YIknhQ.9_WoCxhmu0nT3-JNTDDi-dWPQks").build();



        jda.addEventListener(new MemeCommand());

        EventWaiter waiter = new EventWaiter();

        CommandClientBuilder builder = new CommandClientBuilder();
       builder.setOwnerId("836893191847673932");
        builder.setPrefix("-");
        builder.setHelpWord("helpme");
        builder.addCommand(new HelloCommand(waiter));
        builder.addCommand(new InviteCommand());
        builder.addCommand(new ImageCommand());
        builder.addCommand(new ServerInfo());
        builder.addCommand(new UserInfo(waiter));
        builder.addCommand(new JavaRSS());
        builder.addCommand(new PythonRSS());
        builder.addCommand(new CloudComputingRSS());

        builder.addCommand(new GameDevRSS());
        builder.addCommand(new iOSRSS());
        builder.addCommand(new ProgrammingRSS());
        builder.addCommand(new SoftEngRSS());
       builder.addCommand(new WebRSS());

       builder.addCommand(new JoinCommand());
       builder.addCommand(new PlayCommand());

       builder.addCommand(new ShowQuestions());
        builder.addCommand(new QuestionCommand());

        CommandClient client =builder.build();

        jda.addEventListener(client);
        jda.addEventListener(waiter);
    }
}
