# JSTL(Jsp Standard Tag Libray)

- JSP 페이지를 작성할 때 유용하게 사용할 수 있는 여러 가지 커스텀 액션과 함수가 포함되어 있는 라이브러리
- **JSTL을 사용할 때는 JavaScript의 리터럴 문자열을 사용할 수 없음**

## 1. 선언

```html
<%@ taglib uri="http://java.sun.com/sjp/jstl/core" prefix="c" %>
```

- c라는 prefix로 시작하는 태그는 위의 URI에서 가져오는 테그라고 알려주어야 함

## 2. 사용

### 2.1 set

```html
<c:set var="변수이름" value="값"/>
```

- 이렇게 선언하면 JSP에서 ${변수이름}으로 사용 가능하다.

### 2.2 remove

```html
<c:remove var="변수이름"/>
```

- 변수를 제거할 때 사용

### 2.3 out

```html
<c:set var="aaa" value="<font color=red>안녕</font>"></c:set>

<c:out value="${aaa}" escapeXml="true"></c:out>
```

- 태그가 포함된 변수를 true/false 지정해서 태그를 포함해서 출력을 결정

### 2.4 if

```html
<c:if test="${empty aaa ? true : false}" var="result">
	aaa 존재
</c:if>
```

- test 안의 내용이 true인지 false인지 출력을 결정

### 2.5 choose

```html
<c:choose>
	<c:when test="{1 > 0}">
    	1은 0보다 크지
    </c:when>
    <c:when test="{2 > 0}">
    	2도 0보다 크지
    </c:when>
    <c:when>
    	생각하고 싶지 않아
    </c:when>
</c:choose>
```

### 2.6 forEach

```html
<c:forEach var="임시변수" begin="1" end="10">
	${임시변수}
</c:forEach>
```

```html
<c:forEah var="임시변수" begin="1" end="10" step="2">
	${임시변수}
</c:forEah>
```

- 콜렉션을 출력하는 예

```html
<c:forEach var="임시변수" items="${콜렉션이름}">
	${임시변수}
</c:forEach>
```

