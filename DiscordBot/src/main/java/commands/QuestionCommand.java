package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class QuestionCommand extends Command {

    public QuestionCommand() {
        this.name = "q";
        this.help = "reply to the questions";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        String message = commandEvent.getMessage().getContentRaw();
        if (message.equalsIgnoreCase("-q 1"))
        {
            commandEvent.reply("Java Platform is a collection of programs that help programmers to develop and run Java programming applications efficiently. It includes an execution engine, a compiler, and a set of libraries in it. It is a set of computer software and specifications." +
                    "There are four different types of Java programing language platforms:\n" +
                    "\n" +
                    "1. Java Platform, Standard Edition (Java SE): used for Desktop applications, applets, Java Web Start,\n" +
                    "JavaFX.\n" +
                    "\n" +
                    "2. Java Platform, Enterprise Edition (Java EE):used for Complex, distributed, large scale, applications;\n" +
                    "server-side components, Web Services, etc..\n" +
                    "\n" +
                    "3. Java Programming Language Platform, Micro Edition (Java ME): used for Programming embedded systems, mobile\n" +
                    "devices, TVs, GPSs, etc.\n" +
                    "\n" +
                    "4. Java Card.");
        }
        if (message.equalsIgnoreCase("-q 2"))
        {
            commandEvent.reply("For the equality test the equals() function is used. The == sign only checks the equality between the memory addresses of the variables.");
        }
        if (message.equalsIgnoreCase("-q 3"))
        {
            commandEvent.reply("Object is the root of the class hierarchy.\n" +
                    "Every class has Object as a superclass.\n" +
                    "All objects, including arrays, implement the methods of this class.");
        }
        if (message.equalsIgnoreCase("-q 4"))
        {
            commandEvent.reply("If a class has no modifier (the default), it is visible only within its own package.");
        }
        if (message.equalsIgnoreCase("-q 5"))
        {
            commandEvent.reply("We have to make that class abstract because abstract classes don't instantiate.");
        }
        if (message.equalsIgnoreCase("-q 6"))
        {
            commandEvent.reply(" We can create a new interface, extending the old one or we can use default methods\n");
        }
        if (message.equalsIgnoreCase("-q 7"))
        {
            commandEvent.reply("We do not give the memory address of the collection but we give the address of a proxy (design pattern) using unmodifiable.");
        }
        if (message.equalsIgnoreCase("-q 8"))
        {
            commandEvent.reply("A stream is a sequence of elements supporting sequential and parallel aggregate operations.");
        }
        if (message.equalsIgnoreCase("-q 9"))
        {
            commandEvent.reply("The finally block always executes when the try block exits. This ensures that the finally block is executed even if an unexpected exception occurs.");
        }
        if (message.equalsIgnoreCase("-q 10"))
        {
            commandEvent.reply("Decorator streams “know” to communicate with another stream (primitive or not) in order to process the raw data and offer specialized methods.");
        }

    }
}
