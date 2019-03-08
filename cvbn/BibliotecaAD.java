import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;

public class BibliotecaAD
{
	private BufferedReader archivoIn;
	private PrintWriter	archivoOut;
	private Vector vectorEditoriales, vectorTitulo,vectorLibro;
	
	private ImageIcon imagenesTitulos[];
	
	public Vector obtenerEditoriales()
	{	
		String editoriales="",str;
		try
		{
			//1. Abrir el archivo de datos
			archivoIn = new BufferedReader(new FileReader("Editoriales.txt"));	
			
			//2. Leer todos los datos del archivo
			vectorEditoriales = new Vector();
			while(archivoIn.ready())
			{
				str = archivoIn.readLine();
				vectorEditoriales.add(str);
			}
			
			//3. Cerrar el archivo
			archivoIn.close();
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error: "+fnfe);
		}
		catch(IOException ioe) //excepción de entradas y salidas 
		{
			System.out.println("Error: "+ioe);
		}
		
		return vectorEditoriales;
	}
		public ImageIcon[] obtenerImagenesbTitulo(String libro)
	{
		String str, libros="",titulo="", autor,editorial="", edit, datos="";
		StringTokenizer st;
		int checar=0;
		try
		{
			//1.Abrir el archivo de datos
			archivoIn = new BufferedReader(new FileReader("Libros.txt"));
			
			//2.Leer los datos del archivo
			vectorTitulo = new Vector();
			vectorLibro = new Vector();
			while(archivoIn.ready())
			{
				datos="";
				str=archivoIn.readLine();
				st=new StringTokenizer(str, "_");
				titulo = st.nextToken();
				autor = st.nextToken();
				edit=st.nextToken();
				if(libro.equals(titulo))
				{
					datos=datos+"TITULO: "+titulo;
					datos=datos+"\nAUTOR: "+autor;
					datos=datos+"\nEDITORIAL: "+edit+"\n\n";
					vectorTitulo.add(titulo);
					checar++;
					vectorLibro.add(titulo);
				}
			}
			if (checar==0)
			{
				vectorTitulo.add("NFOUND");
			}
		
			//3.Cerrar archivo
			archivoIn.close();
			//4. Generar la lista de imagenes a partir del vector libros
			imagenesTitulos = new ImageIcon[vectorTitulo.size()];
			String strImagen="";

			for(int i=0; i<vectorTitulo.size(); i++)
			{
				System.out.println(i);
				strImagen = "imagenes/"+(String)vectorTitulo.get(i).toString()+".jpg";
				System.out.println(strImagen);
				imagenesTitulos[i] = new ImageIcon(getClass().getResource(strImagen));
			}

		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error: " + fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error: "+ioe);
		}

