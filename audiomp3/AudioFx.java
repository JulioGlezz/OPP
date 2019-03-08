import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javafx.embed.swing.JFXPanel;

public class AudioFx
{
    private String      song;
    private File        songFile;
    private Media       mediaSong;
    private MediaPlayer player;
    private JFXPanel    jfxPanel;
    
    public void reproducir() throws Exception
    {
        // Crear el ambiente de MediaPlayer (obligatorio)
        //new javafx.embed.swing.JFXPanel();
        jfxPanel = new JFXPanel();
        
        // 1. Especificar el nombre de la cancion a reproducir
        //song = "SOS.mp3";
        song = "Lines On My Face.mp3";
        
        // 2. Abrir el archivo .mp3 de la cancion usando File
        songFile = new File("/JesusGG/Music_JGG/music_mp3/"+song);
        song = songFile.toURI().toString();
        mediaSong = new Media(song);
        
        // 3. Preparar el AudioFx Stream relacionado con la cancion
        player = new MediaPlayer(mediaSong);
        
        // 4. Reproducir la cancion con la clase MediaPlayer
        while(true)
            player.play();
    }
  
    public static void main(String args[]) throws Exception
    {
        AudioFx AudioFx = new AudioFx();
        AudioFx.reproducir();
    }
}
