## Lambda_2

- 람다식은 추상 메서드가 1개인 인터페이스의 객체를 생성하는 표현식 
  - 이때 사용하는 인터페이스를 우리가 직접 만들어서 사용하나??
    - 그렇지 않다. 람다식이 대입되는 target type은 일반적으로 Java가 제공하는 API를 제공
    - 대표적으로 Runnable, Event 처리 interface를람다의 target type으로 사용 
  
- Java에서는 람다의 target type으로 사용 가능한 interface를 여러개 만들어서 우리에게 package형태로 제공

  (java.util.function package)

- 제공되는 interface는 총 5가지종류로 분류 가능

  - Consumer, Supplier, Function, Operator, Predicate

1. #### Consumer

   - 함수적 인터페이스 (람다식이 대입될 수 있는 target type으로 사용 가능한 interface)
   - Consumer는 Java가 우리에게 제공하는 interface이고 추상 메서드를 단 1개만 가지고 있음
   - accept()라는 method를 제공
   - 값을 소비만하는 역할을 담당. accept()라는 함수의 리턴 타입은 void

   ```java
   import java.util.Arrays;
   import java.util.List;
   import java.util.function.BiConsumer;
   import java.util.function.Consumer;
   import java.util.function.IntConsumer;
   import java.util.function.ObjIntConsumer;
   
   public class Exam04_LambdaUsingConsumer {
   	// method를 하나 편하게 쓰기위해 static으로 정의
   	
   	public static List<String> names = 
           Arrays.asList("홍길동", "김길동", "최길동", "박길동");
   	
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
           /*
           홍길동100
           김길동100
           최길동100
           박길동100
           */
   
   		Consumer<String> consumer = t -> {
   			System.out.println(t);
   		};
   		consumer.accept("소리없는 아우성!");
   		// 소리없는 아우성!
   		
           BiConsumer<String, String> biConsumer = (a, b) -> {
   			System.out.println(a + b);
   		};
   		biConsumer.accept("소리없는", "아우성");
   		// 소리없는아우성
           
   		IntConsumer intConsumer = i -> System.out.println(i);
   		intConsumer.accept(100);
           // 100
   		
   		ObjIntConsumer<String> objIntConsumer = (a, b) -> System.out.println(a + b);
   		objIntConsumer.accept("Hello", 100);
           // Hello100
   	}
   }
   ```

2. #### Supplier

   - Supplier라고 불리는 함수적 인터페이스 여러개가 제공되는데 이 인터페이스의 특징은 매개변수가 없다
   - 대신 리턴 값이 존재
   - getXXX()라는 method가 추상 메서드 형태로 인터페이스 안에 선언

   ```java
   import java.util.Arrays;
   import java.util.HashSet;
   import java.util.List;
   import java.util.Set;
   import java.util.function.Consumer;
   import java.util.function.IntSupplier;
   import java.util.function.Supplier;
   
   public class Exam05_LambdaUsingSupplier {
   	
   	// 로또 번호를 생성하는 supplier, consumer를 이용한 메서드
   	public static void generateLotto(IntSupplier supplier, Consumer<Integer> consumer) 	   {
   		Set<Integer> set = new HashSet<Integer>();
   		
   		while(set.size() != 6) {
   			set.add(supplier.getAsInt());
   		}
   		
   		for(Integer i : set) {
   			consumer.accept(i);
   		}
   	}
   	
   	public static void main(String[] args) {
           // 친구 목록을 List<String> 형태로 만듦
   		final List<String> myBuddy = 
               Arrays.asList("홍길동", "김길동", "이순신", "강감찬");
   		
   		// Supplier를 이용해서 랜덤으로 1명의 친구를 출력해보자
   		// Math.random() : 0이상 1미만의 실수
   		Supplier<String> supplier = () -> {
   			return myBuddy.get((int)(Math.random() * 4)); 
   		};
   		System.out.println(supplier.get());
   		
   		// -------------------------------------------------------
   		// IntSupplier : 정수값을 1개 리턴하는 supplier
   		// 로또 번호를 자동으로 생성하고 출력하는 간단한 method를 작성
   		// generateLotto(서플라이어, 컨슈머);
   		
   		generateLotto(() -> {
   			return (int)(Math.random() * 45 + 1);
   		}, t -> {
   			System.out.print(t + " ");
   		});
   	}
   }
   ```

