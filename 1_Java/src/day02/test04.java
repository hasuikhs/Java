package day02;

import java.util.Scanner;

public class test04 {

	public static void main(String[] args) {
		
		int num = 15;
		System.out.println(15%3);
		System.out.println(num++);
		
		Scanner keyboard = null;
		String msg = "hello";
		String msg2 = "hello";
		
		boolean flag = num < 15 && msg.length() > 0;
		System.out.println(flag);
		
		System.out.println(num == msg.length());
		System.out.println(msg.equals(msg2));
		System.out.println(msg == msg2);
		
		String s1 = new String("hello");
		String s2 = new String("hello");
		System.out.println(s1 == s2); // false
		System.out.println(s1.equals(s2)); // true
		
		System.out.println(4 << 2); // 16
		System.out.println(4 >> 1); // 2
		System.out.println(4 & 1);
		
		keyboard = new Scanner(System.in);
		
		System.out.println("점수를 입력하세요.");
		int jumsu = keyboard.nextInt();
		keyboard.nextLine();
		
		System.out.println("유효성 검증");
		if (!(jumsu>=0 && jumsu<=100))
		{
			return;
		}
		System.out.println(jumsu >= 80 ? "PASS" : "NO PASS");
		keyboard.close();
		keyboard = null;
		
		System.out.println("END");
		


	}

}
