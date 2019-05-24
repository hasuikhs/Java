package day04;

import java.util.Arrays;

public class test01 {
	public static void main(String[] args) {
		int count=0;
		// System.out.println(count);
		
		double m = 0.0;
		int[] jumsu; 			// 배열 선언
		jumsu = new int[5]; 	// 배열 생성
		
		jumsu[0] = 90;
		jumsu[1] = 80;
		jumsu[2] = 70;
		jumsu[3] = 60;
		jumsu[4] = 50;
		
		
		for (int i = 0; i < jumsu.length; i++)
		{
			System.out.println(jumsu[i]);
		}
		System.out.println();
		System.out.println(jumsu);
		System.out.println(Arrays.toString(jumsu)); // 배열 내용 확인 (출력용)

		int[] num = {88, 55, 77, 99, 77, 33};
		System.out.println(Arrays.toString(num));
		
		String[] names;
		names = new String[5];
		names[0] = "홍길동";
		names[1] = "김길동";
		names[2] = "최길동";
		
		System.out.println(Arrays.toString(names));
		
		int sum = 0;
		for (int i = 0; i < jumsu.length; i++)
		{
			sum += jumsu[i];
		}
		m = sum / jumsu.length;
		
		for (int i = 0; i < jumsu.length; i++)
		{
			if (names[i] != null && names[i].length() !=0)
				System.out.printf("%s** %d %n", names[i].charAt(0),jumsu[i]);
			else 
				System.out.printf("이름없음 = %3d %n",jumsu[i]);
		}
		System.out.printf("학생 평균 = %.2f",m);
	}

}
