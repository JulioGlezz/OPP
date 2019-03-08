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

public class ExponencialGUI extends JFrame implements ActionListener
{
	//Definir objetos
	private JTextField tfBase, tfPotencia;
	private JButton bCalcular, bSalir;
	private JPanel panel1, panel2;
	private JTextArea taDatos;
	
	private CalculosDP calculos= new CalculosDP();
	
	public ExponencialGUI()
	{
		super("Calcular exponencial: E^x");
		
		//1. Crear objetos de los atributos o variables de clase
		tfBase=new JTextField();
		tfPotencia= new JTextField();
		bCalcular= new JButton("Calcular Exponencial");
		bSalir= new JButton("Salir");
		panel1=new JPanel();
		panel2=new JPanel();
		taDatos= new JTextArea(10,40);
		
		
		bCalcular.addActionListener(this);
		bSalir.addActionListener(this);
		
		//2. Definir el Layot del JFrame
		panel1.setLayout(new GridLayout(3,2));//Panel 1 esta definido en JFrame y JPanel
		panel2.setLayout(new FlowLayout());
		
		//3. Poner los objetos de los atributos en el JFrame para que esten visibles al usuario
		panel1.add(new JLabel("Base [E] = "));
		panel1.add(tfBase);
		panel1.add(new JLabel("Potencia [x] = "));
		panel1.add(tfPotencia);
		panel1.add(bCalcular);
		panel1.add(bSalir);
		
		panel2.add(panel1);
		panel2.add(new JScrollPane(taDatos));
		
		//4. Hacer visible el JFrame
		add(panel2);
		setSize(600,500);
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
			String strbase, strpotencia;
			float base, potencia, exponente;
			
			//1. Obtener el numero
			strbase=tfBase.getText();
			strpotencia=tfPotencia.getText();
			base=Float.parseFloat(strbase);
			potencia=Float.parseFloat(strpotencia);
			
			//2. Calcular el factorial
			if(potencia<0)
				exponente=calculos.exponencial(base,-potencia);
			else
				exponente=calculos.exponencial(base,potencia);
			
			//3. Mostrar el resultado
			if(potencia<0)
				taDatos.setText("El resultado de elevar "+base+"^"+potencia+" es = 1/"+exponente);
			else
				taDatos.setText("El resultado de elevar "+base+"^"+potencia+" es = "+exponente);
		
			//taDatos.append("Conversion de Grados...\n");
		}
		
		
		if(evento.getSource()==bSalir)
		{
			System.exit(0);
		}
	}
	
	
	public static void main(String args[])
	{
		ExponencialGUI exponencial= new ExponencialGUI();
	}
}