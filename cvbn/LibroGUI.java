import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LibroGUI extends JFrame implements ActionListener
{
    private JTextField tfTitulo    = new JTextField();
    private JTextField tfAutor     = new JTextField();
    private JTextField tfEditorial = new JTextField();
    
    private JButton bCapturar, bConsultar, bSalir;
    
    private JTextArea taDatos = new JTextArea(10,23);
    private JPanel panel1, panel2;
    private BibliotecaAD05 biblioad = new BibliotecaAD05();
    
    
    public LibroGUI()
    {
        super("Administracion de Libros");
        
        panel1 = new JPanel();
        panel2 = new JPanel();
        
        panel1.setLayout(new GridLayout(5,2));
        panel2.setLayout(new FlowLayout());
        
        panel1.add(new JLabel("TITULO"));
        panel1.add(tfTitulo);
        
        panel1.add(new JLabel("AUTOR"));
        panel1.add(tfAutor);
        
        panel1.add(new JLabel("EDITORIAL"));
        panel1.add(tfEditorial);
        
        bCapturar = new JButton("Capturar");
        bCapturar.addActionListener(this);
        panel1.add(bCapturar);
        
        bConsultar = new JButton("Consultar");
        bConsultar.addActionListener(this);
        panel1.add(bConsultar);
        
        bSalir = new JButton("Salir");
        bSalir.addActionListener(this);
        panel1.add(bSalir);
        
        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));
        
        add(panel2);
        //setSize(400,400);
        //setVisible(true);
    }
    	public JPanel getPanel2() //esto es para que se utilice con el programa que muestra todos, se tiene que poner en todos los que mandes a llamar y se debe comentar el set visible
	{
		return panel2;
	}
	
    private String obtenerDatos()
    {
    	String datos="";
    	String titulo = tfTitulo.getText();
    	String autor = tfAutor.getText();
    	String editorial = tfEditorial.getText();
    	if(titulo.equals("")||autor.isEmpty()||editorial.equals(""))
    	{
    		datos="VACIO";
    	}
    	else	datos = titulo+"_"+autor+"_"+editorial;
    	return datos;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String respuesta="";
        String datos ="";
        
        if(e.getSource() == bCapturar)
        {
            //1. Obtener datos del nuevo libro
            datos = obtenerDatos();
            String editorial = tfEditorial.getText();
            if(datos.equals("VACIO"))
            {
            	respuesta = "Algun campo esta vacio...";
            }
            else
            {
                //2. Capturar los datos 
           		respuesta=biblioad.capturar(datos);
           		biblioad.capturarEditorial(editorial);
            }
            //3. Mostrar resultado de la transaccion
            taDatos.setText(respuesta);
        }
        
        
        if(e.getSource() == bConsultar)
        {
            //1. Obtener los datos de los libros
            datos = biblioad.consultarLibros();
            
            //2.Mostrar los datos
            taDatos.setText(datos);
        }
        
        if(e.getSource() == bSalir)
            System.exit(0);
    }
    
    public static void main(String args[])
    {
        new LibroGUI();
    }
}
