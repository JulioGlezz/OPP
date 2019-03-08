import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PracticaBiblio extends JFrame implements ActionListener
{
	private JMenuBar  mbPrincipal;
	private JMenu     menuBiblioteca;
	private JMenuItem miConsultar, miAgregar, miSalir;
	
	private JPanel panel;
	
	private BibliotecaGUIAD05  biblioteca   = new BibliotecaGUIAD05();
	private LibroGUI           libros       = new LibroGUI();
	
	public PracticaBiblio()
	{
		super("Practica 01: Biblioteca");
		
		//1.Crear objetos de los atributos
		mbPrincipal = new JMenuBar();
		menuBiblioteca = new JMenu("BIBLIOTECA");
		miConsultar = new JMenuItem ("Consultar Libros");
		miAgregar = new JMenuItem("Agregar Nuevos Libros");
		miSalir = new JMenuItem ("Exit");
		panel = new JPanel();
		 
		//1.2 Colocar el metodo addActionListener a los JMenuItems que pertenece a los JButtons 
		miSalir.addActionListener(this);
		miAgregar.addActionListener(this);
		miConsultar.addActionListener(this);
			
		//2.Colocar los JMenuItems en los JMenus correspondientes ;
		menuBiblioteca.add(miAgregar);
		menuBiblioteca.add(miConsultar);
		menuBiblioteca.add(miSalir);
	
	    //3.Colocar en JMenuBar los Menus 
	    mbPrincipal.add(menuBiblioteca);
	    
	    //4.Colocar el JMenuBar en el JFrame y hacerlo visible
	    setJMenuBar(mbPrincipal);
		setSize(400,400);
		setVisible(true);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Para poder cerrarlo con el tache y no con boton de exit
	}


	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == miAgregar)
		{
		  	panel.setVisible(false);
			panel=libros.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
			setSize(300,400);
		}
		
		if(e.getSource() == miConsultar)
		{
			panel.setVisible(false);
			panel = biblioteca.getPanel2();
			panel.setVisible(true);
			add(panel);
			setVisible(true);
			setSize(800,500);
		}
		
		
		if(e.getSource() == miSalir)
		{
			System.exit(0);
		}
	}

   	public static void main(String args[])
	{
		 PracticaBiblio practica = new PracticaBiblio();
	}
}