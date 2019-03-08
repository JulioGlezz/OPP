import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculosGUI extends JFrame implements ActionListener
{
	private JMenuBar mbPrincipal;
	private JMenu menuCalculos,menuGrados,menuAudio, menuAudioItunes;
	private JMenuItem miFactorial,miGradosCF,miGradosFC,miExponencial,miSalir,miAudioWav,miEcuacion,miTablas,miCalcu,miAudioFX,miAudioZoom, miAudioItunesWav,miAudioItunesFX, miAudioItunesZoom;
	
	private JPanel panel;
	
	private AudioItunesGUIVL_WAV audiovlWAV= new AudioItunesGUIVL_WAV();
	private AudioItunesGUIVL_ZOOM audiovlZOOM= new AudioItunesGUIVL_ZOOM();
	private AudioItunesGUIVL_FX audiovlFX= new AudioItunesGUIVL_FX();
	private AudioGUI audiowav= new AudioGUI();
	private AudioFxGUI audiofx =new AudioFxGUI();
	private AudioJavaZoomGUI audiozoom= new AudioJavaZoomGUI();
	private EcuacionGUI ecuacion= new EcuacionGUI();
	private ExponencialGUI exponencial= new ExponencialGUI();
	private FactorialGUI factorial=new FactorialGUI();
	private GradosCfGUI gradoscf= new GradosCfGUI();
	private GradosFcGUI gradosfc= new GradosFcGUI();
	private TablasGUI tablas= new TablasGUI();
	private Calculadora calcu=new Calculadora();
	
	
	public CalculosGUI()
	{
		super("Java App: Calculos");
		
		//1. Crear objetos de los atributos
		mbPrincipal=new JMenuBar();
		
		menuCalculos=new JMenu("OPCIONES");
		menuGrados=new JMenu("Conversion de Grados");
		menuAudio= new JMenu("REPRODUCTOR");
		menuAudioItunes= new JMenu("REPRODUCTOR iTUNES");
		
		miAudioWav= new JMenuItem("Reproductor WAV");
		miAudioFX= new JMenuItem("Reproductor MP3 FX");
		miAudioZoom= new JMenuItem("Reproductor MP3 JavaZoom");
		
		miAudioItunesWav= new JMenuItem("AudioWAV iTunes");
		miAudioItunesFX= new JMenuItem("AudioFX iTunes");
		miAudioItunesZoom= new JMenuItem("AudioJavaZoom iTunes");
		
		miCalcu= new JMenuItem("Calculadora");
		miEcuacion=new JMenuItem("Raices de ecuacion cuadratica");
		miExponencial=new JMenuItem("Y = B^X");
		miFactorial=new JMenuItem("Factorial de N");
		miGradosCF=new JMenuItem("G. Centigrados a G. Farenheit");
		miGradosFC=new JMenuItem("G. Farenheit a G. Centigrados");
		miTablas= new JMenuItem("Tablas de Multiplicar");
		miSalir=new JMenuItem("Salir");
		
		
		panel=new JPanel();
		
		// 1.2 Colocar el Método
		miAudioWav.addActionListener(this);
		miAudioFX.addActionListener(this);
		miAudioZoom.addActionListener(this);
		
		miAudioItunesWav.addActionListener(this);
		miAudioItunesFX.addActionListener(this);
		miAudioItunesZoom.addActionListener(this);
		
		miCalcu.addActionListener(this);
		miEcuacion.addActionListener(this);
		miExponencial.addActionListener(this);
		miFactorial.addActionListener(this);
		miGradosCF.addActionListener(this);
		miGradosFC.addActionListener(this);
		miTablas.addActionListener(this);
		miSalir.addActionListener(this);
		
		
		//2. Colocar los JMenuItems en los menus correspondientes
		menuGrados.add(miGradosCF);
		menuGrados.add(miGradosFC);
		menuAudio.add(miAudioWav);
		menuAudio.add(miAudioFX);
		menuAudio.add(miAudioZoom);
		
		menuAudioItunes.add(miAudioItunesWav);
		menuAudioItunes.add(miAudioItunesFX);
		menuAudioItunes.add(miAudioItunesZoom);
		
	//	menuCalculos.add(miAudio);
		menuCalculos.add(miEcuacion);
		menuCalculos.add(miCalcu);
		menuCalculos.add(miExponencial);
		menuCalculos.add(miFactorial);
		menuCalculos.add(miTablas);
		menuCalculos.add(menuGrados);
		menuCalculos.add(miSalir);
		
		
		//3. Colocar em MenuBar los JMenu
		mbPrincipal.add(menuCalculos);
		mbPrincipal.add(menuAudio);
		mbPrincipal.add(menuAudioItunes);
		
		//4. Colocar el JMenuBar en el JFrame y hacerlo visible
		setJMenuBar(mbPrincipal);
		setSize(600,500);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==miAudioItunesWav)
		{
			panel.setVisible(false);
			panel=audiovlWAV.getpanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(e.getSource()==miAudioItunesFX)
		{
			panel.setVisible(false);
			panel=audiovlFX.getpanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(e.getSource()==miAudioItunesZoom)
		{
			panel.setVisible(false);
			panel=audiovlZOOM.getpanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(e.getSource()==miAudioWav)
		{
			panel.setVisible(false);
			panel=audiowav.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
			
		//	new AudioGUI();
		}
		
		if(e.getSource()==miAudioFX)
		{
			panel.setVisible(false);
			panel=audiofx.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		//	new AudioFxGUI();
		}
		
		if(e.getSource()==miAudioZoom)
		{
			panel.setVisible(false);
			panel=audiozoom.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		//	new AudioJavaZoomGUI();
		}
		
		if(e.getSource()==miCalcu)
		{
			panel.setVisible(false);
			panel=calcu.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(e.getSource()==miEcuacion)
		{
			panel.setVisible(false);
			panel=ecuacion.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(e.getSource()==miFactorial)
		{
			//new FactorialGUI2();
			panel.setVisible(false);
			panel=factorial.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(e.getSource()==miExponencial)
		{
			//new Exponencial();
			panel.setVisible(false);
			panel=exponencial.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(e.getSource()==miGradosCF)
		{
			//new GradosCF();
			panel.setVisible(false);
			panel=gradoscf.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(e.getSource()==miGradosFC)
		{
			//new GradosFC();
			panel.setVisible(false);
			panel=gradosfc.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
		}
		
		if(e.getSource()==miTablas)
		{
			panel.setVisible(false);
			panel=tablas.getPanel2();
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