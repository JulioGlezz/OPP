import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class AudioOS
{
	private File fCancion;
	private AudioInputStream cancionStream;
	private Clip clip;
	
	public void reproducir(String cancion)
	{
		try
		{
			// 2. Relacionar el nombre de la canción con un archivo (file) .wav
			fCancion = new File("C:/Users/Julio Cesar Gon�lez/Desktop/+/OOP/Audio/"+cancion+".wav");
			
			// 3. Preparar el audiostream del archivo de la canción
			cancionStream= AudioSystem.getAudioInputStream(fCancion);
			
			// 4. Reproducir la canción
			clip= AudioSystem.getClip();
			clip.open(cancionStream);
			//while(true)
			clip.start();
		}
			
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void stop()
	{
		clip.stop();
	}
}