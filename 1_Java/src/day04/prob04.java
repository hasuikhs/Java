package day04;

import java.util.Arrays;

public class prob04 {

	public static void main(String[] args) {
		
		int[] num = new int[6];
		for (int i = 0; i < num.length; i++)
		{
			num[i] = (int) (Math.random() * 5) + 1;
			System.out.println((i+1)+"번째 수 = " + num[i]);
			
			for (int j = 0; j < i; j++) // 중복 제거
			{
				if (num[i] == num[j])
				{
					i--;
					break;
				}
			}
		}
		
		System.out.println(Arrays.toString(num)); // 중복을 제거한 배열 출력
		int cnt = 0;
		for (int i = 0; i < num.length-1; i++)
		{
			for (int j = i + 1; j < num.length; j++)
			{
				if (num[i] > num[j])
				{
					int temp = num[j];
					num[j] = num[i];
					num[i] = temp;	
					cnt++;
					System.out.println(temp);
					System.out.println(i+"번째 = " +num[i]);
					System.out.println(num[j]);
				}
			}
		}
		System.out.println(cnt);
		System.out.println(Arrays.toString(num));
		
	}	
}


