import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Editor extends JFrame implements ActionListener
{
    private JMenuBar  menuBar;
    private JMenu     menu;
    private JMenuItem menuItemNew, menuItemAbrir, menuItemGuardar, menuItemGuardarAs, menuItemSalir;
    
    private JTextArea taEditor= new JTextArea(20,40);
    private JPanel	  panel;
    private String    file="";
    private JFrame v = new JFrame();
    
    private EditorAD editorAD = new EditorAD();
    
    public Editor()
    {
        super("Editor Basico");
        
        menuBar = new JMenuBar();
        menu    = new JMenu("File");
        panel   = new JPanel();
        panel.setLayout(new FlowLayout());
        
        menuItemNew = new JMenuItem("New");
        menuItemNew.addActionListener(this);
        menu.add(menuItemNew);
        
        menuItemAbrir = new JMenuItem("Open");
        menuItemAbrir.addActionListener(this);
        menu.add(menuItemAbrir);
        
        menuItemGuardar = new JMenuItem("Save");
        menuItemGuardar.addActionListener(this);
        menu.add(menuItemGuardar);
        
        menuItemGuardarAs = new JMenuItem("Save As");
        menuItemGuardarAs.addActionListener(this);
        menu.add(menuItemGuardarAs);
        
        menuItemSalir    = new JMenuItem("Exit");
        menuItemSalir.addActionListener(this);
        menu.add(menuItemSalir);
        
        menuBar.add(menu);
        
        panel.add(new JScrollPane(taEditor));
        panel.setVisible(false);
        
        setJMenuBar(menuBar);
        
        add(panel);
        setSize(500,400);
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
    	String datos="";
        
        if(e.getSource() == menuItemNew)
        {
            JOptionPane.showMessageDialog(null,"Nuevo Archivo...");
            taEditor.setText("");
           	panel.setVisible(true);
        }
        
        if(e.getSource() == menuItemAbrir)
        {
            panel.setVisible(true);
            file = JOptionPane.showInputDialog("Abrir Archivo : ");
            datos = editorAD.open(file);
            taEditor.setText(datos);
        }
        
        if(e.getSource() == menuItemGuardar)
        {
        	if(file.equals(""))
        	{
        		file = JOptionPane.showInputDialog(null,"Guardar un Archivo...");	
        	}
        	datos = taEditor.getText();
            editorAD.saveFiles(file,datos);
        }
        
        if(e.getSource() == menuItemGuardarAs)
        {
            file = JOptionPane.showInputDialog(null,"Guardar un Archivo con nuevo nombre...");
            datos = taEditor.getText();
            editorAD.saveAsFiles(file,datos);
        }
        
        if(e.getSource() == menuItemSalir)
            System.exit(0);
    }
    
    public static void main(String args[])
    {
        new Editor();
    }
}