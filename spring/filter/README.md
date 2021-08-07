## 👋 들어가기 전

1. **Filter**
2. **Interceptor**
3. **AOP**

세가지 기능이 모두 비슷한 기능을 하는데, 이들이 필요한 이유는 프로그램을 만들거나 작업을 할 때 공통되는 부분이 굉장히 많다.

예를 들어, *인증 처리라던지, XSS로부터 보안 처리, 로깅 처리, 페이지 인코딩*도 포함될 것이다.

이렇게 프로그램 내에서 자주 사용되는 기능을 소스 여러 군데에 사용되고 있으면 소스 양도 늘어날 것이고, 프로젝트 단위가 커질수록 **서버에 대한 부하**, **유지보수에 어려움**을 겪을 수 있다!

> 쉽게 말해서 공통되는 부분은 빼서 관리하는게 좋다.

위와 같이 공통되는 기능을 처리해주는 기능을 Spring이 제공한다.

위 세가지 기능에 대해 알아보고, 차이점들을 알아보자!

## Filter, Interceptor, AOP의 흐름

![https://media.vlpt.us/images/sa833591/post/e52adfc5-f31b-43b8-beb5-e89fa0d6463a/Filter_Interceptor_AOP%ED%9D%90%EB%A6%842.jpg](https://media.vlpt.us/images/sa833591/post/e52adfc5-f31b-43b8-beb5-e89fa0d6463a/Filter_Interceptor_AOP%ED%9D%90%EB%A6%842.jpg)

1. 서버를 실행시키면 Servlet이 올라오는 동안에 init이 실행되고, 그 후 doFilter가 실행된다.
2. 컨트롤러에 들어가기 전 preHandler가 실행된다.
3. 컨트롤러에서 나와 @Around, postHandler, doFilter 순으로 진행된다.
4. 서블릿 종료시 destroy가 실행된다.

> 순서는 Filter -> Interceptor -> AOP -> Interceptor -> Filter 순으로 이루어진다.Filter와 Interceptor은 Servlet 단위에서 이루어진다.

## Spring Filter

`Dispatcher Servlet` 영역에 들어가기 전 Front Controller 앞 범위에서 수행된다.

또한, Controller 이후 자원 처리가 끝난 후 응답 처리에 대해서도 변경, 조작을 수행할 수 있다.

일반적으로 인코딩 변환 처리, XSS 방어를 개발할 때 사용한다.

> 👉 Filter 실행메소드init() - 필터 인스턴스 초기화doFilter() - 실제 처리 로직destroy() - 필터 인스턴스 종료

## Spring Interceptor

Filter는 스프링 컨텍스트 이전에 실행되어 스프링과 무관하다.

하지만 인터셉터의 경우에는 스프링의 `DispatcherServlet`이 Controller를 호출하기 전,후에 끼어들기 때문에 스프링 컨텍스트(Context,영역) 내부에서 Controller에 관한 `요청`과 `응답`에 관여한다.

그리고 스프링의 모든 @Bean에 접근이 가능하다.

`preHandler`에서 전처리가 이루어지고, `postHandler`에서 후처리를 한다.

> 👉 Interceptor 실행메소드preHandler() - Controller 실행 전postHandler() - Controller 실행 후 view Rendering 실행 전afterCompletion() - view Rendering 이후

## Spring AOP

Controller 처리 이후 주로 비지니스 로직에서 실행된다.

주로 '로깅', '트랜잭션', '에러 처리' 등 비지니스 단의 메서드에서 구체적인 조정이 필요할 때 사용합니다.

Filter와 Interceptor와 달리 메소드 전후 지점에서 자유롭게 설정이 가능하다.AOP는 주소, 파라메터, 어노테이션 등 다양한 방법으로 대상을 지정할 수 있다.

**@Advice와 HandlerInterceptor의 가장 큰 차이는 파라메터의 차이다.**

`@Advice`의 경우에는 JoinPoint와 ProceedingJoinPoint 등을 활용하여 호출 가능하다.반면 `HandelrInterceptor`의 경우는 HttpServletRequest, HttpServletResponse를 파라메터로 사용한다.