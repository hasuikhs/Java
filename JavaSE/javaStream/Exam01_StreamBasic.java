package javaStream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/*
 * Stream은 Java 8에서 도입
 * 주의사항 java.io 안에 있는 Stream과는 다름
 * 사용 용도 : 컬렉션 처리(List, Set, Map, 배열)를 위해서 사용
 * 			   컬렉션 안의 데이터를 반복시키는 반복자의 역할을 하는게 stream
 * 			   예를 들어 ArrayList안에 학생 객체가 5개 있으면 그 5개를 하나씩 가져오는 역할 수행
 * 				=> 이렇게 가져온 데이터를 람다식으로 이용해서 처리 가능 
 */

class Exam01_Student{
	private String name;
	private int kor;
	private int eng;
	
	public Exam01_Student() {}

	public Exam01_Student(String name, int kor, int eng) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}
}

public class Exam01_StreamBasic {
	
	private static List<String> myBuddy = Arrays.asList("홍길동", "김길동", "최길동", "신사임당");
	
	private static List<Exam01_Student> students = 
			Arrays.asList(
					new Exam01_Student("홍길동", 10, 20),
					new Exam01_Student("최길동", 60, 30),
					new Exam01_Student("김길동", 30, 80),
					new Exam01_Student("박길동", 90, 10));
	
	public static void main(String[] args) {
		// 사람 이름을 출력해보자
		// 방법 1. 일반 for문을 이용
		for(int i = 0; i < myBuddy.size(); i++) {
			System.out.println(myBuddy.get(i));
		}
		
		// 방법 2. 첨자를 이용한 반복을 피하기 위해 Iterator를 사용
		Iterator<String> it = myBuddy.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		// 방법 3. 내부 반복자를 이용하여, 반복자가 필요가 없음.
		// 병렬처리가 가능
		Stream<String> stream1 = myBuddy.parallelStream();
		stream1.forEach(t -> System.out.println(t));
		
		Consumer<String> consumer = t -> {
			System.out.println(t + ", " + Thread.currentThread().getName());
		};
		Stream<String> stream2 = myBuddy.parallelStream();
		stream2.forEach(consumer);
		
		// 객체 Stream 처리
		Stream<Exam01_Student> studentStream = students.stream();
		double avg = studentStream.mapToInt(t -> t.getKor()).average().getAsDouble();
		System.out.println("국어 성적의 평균 : " + avg);
	}
}
