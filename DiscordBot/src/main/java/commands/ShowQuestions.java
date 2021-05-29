package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class ShowQuestions extends Command {

    public ShowQuestions() {
        this.name = "JavaQ&A";
        this.aliases = new String[]{"questions","javaq","qa"};
        this.help = "shows available java questions";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.RED);
        eb.setAuthor(commandEvent.getGuild().getName());

        eb.setThumbnail("https://greenlogic.com.au/wp-content/uploads/2019/07/java_logo-1200x700.png");
        eb.setTitle("Java Questions & Answers");
        eb.addField("How to ask the bot: ","Choose one of these questions using the command -q {number}",false);
        eb.addField("E.g. ","the command -q 1 will give the answer for the question number 1",false);
        eb.addField("1. ", "What are Java Platforms ? ", false);
        eb.addField("2. ","How do you test the equality between the values of two variables?",false);
        eb.addField("3. ","What is the Object Class?",false);
        eb.addField("4. ","What is the default access modifier?",false);
        eb.addField("5. ","How can you build a class so that it implements an interface but does not provide implementation for the methods in that interface?",false);
        eb.addField("6. ","What can we do if we want to add a method in an interface that is implemented by many classes without affecting those classes?",false);
        eb.addField("7. ","What can we do if we have a collection of items and want to send it as an argument by reference to another method, but we want to make sure that method does not change the content of the collection?",false);
        eb.addField("8. ","What is a stream?",false);
        eb.addField("9. ","When is the  finally (block) executed?",false);
        eb.addField("10. ","What is a Decorator?",false);
        //Rares
        commandEvent.getChannel().sendMessage(eb.build()).queue();




    }
}
