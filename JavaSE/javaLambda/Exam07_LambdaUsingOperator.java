package javaLambda;

import java.util.function.IntBinaryOperator;

/*
 * Operator는 Function과 하는 일이 거의 비슷
 * 입력매개변수가 있고 리턴값이 존재
 * Function은 mapping 용도로 많이 사용
 * (입력매개변수를 리턴타입으로 변환, mapping의 용도)
 * Operator는 연산용도로 많이 사용
 * (입력매개변수를 연산에 이용하여 같은 타입의 리턴값을 돌려주는 형태로 사용)
 * 
 *  최대값과 최소값을 구하는 static method를 하나 작성해 보자
 *  
 */

public class Exam07_LambdaUsingOperator {
	
	private static int arr[] = {100, 92, 50, 89, 34, 27, 99, 3};
	
	// getMaxMin()을 static method로 만듦
	private static int getMaxMin(IntBinaryOperator operator) {
		int result = arr[0];
		for(int n : arr) {
			result = operator.applyAsInt(result, n);
			// max를 구할시
			// 1번 result : 100, n : 100
			// 2번 result : 100, n : 92
			// 3번 result : 100, n : 50
			// ...
		}
		return result;
	}
	public static void main(String[] args) {
		
		// getMaxMin(람다식!) 
		System.out.println("최대값 : " + getMaxMin((a, b) -> a >= b ? a : b));
		System.out.println("최소값 : " + getMaxMin((a, b) -> a <= b ? a : b));
	}
}