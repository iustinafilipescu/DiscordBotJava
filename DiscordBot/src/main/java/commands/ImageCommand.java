package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.coobird.thumbnailator.Thumbnails;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URL;

public class ImageCommand extends Command {

    public ImageCommand(){
        this.name = "image";
        this.arguments = "[width] [height] [image-url] [degrees to rotate(optional)]"; //arguments shown in $helpme
        this.cooldown = 10;
        this.help = "Manipulates images. Provide an image link and you can resize and or rotate it.";
    }

    @Override
    protected void execute(CommandEvent e) {
        if (e.getArgs().equalsIgnoreCase("")){
            e.reply("You did not provide any arguments, " + e.getAuthor().getAsMention());
            e.reply("To use the Image Manipulator, type the command like this(without brackets]: -image [width] [height] [image-url] [degrees to rotate(optional)]");
        }else{
            try{
                String[] args = e.getArgs().split(" ");
                int width = Integer.parseInt(args[0]);
                int height = Integer.parseInt(args[1]);
                URL imageURL = new URL(args[2]);
                int rotateAmount = 0;
                if (args.length == 4){
                    rotateAmount = Integer.parseInt(args[3]);
                }
                OutputStream os = new ByteArrayOutputStream();
                Thumbnails.of(imageURL).forceSize(width,height).rotate(rotateAmount).outputFormat("png").toOutputStream(os);
                byte[] imageInByte = ((ByteArrayOutputStream) os).toByteArray();
                e.getChannel().sendFile(imageInByte,"newfile.png").queue(); 

                e.reply(e.getAuthor().getAsMention() + ", here is your new image!!! It has been resized to: " + width + "x" + height + " and rotated to " + rotateAmount + "°");
            }catch (Exception ex){
                System.out.println("Some exception happened. oops");
            }

        }

    }
}
