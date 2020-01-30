# Java Benchmarking

- 예시를 통해 Java 프로그램의 **성능 측정 방법**을 알아보자.

## 1. HashMap vs ArrayList vs Vector

### 1.0 Vector vs ArrayList

- Vector와 ArrayList는 배열을 클래스로 구현하여 데이터를 추가하면 **자동으로 메모리 공간이 늘어나는 장점**이 있다.

#### 1.0.1 공통점

- 인덱스를 이용해 접근이 가능
- 순서가 존재
- 데이터 중복 가능

#### 1.0.2 차이점

- Vector와 ArrayList의 **차이점은 동기화의 처리**
- Vector는 자동으로 동기화 보장, ArrayList는 보장하지 않음
- Vector는 복수의 스레드로부터 작업이 한 번에 하나의 스레드만 처리되므로 **안정화의 이점**이 있다.
- **단일 처리 작업시**에는 오히려 성능의 저하를 일으키므로 **ArrayList가 더 효율적인 성능을 보장**한다.
- 현재 크기를 초과할 시 **Vector는 2배, ArrayList는 1.5배**로 크기를 늘린다.

### 1.1 초기 작업

```java
DecimalFormat fmt = new DecimalFormat("###,###,###.##");

// 비교할 Collection 초기화
ArrayList<ArrayList<String>> listArray = null;
ArrayList<HashMap<String, String>> hashArray = null;
ArrayList<Vector<Object>> vectorArray = null;
ArrayList<String> tdList = null;
HashMap<String, String> tdHash = null;

int cntValue = 10;
int cntData = 10000; // 100000, 1000000 테스트를 진행할 횟수

long usedMemoryOfInit = 0;
long usedMemoryOfArrayTest = 0;
long usedMemoryOfHashTest = 0;
long usedMemoryOfVectorTest = 0;

long startArrayTestTime = 0;
long endArrayTestTime = 0;
long startHashTestTime = 0;
long endHashTestTime = 0;
long startVectorTestTime = 0;
long endVectorTestTime = 0;

String title = "키워드 테스트";
```

### 1.1.1 사용한 메모리량을 반환하는 메서드

```java
private static long getUsedMemory(DecimalFormat fmt) {
		System.out.println(
            "Total Memory:\t" + fmt.format(Runtime.getRuntime().totalMemory())
        );
		System.out.println(
            "Free Memory :\t" + fmt.format(Runtime.getRuntime().freeMemory())
        );
		System.out.println(
            "Used Memory :\t"
				+ fmt.format(Runtime.getRuntime().totalMemory() 
                             - Runtime.getRuntime().freeMemory())
        );

		return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	}
```

### 1.1.2 초기 메모리 사용량 반환

```java
System.out.println("Start ==");
usedMemoryOfInit = getUsedMemory(fmt);
```

### 1.2 ArrayList 사용량 반환

```java
System.out.println("ArrayList ==");
listArray = new ArrayList<ArrayList<String>>();

startArrayTestTime = System.currentTimeMillis();

for (int i = 0; i < cntData; i++) {
	tdList = new ArrayList<String>();
    
	tdList.add(title);
	tdList.add(title);

    for (int j = 0; j < cntValue; j++){
		tdList.add(0 + "");
    }
	listArray.add(tdList);
}

endArrayTestTime = System.currentTimeMillis();
usedMemoryOfArrayTest = getUsedMemory(fmt);
```

### 1.3 HashMap 사용량 반환

```java
System.out.println("HashMap ==");
hashArray = new ArrayList<HashMap<String, String>>();

startHashTestTime = System.currentTimeMillis();
for (int i = 0; i < cntData; i++) {
	tdHash = new HashMap<String, String>();
    
	tdHash.put("title", title);
	tdHash.put("keyword", title);

    for (int j = 0; j < cntValue; j++){
		tdHash.put("value" + j, 0 + "");
	}
	hashArray.add(tdHash);
}

endHashTestTime = System.currentTimeMillis();
usedMemoryOfHashTest = getUsedMemory(fmt);
```

### 1.4  Vector 사용량 반환

```java
System.out.println("Vector ==");
vectorArray = new ArrayList<Vector<Object>>();

startVectorTestTime = System.currentTimeMillis();
Vector<Object> tdVector = null;
for (int i = 0; i < cntData; i++) {
	tdVector = new Vector<Object>();

	tdVector.add(title);
	tdVector.add(title);

	for (int j = 0; j < cntValue; j++){
		tdVector.add(0.0);
    }
	vectorArray.add(tdVector);
}

endVectorTestTime = System.currentTimeMillis();
usedMemoryOfVectorTest = getUsedMemory(fmt);
```

