import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.util.Vector;

public class BibliotecaGUI extends JFrame implements ActionListener, ListSelectionListener
{
    // Atributos de la aplicacion
    private JPanel panelUsuario, panelEditoriales, panelLibros, panelPrincipal,panelImagenes;
    
    private JButton bEditorial,bAutor,bTitulo;
    private JTextArea taEditorial, taLibros,taImagenes;
    private JTextField tfAutor,tfTitulo;
    private ImageIcon imagb[], imagb2[];
    
    
    private BibliotecaAD bibliotecaad = new BibliotecaAD();
    
    private Vector vectorEditoriales,vectorLibros,vectorDatos,vectorImagenes;
    private JList  listaEditoriales,listaLibros,listaImagenes,listano;
    
    private ImageIcon imagenesLibros[];
    
    public BibliotecaGUI()
    {
        super("BIBLIOTECA TEC");
        
        // 1. Crear objetos de los atributos
        
        bEditorial = new JButton("Editoriales");
        bAutor = new JButton("Buscar");
        bTitulo= new JButton("Buscar");
        
        tfAutor = new JTextField(10);
        tfTitulo = new JTextField(10);
        
        taEditorial = new JTextArea("EDITORIALES",20,20);
        taLibros    = new JTextArea("LIBROS DE UNA EDITORIAL",20,20);
        taImagenes  = new JTextArea("Imagenes ",20,20);
        
        panelUsuario     = new JPanel();
        panelEditoriales = new JPanel();
        panelLibros      = new JPanel();
        panelPrincipal   = new JPanel();
        panelImagenes    = new JPanel();
        
        // Adionar actionListener a los JButtons
        bEditorial.addActionListener(this);
        bTitulo.addActionListener(this);
        bAutor.addActionListener(this);
        
        // 2. Definir Layouts de los JPanels
        panelUsuario.setLayout(new FlowLayout());
        panelEditoriales.setLayout(new GridLayout(1,2));
        panelLibros.setLayout(new GridLayout(1,1));
        panelPrincipal.setLayout(new BorderLayout(4,4));
        panelImagenes.setLayout( new GridLayout(1,1));
        
        // 3. Colocar los objetos de los atributos en los panels correspondientes
        panelUsuario.add(bEditorial);
        panelUsuario.add(new JLabel("Buscar por Titulo :"));
        panelUsuario.add(tfTitulo);
        panelUsuario.add(bTitulo);
        panelUsuario.add(new JLabel("Buscar por Autor :"));
        panelUsuario.add(tfAutor);
        panelUsuario.add(bAutor);
        
        panelEditoriales.add(new JScrollPane(taEditorial));
        panelLibros.add(new JScrollPane(taLibros));
        panelImagenes.add(new JScrollPane(taImagenes));
        
        panelPrincipal.add(panelUsuario,BorderLayout.NORTH);
        panelPrincipal.add(panelEditoriales,BorderLayout.WEST);
        panelPrincipal.add(panelImagenes,BorderLayout.CENTER);
        panelPrincipal.add(panelLibros,BorderLayout.EAST);
        
        
        // 4. Adicionar el panelPrincipal al JFrame
        add(panelPrincipal);
        setSize(1000,500);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == bEditorial)
        {
            //JOptionPane.showMessageDialog(null,"EDITORIALES...");
            
            vectorEditoriales= bibliotecaad.obtenerNombres();
            
            //Crear Jlist del vector
            listaEditoriales= new JList(vectorEditoriales);
            listaEditoriales.addListSelectionListener(this);
            
            panelEditoriales.setVisible(false);
            panelEditoriales.removeAll();
            panelEditoriales.add(new JScrollPane (listaEditoriales));
            panelEditoriales.setVisible(true);
        }
        
        if(e.getSource()==bTitulo)
        {
        
        	String titulo= tfTitulo.getText();
			imagb2=bibliotecaad.obtenerDatosPRO(titulo);
			
			listaLibros= new JList(imagb2);
			listaLibros.addListSelectionListener(this);
				
			panelImagenes.setVisible(false);
			panelImagenes.removeAll();
			panelImagenes.add(listaLibros);
			panelImagenes.setVisible(true);
			
			
        }
        
        if(e.getSource()==bAutor)
        {
        	String autor= tfAutor.getText();
			imagb=bibliotecaad.obtenerDatosPROC(autor);
			
			listaLibros= new JList(imagb);
			listaLibros.addListSelectionListener(this);
				
			panelImagenes.setVisible(false);
			panelImagenes.removeAll();
			panelImagenes.add(listaLibros);
			panelImagenes.setVisible(true);
        }
    }
    
    public void valueChanged(ListSelectionEvent lse)
    {
        String editorialElegida,libroElegido;
     	if(lse.getValueIsAdjusting()==true) //PERMITE QUE NO SALGAN 2 VECES EL MISMO STRING
		{
			if(lse.getSource()==listaEditoriales)
			{
				editorialElegida=(String)listaEditoriales.getSelectedValue();
				
				//taDatos.setText(personaElegida);
				
				imagenesLibros = bibliotecaad.obtenerImagenesLibros(editorialElegida);
				
				
				listaImagenes = new JList(imagenesLibros);
				listaImagenes.addListSelectionListener(this);
				
				panelImagenes.setVisible(false);
				panelImagenes.removeAll();
				panelImagenes.add(new JScrollPane(listaImagenes));
				panelImagenes.setVisible(true);
			}
			
			if(lse.getSource()==listaImagenes)
			{
				int numeroImagen = listaImagenes.getSelectedIndex();
			
				libroElegido = bibliotecaad.getLibros(numeroImagen);
				
				vectorDatos = bibliotecaad.obtenerDatosImg(libroElegido);
				
				listaLibros= new JList(vectorDatos);
				listaLibros.addListSelectionListener(this);
				
				panelLibros.setVisible(false);
				panelLibros.removeAll();
				panelLibros.add(listaLibros);
				panelLibros.setVisible(true);
			}
			
		}
    }
    
    public static void main(String args[])
    {
        new BibliotecaGUI();
    }
}











