# 어노테이션(Annotation)

- 어노테이션은 **메타데이터**라고 볼 수 있다.

- **메타데이터 ?**

  - 컴파일 과정과 실행 과정에서 **코드를 어떻게 컴파일하고 처리할 것인지를 알려주는 정보**이다.

  ```java
  @AnnotationName	// 이와 같은 형태로 작성된다.
  ```

- **용도 ?**

  - 컴파일러에게 코드 문법 에러를 체크하도록 정보를 제공
  - 소프트웨어 개발 툴이 빌드나 배치 시 코드를 자동으로 생성할 수 있도록 정보를 제공
  - 실행 시(런타임 시) 특정 기능을 실행하도록 정보를 제공

- 어노테이션은 자바가 기본으로 제공해주는 것도 있고, 직접 만들 수도 있다.
  
  - 사용자가 직접 작성하는 어노테이션을 **Custom 어노테이션**이라고 한다.

## 1. 어노테이션 정의와 적용(@interface)

- 다음과 같이 @interface를 사용해서 어노테이션을 정의하고, 그 뒤에 사용할 어노테이션 이름이 온다.

  ```java
  public @interface AnnotationName{
      // 내용
  }
  ```

- 이렇게 정의한 어노테이션은 코드에서 다음과 같이 사용한다.

  ```java
  @AnnotationName
  ```

### 1.1 어노테이션의 엘리먼트

- 어노테이션은 엘리먼트(element)를 멤버로 가질 수 있다.

- 각 **엘리먼트는 타입과 이름으로 구성**되며, 디폴트 값을 가질 수 있다.

- 엘리먼트의 **이름 뒤에는 메서드를 작성하는 것처럼 ()**를 붙여야 한다.

  ```java
  public @interface AnnotationName {
      String elementName1();
      int elementName2() default 5;
  }
  ```

- 위에서 정의한 어노테이션을 코드에서 적용할 때에는 다음과 같이 작성한다.

  ```java
  @AnnotationName(elementName1="값", elementName2=3)
  또는
  @AnnotationName(elementName1="값") // elementName2는 디폴트가 존재하므로 생략 가능
  ```

-----

## 2. 어노테이션의 적용대상(@Target)

- 자신이 만든 **어노테이션이 사용되게 될 자바 요소를 지정**할 수 있다.

- 어노테이션을 적용할 수 있는 대상은 다음과 같다.

  | ElementType 열거 상수 |          적 용 대 상          |
  | :-------------------: | :---------------------------: |
  |         TYPE          | 클래스, 인터페이스, 열거 타입 |
  |    ANNOTATION_TYPE    |          어노테이션           |
  |         FIELD         |             필드              |
  |      CONSTRUCTOR      |            생성자             |
  |        METHOD         |            메서드             |
  |    LOCAL_VARIABLE     |           로컬 변수           |
  |        PACKAGE        |            패키지             |

- 어노테이션이 적용될 대상을 지정할 때에는 **@Target** 어노테이션을 사용한다.

  - @Target의 기본 엘리먼트 **타입들을 배열로** 값을 가진다.

  ```java
  @Target({
      ElementType.TYPE, 	// 클래스, 인터페이스
      ElementType.FIELD,	// 필드
      ElementType.METHOD	// 메서드
  })
  public @interface AnnotationName{
      // 내용
  }
  ```

  - 위와 같이 어노테이션을 적용할 경우 아래 코드처럼 어노테이션을 적용할 수 있다.
  
  ```java
  @AnnotationName
  public class ClassName {
      @AnnotationName
      private String fieldName;
      
      // @AnnotationName (X) --- @Target에 CONSTRUCTOR가 없어 생성자 적용 불가
      public ClassName(){}
      
      @AnnotationName
      public void methodName(){}
}
  ```
  

---

## 3. 어노테이션 유지(@Retention)

- **얼마나 오랫동안 어노테이션 정보가 유지되는지를 설정**할 수 있다.

| RetentionPolicy 열거 상수 |                            설 명                             |
| :-----------------------: | :----------------------------------------------------------: |
|          SOURCE           | 어노테이션 정보가 컴파일시 사라짐, 바이트 코드에는 정보가 남지 않음 |
|           CLASS           | 클래스 파일에 존재하고 컴파일러에 의해 사용가능, 가상머신에서는 사라짐 |
|          RUNTIME          | 실행 시 어노테이션 정보가 가상 머신에 의해서 참조 가능.<br> **자바 리플렉션에 의해 사용** |

- **리플렉션(Reflection)** : 런타임 시에 클래스의 메타 정보를 얻는 기능

  - 예) 클래스가 가지고 있는 필드, 생성자, 메서드, 적용된 어노테이션이 무엇인지 알아내는 것

  ```java
  @Retention(RetentionPolicy.RUNTIME)	// 런타임 시 
  public @interface AnnotationName{
      // 내용
  }
  ```

  