import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;


public class BibliotecaGUI extends JFrame implements ActionListener, ListSelectionListener
{
	//Atributos de la App
	private JPanel panelUsuario, panelEditorial, panelTitulo, panelDatos, panelPrincipal;
	
	private JButton bEditorial, bTitulo, bAutor;
	private JTextField tfTitulo,tfAutor;
	private JTextArea taEditorial, taTitulo, taDatos;
	
    private BibliotecaAD bibliotecasad = new BibliotecaAD();
	private Vector vectorEditoriales, vectorTitulo, vectorDatos;
	private JList listaEditorial, listaTitulo,listaDatos;
	
	private ImageIcon imagenesTitulos[];
	
	
	public BibliotecaGUI()
	{
		super("BIBLIOTECA TEC");
		//1. Crear objetos de los atributos
		tfTitulo     = new JTextField(10);
		tfAutor      = new JTextField(10);
		bEditorial   = new JButton("Editoriales");
		bTitulo      = new JButton("Search Titulo");
		bAutor       = new JButton("Search Autor");
		taEditorial  = new JTextArea("Editoriales",20,20);
		taTitulo     = new JTextArea("Libros",20,20);
		taDatos      = new JTextArea("Datos",20,20);
		
		panelUsuario      = new JPanel();		
		panelEditorial    = new JPanel();
		panelTitulo       = new JPanel();
		panelDatos        = new JPanel();
		panelPrincipal    = new JPanel();
	
		bEditorial.addActionListener(this);
		bTitulo.addActionListener(this);
		bAutor.addActionListener(this);
		
		//2.Definir los Layout de los JPanel
		panelUsuario.setLayout(new FlowLayout());
		panelEditorial.setLayout(new GridLayout(1,1));
		panelTitulo.setLayout(new GridLayout(1,1));
		panelDatos.setLayout(new GridLayout(1,1));
		panelPrincipal.setLayout(new BorderLayout(5,5));
		
		//3.Colocar los objetos en los JPanel correspondientes
		panelUsuario.add(bEditorial);
		panelUsuario.add(new JLabel("Titulo : "));
		panelUsuario.add(tfTitulo);
		panelUsuario.add(bTitulo);
		panelUsuario.add(new JLabel("Autor :  "));
		panelUsuario.add(tfAutor);
		panelUsuario.add(bAutor);
		
		panelEditorial.add(new JScrollPane(taEditorial));
		panelTitulo.add(new JScrollPane(taTitulo));
		panelDatos.add(new JScrollPane(taDatos));
		
		panelPrincipal.add(panelUsuario, BorderLayout.NORTH);
		panelPrincipal.add(panelEditorial, BorderLayout.WEST);
		panelPrincipal.add(panelTitulo, BorderLayout.CENTER);
		panelPrincipal.add(panelDatos, BorderLayout.EAST);

		//4.Adicionarl el panel principal al JFrame
		add(panelPrincipal);		
		//setSize(700,400);
		//setVisible(true);
	}
	
	
	  public JPanel getPanel2()
	{
		return panelPrincipal;
	}
    
	public void actionPerformed(ActionEvent e)
	{
		String dato, respuesta;
		String editorial,titulos,datos,titulo,autor,libro,dueño;
		
		if(e.getSource()==bEditorial)
		{
			
			vectorEditoriales = bibliotecasad.obtenerEditoriales();
			
			listaEditorial= new JList(vectorEditoriales);
			listaEditorial.addListSelectionListener(this);
			
			panelEditorial.setVisible(false);
			panelEditorial.removeAll(); 
			panelEditorial.add(listaEditorial);
			panelEditorial.setVisible(true);
		}
		
		if(e.getSource()==bTitulo)
		{
			libro  = tfTitulo.getText();
			imagenesTitulos = bibliotecasad.obtenerImagenesbTitulo(libro);
			
			listaTitulo= new JList(imagenesTitulos);
			listaTitulo.addListSelectionListener(this);
			
			panelTitulo.setVisible(false);
			panelTitulo.removeAll(); 
			panelTitulo.add(listaTitulo);
			panelTitulo.setVisible(true);
		}		
		if(e.getSource()==bAutor)
		{
			autor   = tfAutor.getText();
			System.out.println(autor);
			imagenesTitulos = bibliotecasad.obtenerImagenesbAutor(autor);
			
			listaTitulo= new JList(imagenesTitulos);
			listaTitulo.addListSelectionListener(this);
			
			panelTitulo.setVisible(false);
			panelTitulo.removeAll(); 
			panelTitulo.add(new JScrollPane(listaTitulo));
			panelTitulo.setVisible(true);
		}
	
	}
	
	public void valueChanged(ListSelectionEvent lse)
	{
		String editorialElegida, tituloElegido, datoElegido;
		
		if(lse.getValueIsAdjusting()==true)
		{
			if(lse.getSource()==listaEditorial)
			{
				editorialElegida=(String)listaEditorial.getSelectedValue();
				System.out.println(editorialElegida);
				
				imagenesTitulos = bibliotecasad.obtenerImagenesTitulos(editorialElegida);
			
				listaTitulo = new JList(imagenesTitulos);
				listaTitulo.addListSelectionListener(this);
				panelTitulo.setVisible(false);
				panelTitulo.removeAll(); 
				panelTitulo.add(new JScrollPane(listaTitulo));
				panelTitulo.setVisible(true);
			}	
		
			if(lse.getSource()==listaTitulo)
			{
				
				int numImagen = listaTitulo.getSelectedIndex(); 
				tituloElegido  = bibliotecasad.getTitulo(numImagen);
				
				String titulo= bibliotecasad.obtenerDatos(tituloElegido);
		
				taDatos.setText(titulo);
			
				System.out.println(tituloElegido);
				
			}
			

		}	
			
	
	}
	
	public static void main (String args[])
	{
		new BibliotecaGUI(); 
	}
}