import javax.sound.sampled.Clip;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer{

  String AK47SoundReload;
  String AK47SoundShot;
  String M4A4SoundReload;
  String M4A4SoundShot;
  String AWPSoundShot;
  String AWPSoundReload;
  String MainMenuMusic;
  String MenuClick;
  Clip clip;

  public AudioPlayer() {
    AK47SoundReload = "AKReload.wav";
  }


  public void setFile(String soundFileName) {

     try{
				File file = new File(AK47SoundReload);
				AudioInputStream sound = AudioSystem.getAudioInputStream(file);
				clip = AudioSystem.getClip();
				clip.open(sound);
			  }catch(Exception e){}

    }

		public void play(){

			clip.start();
		}
  }
