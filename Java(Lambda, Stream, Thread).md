## Java SE

- #### Thread의 구현과 실행

   - ```java
     //	Thread 클래스를 상속
     class MyThread extends Thread{
         public void run(){/* 작업내용 */}	//	Thread 클래스의 run()을 오버라이딩
     }
     ```

   - ```java
     //	Runnable 인터페이스를 구현
     class MyThread implements Runnable{
         public void run(){/* 작업내용 */}	//	Runnable 인터페이스의 run()을 구현
     }
     ```

   - Runnable 인터페이스를 구현하는 방법이 reusability가 높고 코드의 consistency를 유지할 수 있기 때문에 객체지향적인 방법이라 할 수 있음

   - ```java
     //	Thread를 상속받은 class에서는 간단히 getName()이 가능하지만
     //	Runnable을 구현한 class에서는 Thread.currentThread().getName()을 해야함
     System.out.println(Thread.currentThread().getName());
     ```

   - ##### Thread의 실행 - start()

     ```java
     Thread t1 = new Thread();
     t1.start();
     t1.start(); // 예외발생
     
     // 올바른 코드
     Thread t1 = new Thread();
     t1.start();
     t1 = new Thread(); // Thread를 다시 생성
     t1.start();
     ```

   ------

- #### Lambda
  
     - 메서드를 하나의 식으로 표현한 것
     - 함수를 간략하면서도 명확한 식으로 표현 가능하게 해줌
     
     1. ##### Lambda식 작성하기
     
        ```
        반환타입 메서드이름(매개변수 선언){
        	실행 코드
        }
        
        (매개변수 선언) -> { 실행 코드 }
        ```
     
        ```java
        int max(int a, int b){
            eturn a > b ? a : b; 
        }
        
        (a, b) -> a > b ? a : b;
        ```
     
     2. ##### 람다 인터페이스
     
        - Supplier, Consumer, Function, Predicate 는 람다의 다른 문서 참조

------

- #### Stream

  - Stream은 데이터 소스를 추상화하고, 데이터를 다루는데 자주 사용되는 메서드들을 정의

  - ```java
    String[] strArr = {"aaa", "ddd", "ccc"};
    List<String> strList = Arays.asList(strArr); // List 변환
    
    Stream<String> strStream1 = strList.stream(); // stream 생성
    Stream<String> strStream2 = Arrays.stream(strArr); // stream 생성
    ```

  - Stream은 데이터 소스를 변경하지 않음

    ```java
    // 하지만 정렬된 경과를 컬렉션이나 배열에 담아 반환 가능
    List<String> sortedList = strStream2.sorted().collect(Colectors.toList());
    ```

  - Stream은 일회용

    ```java
    // stream은 iterator처럼 일회용
    strStream1.sorted().forEach(System.out::println);
    int numOfStr = strStream1.count(); // 에러 위에서 쓰인 stream은 이미 닫힘
    ```

  - Stream은 작업을 내부 반복으로 처리

    ```java
    stream.forEach(System.out:println);
    ```

  - Stream의 연산

    |                중간 연산                 |           설명            |
    | :--------------------------------------: | :-----------------------: |
    |           Stream<T> distinct()           |         중복 제거         |
    | Stream<T> filter(Predicate<T> predicate) | 조건에 안 맞는 요소 제외  |
    |      Stream<T> limit(long maxSize)       |  스트림의 일부를 잘라냄   |
    |          Stream<T> skip(long n)          |  스트림의 일부를 건너 뜀  |
    |    Stream<T> peek(Consumer<T> action)    | 스트림의 요소에 작업 수행 |
    |            Stream<T> sorted()            |   스트림의 요소를 정렬    |

    |                          최종 연산                           |                     설명                      |
    | :----------------------------------------------------------: | :-------------------------------------------: |
    |           void forEach(Consumer<? super ?> action)           |          각 요소에 지정된 작업 수행           |
    |                         long count()                         |           스트림의 요소의 개수 반환           |
    |                         max(), min()                         |          스트림의 최대/최소값을 반환          |
    |       findAny() // 아무거나 하나, findFirst // 첫 번째       |            스트림의 요소 하나 반환            |
    | allMatch() // 모두 만족, anyMatch() // 하나라도 만족,  noneMatch // 모두 만족하지 않음 | 주어진 조건을 모든 요소가 만족시키는지 아닌지 |
    |                          toArray()                           |             스트림을 배열로 반환              |
    |                           reduce()                           |         요소를 하나씩 줄여가면서 계산         |
    |                          collect()                           |             스트림의 요소를 수집              |

  1. ##### Stream 만들기

     - 컬렉션

       ```java
       List<Integer> list = Array.asList(1, 2, 3, 4, 5);
       Stream<Integer> intStream = list.stream();
       ```

     - 배열

       ```java
       Stream<String> strStream = Stream.of("a", "b", "c");
       Stream<String> strStream = Stream.of(new String[] {"a", "b", "c"});
       Stream<String> strStream = Arrays.stream(new String[] {"a", "b", "c"});
       Stream<String> strStream = Arrays.stream(new String[] {"a", "b", "c"}, 0 , 3);
       ```

     - 특정 범위의 정수

       ```java
       IntStream intStream = IntStream.range(1, 5); // 끝수 포함 X
       IntStream intStream = IntSTream.rangeClosed(1, 5); // 끝수 포함
       ```

     - 두개의 스트림을 연결

       ```java
       Stream<String> Strs1 = Stream.of(str1);
       Stream<String> Strs2 = Stream.of(str2);
       Stream<String> Strs3 = Stream.concat(Strs1, Strs2);
       ```

  2. ##### Stream의 중간 연산

     - 스트림 자르기 - skip(), limit()

       ```java
       IntStream intStream = IntStream.rangeClosed(1, 10); // 1~10의 요소 가진 스트림
       intstream.skip(3).limit(5).forEach(System.out::print); // 4 5 6 7 8
       ```

     - 요소 걸러내기 - filter(), distinct()

       ```java
       // distinct 중복 제거
       IntStream intStream = IntStream.f(1, 2, 2, 3, 3, 3, 4, 5, 5, 6);
       intStream.distinct.forEach(System.out::print); // 1 2 3 4 5 6
       ```

       ```java
       // filter 
       IntStream intStream = IntStream.rangeClosed(1, 10); // 1~10
       intStream.filter(i -> i%2 == 0).forEach(System.out::print); // 2 4 6 8 10
       ```

       