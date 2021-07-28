# Adapter Pattern

```
**Structural Pattern**   
프로그램 구조에 관련된 패턴들
프로그램 내의 자료구조나 인터페이스 구조 등 프로그램의 구조를 설계하는데 활용할 수 있는 패턴들
```

## 어댑터 패턴이란?

한 클래스의 인터페이스를 클라이언트에서 사용하고자하는 다른 인터페이스로 변환한다.  
어댑터를 이용하면 인터페이스 호환성 문제 때문에 같이 쓸 수 없는 클래스들을 연결해서 쓸 수 있다.  



![image](https://t1.daumcdn.net/cfile/tistory/24231F4C575EACA210)



## 어댑터 패턴 호출 과정


![image](https://s3.ap-northeast-2.amazonaws.com/yaboong-blog-static-resources/diagram/adapter-pattern-2.png)


클라이언트에서는 Target Interface 를 호출하는 것 처럼 보인다. 하지만 클라이언트의 요청을 전달받은 (Target Interface 를 구현한) Adapter 는 자신이 감싸고 있는 Adaptee 에게 실질적인 처리를 위임한다. Adapter 가 Adaptee 를 감싸고 있는 것 때문에 Wrapper 패턴이라고도 불린다.



　  



**애초에 두개의 인터페이스가 달라서 호환이 안된다면, 하나를 바꿔서 되게 하던지, 아니면 둘다 바꾸면 되지 않나?**

> 예제에서는 이해를 돕기위해 AirConditioner, Cleaner, HairDryer들의 인터페이스를 만들지도 않았고 클래스 내부도 훤히 들여다 볼 수 있다. 하지만, 이 클래스들이 오픈소스가 아니라 미리 컴파일된 클래스 바이너리 파일만을 제공받은 써드파티 라이브러리라면 직접적인 접근이 불가능 할 수 있다. 직접적으로 접근할 수 있는 경우라 하더라도 Adaptee 쪽에서 우리가 변경한 코드로 인해 라이브러리나 벤더쪽 시스템 전체가 깨질 수도 있다.


　


**그러면 우리쪽 인터페이스를 수정하면 되지 않나?**

>가능할 수 있다. 하지만 바꾸려는 우리쪽 인터페이스를 우리 시스템의 다른 어딘가에서 사용하고 있다면? 그 부분도 수정해줘야 한다. 우리쪽 인터페이스를 수정하고, 이에 영향을 받는 부분들을 수정하다가 예기치 못한 오류가 발생할 가능성이 매우 크다.



　


## Reference :pushpin:

* [https://jusungpark.tistory.com/22](https://jusungpark.tistory.com/22)

* [https://yaboong.github.io/design-pattern/2018/10/15/adapter-pattern/](https://yaboong.github.io/design-pattern/2018/10/15/adapter-pattern/)
