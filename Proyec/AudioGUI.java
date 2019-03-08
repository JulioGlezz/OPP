import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioGUI extends JFrame implements ActionListener
{
	//Definir los objetos
	private File fCancion;
	private AudioInputStream cancionStream;
	private Clip clip;
	
	private JTextField tfCancion;
	private JButton bPlay,bStop;
	private JPanel panel1,panel2;
	
	public AudioGUI() 
	{
		super("Reproductor de musica");
		
		// 1. Crear los objetos de los atributos
		tfCancion= new JTextField();
		
		bPlay= new JButton("Reproducir");
		bStop= new JButton("Detener");
		
		panel1=new JPanel();
		panel2=new JPanel();
		
		bPlay.addActionListener(this);
		bStop.addActionListener(this);
		
		// 2. Definir el Layout
		panel1.setLayout(new GridLayout(2,2));
		panel2.setLayout(new FlowLayout());
		
		// 3. Poner los objetos de los atributos para que esten visibles al usuario
		panel1.add(new JLabel("Cancion a reproducir: "));
		panel1.add(tfCancion);
		panel1.add(bPlay);
		panel1.add(bStop);
		
		panel2.add(panel1);
		
		// 4. Hacer visible el JFrame
		add(panel2);
		setSize(600,500);
		//setVisible(true);
		
	}
	
	public JPanel getPanel2()
	{
		return panel2;
	}
	
	private void reproducir(String cancion) 
	{
		try
		{
		
		// 2. Relacionar el nombre de la canción con un archivo (file) .wav
		fCancion = new File("C:/Users/Yazm�n/Desktop/OOP/Proyecto/"+cancion+".wav");
		
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
	
	public void actionPerformed(ActionEvent opcion)
	{
		String cancion, mensaje;
		
		cancion=tfCancion.getText();
		
		if(opcion.getSource()==bPlay)
		{	 
			reproducir(cancion);
		}
		
		if(opcion.getSource()== bStop)
		{
			clip.stop();
		}
	}
	
	
	public static void main(String args[]) 
	{
		AudioGUI audio = new AudioGUI();
	}
}