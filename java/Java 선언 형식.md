## Java 클래스/생성자/함수(메소드) 선언 형식

## 클래스 선언 형식

```
[접근지정자][기타제어자] class 클래스명 [extends Super클래스][implements 인터페이스…] {
    ...
    클래스 내용
    ...
}
```

- 클래스는 객체를 표현한다.

- [　] : 생략 가능

- 접근지정자(접근제한자): public, protected, default(기본), private

- { }: 클래스/메소드/생성자의 내용이 들어가는 블록이다. 빈 내용이더라도 블록은 꼭 써야 한다.

- 기타제어자: static, final, abstract, native, transient, synchronized, volatile, strictfp 등

　

### 주의사항

- 클래스명은 반드시 대문자로 시작 ( Pascal Case )
- 변수, 메소드 명 ( camel Case )
- 자바언어는 대소문자 구별

　

## 생성자 선언 형식

```
[접근지정자]class 클래스명(파라미터) {
    ...
    생성자 내용
    ...
}
```

- 선언한 Class가 실제로 생성될 때 실행되는 작업을 기술하는 공간이다.

- [　]: 생략 가능

- 접근지정자(접근제한자): public, protected, default(기본), private

- { }: 클래스/메소드/생성자의 내용이 들어가는 블록이다. 빈 내용이더라도 블록은 꼭 써야 한다.
파라미터: 생성자를 통해 클래스를 생성할 때 사용되는 인자값을 받아오는 변수 선언 부


### 주의사항

- 생성자는 클래스명과 동일해야 한다.
- { } 블록 안의 내용이 빈 공간인 것은 기본생성자이다. 그리고 기본 생성자는 생략 할 수 있다. 자바 컴파일러가 자동으로 생성한다.


　


## 함수 선언 형식
```
[접근제한자] [기타제어자] 리턴자료형 함수명([파라미터]) {
    [return 리턴값;]
}
```

- 반복되어지는 코딩을 함수로 만들면 코드의 중복이 줄어든다.

- 함수를 사용하면 구조적 프로그래밍이 가능하다.

- 함수를 만들기 전에 생각해야할 3가지: 기능, 매개변수(파라미터), 리턴값(리턴자료형)

### 함수를 호출하는 방법

- Call by Name: 파라미터 없이 함수명으로만 호출, 예) swap();
- Call by Value: 파라미터에 값을 주고 호출, 예) swap(30);
- Call by Reference: 파라미터에 참조 변수 값을 주고 호출, 예) swap(참조변수);
- Call by Point: 포인트 주소값으로 호출(C언어에서 사용)

　


### 메인 함수 선언 형식
```
public static void main(String[] args) {
    // 실행 내용
}
```

- 클래스를 만들고 실제로 실행하기 위해서는 메인(main) 함수가 필요하다.

- 운영체제로부터 메모리를 할당 받아 프로그램을 실행하는 시작 지점이다.


　


## Reference :pushpin:

- https://roseee.tistory.com/entry/Java-study
- https://hoonmaro.tistory.com/11?category=598745
- https://codedragon.tistory.com/2569