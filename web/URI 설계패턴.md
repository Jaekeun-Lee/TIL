# URI 설계 패턴

#### URI(Uniform Resource Identifier)

- 인터넷에서 특정 자원을 나타내는 주소 값. 해당 값은 유일하다.

#### URL(Uniform Resource Locator)

- 인터넷 상에서의 자원, 특정 파일의 위치를 나타내는 정보

### URI 설계 시 주의할 점

**1. 슬래시 구분자(/)는 계층 관계를 나타내는 데 사용**
```
http://restapi.example.com/houses/apartments
http://restapi.example.com/animals/mammals/whales
```

**2. URI 마지막 문자로 슬래시(/)를 포함하지 않는다.**

URI에 포함되는 모든 글자는 리소스의 유일한 식별자로 사용되어야 하며 URI가 다르다는 것은 리소스가 다르다는 것이고, 역으로 리소스가 다르면 URI도 달라져야 합니다. REST API는 분명한 URI를 만들어 통신을 해야 하기 때문에 혼동을 주지 않도록 URI 경로의 마지막에는 슬래시(/)를 사용하지 않습니다.
```
http://restapi.example.com/houses/apartments  (0)
http://restapi.example.com/houses/apartments/ (X)
```   

**3. 하이픈(-)은 URI 가독성을 높이는데 사용**

URI를 쉽게 읽고 해석하기 위해, 불가피하게 긴 URI경로를 사용하게 된다면 하이픈을 사용해 가독성을 높일 수 있습니다.

**4. 밑줄(_)은 URI에 사용하지 않는다.**

글꼴에 따라 다르긴 하지만 밑줄은 보기 어렵거나 밑줄 때문에 문자가 가려지기도 합니다. 이런 문제를 피하기 위해 밑줄 대신 하이픈(-)을 사용하는 것이 좋습니다.(가독성)

**5. URI 경로에는 소문자가 적합하다.**

URI 경로에 대문자 사용은 피하도록 해야 합니다. 대소문자에 따라 다른 리소스로 인식하게 되기 때문입니다. RFC 3986(URI 문법 형식)은 URI 스키마와 호스트를 제외하고는 대소문자를 구별하도록 규정하기 때문.

**6. 파일 확장자는 URI에 포함시키지 않는다.**
```
http://restapi.example.com/members/soccer/345/photo.jpg (X)
```

**7. 프로그래밍 언어에 의존적인 확장자를 사용하지 않는다.**
```
http://restapi.example.com/classes/java/web-master.do (X)
```

**8. 구현에 의존적인 경로를 사용하지 않는다.**
```
http://restapi.example.com/servlet/classes/java (X)
```

**9. 세션 ID를 포함하지 않는다.**
```
http://restapi.example.com/servlet/classes/java?session-id=aaaa (X)
```

**10. 프로그래밍 언어의 Method명을 이용하지 않는다.**
```
http://restapi.example.com/servlet/classes/java?action=intro (X)
```

**11. 명사에 단수형 보다는 복수형을 사용해야 한다. 컬렉션에 대한 표현은 복수로 사용.**
```
http://restapi.example.com/classes/java/curriculums/web-master 
```

**12. 컨트롤러 이름으로는 동사나 동사구를 사용한다.**
```
http://restapi.example.com/classes/java/curriculums/web-master/re-order 
```

**13. 경로 부분 중 변하는 부분은 유일한 값으로 대체한다.**
```
http://restapi.example.com/classes/java/curriculums/{class-id}/user/{user-id}
```

**14. CRUD 기능을 나타내는 것은 URI에 사용하지 않는다.**
```
http://restapi.example.com/classes/java/curriculums/web-master/READ (X)
Get 메소드를 통한 호출 = http://restapi.example.com/classes/java/curriculums/web-master (O)
```

**15. URI Query Parameter 디자인.**
URI 쿼리 부분으로 컬렉션 결과에 대해서 필터링 할 수 있다.
```
http://restapi.example.com/classes/java/curriculums/web-master?chapter=2
```

**16. URI 쿼리는 컬렉션의 결과를 페이지로 구분하여 나타내는데 사용한다.**
```
http://restapi.example.com/classes/java/curriculums/web-master?chapter=2&page=1&size=10 
```

**17. API에 있어서 서브도메인은 일관성있게 사용해야 한다.**
```
http://restapi.example.com
http://api.restapi.example.com
http://api-restapi.example.com
```

**18. 클라이언트 개발자 포탈 서브 도메인은 일관성 있게 만든다.**
```
http://dev-restapi.example.com 
http://developer-restapi.example.com 
```