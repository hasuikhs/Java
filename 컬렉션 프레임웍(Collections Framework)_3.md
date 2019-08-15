## 컬렉션프레임웍_3

1. #### Iterator

   - 모두 컬렉션에 저장된 요소를 접근하는데 사용되는 인터페이스

   ##### Iterator

   |  메서드   |                            설 명                             |
   | :-------: | :----------------------------------------------------------: |
   | hasNext() | 읽어 올 요소가 남아있는지 확인한다. 있으면 true 없으면 false |
   |  next()   | 다음 요소를 읽어 온다. next()를 호출하기 전에 hasNext() 먼저하는 것이 안전 |
   | remove()  |                 next()로 읽어 온 요소를 삭제                 |

   ```java
   class IteratorEx1{
       public static void main(String[] args){
           ArrayList list = new ArrayList();
           list.add("1");
           list.add("2");
           list.add("3");
           list.add("4");
           list.add("5");
           
           Iterator it = list.iterator();
           
           while(it.hasNext()){			// it에 저장된 요소가 있다면 
               Object obj = it.next();		// obj에 it의 요소를 넣음
               System.out.println(obj);	// 들어간 순서대로 출력
           }
       }
   }
   ```

2. #### Arrays

   - 배열을 다루는데 유용한 메서드가 정의

   1. ##### 배열의 복사 - copyOf(), copyOfRange()

      ```java
      // copyOf()는 배열 전체를, copyOfRange()는 배열의 일부를 복사
      
      int[] arr = {0, 1, 2, 3, 4};
      int[] arr2 = Arrays.copyOf(arr, arr.length);	// arr2 = [0, 1, 2, 3, 4]
      int[] arr3 = Arrays.copyOf(arr, 3);				// arr3 = [0, 1, 2]
      int[] arr4 = Arrays.copyOf(arr, 7);				// arr4 = [0, 1, 2, 3, 4, 0 , 0]
      int[] arr5 = Arrays.copyOfRange(arr,2, 4);		// arr5 = [2, 3]
      int[] arr6 = Arrays.copyOfRange(arr, 0, 7);		// arr6 = [0, 1, 2, 3, 4, 0, 0] 
      ```

   2. ##### 배열 채우기 - fill(), setAll()

      ```java
      // fill()은 배열의 모든 요소를 지정된 값으로 채움,
      // setAll()은 배열을 채우는데 사용할 함수형 인터페이스를 매개변수로 받음
      
      int[] arr = new int[5]
      Arrays.fill(arr, 9);		// arr = [9, 9,9, 9, 9]
      Arrays.setAll(arr, () -> (int)(math.random() * 5) + 1);	// arr = [1, 5, 2, 1, 1]
      ```

   3. ##### 배열의 정렬과 검색 - sort(), binarySearch()

      ```java
      // sort()는 배열의 정렬
      // binarySearch()는 배열에 저장된 요소를 검색할 때 인덱스 반환, 반드시 sort() 후 사용
      
      int[] arr = {3, 2, 0, 1, 4};
      int idx = Arrays.binarySearch(arr, 2);		// idx = -5  잘못된 결과
      
      Arrays.sort(arr);
      System.out.println(Arrays.toString(arr));	// [0, 1, 2, 3, 4]
      int idx = Arrays.binarySearch(arr, 2);		// idx = 2
      ```

   4. ##### 문자열의 비교와 출력 - equals(), toString()

      ```java
      // toString() 배열의 모든 요소를 문자열로 편하게 출력 가능
      
      int[] arr = {0, 1, 2, 3, 4};
      int[][] arr2D = {{11, 12}, {21, 22}};
      
      System.out.println(Arrays.toString(arr));		// [0, 1, 2, 3, 4]
      System.out.println(Arrays.deepToString(arr2D));	// [[11, 12], [21, 22]]
      ```

      ```java
      // equals() 두 배열에 저장된 모든 요소를 비교해서 같으면 true 아니면 false
      // 이 또한 일차원 배열에만 사용 가능하므로, deepEquals() 사용
      
      String[][] str2D = new String[] [] {{"aaa", "bbb"}, {"AAA", "BBB"}};
      String[][] str2D2 = new String[] [] {{"aaa", "bbb"}, {"AAA", "BBB"}}; 
      
      System.out.println(Arrays.equals(str2D, str2D2));		// false
      System.out.println(Arrays.deepEquals(str2D, str2D2));	// true
      ```
