import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.*;

public class BibliotecaAD
{
	private BufferedReader archivoIn,archivoDatos;
	private PrintWriter archivoOut;
	
	private Vector vectorEditoriales,vectorDatos,vectorImagenes;
	private ImageIcon imagenesLibros[];
	
	public Vector obtenerNombres()
	{
		String artistas="",str;
		try
		{
		
		//1.Abrir el archivo de datos
		archivoIn = new BufferedReader(new FileReader("Editoriales.txt"));
		
		//2.Leer todos los datos del archivo
		vectorEditoriales = new Vector();
		while(archivoIn.ready())
		{
			str = archivoIn.readLine();
			
			//artistas= artistas + str + "\n";
			vectorEditoriales.add(str);	
		}
		
		//3.Cerrar el archivo
		archivoIn.close();
		
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error : "+fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error : "+ioe);
		}
		return vectorEditoriales;
	}
	
	
	public Vector obtenerDatos(String editorialElegida)
	{
		String persona="",strDatos,nombre,libro,autor,editorial;
		StringTokenizer st;
		try
		{
		
		//1.Abrir el archivo de datos
		archivoDatos = new BufferedReader(new FileReader("Libros.txt"));
		
		//2.Leer todos los datos del archivo
		vectorDatos = new Vector();
		while(archivoDatos.ready())
		{
			strDatos = archivoDatos.readLine();
			
				st = new StringTokenizer(strDatos,"_");
				libro = st.nextToken();
				autor = st.nextToken();
				editorial=st.nextToken();
				
				
				
				if(editorialElegida.equals(editorial))
				{
	
					vectorDatos.add("Libro: "+libro);
					vectorDatos.add("Autor: "+autor);
					vectorDatos.add("Editorial: "+editorial);
					
				}
				
				
			
			
		}
		
		//3.Cerrar el archivo
		archivoDatos.close();
		
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error : "+fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error : "+ioe);
		}
		return vectorDatos;
		
		
			
	}
	
	public ImageIcon[] obtenerImagenesLibros(String editorialpro)
	{
		String str,albums="",libro,autor,editorial;
		StringTokenizer st;
		try
		{
			//1 Abrir archivo de datos
			archivoIn = new BufferedReader(new FileReader("Libros.txt"));	
			
			//2 Leer los datos
			vectorImagenes = new Vector();
			while(archivoIn.ready())
			{
				str = archivoIn.readLine();
				
				st = new StringTokenizer(str,"_");
				libro = st.nextToken();
				autor = st.nextToken();
				editorial= st.nextToken();
				
				if(editorialpro.equals(editorial))
				{
					vectorImagenes.add(libro);	
				}
			}
			
			//3.Cerrar el archivo
			archivoIn.close();
			
			//4.Generar la lista de imagenes a partir del vector de albums
			imagenesLibros = new ImageIcon[vectorImagenes.size()];
			
			String strImagen="";
			for(int i=0; i<vectorImagenes.size(); i++)
			{
				strImagen=(String)vectorImagenes.get(i).toString()+".jpg";
				imagenesLibros[i] = new ImageIcon(getClass().getResource(strImagen));
			}
			
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error : "+fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error : "+ioe);
		}
		return imagenesLibros;
	}
	
	public String getLibros(int casillaImagen)
	{
		return (String)vectorImagenes.get(casillaImagen).toString();
	}
	
	public Vector obtenerDatosImg(String libroElegido)
	{
		String persona="",strDatos,nombre,libro,autor,editorial;
		StringTokenizer st;
		try
		{
		
		//1.Abrir el archivo de datos
		archivoDatos = new BufferedReader(new FileReader("Libros.txt"));
		
		//2.Leer todos los datos del archivo
		vectorDatos = new Vector();
		while(archivoDatos.ready())
		{
			strDatos = archivoDatos.readLine();
			
				st = new StringTokenizer(strDatos,"_");
				libro = st.nextToken();
				autor = st.nextToken();
				editorial=st.nextToken();
				
				
				
				if(libroElegido.equals(libro))
				{
	
					vectorDatos.add("Libro: "+libro);
					vectorDatos.add("Autor: "+autor);
					vectorDatos.add("Editorial: "+editorial);
					
				}
				
				
			
			
		}
		
		//3.Cerrar el archivo
		archivoDatos.close();
		
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error : "+fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error : "+ioe);
		}
		return vectorDatos;
	}
	
	public ImageIcon[] obtenerDatosPRO(String editorialElegida)
	{
		String str,albums="",libro,autor,editorial;
		StringTokenizer st;
		
		try
		{
			//1 Abrir archivo de datos
			archivoIn = new BufferedReader(new FileReader("Libros.txt"));	
			
			//2 Leer los datos
			vectorImagenes = new Vector();
			while(archivoIn.ready())
			{
				str = archivoIn.readLine();
				
				st = new StringTokenizer(str,"_");
				libro = st.nextToken();
				autor = st.nextToken();
				editorial= st.nextToken();
				
				if(editorialElegida.equals(libro))
				{
					
					vectorImagenes.add(libro);	
				}
				
				
			}
			
			//3.Cerrar el archivo
			archivoIn.close();
			
			//4.Generar la lista de imagenes a partir del vector de albums
			imagenesLibros = new ImageIcon[vectorImagenes.size()];
			
			String strImagen="";
			for(int i=0; i<vectorImagenes.size(); i++)
			{
				strImagen=(String)vectorImagenes.get(i).toString()+".jpg";
				imagenesLibros[i] = new ImageIcon(getClass().getResource(strImagen));
			}
			
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error : "+fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error : "+ioe);
		}
		return imagenesLibros;	
		
		
			
	}
	
	
	
	public ImageIcon[] obtenerDatosPROC(String editorialElegida)
	{
		String str,albums="",libro,autor,editorial;
		StringTokenizer st;
		try
		{
			//1 Abrir archivo de datos
			archivoIn = new BufferedReader(new FileReader("Libros.txt"));	
			
			//2 Leer los datos
			vectorImagenes = new Vector();
			while(archivoIn.ready())
			{
				str = archivoIn.readLine();
				
				st = new StringTokenizer(str,"_");
				libro = st.nextToken();
				autor = st.nextToken();
				editorial= st.nextToken();
				
				if(editorialElegida.equals(autor))
				{
					vectorImagenes.add(libro);	
				}
			}
			
			//3.Cerrar el archivo
			archivoIn.close();
			
			//4.Generar la lista de imagenes a partir del vector de albums
			imagenesLibros = new ImageIcon[vectorImagenes.size()];
			
			String strImagen="";
			for(int i=0; i<vectorImagenes.size(); i++)
			{
				strImagen=(String)vectorImagenes.get(i).toString()+".jpg";
				imagenesLibros[i] = new ImageIcon(getClass().getResource(strImagen));
			}
			
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error : "+fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error : "+ioe);
		}
		return imagenesLibros;	
			
	}
	
	public String consultarLibros()
	{
		String persona="",strDatos,nombre,libro,autor,editorial;
		String datos="";
		StringTokenizer st;
		try
		{
		
		//1.Abrir el archivo de datos
		archivoDatos = new BufferedReader(new FileReader("Libros.txt"));
		
		//2.Leer todos los datos del archivo
		//vectorDatos = new Vector();
		while(archivoDatos.ready())
		{
			strDatos = archivoDatos.readLine();
			
			 datos = datos + strDatos + "\n";
					
		}
		
		//3.Cerrar el archivo
		archivoDatos.close();
		
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error : "+fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error : "+ioe);
		}
		return datos;
	}
	
	public String capturar(String datos)
	{
		String resultado="",respuesta;
		
		try{
		
			//1. ABRIR ARCHIVO LIBROS.TXT PARA CAPTURAR DATOS
		
			archivoOut=new PrintWriter(new FileWriter("Libros.txt",true)); //FILEWRITER TIENE 2 PARAMETROS///
		
			//2.ESCRIBIR O CAPTURAR LOS DATOS                              
			archivoOut.println(datos);
		
			//3.CERRAR EL ARCHIVO 
			archivoOut.close();
			
			resultado="Captura exitosa del Libro:"+datos;
			
			//4 . CHECAR SI LA EDITORIAL EXISTE EN EL ARCHIVO EDITORIALES,TXT
			
			respuesta = capturarEditorial(datos);
			
			resultado = resultado + respuesta + "\n";
			
		}
		catch(IOException ioe)
		{
			resultado="Error en capturar datos...";
			System.out.println("Error:"+ioe);
		}                                        
		
		//4.ENTREGAR RESULTADO DE LA TRANSACCION
		
		return resultado;
	}
	
	private String capturarEditorial(String datos)
	{
		String resultado="",titulo,autor,editorial;
		boolean encontrado=false;
		StringTokenizer st;
		
		//1 OBTENER LA EDITORIAL
		
		st = new StringTokenizer(datos,"_");
		
		titulo = st.nextToken();
		autor = st.nextToken();
		editorial = st.nextToken();
		
		try
		{
			archivoIn = new BufferedReader(new FileReader("Editoriales.txt"));
			
			while(archivoIn.ready()&&encontrado==false)
			{
				String str = archivoIn.readLine();
				
				if(str.equals(editorial))
				{
					encontrado=true;
				}
				
				
				
			}
			
			archivoIn.close();
			
			if(encontrado==false)
			{
				archivoOut = new PrintWriter(new FileWriter("Editoriales.txt",true));
						
				archivoOut.println(editorial);
						
				archivoOut.close();
				resultado="\n Editorial nueva registrada";
			}
			
			
		}
		
		catch(IOException ioe)
		{
			resultado="Error en capturar datos...";
			System.out.println("Error:"+ioe);
		} 
		
	
		
		return resultado;
	}		
}