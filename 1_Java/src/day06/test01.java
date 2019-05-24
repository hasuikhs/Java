package day06;

import java.util.Arrays;

import util.Util;

public class test01 {

	public static void main(String[] args) 
	{
		
		int[] num1 = {99, 44, 77, 68, 80};
		System.out.println(Arrays.toString(num1));
		int[] result1 = Util.Sort(num1);
		System.out.println(Arrays.toString(result1));
		
		int[] num2 = {2, 3, 9, 1, 7};
		System.out.println(Arrays.toString(num2));
		int[] result2 = Util.Sort(num2);
		System.out.println(Arrays.toString(result2));
		
	}

}


