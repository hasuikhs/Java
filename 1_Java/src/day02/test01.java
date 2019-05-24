package day02;

import java.util.Date;

public class test01 {
	public static void main(String[] args) {

		char i;
		i = 'a';
		System.out.println(i);

		Date d = new Date();
		System.out.println(d.toLocaleString());
		Date d2 = d;
		d = null;
		
		String ss = new Date().toString();
		System.out.println(ss);
		
		double pi = Math.PI;
		double r = Math.random();
		int r1 = (int) (Math.random()*45+1);
		System.out.println(pi + ", " + r + ", "+ r1);
		
		System.out.printf("pi = %f, r = %f, r1 = %d \n",pi,r,r1);
		System.out.printf("pi = %.4f, r = %.2f, r1 = %d \n",pi,r,r1);
		
		String s1 = new String("hello");
		String s11 = new String("hello");
		
		String s2 = "hello";
		String s22 = "hello";
		
		
	}

}
