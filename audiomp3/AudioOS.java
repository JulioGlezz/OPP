import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javafx.embed.swing.JFXPanel;

public class AudioOS
{
    private File        songFile;
    private Media       mediaSong;
    private MediaPlayer player;
    private JFXPanel    jfxPanel;
    
    public void reproducir(String song) throws Exception
    {
        // Crear el ambiente de MediaPlayer (obligatorio)
        //new javafx.embed.swing.JFXPanel();
        jfxPanel = new JFXPanel();
        
        // 1. Especificar el nombre de la cancion a reproducir
        //song = "SOS.mp3";
        song = song+".mp3";
        
        // 2. Abrir el archivo .mp3 de la cancion usando File
        songFile = new File(song);
        song = songFile.toURI().toString();
        mediaSong = new Media(song);
        
        // 3. Preparar el Audio Stream relacionado con la cancion
        player = new MediaPlayer(mediaSong);
        
        // 4. Reproducir la cancion con la clase MediaPlayer
        player.play();
    }
    
    public void detener() throws Exception
    {
    	player.stop();	
    }
}
