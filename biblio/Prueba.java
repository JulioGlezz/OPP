import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Prueba
{
	private BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	private String titulo, autor;
	
	private void pedirDatos()
	{
		try
		{
			titulo = JOptionPane.showInputDialog("Titulo del Libro: ");
			System.out
		}	
	}
	
	private void mostrarDatos()
	{
		
	}
	
	
	public static void main(String args[])
	{
		Prueba pr = new Prueba();
		
		pr.pedirDatos();
		pr.mostrarDatos();
	}
}