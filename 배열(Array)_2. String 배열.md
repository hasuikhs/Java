## 배열(Array)_2. String 배열

1. #### String 배열의 선언과 생성

   ```java
   String[] name = new String[3] // 3개의 문자열을 담을 수 있는 배열 생성.
   ```

2. #### String 배열의 초기화

   ```java
   String[] name = new String[] {"Kim", "Park", "Lee"};
   String[] name = {"Kim", "Park", "Lee"}; // new String 생략 가능.
   ```

3. #### char배열과 String 클래스

   ```
   String 클래스는 char배열에 기능(매서드)를 추가한 것.
   ```

   - String 클래스의 주요 매서드

   |               매서드               |                             설명                             |
   | :--------------------------------: | :----------------------------------------------------------: |
   |       char charAt(int index)       |        문자열에서 해당 위치(index)에 있는 문자를 반환        |
   |            int length()            |                     문자열의 길이를 반환                     |
   | String substring(int from, int to) | 문자열에서 해당 범위(from~to)에 있는 문자열을 반환.(to는 범위에 포함되지 않음) |
   |     boolean equals(String str)     |    문자열의 내용이 같은지 확인. 같으면 true, 다르면false     |
   |        char[] toCharArray()        |          문자열을 문자배열(char[])로 변환해서 반환           |