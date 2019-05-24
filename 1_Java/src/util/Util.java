package util;

public class Util {
	
	public static int[] Sort(int[] n) // 원본 유지;
	{
		int[] a = n.clone();
		for (int i = 0; i < a.length - 1; i++)
		{
			for (int j = i + 1; j < a.length; j++)
			{
				if (a[i] > a[j])
				{
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
		return a;
	}
}