### 1.5 측정 결과

```java
System.out.println("");
		System.out.println("Memory =========");
		System.out.println(
            "ArrayList:\t" + 
            fmt.format(usedMemoryOfArrayTest - usedMemoryOfInit) + "\t"
			+ (int) ((usedMemoryOfArrayTest - usedMemoryOfInit) / cntData)
        );
		System.out.println(
            "HashMap\t:\t" + 
            fmt.format(usedMemoryOfHashTest - usedMemoryOfArrayTest) + "\t"
			+ (int) ((usedMemoryOfHashTest - usedMemoryOfArrayTest) / cntData)
        );
		System.out.println(
            "Vector\t:\t" + 
            fmt.format(usedMemoryOfVectorTest - usedMemoryOfHashTest) + "\t"
			+ (int) ((usedMemoryOfVectorTest - usedMemoryOfHashTest) / cntData)
        );

		System.out.println(
            "Diff\t:\t" + 
            String.format("%.3f",
				(usedMemoryOfHashTest - usedMemoryOfArrayTest) / (double) (usedMemoryOfArrayTest - usedMemoryOfInit)
                         )
        );

		System.out.println("Time =========");
		System.out.println(
            "ArrayList:\t" + fmt.format(endArrayTestTime - startArrayTestTime)
        );
		System.out.println(
            "HashMap\t:\t" + fmt.format(endHashTestTime - startHashTestTime)
        );
		System.out.println(
            "Vector\t:\t" + fmt.format(endVectorTestTime - startVectorTestTime)
        );
		System.out.println(
            "Diff\t:\t" + 
            String.format("%.3f",
				((endHashTestTime - startHashTestTime) / (double) (endArrayTestTime - startArrayTestTime))
                         )
        );
```

#### 1.5.1 10,000번 진행시

```
Memory =========
ArrayList:	2,740,584	274
HashMap	:	18,790,736	1879
Vector	:	5,368,728	536
Diff	:	6.856 // hashmap/arraylist
Time =========
ArrayList:	15
HashMap	:	16
Vector	:	0
Diff	:	1.067
```

#### 1.5.2 100,000번 진행시

```
Memory =========
ArrayList:	17,789,824	177
HashMap	:	89,568,912	895
Vector	:	42,854,528	428
Diff	:	5.035
Time =========
ArrayList:	25
HashMap	:	97
Vector	:	47
Diff	:	3.880
```

#### 1.5.3 1,000,000번 진행시

```
Memory =========
ArrayList:	126,294,744	126
HashMap	:	950,359,264	950
Vector	:	403,982,192	403
Diff	:	7.525
Time =========
ArrayList:	139
HashMap	:	3,942
Vector	:	335
Diff	:	28.360
```

## 2. String vs StringBuffer vs StringBuilder

- 일반적으로 쿼리 문장을 작성해보면, 다음과 같이 작성한다.

  ```java
  String strSQL = "";
  str += "select * ";
  str += "from ( ";
  str += "select A_column, ";
  str += "B_column, ";
  ...
  ```

- 이와 같이 String으로 코딩하면 다음과 같은 메모리 사용량을 확인 가능하다.

  |     구분      |       결과       |
  | :-----------: | :--------------: |
  | 메모리 사용량 | 10회 평균 약 5mb |
  |   응답 시간   | 10회 평균 약 5ms |

- 위 코드를 메모리 사용량과 응답 시간을 줄이기 위해 StringBuilder로 변경하자.

  ```java
  StringBuilder strSQL = new StringBuilder();
  strSQL.append("select * ");
  strSQL.append(" from ( ");
  strSQL.append(" select A_column, ");
  strSQL.append(" Bc_column, ");
  ...
  ```

- 이와 같이 StringBuilder를 이용해서 변경할 경우의 메모리 사용량과 응답 시간을 살펴보자.

  |     구분      |        결과        |
  | :-----------: | :----------------: |
  | 메모리 사용량 | 10회 평균 약 371kb |
  |   응답 시간   | 10회 평균 약 0.3ms |

### 1.1 StringBuffer 클래스 vs StringBuilder 클래스

