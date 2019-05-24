package day02;

import java.util.Scanner;

public class test03_Scanner {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요.");
		System.out.println();
		String name = keyboard.nextLine();
		System.out.print("나이를 입력하세요.");
		System.out.println();
		int age = Integer.parseInt(keyboard.nextLine());
		
		System.out.println("국어/영어/수학 점수를 입력하세요.");
		System.out.println("입력 예)90 90 70 처럼 정수를 입력 후 앤터");
		
		int k1 = keyboard.nextInt();
		int k2 = keyboard.nextInt();
		int k3 = keyboard.nextInt();
		keyboard.nextLine();
		
		System.out.println("***** 입력정보 확인 *****");
		System.out.printf("[이름 = %s, 나이 = %d ]\n",name,age);
		System.out.printf("국어 = %s, 영어= %s, 수학 = %s, 평균 = %.2f \n",k1,k2,k3,(k1+k2+k3)/3.);
		System.out.println("***** 입력정보 확인 *****");
		
		keyboard.close();
		keyboard = null;
	}

}
