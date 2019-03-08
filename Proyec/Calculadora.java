import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.Panel;


public class Calculadora extends JFrame implements ActionListener
{
    private JTextField tfNumero = new JTextField(8);
    
    private JButton bSuma, bResta, bMultiplica, bDivide, bIgual, bClear, bPunto;
    private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private JButton bFactorial, bExpo, bRaiz, bCuadrado;
    private JPanel panel1, panel2;
    
    private float n1=(float)0;
    private float n2=(float)0;
	 private float n3=(float)0;
	 private float n4=(float)0;
    private String operacion = "";
    private String strNumero = "";
    private int base, x,i;
    private int op=0;
    public Calculadora()
    {
        super("Calculadora");
        
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel1.setLayout(new GridLayout(6,4));
        
        panel1.add(new JLabel(""));
        
        panel1.add(tfNumero);
        
        bClear = new JButton("Clear");
        panel1.add(bClear);
        
        panel1.add(new JLabel(""));
        
        b7 = new JButton("7");
        panel1.add(b7);
        
        b8 = new JButton("8");
        panel1.add(b8);
        
        b9 = new JButton("9");
        panel1.add(b9);
        
        bSuma = new JButton("+");
        panel1.add(bSuma);
        
        b4 = new JButton("4");
        panel1.add(b4);
        
        b5 = new JButton("5");
        panel1.add(b5);
        
        b6 = new JButton("6");
        panel1.add(b6);
        
        bResta = new JButton("-");
        panel1.add(bResta);
        
        b1 = new JButton("1");
        panel1.add(b1);
        
        b2 = new JButton("2");
        panel1.add(b2);
        
        b3 = new JButton("3");
        panel1.add(b3);
        
        bMultiplica = new JButton("x");
        panel1.add(bMultiplica);
        
        b0 = new JButton("0");
        panel1.add(b0);
        
        bPunto = new JButton(".");
        panel1.add(bPunto);
        
        bIgual = new JButton("=");
        panel1.add(bIgual);
        
        bDivide = new JButton("/");
        panel1.add(bDivide);
        
        bFactorial = new JButton("x!");
        panel1.add(bFactorial);
        
        bRaiz = new JButton("sqrt(x)");
        panel1.add(bRaiz);
        
        bCuadrado = new JButton("x^2");
        panel1.add(bCuadrado);
        
        bExpo = new JButton("y^x");
        panel1.add(bExpo);
        
   		
        bSuma.addActionListener(this);
        bResta.addActionListener(this);
        bMultiplica.addActionListener(this);
        bDivide.addActionListener(this);
        bIgual.addActionListener(this);
        bClear.addActionListener(this);
        bPunto.addActionListener(this);
        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        bFactorial.addActionListener(this);
        bExpo.addActionListener(this);
        bRaiz.addActionListener(this);
        bCuadrado.addActionListener(this);
        
        panel2.add(panel1);
        
        setLayout(new FlowLayout());
        add(panel2);
        setSize(350,220);
     //   setVisible(true);
    }
    
    public JPanel getPanel2()
    {
    	
    	return panel2;
    }
	
	public void actionPerformed(ActionEvent opcion)
	{
		if(opcion.getSource()==bPunto)
		{
			if(n1==0)
			{
				strNumero=strNumero+"0.";
			}
			else
			{
				strNumero=strNumero+".";
			}
		}
		if(opcion.getSource()==b0)
		{
			strNumero=strNumero+"0";
		}
		if(opcion.getSource()==b1)
		{
			strNumero=strNumero+"1";
		}
		if(opcion.getSource()==b2)
		{
			strNumero=strNumero+"2";
		}
		if(opcion.getSource()==b3)
		{
			strNumero=strNumero+"3";
		}
		if(opcion.getSource()==b4)
		{
			strNumero=strNumero+"4";
		}
		if(opcion.getSource()==b5)
		{
			strNumero=strNumero+"5";
		}
		if(opcion.getSource()==b6)
		{
			strNumero=strNumero+"6";
		}
		if(opcion.getSource()==b7)
		{
			strNumero=strNumero+"7";
		}
		if(opcion.getSource()==b8)
		{
			strNumero=strNumero+"8";
		}
		if(opcion.getSource()==b9)
		{
			strNumero=strNumero+"9";
		}
		
		if(opcion.getSource()==bClear)
		{
			tfNumero.setText("");
			strNumero="0";
			n2=(float)0;
			op=0;
		}
		

	
         
				if(op==0)
				{
					n1=Float.parseFloat(strNumero);
					n3=n1;
				}
				else
				{
					n2=Float.parseFloat(strNumero);
					n3=n2;
				}
		
		
		if(opcion.getSource()==bSuma)
		{
			tfNumero.setText("");
			strNumero="0";
			op=1;
			n2=(float)0;
		}
		
		if(opcion.getSource()==bResta)
		{
			tfNumero.setText("");
			strNumero="0";
			op=2;
			n2=(float)0;
		}
		
		if(opcion.getSource()==bMultiplica)
		{
			tfNumero.setText("");
			strNumero="0";
			op=3;
			n2=(float)0;
			
		}
		
		if(opcion.getSource()==bDivide)
		{
			tfNumero.setText("");
			strNumero="0";
			op=4;
			n2=(float)0;
		}
		
		if(opcion.getSource()==bExpo)
		{
			tfNumero.setText("");
			strNumero="0";
			op=5;
			n2=(float)0;
		}
		
		if(opcion.getSource()==bFactorial)
		{
				
					n2=1;
					for(i=1;i<=n1;i++)
					{
						n2=n2*i;
					}
					
							
					
		n3=n2;
		n2=0;
			tfNumero.setText("");
			strNumero="0"+n1;
			
		}
		
		if(opcion.getSource()==bRaiz)
		{
			n3=(float)Math.sqrt(n1);
		}
		
		if(opcion.getSource()==bCuadrado)
		{
			n3=n1*n1;
		}
		
		
		if(opcion.getSource()==bIgual)
		{
		
			if (op==1)
		{
			n1=n1+n2;
			n2=0;
			
		}
		
		if (op==2)
		{
			n1=n1-n2;
			n2=0;
			
		}
		
		if (op==3)
		{
			n1=n1*n2;
			n2=0;
			
		}
		
		if (op==4)
		{
			n1=n1/n2;
			n2=0;
		
		}
		if (op==5)
		{
			n4=n1;
			for(i=2;i<=n2;i++)
			{
				n1=n1*n4;
			}
			n2=0;
					
			
		}
		
	
		
		n3=n1;
		
			tfNumero.setText("");
			strNumero="0"+n1;
		}
		
		tfNumero.setText(""+n3);

		
		
	}
    
    
    public static void main(String args[])
    {
        Calculadora calculadora = new Calculadora();
        calculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
