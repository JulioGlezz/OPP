import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class EditorAD 
{
    private BufferedReader archivoIn;
    private PrintWriter archivoOut;
    private String respuesta;
    private JList listaArchivos;
    private File path;
    
    public String guardar(String titulo,String datos)
    {
       	try
       	{
	    	archivoOut= new PrintWriter(new FileWriter(titulo));
	       	archivoOut.println(datos);
	       	archivoOut.close();
	       	respuesta="Archivo Guardado Exitosamente";

       	}
       	catch(IOException e)
       	{
       		System.out.println(e);
       	}
       	return respuesta;
    }
    
    public String abrir(String titulo)
    {
    	String str;
    	respuesta="";
		
		try
		{
	    	archivoIn= new BufferedReader(new FileReader(titulo));
	    	while(archivoIn.ready())
	    	{
	    		str=archivoIn.readLine();
	    		respuesta=respuesta+str+"\n";
	    	}
	    	archivoIn.close();			
		}
		catch(FileNotFoundException f)
		{
			System.out.println(f);
		}
		catch(IOException ioe)
		{
			System.out.println(ioe);
		}
    	return respuesta;
    }
    
    public JList lista()
    {
    	path = new File("C:/Users/Julio Cesar Gonález/Desktop/ED/4");
    	String directorio[] = path.list();
    	listaArchivos= new JList(directorio);
    	
    	return listaArchivos;
    }
    
    public String borrar(String titulo)
    {
    	File file = new File(titulo);
    	if(file.delete())
    	{
    		respuesta="Archivo borrado exitosamente";
    	}
    	else
    	{
    		respuesta="El archivo no puede ser borrado";
    	}
    	
    	return respuesta;
    }
}
