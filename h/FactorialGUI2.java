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

public class FactorialGUI2 extends JFrame implements ActionListener
{
	//Definir objetos
	private JTextField tfFactorial;
	private JButton bCalcu, bSalir;
	private JPanel panel1, panel2;
	private JTextArea taDatos;
	
	private CalculosDP calculos= new CalculosDP();
	
	public FactorialGUI2()
	{
		super("Calculo de Factorial");
		
		//1. Crear objetos de los atributos o variables de clase
		tfFactorial=new JTextField();
		bCalcu= new JButton("Calcular Factorial");
		bSalir= new JButton("Salir");
		panel1=new JPanel();
		panel2=new JPanel();
		taDatos= new JTextArea(10,30);
		
		
		bCalcu.addActionListener(this);
		bSalir.addActionListener(this);
		
		//2. Definir el Layot del JFrame
		panel1.setLayout(new GridLayout(2,2));//Panel 1 esta definido en JFrame y JPanel
		panel2.setLayout(new FlowLayout());
		
		//3. Poner los objetos de los atributos en el JFrame para que esten visibles al usuario
		panel1.add(new JLabel("Factorial = "));// se crea el atributo cuando se va hacer visible o ejecutar
		panel1.add(tfFactorial);
		panel1.add(bCalcu);
		panel1.add(bSalir);
		
		panel2.add(panel1);
		panel2.add(new JScrollPane(taDatos));
		
		//4. Hacer visible el JFrame
		add(panel2);
		setSize(650,300);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent evento)
	{
		if(evento.getSource()== bCalcu)
		{
			int factorial,num;

			//1. Obtener el numero
			String strNum=tfFactorial.getText();
			num=Integer.parseInt(strNum);
			
			//2. Calcular el factorial
		
			factorial=calculos.calcularFactorial(num);
			
			//3. Mostrar el resultado
			taDatos.setText("El factorial de "+num+" es = "+factorial);
		
			//taDatos.append("Conversion de Grados...\n");
		}
		
		
		if(evento.getSource()==bSalir)
		{
			System.exit(0);
		}
	}
	
	
	public static void main(String args[])
	{
		FactorialGUI2 Factorial= new FactorialGUI2();
	}
}