package jp.id;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

public class AudioPlayer {

	String VLCPath = "C:\\Program Files\\VideoLAN\\VLC" ;
	
	EmbeddedMediaPlayer MediaPlayer;
	
	
	public AudioPlayer() {
		// TODO Auto-generated constructor stub
		
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName() , VLCPath);
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		
		MediaPlayer = new MediaPlayerFactory().newEmbeddedMediaPlayer();
		MediaPlayer.prepareMedia("/Assets/home.mp3", null);
		
		
	}

}
