package day04;

import java.util.Scanner;

public class test04_2 {

	public static void main(String[] args) {
		
		Scanner sourceString = new Scanner(System.in); // 스캐너 선언
		System.out.println("문자열을 입력");
		System.out.println("띄워쓰기로 구분");
		String scString = sourceString.nextLine(); // 문자열 입력받는 코드
		
		String[] strData = scString.split(" "); // 띄워쓰기로 구분
		
		for (String data:strData)
		{
			for (int i = data.length()-1; i >= 0; i--)
			{
				System.out.print(data.charAt(i));
			}
			System.out.print(" ");
		}
		
			


	}

}
