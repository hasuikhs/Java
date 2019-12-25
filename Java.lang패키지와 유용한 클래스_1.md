## Java.lang패키지와 유용한 클래스

### OBject클래스

| Object클래스의 매서드 |                         설 명                         |
| :-------------------: | :---------------------------------------------------: |
|        clone()        |               객체 자신의 복사본을 반환               |
|    equals(object)     |      객체 자신과 객체 obj가 같은 객체인지 알려줌      |
|      finalize()       |   객체가 소멸될 때 가비지컬렉터에 의해 자동적 호출    |
|      getClass()       |  자신의 클래스 정보를 담고 있는 Class 인스턴스 반환   |
|      hashCode()       |               객체 잣니의 해시코드 반환               |
|      toString()       |           객체 자신의 정보를 문자열로 반환            |
|       notify()        |    자신을 사용하려고 기다리는 쓰레드를 하나만 깨움    |
|      notifyAll()      |     자신을 사용하려고 기다리는 모든 쓰레드를 깨움     |
|  wait(long timeout)   | 현재 쓰레드를 무한히 또는 지정된 시간동안 기다리게 함 |

1. #### equals(Object obj)

   ```java
   public static void main(String[] args){
       Value v1 = new Value(10);
       Value v2 = new Value(10);
       
       if(v1.equals(v2)){
           System.out.println("v1과 v2는 같습니다.")
       }else{
           System.out.println("v1과 v2는 다릅니다.")
       } // 결과 : v1과 v2는 다름
     	// 값이 같아도 equals 는 주소를 비교하기 때문  
       v2 = v1;
       
       if(v1.equals(v2)){
           System.out.println("v1과 v2는 같습니다.")
       }else{
           System.out.println("v1과 v2는 다릅니다.")
       } // 결과 : v1과 v2는 같음
   } 
   ```

2. #### hashCode()

   ```
   - equals()에서 보다 시피 인스턴스 변수 값으로 객체의 같고 다름을 판단해야하는 경우라면
     hashCode()메서드도 적절히 오버라이딩 해야 함
   - 같은 객체라면 hashCode메서드를 호출했을 때의 결과값인 해시코드도 같아야 하기 때문
   ```

3. #### toString()

   ```
   - 인스턴스에 대한 정보를 문자열로 제공할 목적으로 정의
   - 클래스를 작성할 때 toString()을 오버라이딩하지 않는다면, 16진수의 해시코드 값 출력
   ```

------

### String클래스

|            메서드            |                             예제                             |                       결과                       |
| :--------------------------: | :----------------------------------------------------------: | :----------------------------------------------: |
|      charAt(int index)       |         String s = "hello";   char c = s.charAt(1);          |                     c = 'e'                      |
|      concat(String str)      |     String s = "hello";  String s2 = s.concat("world");      |                s2 = "hello world"                |
|   contains(CharSequence s)   |     String s = "abcdefg";  boolean b = s.contains("bc");     |                     b = true                     |
|      equals(Object obj)      |      String s = "Hello"; boolean b = s.equals("Hello");      |                     b = true                     |
| equalsIgnoreCase(String str) | String s = "hello"; boolean b = s.equalsIgnoreCase("HELLO"); |                     b = true                     |
|           length()           |         String s = "hello"; int length = s.length();         |                    length = 5                    |
| replace(char old, char new)  |     String s = "hello"; String s1 = s.replace('h','c');      |                   s1 = "cello"                   |
|     split(String regex)      | String animals = "dog,cat,bear"; String arr = animals.split(","); | arr[0] = "dog"; arr[1] = "cat"; arr[2] = "bear"; |
| toLowerCase(), toUpperCase() |       String s = "Hello"; String l = s.toLowerCase(s);       |                   l = "hello"                    |

1. ### StringBuffer

   - StringBuffer는 문자열을 추가하거나 변경 할 때 주로 사용하는 자료형

   ```java
   StringBuffer sb = new StringBuffer);
   sb.append("hello");
   sb.append(" ");
   sb.append("world")
       
   String str = sb.toString();
   System.out.println(str) // hello world
   ```

   - **메서드 체이닝**
     - 자기 자신의 메서드를 호출하여 자기 자신의 값을 바꿔나가는 것을 말한다.
   - 위의 코드를 메서드 체이닝을 이용해서 한줄로 줄여보자

   ```java
   String str = StringBuffer().append("hello").append(" ").append("world").toString();
   ```

2. ### StringBuffer를 이용한 성능 향상

   - 다음과 같은 반복문을 사용할때에는 String 객체를 종료될때까지 불러오므로 별로 좋지 못하다.

     ```java
     String str = "":
     for(int i = 0; i < 100; i++){
         str += "*";
     }
     ```

   - 그렇기 때문에 StringBuffer를 선언해서 사용하는 것이 성능 향상에 도움이 된다.

     ```java
     StringBuffer sb = new StringBuffer();
     for(int i = 0; i < 100; i++){
         sb.append("*");
     }
     ```

   ```java
   // 예제 코드
   public class StringBufferPerformanceTest{
       public static void main(String[] args){
           // (1) String의 +연산을 이용해서 10,000개의 *를 이어붙입니다.
           //시작시간을 기록합니다.(millisecond단위)
           long startTime1 = System.currentTimeMillis();
           String str="";
           for(int i=0;i<10000;i++){
               str=str+"*";
           }
           //종료시간을 기록합니다.(millisecond단위)
           long endTime1 = System.currentTimeMillis();
           
           // (2) StringBuffer를 이용해서 10,000개의 *를 이어붙입니다.
           //시작시간을 기록합니다.(millisecond단위)                
           long startTime2 = System.currentTimeMillis();
           StringBuffer sb = new StringBuffer();
           for(int i=0;i<10000;i++){
               sb.append("*");
           }
           //종료시간을 기록합니다.(millisecond단위)
           long endTime2 = System.currentTimeMillis();
           
           // 방법(1)과 방법(2)가 걸린 시간을 비교합니다.
           long duration1 = endTime1-startTime1;
           long duration2 = endTime2-startTime2;
           
           System.out.println("String의 +연산을 이용한 경우 : "+ duration1);
           System.out.println("StringBuffer의 append()을 이용한 경우 : "+ duration2);
       }
   }
   // 결과
   // String의 +연산을 이용한 경우 : 64
   // StringBuffer의 append()을 이용한 경우 : 2
   ```

   