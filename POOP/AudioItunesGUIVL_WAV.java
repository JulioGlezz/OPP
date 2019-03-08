import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.awt.*;
import java.awt.event.*;

import java.util.Vector;


public class AudioItunesGUIVL_WAV extends JFrame implements ActionListener,ListSelectionListener
{
	//Atributos
	private JPanel panelUsuario, panelArtistas, panelAlbums, panelSongs, panelAudio, panelPrincipal;
	private JButton bCatalogo, bArtista, bAlbums, bSongs;
	private JButton bPlay, bStop;
	private JTextField tfArtista, tfAlbums, tfSong;
	private JTextArea taArtistas, taAlbums, taSongs;
	
	private AudioOS audio = new AudioOS();
	private AudioItunesADVL audioitunesad = new AudioItunesADVL();
	private Vector vectorCancion, vectorArtistas, vectorAlbums, vectorSongs;
	private JList listaArtistas, listaAlbums, listaSongs;
	
	public AudioItunesGUIVL_WAV()
	{
		super("Audio iTunes");
		
		// 1. Crear objetos de los atributos
		panelUsuario	= new JPanel();
		panelArtistas	= new JPanel();
		panelAlbums		= new JPanel();
		panelSongs		= new JPanel();
		panelAudio		= new JPanel();
		panelPrincipal	= new JPanel();
		
		bCatalogo		= new JButton("CATALOGO");
		bArtista		= new JButton("ARTISTA");
		bAlbums			= new JButton("ALBUMS");
		bSongs			= new JButton("SONGS");
		bPlay			= new JButton("PLAY");
		bStop			= new JButton("STOP");
		
		tfArtista		= new JTextField(10);
		tfAlbums		= new JTextField(10);
		tfSong			= new JTextField(10);
		
		taArtistas		= new JTextArea("Artistas",10,20);
		taAlbums		= new JTextArea("Albums");
		taSongs			= new JTextArea("Songs",10,20);
		
		//Definir el Action Listener
		bCatalogo.addActionListener(this);
		bArtista.addActionListener(this);
		bAlbums.addActionListener(this);
		bSongs.addActionListener(this);
		bPlay.addActionListener(this);
		bStop.addActionListener(this);
		
		
		// 2. Definir Layout de los panels
		panelUsuario.setLayout(new FlowLayout());
		panelArtistas.setLayout(new GridLayout(1,1));
		panelAlbums.setLayout(new GridLayout(1,1));
		panelSongs.setLayout(new GridLayout(1,1));
		panelAudio.setLayout(new FlowLayout());
		panelPrincipal.setLayout(new BorderLayout(5,5));
		
		
		// 3. Adicionar los objetos en los Layout correspondientes
		panelUsuario.add(bCatalogo);
		panelUsuario.add(new JLabel("Artista: "));
		panelUsuario.add(tfArtista);
		panelUsuario.add(bAlbums);
		panelUsuario.add(new JLabel("Album: "));
		panelUsuario.add(tfAlbums);
		panelUsuario.add(bSongs);
		
		panelArtistas.add(new JScrollPane(taArtistas));
		panelAlbums.add(new JScrollPane(taAlbums));
		panelSongs.add(new JScrollPane(taSongs));
		
		panelAudio.add(new JLabel("Song: "));
		panelAudio.add(tfSong);
		panelAudio.add(bPlay);
		panelAudio.add(bStop);
		
		panelPrincipal.add(panelUsuario, BorderLayout.NORTH);
		panelPrincipal.add(panelArtistas,BorderLayout.WEST);
		panelPrincipal.add(panelAlbums,BorderLayout.CENTER);
		panelPrincipal.add(panelSongs,BorderLayout.EAST);
		panelPrincipal.add(panelAudio,BorderLayout.SOUTH);
		
		
		// 4. Adicionar el panel principal al JFrame
		add(panelPrincipal);
		setSize(700,400);
		//setVisible(true);
	}
	
	public void albums()
	{
		String artistas;
		// 1. Leer el Artista del tfArtista
		artistas=tfArtista.getText();
		
		// 2. Obtener los Albums del artista seleccionado
		vectorAlbums=audioitunesad.obtenerAlbums(artistas);
		
		// 3. Crear un JList del vector artistas
		listaAlbums= new JList(vectorAlbums);
		listaAlbums.addListSelectionListener(this);
			
		// 4. Desplegar el Jlist en el panel artistas
		panelAlbums.setVisible(false);
		panelAlbums.removeAll();
		panelAlbums.add(listaAlbums);
		panelAlbums.setVisible(true);
	}
	
	public void songs()
	{
		String albums;
		// 1. Leer el Artista del tfArtista
		albums=tfAlbums.getText();
			
		// 2. Obtener los Albums del artista seleccionado
		vectorSongs=audioitunesad.obtenerSongs(albums);
		
		// 3. Crear un JList del vector artistas
		listaSongs= new JList(vectorSongs);
		listaSongs.addListSelectionListener(this);
			
		// 4. Desplegar el Jlist en el panel artistas
		panelSongs.setVisible(false);
		panelSongs.removeAll();
		panelSongs.add(listaSongs);
		panelSongs.setVisible(true);
	}
	
	public void artistas1()
	{
		// 1. Obtener los artistas del archivo
		vectorArtistas=audioitunesad.obtenerArtistas();
			
		// 2. Crear un JList del vector artistas
		listaArtistas = new JList(vectorArtistas);
		listaArtistas.addListSelectionListener(this);
			
		// 3. Desplegar el Jlist en el panel artistas
		panelArtistas.setVisible(false);
		panelArtistas.removeAll();
		panelArtistas.add(listaArtistas);
		panelArtistas.setVisible(true);
	}
	
	public void reproducir()
	{
		String cancion;	
		cancion=tfSong.getText();
		audio.reproducir(cancion);
	}
	
	public JPanel getpanel2()
	{
		return panelPrincipal;
	}
	
	public void actionPerformed(ActionEvent opcion)
	{
	
		if(opcion.getSource()==bCatalogo)
		{
			artistas1();
		}
		
		if(opcion.getSource()==bAlbums)
		{
			albums();
		}
		
		if(opcion.getSource()==bSongs)
		{
			songs();
		}
		
		if(opcion.getSource()==bPlay)
		{	 
			reproducir();
		}
		
		if(opcion.getSource()== bStop)
		{
			audio.stop();
		}
	}
	
	public void valueChanged(ListSelectionEvent lse)
	{
		String artistaE, albumE, songE;
		
		if(lse.getValueIsAdjusting()==true)
		{
			if(lse.getSource()== listaArtistas)
			{
				artistaE= (String)listaArtistas.getSelectedValue();
				tfArtista.setText(artistaE);
				//System.out.println(artistaE);
				albums();
			}
			
			if(lse.getSource()== listaAlbums)
			{
				albumE=(String)listaAlbums.getSelectedValue();
				tfAlbums.setText(albumE);
				songs();
			}
			
			if(lse.getSource()==listaSongs )
			{
				songE= (String)listaSongs.getSelectedValue();
				tfSong.setText(songE);
				reproducir();
			}
		}
	}
	
	public static void main (String args[])
	{
		new AudioItunesGUIVL_WAV();
	}
}
