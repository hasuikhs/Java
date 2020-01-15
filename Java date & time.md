# Java date & time

## 1. Time Stamp

### 1.1 Unix Time Stamp

- 1970년 1월 1일 00:00:00 (UTC) 부터의 경과 시간을  **초**로 환산하여 나타낸 것

### 1.2 Java Time Stamp

- 1970년 1월 1일 00:00:00 (UTC) 부터의 경과 시간을 **밀리초**로 환산하여 나타낸 것

### 1.3 Timezone

- **동일한 로컬 시간을 따르는 지역을 의미**하며, 주로 해당 국가에 의해 법적으로 지정된다.
- 국가별로 각자의 고유한 Timezone을 사용하고 있으며, 면적이 넓은 나라인 경우 지역별로 각각의 Timezone을 사용하기도 한다.

- **오프셋**
  - UTC와의 시간 차이를 의미한다.
  - 예를 들어 우리나라는 +09:00 오프셋을 사용하고 있는데, 이 오프셋은 일본과 인도네시아 등 여러 지역에서 사용하고 있으므로 오프셋과 타임존의 관계는 1:N이다.

- [TimeZoneID 확인](https://docs.oracle.com/middleware/12212/wcs/tag-ref/MISC/TimeZones.html)

## 2. Java 시간 관련 

### 2.1 Date

- 현재 년월일 시분초를 한번에 출력할 때 사용

  ```java
  public static void main(String[] args) {
      Date date = new Date();
      
      System.out.println(date)	// Wed Jan 15 12:59:47 KST 2020
  }
  ```

- Java 8 이후 사용을 **권장하지 않는다.**

### 2.2 Calendar

- Date 클래스에서 권장되지 않는 메소드나 생성자들을 제공한다.

  ```java
  public static void main(String[] args) {
  	Calendar cal = Calendar.getInstance();
  
  	int year = cal.get(Calendar.YEAR);
  	int month = cal.get(Calendar.MONTH) + 1; // 월은 0부터 시작하므로 주의
  	int day = cal.get(Calendar.DAY_OF_MONTH);
  	int hour = cal.get(Calendar.HOUR_OF_DAY);
  	int min = cal.get(Calendar.MINUTE);
  	int sec = cal.get(Calendar.SECOND);
  		
  	System.out.println("현재 시간");
  	System.out.println(year + "년 " + month + "월 " + day + "일");
  	System.out.println(hour + "시 " + min + "분 " + sec + "초");
  }
  
  /*
  	현재 시간
  	2020년 1월 15일
  	13시 33분 9초
  */
  ```

### 2.3 LocalDate, LocalTime, LocalDateTime

- **Calendar, Date 클래스의 문제점**
  - 불변 객체가 아니다.
    - 악의적으로 set을 이용해서 변경 가능하다.
  - 상수 필드 남용
    - Calendar.SECOND 등
  - 헷갈리는 월 지정
    - 1월을 0으로 표현하는 문제
  - 일관성 없는 요일 상수
    - 어디서는 일요일이 0, 다른 곳은 1
  - Date와 Calendar 객체의 역할 분담
    - 연월일 계산은 Date만으로 부족해서 Calendar를 왔다갔다 하므로 자원소모가 크다.
  - 기타 java.util.Date 하위 클래스 문제
- 이러한 문제를 해결하기 위해서 Java 8부터 사용되는 LocalDate, LocalTime, LocalDateTime
- 시간을 

#### 2.3.1 LocalDate

```java
public static void main(String[] args) {
	
    LocalDate currentDate = LocalDate.now();	// 2020-01-15
    
	//LocalDate myDate = LocalDate.of(int year, int month, int dayOfMonth);
		
	currentDate.getYear();			// 2020
	
	currentDate.getMonth();			// JANUARY
		
	currentDate.getMonthValue();	// 1
		
	currentDate.getDayOfYear();		// 15
	
	currentDate.getDayOfMonth();	// 15
	
	currentDate.getDayOfWeek(); 	// WEDNESDAY
		
	currentDate.isLeapYear();		// true	
}
```

#### 2.3.2 LocalTime

```java
public static void main(String[] args) {
	LocalTime currentTime = LocalTime.now();	// 14:32:21.201
		
	// LocalTime targetTime = LocalTime.of(hour, minute, second, nanoOfSecond);
		
	currentTime.getHour();		// 14
	
	currentTime.getMinute();	// 32
		
	currentTime.getSecond();	// 21
		
	currentTime.getNano();		// 201000000
}
```

#### 2.3.3 LocalDateTime

```java
public static void main(String[] args) {
	LocalDateTime currentDateTime = LocalDateTime.now();
    // 2020-01-15T14:45:08.830
	// LocalDateTime targetDateTime = 
    //     LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond);

	ZonedDateTime utcDatetime = ZonedDateTime.now(ZoneId.of("UTC"));
	// 2020-01-15T05:45:08.831Z[UTC]	
	ZonedDateTime seoulDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
    // 2020-01-15T14:45:08.831+09:00[Asia/Seoul]
}
```



