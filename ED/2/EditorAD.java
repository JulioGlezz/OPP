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
	
	public void saveAsFiles(String name, String data)
	{
		try
		{
			file = new File("C:/Users/Julio Cesar Gonález/Desktop/ED/2/" + name);
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
			file = new File("C:/Users/Julio Cesar Gonález/Desktop/ED/2/"+name);
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
			fileIn = new BufferedReader(new FileReader("C:/Users/Julio Cesar Gonález/Desktop/ED/2/"+name));
			
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
    
}