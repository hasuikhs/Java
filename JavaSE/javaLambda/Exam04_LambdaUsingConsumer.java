package javaLambda;

/*
 * 람다식은 추상 메서드가 1개인 인터페이스의 객체를 생성하는 표현식 
 * => 이때 사용하는 인터페이스를 우리가 직접 만들어서 사용하나??
 * ==> 그렇지 않다. 람다식이 대입되는 target type은 일반적으로
 *     Java가 제공하는 API를 제공
 *     대표적인게.. Runnable, Event 처리 interface를 람다의 target type으로 사용 
 *     
 * Java에서는 람다의 target type으로 사용 가능한 
 * interface를 여러개 만들어서 우리에게 package형태로 제공
 * (java.util.function package)
 * 
 * 제공되는 interface는 총 5가지종류로 분류 가능하다
 * Consumer : 인자를 사용하고, 리턴이 없는 추상 메서드를 가지고 있음
 * Supplier : 사용되는 인자가 없고, 리턴값이 존재
 * Function :
 * Operator :
 * Predicate:
 * 총 5가지 분류가 존재
 * 
 * Consumer : 함수적 인터페이스 
 * 			  (람다식이 대입될 수 있는 target type으로 사용 가능한 interface)
 * Consumer는 Java가 우리에게 제공하는 interface이고 추상 메서드를 단 1개만 가지고 있음
 * accept()라는 method를 제공
 * 값을 소비만하는 역할을 담당. accept()라는 함수의 리턴 타입은 void  
 */

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.ObjIntConsumer;

public class Exam04_LambdaUsingConsumer {
	// method를 하나 편하게 쓰기위해 static으로 정의
	
	public static List<String> names = Arrays.asList("홍길동", "김길동", "최길동", "박길동");
	
	// 일반적인 method 호출은 사용하는 data가 인자로 전달되는 형태
	// 람다식을 사용하면 method를 호출할 때 data가 아니라 실행 코드를 넘겨줄 수 있음
	// (눈에 보이는 형태만 그렇다)
	// 일반적으로 프로그래밍 언어에서 이렇게 함수를 다른 함수의 인자로
	// 사용 가능한데 이런 함수를 first-classes function이라고 함
	// 일급함수로 표현(JavaScript가 대표적)
	// Java언어도 람다를 도입해서 마치 1급함수를 사용하는 것처럼 사용 가능
	
	public static void printName(Consumer<String> consumer) {
		for(String name : names) {
			consumer.accept(name);
		}
	}
	
	public static void main(String[] args) {
		
		printName(t -> System.out.println(t + "100"));

		Consumer<String> consumer = t -> {
			System.out.println(t);
		};
		
		consumer.accept("소리없는 아우성!");
		
		BiConsumer<String, String> biConsumer = (a, b) -> {
			System.out.println(a + b);
		};
		biConsumer.accept("소리없는", "아우성");
		
		IntConsumer intConsumer = i -> System.out.println(i);
		intConsumer.accept(100);
		
		ObjIntConsumer<String> objIntConsumer = (a, b) -> System.out.println(a + b);
		objIntConsumer.accept("Hello", 100);
	}
}
