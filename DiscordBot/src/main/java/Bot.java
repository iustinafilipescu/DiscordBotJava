import events.HelloEvent;
import events.InviteCommand;
import events.UserInfoCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Bot {
    public static void main(String[] args) throws LoginException {
        JDA jda =  JDABuilder.createDefault("ODM2ODkzMTkxODQ3NjczOTMy.YIknhQ.9_WoCxhmu0nT3-JNTDDi-dWPQks").build();

        jda.addEventListener(new HelloEvent());
        jda.addEventListener(new InviteCommand());
        jda.addEventListener(new UserInfoCommand());

    }
}
