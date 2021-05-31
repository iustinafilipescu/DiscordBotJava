package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class QuestionCommand extends Command {

    public QuestionCommand() {
        this.name = "q";
        this.help = "reply to the questions";
        super.category = new Category("Learning Java");
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
        if (message.equalsIgnoreCase("-q 11")){
            commandEvent.reply("1.Design\n2.Functionality\n3.Considertions");
        }
        if (message.equalsIgnoreCase("-q 12")){
            commandEvent.reply("JComponent is the base class for all Swing components, except top-level containers: JFrame, JDialog, JApplet. ");
        }
        if (message.equalsIgnoreCase("-q 13")){
            commandEvent.reply("A set of graphics and media packages that enables developers to design, create, test, debug, and deploy rich client applications.");
        }
        if (message.equalsIgnoreCase("-q 14")){
            commandEvent.reply("In most cases, the Runnable interface should be used if you  are only planning to override the run() method and no other Thread methods.");
        }
        if (message.equalsIgnoreCase("-q 15")){
            commandEvent.reply("The Java volatile keyword is used to mark a variable as \"being stored in main memory\" → every read of a volatile variable will be read from the computer's main memory, and not from the CPU cache.");
        }
        if (message.equalsIgnoreCase("-q 16")){
            commandEvent.reply("JDBC (Java Database Connectivity) is a Java API that can access any kind of tabular data, especially data stored in a relational database.");
        }
        if (message.equalsIgnoreCase("-q 17")){
            commandEvent.reply("A context through which the communication with a database takes place.\n");
        }
        if (message.equalsIgnoreCase("-q 18")){
            commandEvent.reply("Consists of:\n" +
                    "– The Java Persistence API\n" +
                    "– Java Persistence Query Language (JPQL)\n" +
                    "– The Java Persistence Criteria API\n" +
                    "– O/R mapping metadata (Persistence Annotations)");
        }
        if (message.equalsIgnoreCase("-q 19")){
            commandEvent.reply("A set of rules governing the exchange or transmission of data between devices.");
        }
        if (message.equalsIgnoreCase("-q 20")){
            commandEvent.reply("An object which acts as an interface to another object (also called surrogate, placeholder)");
        }
        if (message.equalsIgnoreCase("-q 21")){
            commandEvent.reply("1. Bind - the association between an object and a symbolic name\n" +
                    "2.Lookup - obtaining the reference to an object using its symbolic name");
        }
        if (message.equalsIgnoreCase("-q 22")){
            commandEvent.reply("Data and functionality are considered resources and are accessed using an uniform interface");
        }
        if (message.equalsIgnoreCase("-q 23")){
            commandEvent.reply("1.Get\n2.Post\n3.Put\n4.Patch");
        }
        if (message.equalsIgnoreCase("-q 24")){
            commandEvent.reply("Thymeleaf is a server-side Java template engine for both web and standalone environments.");
        }
        if (message.equalsIgnoreCase("-q 25")){
            commandEvent.reply("Classes are introduced into the Java environment when they are referenced by name in a class that is already running");
        }
        if (message.equalsIgnoreCase("-q 26")){
            commandEvent.reply("The CLASSPATH environment variable specifies the locations where to look for classes, above the location of the package hierarchy.");
        }
        if (message.equalsIgnoreCase("-q 27")){
            commandEvent.reply("It's a class loader which is used to load classes and resources from a search path of URLs referring to both JAR files and directories.");
        }
        if (message.equalsIgnoreCase("-q 28")){
            commandEvent.reply("Annotations are used for:\n" +
                    "1. Information for the compiler\n" +
                    "2. Compile-time and deployment-time processing\n" +
                    "3. Runtime processing ");
        }
        if (message.equalsIgnoreCase("-q 29")){
            commandEvent.reply("Internationalization (i18n) is the process of designing an application so that it can be adapted to various languages and regions without engineering changes.");
        }
        if (message.equalsIgnoreCase("-q 30")){
            commandEvent.reply("NumberFormat helps you to format and parse numbers for any locale.");
        }







    }
}
