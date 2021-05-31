package music;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.managers.AudioManager;

public class JoinCommand extends Command {

    public JoinCommand() {
        this.name="join";
        this.help="Bot is joining the server for playing music!";
        super.category = new Category("Playing music");
    }
    @Override
    protected void execute(CommandEvent event) {

        final MessageChannel channel = event.getChannel();
        final Member self= event.getSelfMember();
        final GuildVoiceState selfVoiceState= self.getVoiceState();


        if(selfVoiceState.inVoiceChannel())
        {
            channel.sendMessage("Bot already in channel!").queue();
            return ;
        }
        final Member member = event.getMember();
        final GuildVoiceState memberVoiceState= member.getVoiceState();


        if(!memberVoiceState.inVoiceChannel()){
            channel.sendMessage("You need to be in channel to queue music!").queue();
            return;
        }

        final AudioManager audioManager = event.getGuild().getAudioManager();
        final VoiceChannel memberChannel = memberVoiceState.getChannel();

        audioManager.openAudioConnection(memberChannel);
        channel.sendMessageFormat("Connecting to '\uD83D\uDD0A %s' ", memberChannel.getName()).queue();

    }


}
