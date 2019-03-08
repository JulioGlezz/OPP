public class CalculosDP
{
	public float gradosCF(float centigrados)
	{
		float farenheit = (float)1.8*centigrados+32;
		
		return farenheit;
	}
	
	public float gradosFC(float farenheit)
	{
		float centigrados= (farenheit-32)/(float)(1.8);
		return centigrados;
	}
	
	public int calcularFactorial(int numero)
	{
		int factorial=1;
		
		if(numero>1)
		{
			for(int i=2;i<=numero;i++)
			{
				factorial=i*factorial;
			}
		}
	return factorial;
	}
	
	public float exponencial(float base,float potencia)
	{
		float resultado;
		
		resultado=(float)1;
		
		if(potencia!=0)
		{
			for(int i=0;i<potencia;i++)
			{
				resultado=resultado*base;
			}
		}
		
		return resultado;
	}
	
public static String tabla(int n) {
        String respuesta = "Tabla de "+n+"\n";
        for (int i = 1 ; i<=10;i++){
            respuesta += n +" X "+ i +" = "+ n*i ;
            respuesta += "\n";
        }
        return respuesta;
    }
    	
	public float a0_b0(float c)
	{
		float x;
		x=-c;
		return x;
	}
	
	public float a_0(float b, float c)
	{
		float x;
		x=-c/b;
		return x;
	}
	
	public float a_mayor1(float a, float b, float c)
	{
		float x;
		x=(-b+(float)Math.sqrt((b*b)-((float)4*a*c)))/((float)2*a);
		return x;
	}
	
	public float a_mayor2(float a, float b, float c)
	{
		float x;
		x=(-b-(float)Math.sqrt((b*b)-((float)4*a*c)))/((float)2*a);
		return x;
	}
}