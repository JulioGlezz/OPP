import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

public class DirectorioAD
{
	private BufferedReader archivoIn,archivoDatos;
	private Vector vectorPersonas,vectorDatos;
	
	public Vector obtenerDirectorio()
	{
		String x = "",str;
		try
		{
		//1.Abrir el archivo de datos
		archivoIn = new BufferedReader(new FileReader("Directorio.txt"));
		
		//2.Leer todos los datos del archivo
		vectorPersonas = new Vector();
		while(archivoIn.ready())
		{
			str = archivoIn.readLine();			
			vectorPersonas.add(str);	
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
		return vectorPersonas;
	}
	
	
	public Vector obtenerDatos(String personaElegida)
	{
		String persona = "",strDatos,nombre,telefonocasa,telefonocelular,direccion;
		StringTokenizer st;
		try
		{
		
		//1.Abrir el archivo de datos
		archivoDatos = new BufferedReader(new FileReader("Datos.txt"));
		
		//2.Leer todos los datos del archivo
		vectorDatos = new Vector();
		while(archivoDatos.ready())
		{
			strDatos = archivoDatos.readLine();
			
				st = new StringTokenizer(strDatos,"_");
				nombre = st.nextToken();
				telefonocasa = st.nextToken();
				telefonocelular = st.nextToken();
				direccion = st.nextToken();
				
				
				if(personaElegida.equals(nombre))
				{
					vectorDatos.add("Nombre: "+nombre);
					vectorDatos.add("Telefono Casa: "+telefonocasa);
					vectorDatos.add("Telefono Celular: "+telefonocelular);
					vectorDatos.add("Direccion : "+direccion);
				}
		}
		
		//3.Cerrar el archivo
		archivoDatos.close();
		
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error : " + e);
		}
		catch(IOException e)
		{
			System.out.println("Error : " + e);
		}
		return vectorDatos;
		
		
			
	}
	
}