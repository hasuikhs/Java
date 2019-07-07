## 컬렉션 프레임웍_2

1. #### ArrayList

   - 데이터의 저장순서가 유지되고 중복을 허용

   ```java
   ArrayList list1 = new ArrayList(10);	// list1 생성
   // list1 에 인자 추가
   list1.add(new Integer(5));
   list1.add(new Integer(4));
   list1.add(new Integer(2));
   list1.add(new Integer(0));
   list1.add(new Integer(1));
   
   ArrayList list2 = new ArrayList(list1.subList(1, 4));
   // list2 생성 subList로 list1의 1 ~ 3 까지의 인자 반환
   
   Collections.sort(list1); // list1과 list2 정렬 오름차순
   Collections.sort(list2);
   ```

2. #### LinkedList

   - LinkedList는 데이터가 불연속적으로 존재
   - 순차적으로 추가/삭제하는 경우 ArrayList가 더  빠름
   - 중간에 데이터를 추가/삭제하는 경우 LinkedList가 더 빠름

3. #### Stack과 Queue

   - Stack : Last In First Out

   - Stack의 활용 : 수식계산, 수식괄호검사, 웹브라우저의 뒤로/앞으로

     |      메서드       |                          설 명                          |
     | :---------------: | :-----------------------------------------------------: |
     |      empty()      |                 Stack이 비어있는지 확인                 |
     |      peek()       |  Stack의 마지막에 저장된 객체를 확인, 없으면 Exception  |
     |       pop()       | Stack에 마지막으로 저장된 객체를 꺼냄, 없으면 Exception |
     | push(Object item) |                Stack에 객체를 밀어 넣음                 |
     | search(Object o)  |   Stack에서 주어진 객체(o)를 찾아서 위치(index) 반환    |

   - Queue : First In First Out

   - Queue의 활용 : 최근사용문서, 인쇄작업 대기목록, 버퍼(buffer)

     |     메서드      |                            설 명                             |
     | :-------------: | :----------------------------------------------------------: |
     |  add(Object o)  | 지정된 객체를 Queue에 추가, 성공(true), 저장공간 부족시 Exception |
     |    remove()     |         Queue에서 객체를 꺼내 반환, 없으면 Exception         |
     |    element()    |                    삭제없이 요소를 읽어옴                    |
     | offer(Object o) |        Queue에 객체 저장, 성공시(true), 실패시(false)        |
     |     poll()      |          Queue에서 객체를 꺼내 반환, 비었을 시 null          |
     |     peek()      |                     삭제없이 요소 읽어옴                     |

   - ##### Deque(Double-Ended Queue)

     - Queue의 변형으로, 양쪽 끝에 추가/삭제가 가능

       |    Deque    |  Queue  | Stack  |
       | :---------: | :-----: | :----: |
       | offerLast() | offer() | push() |
       | pollLast()  |    -    | pop()  |
       | pollFirst() | poll()  |   -    |
       | peekFirst() | peek()  |   -    |
       | peekLast()  |    -    | peek() |

       

4. #### 