
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AudioFxGUI extends JFrame implements ActionListener
{
    private JPanel panel1, panel2, panel3;
    private JButton bPlay, bStop;
    private JTextField tfSong;
    private JLabel lbSong;
    private Thread thrAudio;
    
    
    public AudioFxGUI()
    {
    	super("Audio Reproductor MP3 con FX");
    	
    	// 1. Crear los objetos de los atributos
    	panel1= new JPanel();
    	panel2= new JPanel();
    	panel3= new JPanel();
    	bPlay= new JButton("Play");
    	bStop= new JButton("Stop");
    	tfSong= new JTextField();
    	lbSong= new JLabel("Now playing: ");
    	
    	// Adicionar a lols botones addActionListener
    	bPlay.addActionListener(this);
    	bStop.addActionListener(this);
    	
    	// 2. Definir los Layouts para los panels 
    	panel1.setLayout(new GridLayout(2,2));
    	panel2.setLayout(new GridLayout(2,1));
    	panel3.setLayout(new FlowLayout());
    	
    	// 3. Adicionar los objetos a los Panels
    	panel1.add(new JLabel("Cancion a reproducir: "));
    	panel1.add(tfSong);
    	panel1.add(bPlay);
   		panel1.add(bStop);
   		
   		panel2.add(panel1);
   		panel2.add(lbSong);
   		
   		panel3.add(panel1);
   		panel3.add(panel2);
   		
    	
    	// 4. Adicionar al panel 3 y hacer visible el JFrame
    	add(panel3);
    	setSize(300,200);
    //	setVisible(true);
    	
    	
    	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
   public JPanel getPanel2()
	{
		return panel3;
	}
    
    public void actionPerformed(ActionEvent evento)
    {
    	String song, respuesta;
    	
    	if(evento.getSource()==bPlay)
    	{
    		song = tfSong.getText();
    		
    		thrAudio = new Thread(new AudioFxOS(song));
    		thrAudio.start();
    		lbSong.setText("Reproduciendo: " + song);
    	//	lbSong.setText(respuesta);
    	}
    	
    	if(evento.getSource()==bStop)
    	{
    		//player.close();
    		thrAudio.stop();
    	//	player.stop();
    		
    	}
    }
  
    public static void main(String args[]) 
    {
       new AudioFxGUI();
       // audio.reproducir();
    }
}
