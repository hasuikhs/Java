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

