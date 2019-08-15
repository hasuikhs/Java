## 컬렉션 프레임웍(Collection Framework)_4

1. #### HashSet

   - Set인터페이스를 구현한 가장 대표적인 컬렉션
   - 저장순서를 유지하지 않으므로 저장순서를 유지하고자 한다면 LinkedHashSet을 사용

   |    생성자 또는 메서드     |                          설 명                          |
   | :-----------------------: | :-----------------------------------------------------: |
   |         HashSet()         |                   HashSet 객체를 생성                   |
   |   HashSet(Collection c)   |       주어진 컬렉션을 포함하는 HashSet 객체 생성        |
   |   HashSet(int Capacity)   |       주어진 값을 초기용량으로 하는 HashSet 생성        |
   |       add(Object o)       |                   새로운 객체를 저장                    |
   |   addAll(Collection c)    |        주어진 컬렉션에 저장된 모든 객체들을 추가        |
   |          clear()          |                 저장된 모든 객체를 삭제                 |
   |          clone()          |                 HashSet을 복제해서 반환                 |
   |    contains(Object o)     |          지정된 객체를 포함하고 있는지 알려줌           |
   | containsAll(Collection c) | 주어진 컬렉션에 저장된 모든 객체를 포함하는지를 알려줌  |
   |         isEmpty()         |               HashSet이 비어있는지 알려줌               |
   |        iterator()         |                     iterator를 반환                     |
   |     remove(Object o)      |       지정된 객체를 HashSet에서 삭제(성공시 true)       |
   |  removeAll(Collection c)  | 주어진 컬렉션에 저장도니 모든 개체와 동일한 것들을 삭제 |
   |  retainAll(Collection c)  |  주어진 컬렉션에 저장된 객체와 동일한 것만 남기고 삭제  |
   |          size()           |                 저장된 객체의 수를 반환                 |
   |         toArray()         |         저장된 객체들을 객체 배열의 형태로 반환         |
   |    toArray(Object[] a)    |       저장된 객체들을 주어진 객체배열(a)에 담는다       |

   - add()

     ```java
     Object[] objArr = {"1", new Integer(1), "2", "2", "3", "3", "4", "4", "4"};
     Set set = new HashSet();
     
     for(int i = 0; i < objArr.length; i++){
         set.add(Object[i]);
     }
     
     System.out.println(set); // 결과 [1, 1, 2, 3, 4]
     // 첫 1은 String, 두번째 1은 int형, 나머지는 중복 제외 저장
     ```

2. #### TreeSet

   - 이진 검색 트리라는 자료구조의 형태로 데이터를 저장하는 컬렉션

   |              생성자 또는 메서드              |                            설 명                             |
   | :------------------------------------------: | :----------------------------------------------------------: |
   |               descendingSet()                |       TreeSet에 저장된 요소들을 역순으로 정렬해서 반환       |
   |                   first()                    |              정렬된 순서에서 첫번째 객체를 반환              |
   |          headSet(Object toElement)           |           지정된 객체보다 작은 값의 객체들을 반환            |
   |        headSet(toElement, inclusive)         | 지정된 객체보다 작은 값의 객체들을 포함, inclusive가 true이면 같은 값의 객체도 반환 |
   |               higher(Object o)               | 지정된 객체보다 큰 값을 가진 객체 중 제일 가까운 값의 객체를 반환 |
   |                    last()                    |              정렬된 순서에서 마지막 객체를 반환              |
   |                   lower()                    | 지정된 객체보다 작은 값을 가진 객체 중 제일 가까운 값의 객체를 반환 |
   |                 pollFirst()                  |                 TreeSet의 첫번째 요소를 반환                 |
   |                  pollLast()                  |                 TreeSet의 마지막 요소를 반환                 |
   | subSet(Object fromElement, Object toElement) |    from과 to 사이의 결과를 반환(끝 요소는 포함되지 않음)     |
   |         tailSet(Object fromElement)          |            지정된 객체보다 큰 값의 객체들을 반환             |

   - headSet, tailSet

     ```java
     public static void main(String[] args){
         TreeSet set = new TreeSet();
         int[] score = {80, 95, 50, 35, 45, 65, 10, 100};
         
         for(int i = 0; i < score.length; i++){
             set.add(new Integer(score[i]));
         }
         
         System.out.println("50보다 작은 값 : " + set.headSet(new Integer(50)));
         System.out.println("50보다 큰 값 : " + set.tailSet(new Integer(50)));
     }
     ```

     
