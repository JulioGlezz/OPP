public class CalculosRaizDP
{
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