## Stream

1. #### Stream Basic

   - Stream은 Java 8에서 도입

   - 주의사항 java.io 안에 있는 Stream과는 다름

   - 사용 용도

     - 컬렉션 처리(List, Set, Map, 배열)를 위해서 사용

     - 컬렉션 안의 데이터를 반복시키는 반복자의 역할을 하는게 stream

     - 예를 들어 ArrayList안에 학생 객체가 5개 있으면 그 5개를 하나씩 가져오는 역할 수행

       => 이렇게 가져온 데이터를 람다식으로 이용해서 처리 가능 

   - Exam01

     ```java
     // Stream 예제를 위한 Student VO class
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
     	// getter & setter
     	...
     }
     ```

     ```java
     public class Exam01_StreamBasic {
     	
     	private static List<String> myBuddy 
             			= Arrays.asList("홍길동", "김길동", "최길동", "신사임당");
     	
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
     		
             // 람다 interface Consumer를 이용한 Stream 처리
     		Consumer<String> consumer = t -> {
     			System.out.println(t + ", " + Thread.currentThread().getName());
     		};
     		Stream<String> stream2 = myBuddy.parallelStream();
     		stream2.forEach(consumer);
     		
     		// 객체 Stream 처리
     		Stream<Exam01_Student> studentStream = students.stream();
     		double avg = studentStream.mapToInt(t -> tKor()).average().getAsDouble();
     		System.out.println("국어 성적의 평균 : " + avg);
     	}
     }
     ```

2. #### Stream Source

   -  java.util.stream package 안에 우리가 사용 가능한 stream 존재
   - BaseStream으로부터 상속받아서 몇몇개의 Stream 존재
   - Stream => 해당 Stream 안에 객체가 들어가 있는 경우
   - IntStream => 해당 Stream 안에 int 값이 들어가 잇는 경우 사용
   - LongStream, DoubleStream 도 존재
   - 여러가지 형태의 다양한 source에서 Stream을 얻어낼 수 있음

   ```java
   
   public class Exam02_StreamSource {
   	
   	private static List<String> names = Arrays.asList("홍길동", "김길동", "최길동");
   	
   	private static int myArr[] = {10, 20, 30, 40, 50};
   	
   	public static void main(String[] args) {
   		// List로부터 Stream을 생성 가능
   		Stream<String> stream1 = names.stream();
   		
   		// 배열로부터 Stream을 생성 가능
   		IntStream stream2 = Arrays.stream(myArr);
   		System.out.println(stream2.sum());
   		
   		// 정수형 숫자 영역을 이용해서 Stream을 생성 가능
   		IntStream stream3 = IntStream.rangeClosed(1, 10);
   		
   		// 파일로부터 Stream을 생성 가능
   		Path path = Paths.get("asset/readme.txt");
   		// File 객체(java.io)와 유사한 java.nio에 포함된 class
   		// Path
   		try {
   			Stream<String> stream4 = Files.lines(path, Charset.forName("UTF-8"));
   			stream4.forEach(t -> System.out.println(t));
   			stream4.close();
   		} catch(Exception e) {
   			System.out.println(e);
   		}
   	}
   }
   ```

