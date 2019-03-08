import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TablasGUI extends JFrame implements ActionListener
{
	//Definir objetos
	private JTextField tfTabla;
	private JButton bCalcular, bSalir;
	private JPanel panel1, panel2;
	private JTextArea taDatos;
	
	private CalculosDP calcular_r= new CalculosDP();
	
	public TablasGUI()
	{
		super("Tabla de N");
		
		//1. Crear objetos de los atributos o variables de clase
		tfTabla=new JTextField();
		bCalcular= new JButton("Calcular");
		bSalir= new JButton("Salir");
		panel1=new JPanel();
		panel2=new JPanel();
		taDatos= new JTextArea(15,40);
		
		
		bCalcular.addActionListener(this);
		bSalir.addActionListener(this);
		
		//2. Definir el Layot del JFrame
		panel1.setLayout(new GridLayout(2,2));//Panel 1 esta definido en JFrame y JPanel
		panel2.setLayout(new FlowLayout());
		
		//3. Poner los objetos de los atributos en el JFrame para que esten visibles al usuario
		panel1.add(new JLabel("Tabla de N = "));// se crea el atributo cuando se va hacer visible o ejecutar
		panel1.add(tfTabla);
		panel1.add(bCalcular);
		panel1.add(bSalir);
		
		panel2.add(panel1);
		panel2.add(new JScrollPane(taDatos));
		
		//4. Hacer visible el JFrame
		add(panel2);
		setSize(400,500);
		//setVisible(true);
	}
	
	public JPanel getPanel2()
	{
		return panel2;
	}
	
	public void actionPerformed(ActionEvent evento)
	{
		if(evento.getSource()== bCalcular)
		{
			String snumero,cadena;
			int num;
			
			snumero=tfTabla.getText();
			num=Integer.parseInt(snumero);
			
			cadena=calcular_r.tabla(num);
			
			taDatos.setText(cadena);
		}
		
		
		if(evento.getSource()==bSalir)
		{
			System.exit(0);
		}
	}
	
	
	public static void main(String args[])
	{
		TablasGUI tablas= new TablasGUI();
	}
}