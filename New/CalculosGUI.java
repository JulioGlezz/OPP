import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class CalculosGUI extends JFrame implements ActionListener
{
	private JMenuBar mbPrincipal;
	private JMenu menuCalculos,menuGrados;
	private JMenuItem miFactorial,miGradosCF,miGradosFC,miExponencial,miSalir,miAudio,miEcuacion;
	
	private JPanel panel;
	
	private AudioGUI audio = new AudioGUI();
	private EcuacionGUI ecuacion = new EcuacionGUI();
	private ExponencialGUI exponencial = new ExponencialGUI();
	private FactorialGUI factorial =new FactorialGUI();
	private GradosCfGUI gradoscf = new GradosCfGUI();
	private GradosFcGUI gradosfc = new GradosFcGUI();
	
	public CalculosGUI()
	{
		super("Java App: Calculos");
		
		//1. Crear objetos de los atributos
		mbPrincipal=new JMenuBar();
		
		menuCalculos = new JMenu("OPCIONES");
		menuGrados=new JMenu("Conversion de Grados");
		
		miAudio = new JMenuItem("Reproduccion de musica");
		miEcuacion = new JMenuItem("Raices de ecuacion cuadratica");
		miExponencial = new JMenuItem("Y = B^X");
		miFactorial = new JMenuItem("Factorial de N");
		miGradosCF = new JMenuItem("G. Centigrados a G. Farenheit");
		miGradosFC = new JMenuItem("G. Farenheit a G. Centigrados");
		miSalir = new JMenuItem("Salir");
		
		panel = new JPanel();
		
		// 1.2 Colocar el Metodo
		miAudio.addActionListener(this);
		miEcuacion.addActionListener(this);
		miExponencial.addActionListener(this);
		miFactorial.addActionListener(this);
		miGradosCF.addActionListener(this);
		miGradosFC.addActionListener(this);
		miSalir.addActionListener(this);
		
		//2. Colocar los JMenuItems en los menus correspondientes
		menuGrados.add(miGradosCF);
		menuGrados.add(miGradosFC);
		
		menuCalculos.add(miAudio);
		menuCalculos.add(miEcuacion);
		menuCalculos.add(miExponencial);
		menuCalculos.add(miFactorial);
		menuCalculos.add(menuGrados);
		menuCalculos.add(miSalir);
		
		
		//3. Colocar em MenuBar los JMenu
		mbPrincipal.add(menuCalculos);
		
		//4. Colocar el JMenuBar en el JFrame y hacerlo visible
		setJMenuBar(mbPrincipal);
		setSize(600,500);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		System.out.println(""+e);

		if(e.getSource()==miAudio)
		{
			panel.setVisible(false);
			panel = audio.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(e.getSource()==miEcuacion)
		{
			panel.setVisible(false);
			panel = ecuacion.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(e.getSource()==miFactorial)
		{
			//new FactorialGUI2();
			panel.setVisible(false);
			panel = factorial.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(e.getSource()==miExponencial)
		{
			//new Exponencial();
			panel.setVisible(false);
			panel = exponencial.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(e.getSource()==miGradosCF)
		{
			//new GradosCF();
			panel.setVisible(false);
			panel = gradoscf.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(e.getSource()==miGradosFC)
		{
			//new GradosFC();
			panel.setVisible(false);
			panel = gradosfc.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(e.getSource()==miSalir)
		{
			System.exit(0);
		}
		
	}
	
	public static void main(String args[])
	{
		new CalculosGUI();
	}
}