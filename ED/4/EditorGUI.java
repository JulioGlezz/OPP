import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.StringTokenizer;

import java.util.Vector;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class EditorGUI extends JFrame implements ActionListener, ListSelectionListener
{
    private JMenuBar  menuBar;
    private JMenu     menu, menuFile;
    private JMenuItem menuItemNew, menuItemAbrir, menuItemGuardar, menuItemGuardarAs, menuItemSalir;
    private JMenuItem menuItemOpen, menuItemCopy, menuItemDelete, menuItemClose;
    
    private JTextArea taEditor= new JTextArea(20,40);
    private JPanel	  panel;
    private String    nombreArchivo="", archivoElegido;
    
    private Vector vectorFiles = new Vector();
    private JList  listaFiles  = new JList();
    
    private EditorAD editorad= new EditorAD();
    
    private String respuesta;
    
    public EditorGUI()
    {
        super("Editor Básico");
        
        menuBar = new JMenuBar();
        menu    = new JMenu("Editor Basico");
        menuFile= new JMenu("File");
        panel   = new JPanel();
        panel.setLayout(new FlowLayout());
        
        menuItemNew     = new JMenuItem("New");
        menuItemAbrir   = new JMenuItem("Open");
        menuItemOpen    = new JMenuItem("Open File");
        menuItemCopy    = new JMenuItem("Copy File");
        menuItemDelete  = new JMenuItem("Delete File");
        menuItemGuardar = new JMenuItem("Save");
        menuItemGuardarAs = new JMenuItem("Save As");
        menuItemClose   = new JMenuItem("Close");
        menuItemSalir   = new JMenuItem("Exit");
        
        //menuFile.setEnabled(false);
        menuItemOpen.setEnabled(false);
        menuItemCopy.setEnabled(false);
        menuItemDelete.setEnabled(false);
        
        menuItemNew.addActionListener(this);
        menuItemAbrir.addActionListener(this);
        menuItemOpen.addActionListener(this);
        menuItemCopy.addActionListener(this);
        menuItemDelete.addActionListener(this);
        menuItemGuardar.addActionListener(this);
        menuItemGuardarAs.addActionListener(this);
        menuItemClose.addActionListener(this);
        menuItemSalir.addActionListener(this);
        
        menu.add(menuItemNew);
        menu.add(menuItemAbrir);
        
        menuFile.add(menuItemOpen);
        menuFile.add(menuItemCopy);
        menuFile.add(menuItemDelete);
        
        menu.add(menuFile);
        menu.add(menuItemGuardar);
        menu.add(menuItemGuardarAs);
        menu.add(menuItemClose);
        menu.add(menuItemSalir);
        
        menuBar.add(menu);
        
        panel.add(new JScrollPane(taEditor));
        panel.setVisible(false);
        
        setJMenuBar(menuBar);
        
        add(panel);
        setSize(500,400);
        setVisible(true);
    }
    
    private void activaItems()
    {
        //menuFile.setEnabled(true);
        menuItemOpen.setEnabled(true);
        menuItemCopy.setEnabled(true);
        menuItemDelete.setEnabled(true);
    }
    
    private void inactivaItems()
    {
        //menuFile.setEnabled(false);
        menuItemOpen.setEnabled(false);
        menuItemCopy.setEnabled(false);
        menuItemDelete.setEnabled(false);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource() == menuItemNew)
        {
            //JOptionPane.showMessageDialog(null,"Abrir un nuevo archivo...");
            nombreArchivo=JOptionPane.showInputDialog("Nombre del archivo: ");
            taEditor.setText("");
            panel.setVisible(false);
            panel.removeAll();
            panel.add(new JScrollPane(taEditor));
            panel.setVisible(true);
        }
        
        if(e.getSource() == menuItemOpen)
        {
            //JOptionPane.showMessageDialog(null,"Abrir un archivo del directorio...");
            String datos;
            datos=editorad.abrir(nombreArchivo);
            taEditor.setText(datos);
            panel.setVisible(false);
            panel.removeAll();
            panel.add(new JScrollPane(taEditor));
            panel.setVisible(true);
            inactivaItems();
        }
        
        
        if(e.getSource() == menuItemAbrir)
        {
            //JOptionPane.showMessageDialog(null,"Mostrar Archivos del Directorio...");
    		listaFiles=editorad.lista();
    		listaFiles.addListSelectionListener(this);
    		panel.setVisible(false);
            panel.removeAll();
            panel.add(new JScrollPane(listaFiles));
            panel.setVisible(true);
            
        }
        
        if(e.getSource() == menuItemGuardar)
        {
            //JOptionPane.showMessageDialog(null,"Guardar un archivo...");
            String escrito;
            escrito=taEditor.getText();
            respuesta=editorad.guardar(nombreArchivo,escrito);
            JOptionPane.showMessageDialog(null,respuesta);
        }
        
        if(e.getSource() == menuItemGuardarAs)
        {
            //JOptionPane.showMessageDialog(null,"Guardar archivo con otro nombre...");
            String escrito;
            escrito=taEditor.getText();
            nombreArchivo=JOptionPane.showInputDialog("Nombre del archivo: ");
            respuesta=editorad.guardar(nombreArchivo,escrito);
            JOptionPane.showMessageDialog(null,respuesta);
        }
        
        if(e.getSource() == menuItemDelete)
        {
            //JOptionPane.showMessageDialog(null,"Borrar un archivo del directorio...");
            archivoElegido=nombreArchivo;
            respuesta=editorad.borrar(archivoElegido);
            JOptionPane.showMessageDialog(null,respuesta);
            inactivaItems();
        }
        
        if(e.getSource() == menuItemCopy)
        {
            //JOptionPane.showMessageDialog(null,"Copiar un archivo...");
            archivoElegido=nombreArchivo;
            String datos=editorad.abrir(nombreArchivo);
            StringTokenizer st;
            String titulo,n;
            st=new StringTokenizer(archivoElegido,".");
            titulo=st.nextToken();
            n=st.nextToken();
            archivoElegido=titulo+" copia."+n;
            respuesta=editorad.guardar(archivoElegido,datos);
            JOptionPane.showMessageDialog(null,"Archivo copiado exitosamente");
            inactivaItems();
        }
        
        if(e.getSource() == menuItemClose)
        {
            //JOptionPane.showMessageDialog(null,"Cerrar todo...");
            panel.setVisible(false);
            panel.removeAll();
            panel.setVisible(true);
        }
        
        if(e.getSource() == menuItemSalir)
            System.exit(0);
    }
    
    public void valueChanged(ListSelectionEvent lse)
    {   
        if(lse.getValueIsAdjusting() == true)
        {
            if(lse.getSource() == listaFiles)
            {
                nombreArchivo = (String)listaFiles.getSelectedValue();
                System.out.println(nombreArchivo);
                activaItems();
            }
        }
    }
    
    public static void main(String args[])
    {
        new EditorGUI();
    }
}