		return imagenesTitulos;
	}
	
	
	public ImageIcon[] obtenerImagenesbAutor(String autor)
	{
		String str, libros="",titulo="", aut,editorial="", edit, datos="";
		StringTokenizer st;
		int checar=0;
		try
		{
			//1.Abrir el archivo de datos
			archivoIn = new BufferedReader(new FileReader("Libros.txt"));
			
			//2.Leer los datos del archivo
			vectorTitulo = new Vector();
			vectorLibro = new Vector();
			while(archivoIn.ready())
			{
				datos="";
				str=archivoIn.readLine();
				st=new StringTokenizer(str, "_");
				titulo = st.nextToken();
				aut = st.nextToken();
				edit=st.nextToken();
				if(aut.equals(autor))
				{
					datos=datos+"TITULO: "+titulo;
					datos=datos+"\nAUTOR: "+aut;
					datos=datos+"\nEDITORIAL: "+edit+"\n\n";
					vectorTitulo.add(titulo);
					checar++;
					vectorLibro.add(titulo);
				}
			}
			if (checar==0)
			{
				vectorTitulo.add("NFOUND");
			}
		
			//3.Cerrar archivo
			archivoIn.close();
			//4. Generar la lista de imagenes a partir del vector libros
			imagenesTitulos = new ImageIcon[vectorTitulo.size()];
			String strImagen="";

			for(int i=0; i<vectorTitulo.size(); i++)
			{
				System.out.println(i);
				strImagen = "imagenes/"+(String)vectorTitulo.get(i).toString()+".jpg";
				System.out.println(strImagen);
				imagenesTitulos[i] = new ImageIcon(getClass().getResource(strImagen));
			}

		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error: " + fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error: "+ioe);
		}

		return imagenesTitulos;
	}
	public Vector obtenerTitulos(String editorial)
	{
		String str, titulos="", titulo, autor, edit;
		StringTokenizer st;
		
		try
		{
			//1.Abrir el archivo de Datos
			archivoIn = new BufferedReader(new FileReader("Libros.txt"));
		
			//2.Leer todos los datos del archivo
			vectorTitulo = new Vector();
			while(archivoIn.ready())
			{
				str = archivoIn.readLine();
				st = new StringTokenizer(str,"_");
				titulo    = st.nextToken();
				autor     = st.nextToken();
				edit = st.nextToken();
				
				if(editorial.equals(titulo))
				{
					//albums = albums + album + "\n";
					vectorTitulo.add(titulo);
				}
			}
			//3, Cerrar el archivo
			archivoIn.close();
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error: "+fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error: "+ioe);
		}
		
			
		return vectorTitulo;
	}



	public ImageIcon[] obtenerImagenesTitulos(String editorial)
	{
		String str, libros="",titulo, autor, edit;
		StringTokenizer st;
		int checar=0;
		
		try
		{
			//1.Abrir el archivo de datos
			archivoIn = new BufferedReader(new FileReader("Libros.txt"));
			
			//2.Leer los datos del archivo
			vectorTitulo = new Vector();
			vectorLibro = new Vector();
			while(archivoIn.ready())
			{
				str    = archivoIn.readLine();
				st     = new StringTokenizer(str,"_");
				titulo = st.nextToken();
				autor  = st.nextToken();
				edit   = st.nextToken();
				
				if(editorial.equals(edit))
				{
					vectorTitulo.add(titulo);
					vectorLibro.add(titulo);
					checar++;
				}
			}
			if (checar==0)
			{
				vectorTitulo.add("NFOUND");
			}
			
			//3.Cerrar archivo
			archivoIn.close();
			//4. Generar la lista de imagenes a partir del vector libros
			imagenesTitulos = new ImageIcon[vectorTitulo.size()];
			String strImagen="";
			for(int i=0; i<vectorTitulo.size(); i++)
			{
				
				strImagen = "imagenes/"+(String)vectorTitulo.get(i).toString()+".jpg";
				imagenesTitulos[i] = new ImageIcon(getClass().getResource(strImagen));
			}
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error: " + fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error: "+ioe);
		}

		return imagenesTitulos;
	}	
	
		public String getTitulo(int casillaTitulo)
	{
		return vectorTitulo.get(casillaTitulo).toString(); //Lo que me esta dando es un string, con casting regreso un string
	}
	
		public String consultarLibros()
	{
		String str, libros="",titulo, autor, edit, datos="";
		StringTokenizer st;
		try
		{
			//1.Abrir el archivo de datos
			archivoIn = new BufferedReader(new FileReader("Libros.txt"));
			
			//2.Leer los datos del archivo
			while(archivoIn.ready())
			{
				str=archivoIn.readLine();
				st=new StringTokenizer(str, "_");
				titulo = st.nextToken();
				autor = st.nextToken();
				edit=st.nextToken();
				
				datos=datos+"TITULO: "+titulo;
				datos=datos+"\nAUTOR: "+autor;
				datos=datos+"\nEDITORIAL: "+edit+"\n\n";
			}
			
			//3.Cerrar archivo
			archivoIn.close();
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error: " + fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error: "+ioe);
		}

		return datos;
	}
	
	public String capturar(String datos)
	{
		String resultado="", respuesta="";
		try
		{
			//1. Abrir archivo Libros.txt para capturar datos
			archivoOut = new PrintWriter(new FileWriter("Libros.txt", true));
			//2. Escribir o capturar los datos
			archivoOut.println(datos);
			//3. Cerrar el archivo
			archivoOut.close();
			resultado=("Captura exitosa del Libro: "+datos);
			//4. Checar si la editorial existe en el archivo Editoriales.txt
			resultado = resultado + respuesta+"\n";
		}
		catch(IOException ioe)
		{
			resultado="Error en capturar datos";
			System.out.println("Error: "+ioe);
		}
		//4. Entregar resultado
		return resultado;
	}
	
	public void capturarEditorial(String editorial)
	{
		String str="" ,resultado="";
		int existe=0;
		
		try
		{
		  archivoIn = new BufferedReader(new FileReader("Editoriales.txt"));
		
		while(archivoIn.ready())
			{
				str = archivoIn.readLine();
				if(str.equals(editorial))
				{
					existe=1;
				}
			}
			
		//3. Cerrar el archivo
		archivoIn.close();
		
		//3.Buscar la editorial
		archivoOut = new PrintWriter(new FileWriter("Editoriales.txt", true));
		if(existe!=1)
		{
			archivoOut.println(editorial);
		}
		
		archivoOut.close();
		
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error: " + fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error: "+ioe);
		}


	}
	
	public String obtenerDatos(String tituloElegido)
	{
		String datos="", str,editorial,autor,libros;
		StringTokenizer st;
		
		try
		{
			//1.Abrir el archivo de datos
		archivoIn = new BufferedReader (new FileReader ("Libros.txt"));
		//2.Leer todos los datos del archivo
		while(archivoIn.ready())
		{
		   str = archivoIn.readLine();
		   st  = new StringTokenizer(str,"_");
		   libros  = st.nextToken();
		   autor = st.nextToken();
		   editorial = st.nextToken();
			  
		  if(tituloElegido.equals(libros))
		  
		    {
		    	//albums = albums + album + "\n";
		     	datos = datos+"Editorial : "+editorial+ "\nLibro : "+ libros+"\nAutor : "+ autor+"\n";
		     	
		  	}
		  
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

        return datos;
	}
}