- StringBuffer 클래스나 StringBuilder 클래스에서 제공하는 메서드는 동일하다.
- StringBuffer 클래스는 Thread에 안전하게(ThreadSafe) 설계되어 있으므로, **여러개의 Thread에서  하나의 StringBuffer 객체를 처리**해도 문제가 되지 않는다.
- **StringBuilder는 단일 Thread에서의 안전성만을 보장**한다.

### 1.2 성능 비교

> 그렇다면 String, StringBuffer, StringBuilder 세 개의 String 클래스에서 어느것이 가장 빠르고 메모리를 적게 사용하는지 알아보도록하자.

- 세가지 String 클래스를 이용하여 10,000 회 반복하여 문자열을 더하고, 이런 작업을 10회 반복해보면

  |     소스 코드     | 응답 시간(ms) | 소요시간 | 메모리 사용량(bytes) |  비고   |
  | :---------------: | :-----------: | :------: | :------------------: | :-----: |
  |   a += aValue;    |   95,801.41   |   95초   |   100,102,000,000    | 약 95gb |
  | b.append(aValue); |    247.48     |  0.25초  |      29,493,600      | 약 28mb |
  | c.append(aValue); |    174.17     |  0.17초  |      29,493,600      | 약 39mb |

- 왜 이러한 결과가 발생할까?

  ```java
  // String
  a += aValue
  ```

  1. 위와 같이 코딩하게  되면 더할때마다 새로운 String 객체가 만들어짐
  2. 이전에 있던 a **객체는 더이상 필요가 없어지므로 쓰레기 값이 되어 GC(GarbageCollector) 대상이 됨**
  3. **이러한 작업을 계속 반복하게 되면서 메모리를 많이 사용**하게 됨

- 그렇다면 **String**은 사용하지 말아야하나?

  - 아니다. **String 클래스는 짧은 문자열을 더할 경우** 사용하자.

- **StringBuffer**는 언제 사용해야하나?

  - Thread에 안전한 프로그램이 필요할때나, 개발 중인 시스템의 대부분이 **Thread에 안전한지를 모를 경우**
  - 만약 클래스에 **static으로 선언된 문자열을 변경**하거나, **singleton으로 선언된 클래스에 선언**된 경우

- **StrigBuilder**는 언제 사용해야하나?

  - Thread에 안전한지의 여부와 전혀 관계없는 프로그램을 개발할 경우
  - 만약, 메서드 내에 변수를 선언했다면, 그 변수는 그 메서드 내에서만 살아있으므로 StringBuilder를 사용

### 1.3 실습

```java
// 초기 기본값 테스트
System.out.println("Start ==");
usedMemoryOfInit = getUsedMemory(fmt);

// String test 시작
System.out.println("String ==");

startStringTestTime = System.currentTimeMillis();

for (int i = 0; i < cntData; i++) {
	str += strValue;
}

endStringTestTime = System.currentTimeMillis();

usedMemoryOfStringTest = getUsedMemory(fmt);
// String test 종료

// StringBuffer test 시작
System.out.println("StringBuffer ==");

startStrBufferTestTime = System.currentTimeMillis();

for (int i = 0; i < cntData; i++) {
	strbf.append(strValue);
}

endStrBufferTestTime = System.currentTimeMillis();

usedMemoryOfStrBufferTest = getUsedMemory(fmt);
// StringBuffer test 종료

// StringBuilder test 시작
System.out.println("StringBuilder ==");

startStrBuilderTestTime = System.currentTimeMillis();

for (int i = 0; i < cntData; i++) {
	strbd.append(strValue);
}

endStrBuilderTestTime = System.currentTimeMillis();

usedMemoryOfStrBuilderTest = getUsedMemory(fmt);
// StringBuilder test 종료
```

#### 1.3.1 10,000번 진행시

```
Memory =====
String : 	343,854,208	34385
StringBuffer : 	0	0
StringBuilder : 	0	0
Time =====
String:	238
StringBuffer : 	0
StringBuilder : 	1
```

#### 1.3.2 50,000번 진행시

```
Memory =====
String 		 : 	340,336,832	6806
StringBuffer : 	5,792,136	115
StringBuilder: 	7,594,672	151
Time =====
String		 :	3,745
StringBuffer : 	2
StringBuilder:	1
```

#### 1.3.3 100,000번 진행시

```
Memory =====
String 		 : 	341,934,960	3419
StringBuffer : 	4,128,816	41
StringBuilder: 	9,616,016	96
Time =====
String 		 :	16,110
StringBuffer : 	3
StringBuilder: 	1
```





