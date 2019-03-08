import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class BiblioMenu extends JFrame implements ActionListener
{
	// Atributos de la aplicacion
	private JButton adnL, bConsul;
	private JPanel pPrincipal, pUser;
	
	public BiblioMenu()
	{
		super("Biblioteca Tec");
		
		// 1. Crear objetos de los atributos
		adnL = new JButton ("Agregar nuevo libro");
		bConsul= new JButton ("Consultar");
		
		pPrincipal = new JPanel ();
		pUser = new JPanel ();
		
		// Adionar actionListener a los JButtons
		bConsul.addActionListener(this);
		adnL.addActionListener(this);
		
		// 2. Definir Layouts de los JPanels
		pUser.setLayout(new FlowLayout());
		pPrincipal.setLayout(new BorderLayout(4,4));

		// 3. Colocar los objetos de los atributos en los panels correspondientes
		pUser.add(bConsul);
		pUser.add(adnL);
		
		pPrincipal.add(pUser,BorderLayout.CENTER);
		
		// 4. Adicionar el panelPrincipal al JFrame
        add(pUser);
        setSize(1000,500);
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
	}
	
	public static void  main(String args[])
    {
    	new BiblioMenu();	
    }
}