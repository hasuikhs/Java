package day02;

import java.util.Scanner;

public class Prob2 {

	public static void main(String[] args) {
		
		/*
		  변수 num의 값에따라  양수 음수  0을 출력하는  코드를 완성하세요.
		   힌트: 삼항연산자.
		*/
			int num = -90;
			System.out.println("양수 음수  0 판별후 출력");
			
			System.out.printf("%d => ",num);
			System.out.println(num > 0 ? "양수" : ( num == 0 ? "0" : "음수"));
			System.out.println();


			/*
		        다음은 대문자를 소문자로 변경하는 코드입니다.
		        변수 ch에 저장된 문자가 대문자 인 경우에만 
			소문자로 변경하는 코드를 완성 합니다.
		  	*/
			char ch = 'P';
			char lowerCase = (ch >='A' && ch <='Z') ? (char) (ch + 32) : ch;
			System.out.print("ch : [ " + ch);
			System.out.println(" ] to lowerCase : [ " + lowerCase + " ]");

			System.out.println();
			
			/*  년도를 입력받아  윤년인지 판별하여 출력해  보세요 */
			
			Scanner year = new Scanner(System.in);
			
			System.out.println("년도를 입력하세요.");
			int y = year.nextInt();
			year.nextLine();
			
			System.out.println(y % 400 == 0 || (y % 4 == 0 && !(y % 100 == 0)) ? "윤년" : "윤년이 아님");
			
			year.close();
			year = null;
		
	}

	private static char String(String string) {
		// TODO Auto-generated method stub
		return 0;
	}

}
