#Singleton Pattern

```
**Creational Pattern**   
객체를 생성하는데 관련된 패턴들
객체가 생성되는 과정의 유연성을 높이고 코드의 유지를 쉽게 함
```

##싱글톤 패턴이란?

전역 변수를 사용하지 않고 **객체를 하나만 생성**하도록 하며, 생성된 객체를 어디에서든지 참조할 수 있도록 하는 패턴  
![image](https://www.google.com/url?sa=i&url=https%3A%2F%2Fko.wikipedia.org%2Fwiki%2F%25EC%258B%25B1%25EA%25B8%2580%25ED%2584%25B4_%25ED%258C%25A8%25ED%2584%25B4&psig=AOvVaw2qro6ssX5rfIzzmHCA7ipo&ust=1627553685653000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCIDI4ozEhfICFQAAAAAdAAAAABAD)


싱글턴 패턴은 인스턴스가 오직 1개만 생성되야 하는 경우에 사용되는 패턴.  
예를들어 레지스트리 같은 설정 파일의 경우 객체가 여러개 생성되면 설정 값이 변경될 위험이 생길 수 있다.  
인스턴스가 1개만 생성되는 특징을 가진 싱글턴 패턴을 이용하면, 하나의 인스턴스를 메모리에 등록해서 
여러 스레드가 동시에 해당 인스턴스를 공유하여 사용하게끔 할 수 있으므로, 요청이 많은 곳에서 사용하면 효율을 높일 수 있다.
주의 해야할 점은 싱글턴을 만들때 `동시성(Concurrency)` 문제를 고려해서 싱글턴을 설계해야 한다.



##자바의 싱글턴 패턴(Sigleton Pattern in Java)
싱글턴 패턴의 공통적인 특징은 private constructor 를 가진다는 것과, static method 를 사용한다는 점이다.


### 1. Eager Initialization(이른 초기화, Thread-safe)
```
public class SocketClient {

    private static SocketClient socketClient = null;

    private SocketClient () {

    }

    public static SocketClient getInstance() {
        if (socketClient == null) {
            socketClient = new SocketClient();
        }

        return socketClient;
    }
}
```
Eager Initialization(이른 초기화, Thread-safe) 방식은 static 키워드의 특징을 이용하여
클래스로더가 초기화하는 시점에 `정적 바인딩(static binding)`을 통해 해당 인스턴스를 메모리에 등록해서 사용하는 것.

이 방식은 클래스 로더에 의해 클래스가 최초로 로딩될 때 객체가 생성되기 때문에 Thread-safe하다.

싱글톤 구현 시 중요한 점이, 멀티 스레딩 환경에서도 동작 가능하게끔 구현해야 한다는 것, 즉 `Thread-safe`가 보장되어야 한다.


### 2. Lazy Initialization. LazyHolder(게으른 홀더, Thread-safe)

```
public class Singleton {

    private Singleton() {}

    /**
     * static member class
     * 내부클래스에서 static변수를 선언해야하는 경우 static 내부 클래스를 선언해야만 한다.
     * static 멤버, 특히 static 메서드에서 사용될 목적으로 선언
     */
    private static class InnerInstanceClazz() {
        // 클래스 로딩 시점에서 생성
        private static final Singleton uniqueInstance = new Singleton();
    }

    public static Singleton getInstance() {
        return InnerInstanceClazz.instance;
    }
    
}
```

Lazy Initialization. LazyHolder(게으른 홀더, Thread-safe) 방식은 가장 많이 사용되는 싱글턴 구현 방식이다.  
싱글턴 클래스에는 InnerInstanceClazz 클래스의 변수가 없기 때문에 static 멤버 클래스더라도 클래스 로더가 초기화 과정을 진행할때 InnerInstanceClazz 메서드를 초기화 하지 않고,   
getInstance() 메서드를 호출할때 초기화 된다. 즉, `동적바인딩(Dynamic Binding)` (런타임시에 성격이 결정) 의 특징을 이용하여 Thread-safe 하면서 성능이 뛰어나다.  
InnerInstanceClazz 내부 인스턴스는 static이기 때문에 클래스 로딩 시점에 한번만 호출된다는 점을 이용한것이며, final을 써서 다시 값이 할당되지 않도록 한다.



## 스프링의 싱글턴 패턴(Singleton Pattern in Spring)

스프링은 빈을 등록할 때 범위(scope)를 지정할 수 있는데 디폴트가 싱글턴(Singleton)이다.  
```
그 외에도 prototype, request, session 이 있습니다.
prototype : 컨테이너에 빈을 요청할 때마다 매번 새로운 객체를 만든다.
request : HTTP 요청 하나당 하나의 객체를 만든다.
```
스프링에서 싱글턴을 저장하고 관리해주는 것이 `applicationContext`이다.  
`applicationContext`의 명칭은 Singleton Registry, IOC 컨테이너, 스프링 컨테이너, 빈 팩토리 등으로 불린다.
스프링의 핵심 컨테이너의 빈 관리를 담당하는 **BeanFactory**의 핵심 구현 클래스는 `DefaultListableBeanFactory`이다.   
대부분의 애플리케이션 컨텍스트는 바로 이 클래스를 **BeanFactory**로 사용하는데, 핵심 구현 클래스인 `DefaultListableBeanFactory` 가 구현하고 있는 인터페이스의 한가지가 바로 `SingletonRegistry`이다.


### 스프링은 왜 Bean 을 Singleton 으로 생성할까?

스프링에서 하나의 요청을 처리하기 위해서는 Presentation Layer, Business Layer, Data Access Layer 등 다양한 기능을 담당하는 객체들이 계층형을 이루고 있는데, 
클라이언트 요청 마다 각 로직을 담당하는 객체를 만들어 사용한다면, GC 가 있더라도 메모리 부하가 올 수 있습니다.
이 때문에 엔터프라이즈 분야에서는 `서비스 오브젝트(Service Object)` 라는 개념을 사용해 왔는데 서블릿은 Java 엔터프라이즈 기술의 가장 기본이 되는 서비스 오브젝트라고 할수 있습니다.
서블릿은 대부분의 멀티 스레딩 환경에서 싱글턴을 동작하며, 서블릿 클래스 하나당 하나의 객체를 생성하여, 클라이언트 요청 처리를 담당하는 스레드 들이 해당 객체를 공유해서 사용합니다.

### 스프링은 어떻게 빈을 싱글턴으로 생성할까?
스프링은 어노테이션 설정만으로 **IoC 컨테이너(applicationContext)** 에 제어권을 넘겨줌으로써 손쉽게 빈(Bean) 을 싱글턴으로 생성하여 사용할 수 있습니다.
Component-scan 대상이 되는 어노테이션들 @Repository, @Service, @Controller, @Component 등 을 사용하면됩니다.


### 싱글턴 설계시 주의사항

싱글턴의 중요한 특징 중 하나가 멀티 스레딩 환경에서도 동작 가능하게 구현해야 한다고 했습니다. 즉, Thread-safe 를 보장해야 한다고 했습니다.
따라서 Thread-safe 를 보장하려면, `무상태성(stateless)` 을 지켜야 합니다. 즉, 상태 정보를 클래스 내부에 가지고 있으면 안됩니다.

```
@RequiredArgsConstructor
public class EventService {
  private final ApplyRepository; // (1)
  private List<Stirng> applicants; // (2)
  private ApplyVo apply; // (2)

  public void createEvent() {
    // 생략
  } 
}
```

* (1) 번 같은 경우는 자신의 클래스 내부에서 다른 싱글턴 빈(Singleton Bean) 을 저장하려는 용도이면 사용 가능합니다.
* (2) 번과 같은 전역 변수는 메모리의 메서드 영역(Static Area) 에 저장됩니다. 메서드 영역은 스레드가 공유 가능한 영역 이므로, 여러개의 스레드가 접근하는 경우 값이 변경될 위험이 있기 때문에 Thread-safe 하지 않습니다.  

따라서 (2) 번같은 경우는 지역변수나, 메서드의 매개변수로 이용하여 스레드가 공유 불가능한 스택 영역(Stack Area) 에 저장되도록하여 Thread-safe 를 보장하게끔 만들어 줘야 합니다.



## Reference :pushpin:

* [https://medium.com/@joongwon/multi-thread](https://medium.com/@joongwon/multi-thread-%ED%99%98%EA%B2%BD%EC%97%90%EC%84%9C%EC%9D%98-%EC%98%AC%EB%B0%94%EB%A5%B8-singleton-578d9511fd42)

* [https://itmore.tistory.com/entry/스프링-ApplicationContext-동작방식](https://itmore.tistory.com/entry/%EC%8A%A4%ED%94%84%EB%A7%81-ApplicationContext-%EB%8F%99%EC%9E%91%EB%B0%A9%EC%8B%9D)

* [Head First Design Pattern](https://webdevtechblog.com/%EC%8B%B1%EA%B8%80%ED%84%B4-%ED%8C%A8%ED%84%B4-singleton-pattern-db75ed29c36#)

* [https://joont.tistory.com/144](https://joont.tistory.com/144)