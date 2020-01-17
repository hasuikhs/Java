# Calendar

## 1. 첫 번째

- 소스

  ```java
  public class Calendar {
  
  	public static void main(String[] args) {
  
  		Scanner sc = new Scanner(System.in);
  
  		int m = sc.nextInt() - 1; // 월 입력
  		int y = sc.nextInt() - 1900; // 년도 입력
  
  		Date cal = new Date();
  		cal.setMonth(m);
  		cal.setYear(y);
  		cal.setDate(1);
  
  		Date cloneCal = new Date();
  		cloneCal.setMonth(m);
  		cloneCal.setYear(y);
  
  		// 말 일 구하기
  		int lastDayOfMonth = 28;
  		for (; lastDayOfMonth < 36; lastDayOfMonth++) {
  			cloneCal.setDate(lastDayOfMonth);
  			if (cloneCal.getMonth() != cal.getMonth()) {
  				lastDayOfMonth--;
  				break;
  			}
  		}
  
  		DateFormat format = new SimpleDateFormat("MMMM yyyy", Locale.US);
  		String dateStr = format.format(cal.getTime());
  		System.out.println(dateStr);
  
  		System.out.println("Su Mo Tu We Th Fr Sa");
  
  		String[] calendar = new String[40];
  
  		// 일(0), 월(1), 화(2), 수(3), 목(4), 금(5), 토(6)
  		
  		int day = 1;
  		for (int i = 0; i <= cal.getDay() + lastDayOfMonth; i++) {
  			if(i <= cal.getDay()) {
  				calendar[i] = "  ";
  			} else {
  				calendar[i] = Integer.toString(day);
  				day++;
  			}
  		}
  		
  		for (int i = 1; i <= cal.getDay() + lastDayOfMonth; i++) {
  			System.out.printf("%2s ", calendar[i]);
  			if (i % 7 == 0) {
  				System.out.println();
  			}
  			if (calendar[i] == null) {
  				break;
  			}
  			
  		}
  	}
  }
  ```

- 결과

  ```bash
  5 2020 # 입력
  
  May 2020
  Su Mo Tu We Th Fr Sa
                  1  2 
   3  4  5  6  7  8  9 
  10 11 12 13 14 15 16 
  17 18 19 20 21 22 23 
  24 25 26 27 28 29 30 
  31 
  ```

- 받은 피드백

  - 숫자들의 의미 불명
  - 배열의 크기를 정하지 않아도 되는 콜렉션 사용 추천
  - sublist와 join 등 사용

## 2. 두 번째

- 소스

  ```java
  public class Calendar {
  	private static final int WEEK_DAY = 7;
  
  	@SuppressWarnings("deprecation")
  	public static void main(String[] args) {
  
  		Scanner scn = new Scanner(System.in);
  		
  		int m = scn.nextInt() - 1; // 월 입력
  		int y = scn.nextInt() - 1900; // 년도 입력
  		
  		scn.close();
  		
  		Date cal = new Date();
  		cal.setMonth(m);
  		cal.setYear(y);
  		cal.setDate(1);
  
  		Date cloneCal = new Date();
  		cloneCal.setMonth(m);
  		cloneCal.setYear(y);
  
  		// 말 일 구하기
  		int lastDayOfMonth = 28;
  		for (; lastDayOfMonth <= 35; lastDayOfMonth++) {
  			cloneCal.setDate(lastDayOfMonth);
  			if (cloneCal.getMonth() != cal.getMonth()) {
  				lastDayOfMonth--;
  				break;
  			}
  		}
  
  		DateFormat format = new SimpleDateFormat("MMMM yyyy", Locale.US);
  		String dateStr = format.format(cal.getTime());
  		System.out.println(dateStr);
  
  		System.out.println("Su Mo Tu We Th Fr Sa");
  
  		ArrayList<String> arrCal = new ArrayList<String>();
  
  		// 일(0), 월(1), 화(2), 수(3), 목(4), 금(5), 토(6)
  
  		int day = 1;
  		int lengthOfMonth = cal.getDay() + lastDayOfMonth;
  
  		for (int i = 0; i <= lengthOfMonth; i++) {
  			if (i <= cal.getDay()) {
  				arrCal.add("  ");
  			} else {
  				arrCal.add(Integer.toString(day));
  				day++;
  			}
  		}
  
  		for (int i = 1; i <= lengthOfMonth; i++) {
  			System.out.printf("%2s ", arrCal.get(i));
  			if (i % WEEK_DAY == 0) {
  				System.out.println();
  			}
  			if (arrCal.get(i) == null) {
  				break;
  			}
  
  		}
  	}
  }
  ```

- 개선 사항

  - Scanner 클래스 close()
  - 기존 크기가 정해진 배열 삭제 후 ArrayList 사용
  - 상수 사용

- 힌트

  ```java
  public class testCalArray {
  
  	public static void main(String[] args) {
  		int WEEK_DAY = 7;
  		ArrayList<String> alMonth = new ArrayList<String>();
  
  		for (int i = 0; i < WEEK_DAY * 5; i++) {
  			if ((i > 3) && (i < 30)) {
  				alMonth.add((i + 1) + "");
  			} else {
  				alMonth.add(" ");
  			}
  		}
  
  		for (int i = 0; i < 5; i++) {
  			List<String> sub = alMonth.subList(i * WEEK_DAY, (i + 1) * WEEK_DAY);
  			 System.out.println(sub);
  			System.out.println(String.join(" ", sub));
  		}
          
          /*
                      5 6 7
          	8 9 10 11 12 13 14
              15 16 17 18 19 20 21
              22 23 24 25 26 27 28
              29 30
          */
  	}
  }
  ```

  

