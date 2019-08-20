## Lambda_1

1. #### Lambda Basic

   - 함수적 프로그래밍 패턴을 위해 Java는 8버전부터 Lambda를 지원!

   - 람다는 익명함수를 만들기 위한 expression(식)

     - 객체지향언어보다는 함수지향적 언어에서 사용

   - 기존 자바 개발자들은 이 Lambda라는 개념에 익숙해지기가 쉽지 않음

     그럼에도 자바가 Lambda를 도입한 이유는 크게 2가지 정도로 생각 가능

     ```
     1. 코드가 간결해짐
      
     2. Java Stream을 이용하기 위해서 람다를 이용
        Java Stream은 collection(List, Map, Set, Array..)의 효율적인 처리 가능
        (병렬처리가 가능)
     ```

   - 람다식의 기본 형태

     ```
     ( 매개변수 ) -> { 실행 코드 }
     ```

   - 익명함수를 정의하는 형태로 되어있지만 실제로는 익명클래스의 인스턴스를 생성

   - 람다식이 어떤 객체를 생성하느냐는 람다식이 대입되는 interface 변수가 어떤 interface인가에 달려있음

   - 일반적인 interface를 정의해서 람다식으로 표현해 보자

     ```java
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
     		// 3. Runnalbe interface를 구현한 익명 class를 이용해서
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
     		}).start(); // 람다식으로 간결해진 Thread code
     		
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
     ```

2. #### Lambda Expression

   - 람다식을 표현하는 방식은

     ```
     (인자1, 인자2, 인자3, ...) -> { 실행코드 }
     ```

     1. ###### 매개변수의 이름은 개발자가 지정 가능

        ```java
        Exam02_LambdaIF obj = (int k) -> {System.out.println("출력");};
        ```

     2. ###### 매개변수 타입은 컴파일러의 타입 유추에 의해 알 수 있기에 매개변수의 타입을 지정하지 않음

        ```java
        Exam02_LambdaIF obj = (k) -> {System.out.println("출력");};
        ```

     3. ###### 만약 매개변수가1개인 경우 () 도 생략 가능

        ```java
        Exam02_LambdaIF obj = k -> {System.out.println("출력");};
        ```

     4. ###### 만약 실행문이 1개인 경우 {}도 생략 가능

        ```java
        Exam02_LambdaIF obj = k -> System.out.println("출력");
        ```

     5. ###### 매개변수가 없다면 ()는 생략 불가능

        ```java
        Exam02_LambdaIF obj = () -> System.out.println("출력");
        ```

     6. ###### 실행문에 당연히 return 구문 존재 가능

        ```java
        Exam02_LambdaIF obj = () ->  return a;
        ```

     7. ###### 만약 실행문에 return 구문 1개만 존재하면 {}와 return keyword 생략 가능

        ```java
        Exam02_LambdaIF obj = () ->  a;
        ```
     
   - 람다식은 interface type의 instance를 생성하는 expression
   
   - 람다식은 결국 익명 객체를 생성하는 코드
   
   - 람다식이 생성하는 객체는 결국 어떤 interface type의 변수에 assign이 되는가에 달려있음
   
   - 이렇게 람다식으로 만들어지는 객체의 interface type을 람다의 target type이라고 함
   
   - target type은 아무 interface나 사용 불가능
   
   - 람다의 target type이 되려면 해당 interface는 반드시 추상 메서드가 1개만 존재
   
   - 그래서 interface를 사용할 때 어노테이션을 이용해서 check 가능
   
   - @FunctionalInterface를 이용해서 해당 interface가 
   
     람다의 target type이 될 수 있는지 compiler에 의한 check 가능(함수적 인터페이스)
   
     ```java
     - Thread를 생성할 때 Runnable interface를 사용하는데 
       이 Runnable interface는 public void run()이라는 추상 method 1개만 가지고 있음
       따라서 이 interface는 람다의 target type이 될 수 있고
       Runnable interface는 함수적 인터페이스라고 할 수 있음
     - 이벤트를 처리하는 interface는 대체로 함수적 interface
     ```
   
     ```java
     // 매개변수가 두개인 람다식
     @FunctionalInterface
     interface Exam02_LambdaIF{
     	int myFunc(int a, int b);
     }
     
     public class Exam02_LambdaExpression {
     	public static void main(String[] args) {
     		Exam02_LambdaIF obj = (a, b) ->  a + b;
     		System.out.println(obj.myFunc(10, 20));
     	}
     }
     ```
   
3. #### Lambda Variable

   - 람다식을 정의해서 사용할 때 주의해야 할 점이 몇가지 존재
   - 클래스의 맴버(필드 + 메서드)와 로컬변수(지역변수)의 사용에 약간의 제약이 존재
   - 특히 this keyword를 사용할 때 주의
   - this : 현재 사용되는 객체의 reference
   - 람다식은 익명 객체를 만들어 내는 코드
   - 람다식의 실행코드 내에서 this keyword를 쓰면 익명객체를 지칭하지 않음. 상위 객체를 지칭
   - 람다식 안에서는 지역변수를 read only 형태로 사용해야 함

   ```java
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
   			System.out.println("OuterClass의 객체를 찾아요 : " + 						                                            OuterClass.this.outerField);
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
           // javaLambda.OuterClass
           
   		OuterClass.InnerClass inner = outer.new InnerClass(); // 내부 클래스의 객체 생성
           // javaLambda.OuterClass$InnerClass
   		
           inner.fieldLambda.myFunc();
           // outerField : 100
        // OuterClass의 객체를 찾아요 : 100
           // innerField : 200
           // this.innerField : 200
   		
           inner.innerMethod();
           // 100
   	}
   }
   
   ```
   