3. #### Stream Pipeline

   - reduction

     => 대량의 데이터를 가공해서 축소하는 개념

     => sum, average, count, max, min

   - Collection을 사용할 때 Stream을 이용해서 이런 reduction작업을 쉽게 할 수 있다

   - 만약 Collection 안에 reduction하기가 쉽지 않은 형태로 데이터가 들어가 있으면

     중간처리 과정을 거쳐서 reduction하기 좋은 형태로 변환

   - Stream은 pipeline을 지원(stream을 연결해서 사용 가능)

   ```java
   class Exam03_Employee implements Comparable<Exam03_Employee>{
   	private String name;	// 이름
   	private int age;		// 나이
   	private String dept;	// 부서
   	private String gender;	// 성별
   	private int salery; 	// 연봉
   	
   	public Exam03_Employee() {}
   
   	public Exam03_Employee(String name, int age, 
                              String dept, String gender, int salery) {
   		super();
   		this.name = name;
   		this.age = age;
   		this.dept = dept;
   		this.gender = gender;
   		this.salery = salery;
   	}
   
   	// getter & setter
       ...
   
   	@Override
   	public int hashCode() {
   		final int prime = 31;
   		int result = 1;
   		result = prime * result + age;
   		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
   		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
   		result = prime * result + ((name == null) ? 0 : name.hashCode());
   		result = prime * result + salery;
   		return result;
   	}
   	
   	@Override
   	public boolean equals(Object obj) {
   		// 만약 overriding을 하지 않으면 메모리 주소 가지고 비교
   		// 내가 원하는 방식으로 overriding을 해서 특정 조건을 만족하면
   		// 객체가 같아!! 라는 식으로 작성해 보자
   		boolean result = false;
   		Exam03_Employee target = (Exam03_Employee)obj;
   		if(this.getName().equals(target.getName())) {
   			result = true;
   		} else {
   			result = false;
   		}
   		
   		return result;
   	}
   
   	@Override
   	public int compareTo(Exam03_Employee o) {
   		// 정수값을 리턴
   		// 양수가 반환되면 순서를 교체
   		// 0이나 음수가 리턴되면 순서를 바꾸지 않음
   		int result = 0;
   		
   		if (this.getSalery() > o.getSalery()) {
   			result = 1;
   		} else if(this.getSalery() == o.getSalery()) {
   			result = 0;
   		} else {
   			result = -1;
   		}
   		
   		return result;
   	}
   }
   ```

   ```java
   public class Exam03_StreamPipeline {
   	
   	private static List<Exam03_Employee> employees = 
   			Arrays.asList(
   					new Exam03_Employee("홍길동", 20, "IT", "남자", 2000),
   					new Exam03_Employee("김길동", 30, "Sales", "여자", 3000),
   					new Exam03_Employee("최길동", 40, "IT", "남자", 1000),
   					new Exam03_Employee("이순신", 50, "Sales", "남자", 3500),
   					new Exam03_Employee("유관순", 35, "IT", "여자", 7000),
   					new Exam03_Employee("신사임당", 60, "IT", "여자", 4000),
   					new Exam03_Employee("강감찬", 30, "IT", "남자", 1000),
   					new Exam03_Employee("이황", 45, "Sales", "남자", 5000),
   					new Exam03_Employee("홍길동", 20, "IT", "남자", 2000));
   	
   	public static void main(String[] args) {
   		// 부서가 IT인 사람들 중 남자에 대한 연봉 평균을 구해보자
   		Stream<Exam03_Employee> stream = employees.stream();
   		
   		// stream의 중간처리와 최종처리를 이용해서 원하는 작업을 해보자
   		// filter method는 결과값을 가지고 있는 stream을 반환
   //		double avg = stream.filter(t -> t.getDept().equals("IT"))
   //						   .filter(t -> t.getGender().equals("남자"))
   //						   .mapToInt(t -> t.getSalery())
   //						   .average().getAsDouble();
   //						   // lazy 처리 최종처리가 존재하지 않으면 중간처리는 진행되지 않는다
   //		System.out.println("IT부서의 남자평균 연봉 : " + avg);
   		
   		// stream은 한번 사용되면 재사용 불가능
   		// 그럼 Stream이 가지고 있는 method는 무엇이 존재하나?
   		// 나이가 35살 이상인 직원 중 남자 직원의 이름을 출력
   		stream.filter(t -> (t.getAge() >= 35))
   			  .filter(t -> t.getGender().equals("남자"))
   			  .forEach(t -> System.out.println(t.getName()));
   		
   		// 중복 제거를 위한 중간 처리
   		int temp[] = {10, 20, 30, 40, 50, 30, 40};
   		IntStream s = Arrays.stream(temp);
   		s.distinct().forEach(t -> System.out.println(t));
   		
   		System.out.println("== 객체에 대한 중복 제거를 해 보자 ==");
   		// VO 안에서 equals() method를 overriding해서 처리
   		employees.stream()
   			   	 .distinct()
   			   	 .forEach(t -> System.out.println(t.getName()));
   		
   		// mapToInt() => mapXXX()
   
   		// 정렬(부서가 IT인 사람을 연봉순으로 출력)
   		employees.stream()
   			 .filter(t -> t.getDept().equals("IT"))
   			 .distinct()
   			 .sorted(Comparator.reverseOrder())		
              	 // 오름차순이 기본, 인자가있으면 내림차순
   			 .forEach(t -> System.out.println(t.getName() + ", " + t.getSalery()));
   		
   		// 반복
   		// forEach()를 이용하면 스트림 안의 요소를 반복 가능
   		// forEach()는 최종 처리 함수
   		// 중간 처리 함수로 반복처리하는 함수가 하나 더 제공(peek)
   		employees.stream()
   				 .peek(t -> System.out.println(t.getName()))
   				 .mapToInt(t -> t.getSalery())
   				 .forEach(t -> System.out.println(t));
   				 
   		// 확인용 최종 처리 함수
   		// 50살 이상인 사람만 추출해서 이름 출력
   		boolean result = employees.stream()
   				 .filter(t -> (t.getAge() >= 50))
   				 .allMatch(t -> (t.getAge() > 55));
   		System.out.println(result);
   		
   		// 최종 확인용 함수로 forEach를 많이 사용했는데
   		// forEach말고 collect()를 이용해 보자
   		// 나이가 50살 이상인 사람들의 연봉을 구해서
   		// List<Integer> 형태의 ArrayList에 저장해 보자
   		List<Integer> tmpList = employees.stream()
   					.filter(t -> (t.getAge() >= 50))
   					.map(t -> t.getSalery())
   					.collect(Collectors.toList());
   		System.out.println(tmpList);
   
   		// 당연히 Set, Map 으로 저장 가능
   		Set<Integer> tmpSet = employees.stream()
   				.filter(t -> (t.getAge() >= 50))
   				.map(t -> t.getSalery())
   				.collect(Collectors.toCollection(HashSet :: new));
   		System.out.println(tmpSet);
   	}
   }
   ```
