import javax.swing.JOptionPane;


public class GradosFcGUI
{
    private float obtenerGrados()
    {
        String strGrados;
        float gf;
        
        strGrados = JOptionPane.showInputDialog("G. farenheit =");
        gf = Float.parseFloat(strGrados);
        
        return gf;
    }
       
    private float convertirGF_GC(float gf)
    {
    	    	
        float gc = ((float)gf - 32) / ((float)9/5);
        
        return gc;
    }
    
    private void desplegarResultado(float gf, float gc)
    {
        JOptionPane.showMessageDialog(null,gf+" G. farenheit = "+gc+" G. Centigrados");
    }
    
    private void conversionGrados()
    {
        float farenheit, centigrados;
        
        // 1. Obtener G. Centigrados a convertir
        farenheit = obtenerGrados();
        
        
        // 2. Convertir G. Centigrados a G. Farenheit
        centigrados = convertirGF_GC(farenheit);
        
        // 3. Desplegar resultado
        desplegarResultado(farenheit,centigrados);
    }
    
    public static void main(String args[])
    {
        GradosFcGUI objetoGrados = new GradosFcGUI();
        objetoGrados.conversionGrados();
    }
}
