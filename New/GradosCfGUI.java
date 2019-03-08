import javax.swing.JOptionPane;

public class GradosCfGUI
{
	private void conGrados()
	{
		String strGra;
		float ce, fa;
		
		strGra = JOptionPane.showInputDialog("Grados Centigrados =");
		ce = Float.parseFloat(strGra);
		
		fa = (float)9/5*ce+32;
		
		JOptionPane.showMessageDialog(null,ce+"G.centigrados ="+fa+"G. fahrenheit");
	}
	
	public static void main (String args[])
	{
		GradosCfGUI objetoGradoos = new GradosCfGUI();
		objetoGradoos.conGrados();
	}
	
}