3. #### Function

   - Function 함수적 인터페이스는 입력매개변수와 리턴값이 applyXXX() method가 제공
   - 일반적으로 입력매개변수를 리턴값으로 mapping시킬 때 일반적으로 사용

   ```java
   Function<T, R> func = t -> { return ~~ };
    * T : 입력 매개변수의 generic
    * R : 리턴값이 generic
   ```

   ```java
   // Student VO class 정의
   class Exam06_Student{
   	private String sName;
   	private int sKor;
   	private int sEng;
   	private int sMath;
   	
   	public Exam06_Student() {}
   
   	public Exam06_Student(String sName, int sKor, int sEng, int sMath) {
   		super();
   		this.sName = sName;
   		this.sKor = sKor;
   		this.sEng = sEng;
   		this.sMath = sMath;
   	}
   
   	public String getsName() {
   		return sName;
   	}
   
   	public void setsName(String sName) {
   		this.sName = sName;
   	}
   
   	public int getsKor() {
   		return sKor;
   	}
   
   	public void setsKor(int sKor) {
   		this.sKor = sKor;
   	}
   
   	public int getsEng() {
   		return sEng;
   	}
   
   	public void setsEng(int sEng) {
   		this.sEng = sEng;
   	}
   
   	public int getsMath() {
   		return sMath;
   	}
   
   	public void setsMath(int sMath) {
   		this.sMath = sMath;
   	}
   }
   ```

   ```java
   public class Exam06_LambdaUsingFunction {
   	
   	private static List<Exam06_Student> students = 
   			Arrays.asList(new Exam06_Student("홍길동", 10, 20, 30),
   						  new Exam06_Student("김길동", 50, 60, 70),
   						  new Exam06_Student("이순신", 92, 20, 30),
   						  new Exam06_Student("신사임당", 10, 100, 70));
   	
   	private static void printName(Function<Exam06_Student, String> function) {
   		for(Exam06_Student s : students) {
   			System.out.println(function.apply(s));
   		}
   	}
   	
   	private static double getAvg(ToIntFunction<Exam06_Student> function) {
   		double sum = 0;
   		for(Exam06_Student s : students) {
   			sum += function.applyAsInt(s);
   		}
   		return sum / students.size();
   	}
   	
   	public static void main(String[] args) {
   		// 학생 이름을 출력
   		printName(t -> t.getsName());
           /*
           	홍길동
           	김길동
           	이순신
           	신사임당
           */
   		
   		// getAvg()라는static method를 만들어서 다음의내용을 출력
   		// 학생들의 국어성적 평균
   		System.out.println(getAvg(t -> t.getsKor()));	// 40.5
   		// 학생들의 영어성적 평균
   		System.out.println(getAvg(t -> t.getsEng()));	// 50.0
   		// 학생들의 수학성적 평균
   		System.out.println(getAvg(t -> t.getsMath()));	// 50.0
   	}
   }
   ```

4. #### Operator

   - Operator는 Function과 하는 일이 거의 비슷

   - 입력매개변수가 있고 리턴값이 존재

   - Function은 mapping 용도로 많이 사용

     (입력매개변수를 리턴타입으로 변환, mapping의 용도)

   - Operator는 연산용도로 많이 사용

     (입력매개변수를 연산에 이용하여 같은 타입의 리턴값을 돌려주는 형태로 사용)

   ```java
   // 최대값과 최소값을 구하는 static method를 하나 작성해 보자
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
   		System.out.println("최대값 : " + getMaxMin((a, b) -> a >= b ? a : b));	// 100
   		System.out.println("최소값 : " + getMaxMin((a, b) -> a <= b ? a : b));	// 3
   	}
   }
   ```

5. #### Predicate

   - Predicate는 입력매개변수가 존재, boolean 리턴
   - 사용되는 method는 testXXX() 가 사용
   - 입력매개변수 값을 조사하여 true, false 값을 리턴해야 하는 경우

   ```java
   class Exam08_Student{
   	private String name; 	 // 학생이름
   	private int kor;     	 // 국어 성적
   	private int eng;		 // 영어 성적
   	private int math;		 // 수학 성적
   	private String gender; 	 // 성별
   	
   	// 기본 생성자
   	public Exam08_Student() {}
   
   	public Exam08_Student(String name, int kor, int eng, int math, String gender) {
   		super();
   		this.name = name;
   		this.kor = kor;
   		this.eng = eng;
   		this.math = math;
   		this.gender = gender;
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
   	public int getMath() {
   		return math;
   	}
   	public void setMath(int math) {
   		this.math = math;
   	}
   	public String getGender() {
   		return gender;
   	}
   	public void setGender(String gender) {
   		this.gender = gender;
   	}
   }
   ```

   ```java
   public class Exam08_LambdaUsingPredicate {
       // 학생객체를 만들어서 List로 유지
   	private static List<Exam08_Student> students = 
   			Arrays.asList(
   					new Exam08_Student("홍길동", 10, 20, 30, "남자"),
   					new Exam08_Student("박길동", 20, 90, 60, "남자"),
   					new Exam08_Student("신사임당", 30, 30, 90, "여자"),
   					new Exam08_Student("유관순", 80, 80, 100, "여자"),
   					new Exam08_Student("이순신", 30, 10, 10, "남자"));
   	
   	// static method를 하나 정의하는데 성별에 따른 
   	// 특정 과목의 평균을 구하는 작업을 할 것
   	private static double avg(Predicate<Exam08_Student> predicate,
   									ToIntFunction<Exam08_Student> function) {
   		double sum = 0;
   		int cnt = 0;
   		for(Exam08_Student s : students) {
   			if (predicate.test(s)) {
   				sum += function.applyAsInt(s);
   				cnt++;
   			}
   		}
   		return sum / cnt;
   	}
   	
   	public static void main(String[] args) {
   		System.out.println(avg(t -> t.getGender().equals("남자"), t -> t.getMath()));
           // 33.3333333336
   		System.out.println(avg(t -> t.getGender().equals("여자"), t -> t.getEng()));
           // 55.0
   	}
   }
   ```

   