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
        super.category = new Category("Learning Java");
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        EmbedBuilder eb = new EmbedBuilder();
        EmbedBuilder eb1 = new EmbedBuilder();
        EmbedBuilder eb2 = new EmbedBuilder();
        eb.setColor(Color.RED);
        eb.setAuthor(commandEvent.getGuild().getName());
        eb1.setColor(Color.RED);
        eb1.setAuthor(commandEvent.getGuild().getName());
        eb2.setColor(Color.RED);
        eb2.setAuthor(commandEvent.getGuild().getName());

        eb.setThumbnail("https://greenlogic.com.au/wp-content/uploads/2019/07/java_logo-1200x700.png");
        eb.setTitle("Java Questions & Answers");
        eb1.setThumbnail("https://greenlogic.com.au/wp-content/uploads/2019/07/java_logo-1200x700.png");
        eb1.setTitle("Java Questions & Answers");
        eb2.setThumbnail("https://greenlogic.com.au/wp-content/uploads/2019/07/java_logo-1200x700.png");
        eb2.setTitle("Java Questions & Answers");
        eb.addField("How to ask the bot: ","Choose one of these questions using the command -q {number}",false);
        eb1.addField("How to ask the bot: ","Choose one of these questions using the command -q {number}",false);
        eb2.addField("How to ask the bot: ","Choose one of these questions using the command -q {number}",false);
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
        eb1.addField("11. ","Which are the stages of creating a GUI application?",false);
        eb1.addField("12. ","What is JComponent?",false);
        eb1.addField("13. ","What is JavaFX?",false);
        eb1.addField("14. ","When you should use the Runnable interface?",false);
        eb1.addField("15. ","How is used the volatile keyword?",false);
        eb1.addField("16. ","What is JDBC?",false);
        eb1.addField("17. ","What is a connection?",false);
        eb1.addField("18. ","In what consists object/relational mapping specifications for managing relational data in Java applications?",false);
        eb1.addField("19. ","What is a protocol?",false);
        eb1.addField("20. ","What is a proxy?",false);
        eb2.addField("21. ","Which are the common name services operations?",false);
        eb2.addField("22. ","What are data and functionality and how are they accessed?",false);
        eb2.addField("23. ","Which are the HTTP methods?",false);
        eb2.addField("24. ","What is Thymeleaf?",false);
        eb2.addField("25. ","When are classes are introduced into the Java environment?",false);
        eb2.addField("26. ","Why is CLASSPATH environment variable important?",false);
        eb2.addField("27. ","What is URLClassLoader?",false);
        eb2.addField("28. ","For what are annotations used?",false);
        eb2.addField("29. ","What is Internationalization?",false);
        eb2.addField("30. ","What is NumberFormat?",false);


        //Rares
        commandEvent.getChannel().sendMessage(eb.build()).queue();
        commandEvent.getChannel().sendMessage(eb1.build()).queue();
        commandEvent.getChannel().sendMessage(eb2.build()).queue();




    }
}
