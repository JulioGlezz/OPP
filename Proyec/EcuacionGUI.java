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


public class EcuacionGUI extends JFrame implements ActionListener
{
	//Definir los objetos
	private JTextField tfA,tfB,tfC;
	private JButton bCalcular,bSalir;
	private JPanel panel1,panel2;
	private JTextArea taResult;
	
	private CalculosDP calcular= new CalculosDP();
	
	public EcuacionGUI()
	{
		super("Ecuacion cuadratica");
		
		// 1. Crear los objetos de los atributos
		tfA= new JTextField();
		tfB= new JTextField();
		tfC= new JTextField();
		
		bCalcular=new JButton("Calcular raices");
		bSalir= new JButton("Salir");
		
		panel1=new JPanel();
		panel2=new JPanel();
		
		taResult=new JTextArea(10,40);
		
		
		bCalcular.addActionListener(this);
		bSalir.addActionListener(this);
		
		
		// 2. Definir el Layout
		panel1.setLayout(new GridLayout(4,2));
		panel2.setLayout(new FlowLayout());
		
		// 3. Poner los objetos de los atributos para que esten visibles al usuario
		panel1.add(new JLabel("Coeficiente A ="));
		panel1.add(tfA);
		panel1.add(new JLabel("Coeficiente B ="));
		panel1.add(tfB);
		panel1.add(new JLabel("Coeficiente C ="));
		panel1.add(tfC);
		panel1.add(bCalcular);
		panel1.add(bSalir);
		
		panel2.add(panel1);
		panel2.add(new JScrollPane(taResult));
		
		
		// 4. Hacer visible el JFrame
		add(panel2);
		setSize(600,500);
		//setVisible(true);
		
	}
	
	public JPanel getPanel2()
	{
		return panel2;
	}
	
	public void actionPerformed(ActionEvent opcion)
	{
		if(opcion.getSource() == bCalcular)
		{
			String strA,strB,strC;
			float a,b,c,x,x1,x2;
			
			//Obtener los coeficientes
			strA=tfA.getText();
			strB=tfB.getText();
			strC=tfC.getText();
			
			a=Float.parseFloat(strA);
			b=Float.parseFloat(strB);
			c=Float.parseFloat(strC);
			
			x=0;
			x1=0;
			x2=0;
			
			//Obtener valores
			if(a==0)
			{
				if(b==0)
				{
					x=calcular.a0_b0(c);
				}
				else
				{
					x=calcular.a_0(b,c);
				}
			}
			else
			{
				if((b*b)>=((float)4*a*c))
				{
					x1=calcular.a_mayor1(a,b,c);
					x2=calcular.a_mayor2(a,b,c);
				}
			}
			
			//Desplegar resultados
			if(a==0)
			{
				taResult.setText("X = "+x);
			}
			else
			{
				if((b*b)>=((float)4*a*c))
				{
					taResult.setText("X1 = "+x1+"\nX2 = "+x2);
				}
				else
				{
					taResult.setText("Las raices son imaginarias");
				}
			}
			
		}
		
		if(opcion.getSource() == bSalir)
		{
			System.exit(0);
		}
	}
	
	public static void main(String args[])
	{
		new EcuacionGUI();
	}
}