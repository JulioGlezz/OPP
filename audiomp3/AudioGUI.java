import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AudioGUI extends JFrame implements ActionListener
{
    private String song;
    
    private JPanel panel1, panel2;
    private JTextField tfSong;
    private JButton bPlay,bStop;
    private JLabel lbSong;
    
    private AudioOS audio = new AudioOS();
    
    public AudioGUI()
    {
    	super("Audio FX MP3");
    	
    	// 1. Crear los objetos de los atributos
    	tfSong = new JTextField();
    	bPlay  = new JButton("Play");
    	bStop  = new JButton("Stop");
    	lbSong = new JLabel("Reproduciendo: ");
    	panel1 = new JPanel();
    	panel2 = new JPanel();
    	
        // Adicionar a los JButtons addActionListener
        bPlay.addActionListener(this);
        bStop.addActionListener(this);
        
        // 2. Definir los Layouts para los JPanels
        panel1.setLayout(new GridLayout(2,2));
        panel2.setLayout(new FlowLayout());

		// 3. Adicionar los objetos a los JPanels correspondientes
        panel1.add(new JLabel("Cancion a reproducir: "));
        panel1.add(tfSong);
        panel1.add(bPlay);
        panel1.add(bStop);
        
        panel2.add(panel1);
        panel2.add(lbSong);
    	
    	//4.Adicionar panel2 al JFrame y hacerlo visible con las dimensiones adecuadas
    	setVisible(true);
    	add(panel2);
        setSize(350,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
  
  	public void actionPerformed(ActionEvent e)
  	{
  		
        
        if(e.getSource() == bPlay)
        {
        	try
        	{
        		song = tfSong.getText();
            
           		audio.reproducir(song);
            
           		lbSong.setText("Reproduciendo: "+song);

        	}
        	catch (Exception exc)
        	{
        		System.out.println("Error: "+exc);
        	}
        }
        
        if(e.getSource() == bStop)
        {
        	try
        	{
        		audio.detener();	
        	}
        	catch(Exception exception)
        	{
        		System.out.println("Error: "+exception);
        	}
        	
        }
  	}
  
    public static void main(String args[])// throws Exception
    {
        AudioGUI audio = new AudioGUI();
        //audio.reproducir();
    }
}
