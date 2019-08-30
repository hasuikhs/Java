package javaLambda;
/*
 *  함수적 프로그래밍 패턴을 위해 Java는 8버전부터 Lambda를 지원!
 *  
 *  람다는 익명함수를 만들기 위한 expression(식)
 *  ==> 객체지향언어보다는 함수지향적 언어에서 사용
 *  
 *  기존 자바 개발자들은 이 Lambda라는 개념에 익숙해지기가 쉽지 않음
 *  그럼에도 자바가 Lambda를 도입한 이유는 크게 2가지 정도로 생각 가능
 *  
 *  1. 코드가 간결해짐
 *  
 *  2. Java Stream을 이용하기 위해서 람다를 이용
 *     Java Stream은 collection(List, Map, Set, Array..)의 효율적인 처리 가능
 *     (병렬처리가 가능)
 *  
 *  람다식의 기본 형태
 *  
 *  ( 매개변수 )->{ 실행 코드 }
 *  익명함수를 정의하는 형태로 되어있지만 실제로는 익명클래스의 인스턴스를 생성
 *  
 *  람다식이 어떤 객체를 생성하느냐는 람다식이 대입되는 interface 변수가
 *  어떤 interface인가에 달려있음
 *  
 *  일반적인 interface를 정의해서 람다식으로 표현해 보자 
 */

interface Exam01_LambdaIF{
	// 추상 method만 올 수 있다!
	// method의 정의가 없고 선언만 존재하는 게 추상(abstract method) method
	void myFunc(int k);
}

public class Exam01_LambdaBasic {
	public static void main(String[] args) {
		
		// Thread를 생성하려고 함 
		// 1. Thread의 subclass를 이용해서 Thread 생성
		//	  그다지 좋은 방식은 아니다
		// 2. Runnable interface를 구현한 class를 이용해서
		//    Thread를 생성(더 좋은 방식)
		// 3. Runnable interface를 구현한 익명 class를 이용해서
		//    Thread를 생성(안드로이드에서 일반적인 형태)
		
//		Runnable runnable = new Runnable() {
//			// 객체를 생성 못하는 이유는 추상 메서드가 존재하기 때문인데
//			// 이 method를 overriding하면 객체 생성 가능
//			@Override
//			public void run() {
//				
//			}
//		};
		
		new Thread(()-> {
			System.out.println("쓰레드 실행!");
		}).start();
		
//		Exam01_LambdaIF sample = new Exam01_LambdaIF() {
//			@Override
//			public void myFunc(int k) {
//				System.out.println("출력되요!!");
//			}
//		};
		
		// 추상 method가 하나일 경우에만 람다식 사용이 가능
		Exam01_LambdaIF sample = (int k)-> { System.out.println("출력되요!!"); };
		sample.myFunc(100);
	}
}
