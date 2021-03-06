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


public class GradosFcGUI extends JFrame implements ActionListener //Encapsulación: esconder en una clase todos los elementos que forman parte
{
	
	//Atributos: definir
	private JTextField tfGrados;
	private JButton bCalcularGf_a_Gc,bSalir;
	private JPanel panel1,panel2;
	private JTextArea taDatos;
	
	private CalculosDP calculos= new CalculosDP();
	//Terminan atributos
	
	
	//Constructor 
	public GradosFcGUI()
	{
		super("Conversion de Grados");
		//1. Crear objetos de los atributos o variables de clase
		tfGrados = new JTextField();
		//botones
		bCalcularGf_a_Gc= new JButton("G. Farenheit a G. Centigrados");
		bSalir= new JButton("Exit");
		panel1= new JPanel();
		panel2= new JPanel();
		taDatos= new JTextArea(10,40);
		
		//1.1 Adicionar addAccionListener a los JButtons
		bSalir.addActionListener(this);
		bCalcularGf_a_Gc.addActionListener(this);
		
		//2. Definir el Layot de los JPanels
		panel1.setLayout(new GridLayout(2,2));//Panel 1 esta definido en JFrame y JPanel
		panel2.setLayout(new FlowLayout());
		
		
		//3. Poner los objetos de los atributos en los JPanels correspondientes 
		panel1.add(new JLabel("Grados a convertir = "));// se crea el atributo cuando se va hacer visible o ejecutar
		panel1.add(tfGrados);
		panel1.add(bCalcularGf_a_Gc);
		panel1.add(bSalir);
		
		panel2.add(panel1);
		panel2.add(new JScrollPane(taDatos));
		
		//4. Poner el panel1 en JFrame y hacerlo visible
		add(panel2);
		setSize(600,500); //(x,y)
		//setVisible(true);
	}
	
	public JPanel getPanel2()
	{
		return panel2;
	}
	
	public void actionPerformed(ActionEvent evento)
	{
		try
		{
			
			if(evento.getSource()==bCalcularGf_a_Gc)
			{
				//1. Obtener los grados a convertir
				String strGrados=tfGrados.getText();
				
				//2. Hacer la conversion
				float gf=Float.parseFloat(strGrados);
				float gc=calculos.gradosFC(gf);
				//(grados*1.8)+32
				
				//3. Mostrar el resultado
				taDatos.setText(gf+" Grados Farenheit = "+gc+" Grados Centigrados");
			}
		}
		catch(Exception a)
		{
			taDatos.setText("Alguno de los datos ingresados no es numero");
		}
		
		if(evento.getSource()==bSalir)
		{
			System.exit(0);
		}
	}
	
	public static void main(String args[])
	{
		GradosFcGUI grados = new GradosFcGUI();
	}
}