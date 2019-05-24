package day04;

import java.util.Arrays;

public class test07 {

	public static void main(String[] args) {
		
		int[] num = new int[6];
		
		for (int i = 0; i < num.length; i++)
		{
			num[i] = (int) (Math.random() * 45) + 1;		
		}
		System.out.println(Arrays.toString(num));
	
		
		for (int i = 0; i <num.length-1; i++)
		{
			for (int j = i + 1; j < num.length; j++)
			{
				if (num[i] > num[j])
				{
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(num));
		
		for (int i = 0; i < num.length; i++)
		{
			for (int j = i + 1; j < num.length; j++)
			{
				if (num[j] == num[i])
				{
					num[j] = (int)(Math.random() * 45) + 1;
				}
			}
		}
		System.out.println(Arrays.toString(num));
		
		for (int i = 0; i <num.length-1; i++)
		{
			for (int j = i + 1; j < num.length; j++)
			{
				if (num[i] > num[j])
				{
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(num));
	}
}