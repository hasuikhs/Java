package util;

public class Calc {
 // + - * /
	
	public static double add(double x, double y)
	{
		return x + y;
	}
	public static int add(int ... x)
	{
		int sum = 0;
    //  for (int i = 0; i < x.length; i++)
	//	{
	//		sum += x[i];
	//	}
	//	return sum;
		for (int data:x)
		{
			sum += data;
		}
		return sum;
	}
	
	
	public static int sub(int x, int y)
	{
		return x - y;
	}
	
	public static int multi(int x, int y)
	{
		return x * y;
	}
	
	public static int divide(int x, int y)
	{
		return x / y;
	}

}
