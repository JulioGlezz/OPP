import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Vector;

public class AudioItunesADVL
{
	private BufferedReader archivoIn;
	private Vector vectorArtistas, vectorAlbums, vectorSongs;
	
	public Vector obtenerArtistas()
	{
		String str;
		try
		{
			// 1. Abrir el archivo de datos
			archivoIn= new BufferedReader(new FileReader("Artistas.txt"));
			vectorArtistas= new Vector();
			
			// 2. Leer todos los datos del archivo
			while(archivoIn.ready())
			{
				str=archivoIn.readLine();
				//artistas=artistas+str+"\n";
				vectorArtistas.add(str);
			}
			
			// 3. Cerrar el archivo
			archivoIn.close();
		}
		catch(FileNotFoundException e1)
		{
			System.out.println("Error "+e1);
		}
		catch(IOException e2)
		{
			System.out.println("Error "+e2);
		}
		return vectorArtistas;
	}
	
	public Vector obtenerAlbums(String artista)
	{
		String str,album,grupo;
		StringTokenizer st;
		
		try
		{
			// 1. Abrir el arcivo de datos
			archivoIn= new BufferedReader(new FileReader("Albums.txt"));
			vectorAlbums= new Vector();
			
			// 2. Leer todos los datos del archivo del artista seleccionado
			while(archivoIn.ready())
			{
				str=archivoIn.readLine();
				st=new StringTokenizer(str,"_");
				
				grupo=st.nextToken();
				album=st.nextToken();
				
				if(grupo.equals(artista))
				{
					vectorAlbums.add(album);
				}
			}
			
			// 3. Cerrar el archivo
			archivoIn.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error " + e);
		}
		catch(IOException e)
		{
			System.out.println("Error " + e);
		}
		
		return vectorAlbums;
	}
	
	public Vector obtenerSongs(String album)
	{
		String str, albums,song;
		StringTokenizer st;
		try
		{
			// 1. Abrir el arcivo de datos
			archivoIn = new BufferedReader(new FileReader("Songs.txt"));
			vectorSongs = new Vector();
			
			// 2. Leer todos los datos del archivo del artista seleccionado
			while(archivoIn.ready())
			{
				str = archivoIn.readLine();
				st = new StringTokenizer(str,"_");
				
				albums = st.nextToken();
				song = st.nextToken();
				
				if(albums.equals(album)) vectorSongs.add(song);
			
			}
				
			// 3. Cerrar el archivo
			archivoIn.close();

		}
		catch(FileNotFoundException e1)
		{
			System.out.println("Error "+e1);
		}
		catch(IOException e2)
		{
			System.out.println("Error "+e2);
		}
		
		return vectorSongs;
	}
	
}