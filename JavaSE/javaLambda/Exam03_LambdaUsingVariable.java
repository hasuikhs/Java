package javaLambda;

/*
 * 람다식을 정의해서 사용할 때 주의해야 할 점이 몇가지 존재
 * 클래스의 맴버(필드 + 메서드)와 로컬변수(지역변수)의 사용에 약간의 제약이 존재
 * 
 * 특히 this keyword를 사용할 때 주의
 * this : 현재 사용되는 객체의 reference
 * 람다식은 익명 객체를 만들어 내는 코드
 * 람다식의 실행코드 내에서 this keyword를 쓰면 익명객체를 지칭하지 않음. 상위 객체를 지칭
 * 람다식 안에서는 지역변수를 read only 형태로 사용해야 함
 */

@FunctionalInterface
interface Exam03_LambdaIF{
	public void myFunc();
}

class OuterClass{
	// Field (기본적으로 class의 field는 private)
	public int outerField = 100;
	
	public OuterClass() {
		// default 생성자
		System.out.println(this.getClass().getName());
	}
	
	// class 안에 다른 class를 정의 (inner class)
	class InnerClass{
		int innerField = 200; // Field
		
		Exam03_LambdaIF fieldLambda = () -> {
			System.out.println("outerField : " + outerField);
			System.out.println("OuterClass의 객체를 찾아요 : " + OuterClass.this.outerField);
			System.out.println("innerField : " + innerField);
			System.out.println("this.innerField : " + this.innerField);
			System.out.println(this.getClass().getName());
		}; // Field
		
		public InnerClass() {
			System.out.println(this.getClass().getName());
		} // 생성자
		
		public void innerMethod() {		// method
			int localVal = 100;			// 지역변수(local variable)
										// 지역변수는 stack영역에 저장이되고
										// method가 호출되면 생기고
										// method가 끝나면 없어짐
			
			Exam03_LambdaIF localLambda = () -> {
				System.out.println(localVal);
				// localVal = 50;		// final로 설정하면 값을 못바꿈
									 // 값을 바꿀수가 없어요(read only)
			};
			
			localLambda.myFunc();
		}
	}
}

// 프로그램의시작을  위한 dummy class로 사용
public class Exam03_LambdaUsingVariable {
	
	public static void main(String[] args) {
		// 람다식을 사용하려면 InnerClass의 instance가 존재해야 함
		// 그런데 하필이면 이 InnerClass가 inner class네???
		// inner class의 instance를 생성하려면 outer class의 instance부터 생성해야 함
		
		OuterClass outer = new OuterClass(); // 외부 클래스의 객체생성
		OuterClass.InnerClass inner = outer.new InnerClass(); // 내부 클래스의 객체 생성
		inner.fieldLambda.myFunc();
		inner.innerMethod();
	}
}
