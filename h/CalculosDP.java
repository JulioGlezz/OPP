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
	
	public String calcularTablas(float num)
	{
		String tabla="";
		
		for (int i=1; i<11; i++)
		{
			tabla=tabla+"\n" + num  + " x " + i + " = " + (i*num );
		}
		
		return tabla;
	}
	 	
}