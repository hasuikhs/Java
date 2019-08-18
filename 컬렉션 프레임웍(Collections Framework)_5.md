## 컬렉션 프레임웍(Collections Framework)_5

1. #### HashMap

   |                생성자 / 메서드                 |                            설 명                             |
   | :--------------------------------------------: | :----------------------------------------------------------: |
   |                   HashMap()                    |                      HashMap 객체 생성                       |
   |          HashMap(int initialCapacity)          |       지정된 값을 초기용량으로 하는 HashMap 객체 생성        |
   |                 HashMap(Map m)                 |        지정된 Map의 모든 요소를 포함하는 HashMap 생성        |
   |                    clear()                     |               HashMap에 저장된 모든 객체 제거                |
   |                    clone()                     |                 현재 HashMap을 복제해서 반환                 |
   |            containsKey(Object key)             |         HashMap에 지정된 key가 포함되어있는지 알려줌         |
   |          containsValue(Object value)           |        HashMap에 지정된 value가 포함되어있는지 알려줌        |
   |                   entrySet()                   | HashMap에 저장된 키와 값을 엔트리의 형태로 Set에 저장 후 반환 |
   |                get(Object key)                 |            지정된 key의 값을 반환, 못찾으면 null             |
   |                   isEmpty()                    |                 HashMap이 비어있는지 알려줌                  |
   |                    keySet()                    |         HashMap에 저장된 모든 키가 저장된 Set을 반환         |
   |         put(Object key, Object value)          |               지정된 키와 값을 HashMap에 저장                |
   |                 putAll(Map m)                  |           Map에 저장된 모든 요소를 HashMap에 저장            |
   |               remove(Object key)               |         HashMap에서 지정된 key로 저장된 value를 제거         |
   |       replace(Object key, Object value)        |              지정된 key의 값을 다른 값으로 교체              |
   | replace(Object key, Object oldValue, newValue) |       지정된 key와 oldValue가 일치하면 newValue로 교체       |
   |                     size()                     |             HashMap에 저장된 요소의 개수를 반환              |
   |                    values()                    |        HashMap에 저장된 모든 값을 컬렉션 형태로 반환         |

   ```java
   class HashMap{
       public static void main(String[] args){
           String[] data = {"A", "K", "A", "K", "D", "K", "A", "K", "K", "K", "Z", "D"};
           
           HashMap map = new HashMap();
           
           for(int i = 0; i < data.length; i++){
               if(map.containsKey(data[i])){
                   Integer value = (Integer)map.get(data[i]);
                   map.put(data[i], new Integer(value.intValue() + 1));
               } else {
                   map.put(data[i], new Integer(1));
               }
           }
           
           Iterator it = map.entrySet().iterator();
           
           while(it.hasNext()){
               Map.Entry entry = (Map.Entry)it.next();
               int value = ((Integer)entry.getValue()).intValue();
               System.out.println(entry.getKey() + " : " 
                                  + printBar('#', value) + " " +value);
           }
       }
       
       public static String printBar(char ch, int value){
           char[] bar = new char[value];
           
           for(int i = 0; i < bar.length; i++){
               bar[i] = ch;
           }
           
           return new String(bar);
       }
   }
   
   ///// 결과 /////
   // A : ### 3
   // D : ## 2
   // Z : # 1
   // K : ###### 6
   ```

2. #### TreeMap

   - HashMap이 TreeMap보다 더 뛰어나므로 HashMap을 사용하는 것이 좋음
   - 단, 범위검색이나 정렬이 필요한 경우에는 TreeSet을 이용하도록 하자
   - 메서드의 구성은 HashMap과 비슷하다