## 컬렉션 프레임웍(Collections Framework)

- 데이터 군을 저장하는 클래스들을 표준화한 설계

- | 인터페이스 |                            특 징                             |
  | :--------: | :----------------------------------------------------------: |
  |    List    | 순서가 있는 데이터의 집합, 데이터 중복 허용(ArrayList, LinkedList, Stack, Vector) |
  |    Set     | 순서가 없는 데이터의 집합, 데이터 중복 허용 X(HashSet, TreeSet) |
  |    Map     | key와 value의 쌍으로 이루어진 데이터의 집합,  순서는 유지되지 않으며, 키는 중복을 허용하지 않고, 값은 중복을 허용 |

#### List인터페이스

|                  메서드                   |                            설 명                             |
| :---------------------------------------: | :----------------------------------------------------------: |
|    void add(int index, Object element)    | 지정된 위치(index)에 객체(element)나 컬렉션에 포함된 객체 추가 |
|              get(int index)               |             지정된 위치(index)에 있는 객체 반환              |
|             indexOf(Object o)             |        지정된 객체의 위치(index) 반환 앞에서부터 검색        |
|           lastIndexOf(Object o)           |        지정된 객체의 위치(index) 반환 뒤에서부터 검색        |
| listIterator() or listIterator(int index) |          List 각체에 접근 가능한 ListIterator 반환           |
|             remove(int index)             |        지정된 위치(index)에 있는 객체를 삭제 후 반환         |
|      set(int index, Object element)       |                  지정된 위치에 객체를 저장                   |
|            sort(Comparator c)             |                  지정된 비교자로 List 정렬                   |
|    subList(int fromIndex, int toIndex)    |            지정된 범위(from~to)에 있는 객체 반환             |

#### Map인터페이스

|            메서드             |                       설 명                       |
| :---------------------------: | :-----------------------------------------------: |
|            clear()            |               Map의 모든 객체 삭제                |
|    containsKey(Object key)    |   지정된 key와 일치하는 Map의 key가 있는지 확인   |
|  containsVale(Object value)   | 지정된 value와 일치하는 Map의 value가 있는지 확인 |
|          entrySet()           |  Map에 저장되어 있는 key-value쌍을 Set으로 반환   |
|       equals(Object o)        |                동일한 Map인지 비교                |
|        get(Object key)        |    지정한 key객체에 대응하는 value를 찾아 반환    |
|          hashCode()           |                  해시코드를 반환                  |
|           isEmpty()           |               Map이 비어있는지 확인               |
|           keySet()            |            Map에  저장된 모든 key 반환            |
| put(Object key, Object value) |            Map에 key와 value 쌍을 저장            |
|         putAll(Map t)         |       지정된 Map의 모든 key-value 쌍을 추가       |
|      remove(Object key)       |    지정한 key객체와 일치하는 key-value 를 삭제    |
|            size()             |       Map에 저장된 key-value 쌍의 개수 반환       |
|           values()            |        Map에 저장된 모든 value객체를 반환         |

