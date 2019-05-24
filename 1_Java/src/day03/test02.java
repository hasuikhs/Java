package day03;

import java.util.Scanner;

public class test02 {

	public static void main(String[] args) {
		
		System.out.println("성적처리 Application을 시작하려면 yes를 입력하세요 ...");
		Scanner input = new Scanner(System.in);
		String msg = input.nextLine();
		
		if (!(msg != null && msg.equalsIgnoreCase("yes"))) {
			System.out.println("Application Stop");
			if (input != null) {
				input.close();
				input = null;
			}
			return;
			
		}
		else {
		System.out.println("성적처리 Application Start");
		System.out.println("성적을 입력하세요...");
		System.out.println("국어 영어 수학 \n입력 예) 90 90 90 앤터");
		
		int k1 = input.nextInt();
		int k2 = input.nextInt();
		int k3 = input.nextInt();
		input.nextLine();
				
		double m = 0;
		System.out.printf("국어 = %d, 영어 = %d, 수학 = %d \n",k1, k2, k3);
		System.out.printf("\t 평균 = %.2f \n", m = (k1 + k2 + k3) / 3.);
		
		// 등급처리
		
		char grade = ' ';
		
		// switch
		switch ((int) m / 10) {
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		default:
			grade ='F';
			break;
		}
		System.out.printf("성적처리결과 [%c] 등급\n",grade);
		
		
		
		// Scanner 자원반납 코드
		if (input != null) {
			input.close();
			input = null;
		}
		
		System.out.println("Application Stop");
		}
		
	}

}
