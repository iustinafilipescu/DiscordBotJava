package music;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

import java.net.URI;
import java.net.URISyntaxException;

public class PlayCommand extends Command {

    public PlayCommand() {
        super.name = "play";
        super.help = "Play a song with a specific url";
        super.aliases = new String[]{"play"};
        super.category = new Category("Playing music");
        super.cooldown = 5;
        super.arguments = "[song-url]";
    }

    @Override
    protected void execute(CommandEvent event) {


        if (event.getArgs().isEmpty()){
            event.reply("Provide a name! Like this: -user-info [name]");
        }else {
            final TextChannel channel = event.getTextChannel();
            final Member self = event.getSelfMember();
            final GuildVoiceState selfVoiceState = self.getVoiceState();

            if (!selfVoiceState.inVoiceChannel()) {
                channel.sendMessage("Bot needs to be in voice channel").queue();
                return;
            }

            final Member member = event.getMember();
            final GuildVoiceState memberVoiceState = self.getVoiceState();

            if (!memberVoiceState.inVoiceChannel()) {
                channel.sendMessage("You need to be in a voice channel for this command to work.").queue();
                return;
            }

            if (!memberVoiceState.getChannel().equals(selfVoiceState.getChannel())) {
                channel.sendMessage("You need to be in the same voice channel as me for this to work!").queue();
                return;
            }

            String link=String.join(" ",event.getArgs());
            if(!isUrl(link)){
                link="ytsearch:" + link;
            }
            PlayerManager.getInstance().loadAndPlay(channel,link);
        }


    }

    private boolean isUrl(String url)
    {
        try{
            new URI(url);
            return true;
        } catch (URISyntaxException e) {
            return false;
        }
    }

}
