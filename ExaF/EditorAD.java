import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class EditorAD 
{
	private File file;
	
	private BufferedReader fileIn;
	private BufferedWriter fileOut;
	
	private BufferedReader archivoIn,archivoDatos;
	private Vector vectorFiles,vectorData;
	
	private String res;
	
	public void saveAsFiles(String name, String data)
	{
		try
		{
			file = new File("C:/Users/Julio Cesar Gonález/Desktop/ExaF/" + name);
			if(file.exists())
			{
				JOptionPane.showMessageDialog(null,"Este nombre ya existe, favor de usar otro");
			}
			else 
	        {
	           	fileOut = new BufferedWriter(new FileWriter(file));
	           	fileOut.write(data);
	           	fileOut.close(); 	
	       	}
		}
		catch(IOException ex)
		{
			System.out.println("Error:" + ex);
		}
	}
    
    
    
    public void saveFiles(String name, String data)
	{
		try
		{
			file = new File("C:/Users/Julio Cesar Gonález/Desktop/ExaF/"+name);
			if(file.exists())
			{
				fileOut = new BufferedWriter(new FileWriter(file));
	           	fileOut.write(data);
	           	fileOut.close();
			}
			else 
	        {
	           	fileOut = new BufferedWriter(new FileWriter(file));
	           	fileOut.write(data);
	           	fileOut.close(); 	
	       	}
		}
		catch(IOException ex)
		{
			System.out.println("Error:" + ex);
		}
	}
	
	
	public String open(String name)
	{
		String datos="";
		try
		{
			fileIn = new BufferedReader(new FileReader("C:/Users/Julio Cesar Gonález/Desktop/ExaF/"+name));
			
			while(fileIn.ready())
			{
				 datos = datos + fileIn.readLine() + "\n";
			}
		
			fileIn.close();
		
		}
		catch(FileNotFoundException fn)
		{
			System.out.println("Error : " + fn);
		}
		catch(IOException ex)
		{
			System.out.println("Error : " + ex);
		}
		
		return datos;
	}
	
	public Vector obtenerArchivos()
	{
		String x = "",str;
		try
		{
		//1.Abrir el archivo de datos
		archivoIn = new BufferedReader(new FileReader("Directorio.txt"));
		
		//2.Leer todos los datos del archivo
		vectorFiles = new Vector();
		while(archivoIn.ready())
		{
			str = archivoIn.readLine();			
			vectorFiles.add(str);	
		}
		
		//3.Cerrar el archivo
		archivoIn.close();
		
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error : " + e);
		}
		catch(IOException e)
		{
			System.out.println("Error : " + e);
		}
		return vectorFiles;
	}
	
	public String openFile(String name) 
    {
        String result="";
        try 
        {
            BufferedReader archivoIn = new BufferedReader(new FileReader(name));
            while (archivoIn.ready()) 
            {
                result += archivoIn.readLine()+"\n";
            }
            archivoIn.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Error: " + e);
        } 
        catch (IOException e) 
        {
            System.out.println("Error: " + e);
        }
        return result;
    }
    
    public Vector returnVector(String datos) 
    {
        String[] intermediate = datos.split("&");
        vectorData = new Vector();
        for (int i = 0; i < intermediate.length; i++) 
        {
            vectorData.add(intermediate[i]);
        }
        return vectorData;
    } 
        
    public String archivosDisponibles() 
    {
        String songs = "";
        File directory = new File(".");
        // get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) 
        {
            songs += file.getName()+"&";
        }
        return songs;
    }
    
    public String deleteArchivo(String name) 
    {
       	File file = new File(name);
    	if(file.delete())
    	{
    		res="Archivo borrado exitosamente";
    	}
    	else
    	{
    		res="El archivo no puede ser borrado";
    	}
    	
    	return res;    
    }
    
    public String capturarDatos(String datos, String name) 
    {

        try 
        {
            //Abrir archivo
            BufferedWriter archivoOut = new BufferedWriter(new FileWriter(name));
            archivoOut.write(datos);
            archivoOut.close();
            return "Successfully written";
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("error: " + e);
        } 
        catch (IOException e) 
        {
            System.out.println("error: " + e);
        }
        return "Failure in capturing data";
    }
}