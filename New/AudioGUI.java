import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioGUI
{
	private File fileSong;
	private AudioInputStream audioStream;
	private Clip clip;
	
	
	public void getpanel2()
	{
       return panel2();
	}
	private void reproducir() throws Exception
	{
		// 1. Obtener el nombre de la canción a reproducir
		String song ="CNN.wav";
		
		// 2. Relacionar el nombre de la canción con un archivo (file) .wav
		fileSong = new File(song);
		
		// 3. Preparar el audiostream del archivo de la canción
		audioStream= AudioSystem.getAudioInputStream(fileSong);
		
		// 4. Reproducir la canción
		clip= AudioSystem.getClip();
		clip.open(audioStream);
		while(true)
			clip.start();
		
	}
	
	public static void main(String args[]) throws Exception
	{
		AudioGUI audio= new AudioGUI(); // se crea
		audio.reproducir(); //se manda llamar
	}
}