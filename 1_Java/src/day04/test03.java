package day04;

import java.util.Arrays;

public class test03 {

	public static void main(String[] args) {
		
		String msg = "hello java programming ~~~";
		
		char[] c;
		c = new char[msg.length()];
				
		for(int i = 0; i < msg.length(); i++)
		{
			c[i] = msg.charAt(i);
		}
		
		for (char data:c)
		{
			System.out.print(data);
		}
		System.out.println();
		System.out.println(Arrays.toString(c));
		
		int[] n1 = {1, 2, 3};
		int[] n2 = new int[n1.length*2];
		
		System.out.println(Arrays.toString(n1));
		System.out.println(Arrays.toString(n2));
		
		System.arraycopy(n1, 0, n2, 1, n1.length);
		System.out.println(Arrays.toString(n2));
		
		for(int data:n2)
		{
			System.out.print(data);
		}
		System.out.println();
		
		char[] s = "SQL".toCharArray();
		System.out.println(Arrays.toString(s));
		
		String[] s3 = {"java", "sql", "cent os","R", msg};
		
		System.out.println("-----------------------------------------");
		for (String data:s3)
		{
			if (data.length() >=5)
			{
				System.out.println(data);
			}
		}

	}

}
