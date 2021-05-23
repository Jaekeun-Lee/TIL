# Rest란?

**Rest** ( Representational State Transfer : 자원의 상태 전달 ) - 네트워크 아키텍처

```
INDEX

1. REST 구성
2. REST 특징
3. REST API 디자인 가이드
4. HTTP 응답 상태 코드
```

## 1. REST 구성
* **자원(RESOURCE)** - URI
* **행위(Verb)** - HTTP METHOD
* **표현(Representations)**

　

## 2. REST 특징

* **Uniform (유니폼 인터페이스)**  
  Uniform Interface는 URI로 지정한 리소스에 대한 조작을 통일되고 한정적인 인터페이스로 수행하는 아키텍처 스타일을 말합니다.
  

* **Client - Server 구조**  
  REST 서버는 API 제공, 클라이언트는 사용자 인증이나 컨텍스트(세션, 로그인 정보)등을 직접 관리하는 구조로 각각의 역할이 확실히 구분되기 때문에 클라이언트와 서버에서 개발해야 할 내용이 명확해지고 서로간 의존성이 줄어들게 됩니다.


* **Stateless (무상태성)**   
  요청에 대해 클라이언트의 상태를 서버에 저장하지 않는다. 다시 말해 작업을 위한 상태정보를 따로 저장하고 관리하지 않는다.
  세션 정보나 쿠키 정보를 별도로 저장하고 관리하지 않기 때문에 API서버는 들어오는 요청만을 단순히 처리하면 된다. 때문에 서비스의 자유도가 높아지고 서버에서 불필요한 정보를 관리하지 않음으로써 구현이 단순해진다.
  

* **Cacheable (캐시 가능)**  
  * REST의 가장 큰 특징 중 하나는 HTTP라는 기존 웹표준을 그대로 사용하기 때문에, 웹에서 사용하는 기존 인프라를 그대로 활용이 가능합니다. 따라서 HTTP가 가진 캐싱 기능이 적용 가능합니다. HTTP 프로토콜 표준에서 사용하는 Last-Modified태그나 E-Tag를 이용하면 캐싱 구현이 가능합니다.
  * 클라이언트는 서버의 응답을 Cache(임시저장) 할 수 있어야 한다. 클라이언트가 Cache를 통해 응답을 재사용 할 수 있어야 하며, 이를 통해 서버의 부하를 낮춘다.
  
   
* **Layered Architecture (계층형 구조)**  
  REST 서버는 다중 계층으로 구성될 수 있으며 서버와 클라이언트 사이에, 방화벽, 게이트웨이, Proxy 등 다양한 계층 형태로 구성이 가능해야 하며, 이를 확장할 수 있어야 한다.


* **Self-descriptiveness (자체 표현 구조)**  
  REST의 또 다른 큰 특징 중 하나는 REST API 메시지만 보고도 이를 쉽게 이해 할 수 있는 자체 표현 구조로 되어 있다는 것입니다.
  

* Code on Demand ( Optional ) : 자바스크립트 등 특정한 기능을 서버로 부터 클라이언트가 전달 받아 코드를 실행 할 수 있어야 한다.


　
## 3. REST API 디자인 가이드

REST API 설계 시 가장 중요한 항목은 다음의 2가지로 요약할 수 있습니다.

<b style="background-color: red; color: white">첫 번째, URI는 정보의 자원을 표현해야 한다.</b> <br>
<b style="background-color: red; color: white"> 두 번째, 자원에 대한 행위는 HTTP Method(GET, POST, PUT, DELETE)로 표현한다.</b>

　

### REST API 

1. 자원의 식별  
    * 웹 기반의 Rest에서는 리소스 접근을 할 때 URI를 사용한다.
    
    * ex) https://foo.co.kr/user/100
    
        * Resource = user
        * identifier = 100


2. 메세지를 통한 리소스 조작
    * Web에서는 다양한 방식으로 데이터를 전달할 수 있다.
    * 그 중에서 가장 많이 사용하는 방식은 HTML, XML, JSON, TEXT 등 이 있다.
    * 이 중에서 어떠한 타입의 데이터인지를 알려주기 위해 HTTP Header 부분에 content-type 을 통해서 데이터의 타입을 지정해 줄 수 있다.
    * 또한 리소스 조작을 위해 데이터 전체를 전달하지 않고, 이를 메시지로 전달한다.
    * ex) 서버의 user라는 정보의 전화번호를 처음에 number라고 설정해놓았다. 이후 서버에서 number -> phone-number로 resource를 변경하게 된다면 Client는 처리하지 못하고 에러가 나게 된다.
        * 이러한 부분을 방지하기 위해, 별도의 메시지 형태로 데이터를 주고 받으며, Client - Server가 독립적으로 확장 가능하도록 해야한다.


3. 자기 서술적 메시지
    * 요청하는 데이터가 어떻게 처리되어져야 하는지 충분한 데이터를 포함할 수 있어야 한다.
    * HTTP 기반의 REST에서는 HTTP Method와 Header 정보, 그리고 URI에 포함되는 정보로 표현 할 수 있다.
   ```properties
   GET:     https://foo.co.kr/user/100, 사용자의 정보 요청
   POST:    https://foo.co.kr/user/100, 사용자의 정보 생성 
   PUT:     https://foo.co.kr/user/100, 사용자의 정보 생성 및 수정 
   DELETE:  https://foo.co.kr/user/100, 사용자의 정보 삭제 
   ```
    * 그외에 담지 못한 정보들은 URI의 메시지를 통해 표현한다.
   


4. 애플리케이션 상태에 대한 엔진으로써 하이퍼미디어
   * REST API를 개발할 때 단순히 Client 요청에 대한 데이터 응답만 해주는 것이 아닌 관련된 리소스에 대한 Link 정보까지 같이 포함되어져야 한다.
   * 이러한 조건들을 잘 갖춘 경우 REST Ful 하다고 표현하고, 이를 REST API라고 부른다.
    

　


