### 열거 타입(Enumeration Type)

- 한정된 값만을 갖는 데이터 타입이다.

### 열거 타입 선언

- 열거 타입의 이름을 정하고 열거 타입 이름으로 소스 파일(.java)을 생성해야 한다.
- 열거 타입 이름은 관례적으로 첫 문자를 대문자로하고 나머지는 소문자로 구성한다.
- 만약 여러 단어로 구성된 이름일 경우 각 단어의 첫 문자는 대문자로 작성하는 것이 관례이다.
- 예) **Week.java, MemberLevel.java**
- 형식

```
publicenum 열거타입이름 {
	(열거 상수 선언)
}

```

- 열거 상수는 열거 타임의 값으로 사용되며 관례적으로 모두 대문자로 작성한다.
- 만약 열거 상수가 여러 단어로 구성될 경우 단어 사이를 밑줄(_)로 연결한다.
- 예

```
publicenumMonth {
JANUARY,
FEBRUARY,
MARCH,
APRIL,
MAY,
JUNE,
JULY,
	.
	.
}

```

- 열거 상수는 열거 객체로 생성된다. 해당 열거 타입의 열거 상수 개수만큼 객체가 열거 타입 객체가 생성된다.
- 열거 타입 **Month**의 경우 **JANUARY**부터 **DECEMBER**까지 12개의 열거 상수는 힙 영역에 Month 객체로 생성된다.
- 그리고 메소드 영역에 생성된 열거 상수가 해당 해당 Month 객체를 각각 참조한다.

[https://t1.daumcdn.net/cfile/tistory/2362E74C57728A3C03](https://t1.daumcdn.net/cfile/tistory/2362E74C57728A3C03)

### 열거 타입 변수

- 열거 타입을 선언했다면 열거 타입은 하나의 데이터 타입이므로 변수를 선언하고 사용한다.
- 형식
- 예

```
Month thisMonth;
Month birthMonth;

```

- 열거 타입 변수를 선언 후 열거 상수를 저장할 수 있다. 이 때, 열거 상수는 반드시 열거타입.열거상수로 사용된다.
- 열거 타입 변수는 null 값도 저장할 수 있다.
- 형식
- 예

```
Month thisMonth = Month.JUNE;

```

- 열거 타입 변수 thisMonth는 스택 영역에 생성된다.
- thisMonth에 저장되는 값은 Month.JUNE 열거 상수가 참조하는 객체의 번지이다.
- 즉, 열거 상수 Month.JUNE와 thisMonth 변수는 서로 같은 Month 객체를 참조하게 된다.
- 그러므로 thisMonth == Month.JUNE 상수의 비교 결과는 true가 된다.
-

### 열거 객체의 메소드

- 열거 객체는 열거 상수의 문자열을 내부 데이터로 가지고 있다.
- 열거 객체의 메소드들은 **java.lang.Enum** 클래스에 선언된 메소드인데, 모든 열거 타입은 컴파일 시에 **Enum** 클래스를 상속하게 되어 있어 열거 객체에서 해당 메소드들을 사용할 수 있다.

![제목 없음](image/enum.png)

- name()
    - 열거 객체가 가지고 있는 문자열을 리턴한다.
    - 리턴되는 문자열은 열거 타입을 정의할 때 사용한 상수 이름과 동일하다.
    - 예)

    ```

    Month thisMonth = Month.JUNE;
    String month = thisMonth.name(); // month = "JUNE"
    ```

- ordinal()
    - ordinal() 메소드는 전체 열거 객체 중 몇 번째 열거 객체인지 알려준다.
    - 열거 객체의 순번은 열거 객체 타입을 정의할 때 주어진 순번이며 0번부터 시작한다.
    - 예)

    ```

    Month thisMonth = Month.JUNE;
    int ordinal = thisMonth.ordinal(); // ordinal = 5
    ```

- compareTo()
    - 매개값으로 주어진 열거 객체를 기준으로 전후로 몇 번째 위치하는지를 비교한다.
    - 열거 객체가 매개값의 열거 객체보다 순번이 빠르다면 음수, 순번이 늦다면 양수가 리턴된다.
    - 예)

    ```

    Month month1 = Month.JUNE;
    Month month2 = Month.MARCH;
    int result1 = month2.compareTo(month1); // -3int result2 = month1.compareTo(month2); // 3
    ```

- valueOf()
    - 매개값으로 주어지는 문자열과 동일한 문자열을 가지는 열거 객체를 리턴한다.
    - 이 메소드는 외부로부터 문자열을 입력 받아 열거 객체로 변환할 때 유용하게 사용할 수 있다.
    - 예)

    ```
    Month thisMonth = Month.valueOf("JUNE");

    ```

- values()
    - 열거 타입의 모든 열거 객체들을 배열로 만들어 리턴한다.
    - 예)

    ```
    Month[] months =Month.values();
    for(Month month : months) {
    System.out.println(month); // JANUARY, FEBRUARY, … DECEMBER
    }

    ```
