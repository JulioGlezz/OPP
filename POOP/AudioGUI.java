import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AudioGUI extends JFrame implements ActionListener
{
	//Definir los objetos
	
	private JTextField tfCancion;
	private JButton bPlay,bStop;
	private JPanel panel1,panel2;
	
	private AudioOS audio = new AudioOS();
	
	public AudioGUI() 
	{
		super("Reproductor de musica");
		
		// 1. Crear los objetos de los atributos
		tfCancion = new JTextField();
		
		bPlay = new JButton("Reproducir");
		bStop = new JButton("Detener");
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		
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
	//	setVisible(true);
		
	}
	
	public JPanel getPanel2()
	{
		return panel2;
	}
	
	
	public void actionPerformed(ActionEvent opcion)
	{
		String cancion, mensaje;
		
		cancion = tfCancion.getText();
		
		if(opcion.getSource()==bPlay)
		{	 
			audio.reproducir(cancion);
		}
		
		if(opcion.getSource()== bStop)
		{
			audio.stop();
		}
	}
	
	
	
	public static void main(String args[]) 
	{
		new AudioGUI();
	}
}