package day03;

import java.util.Scanner;

public class prob03 {

	public static void main(String[] args) {
		
		Scanner sourceString = new Scanner(System.in);
		System.out.println("암호화할 문자열을 입력");
		String scString = sourceString.nextLine();
		
		Scanner shift = new Scanner(System.in);
		System.out.println("쉬프트할 숫자 입력");
		int sh = shift.nextInt();
		shift.nextLine();
		
		String encodedString = "";
		
		// 프로그램을 구현부 시작.	
		// 참고 : 문자 'a'의 정수값은 97이며, 'z'는 122입니다. 
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < scString.length(); i++) {
			if (scString.charAt(i) >= 'a' && scString.charAt(i) <= 'z')
				sb.append((char) ((scString.charAt(i) - (97 - sh)) % 26 + 97));
			else 
				sb.append((char) scString.charAt(i));
		}
		// 프로그램 구현부 끝.
		encodedString = sb.toString();
		System.out.println("암호화할 문자열 : " + scString);
		System.out.println("암호화된 문자열 : " + encodedString);
		
		sourceString.close();
		shift.close();
		sourceString = null;
		shift = null;
				


	}

}
