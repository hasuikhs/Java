package day06;

public class test03 
{
	public static void main(String[] args) 
	{
		int a = 100;
		int b = 10;
		
		day06.test03.max(a, b);
		new test03().min(a,b);
	}

	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	public int min(int a, int b)
	{
		return a < b ? a : b;
	}
}
