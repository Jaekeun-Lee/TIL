# Spring boot Bean Validation

>Validation Starter는 Bean Validation Specification 구현체 중 가장 널리 사용되고 있는 hibernate validator를 포함하고 있다.

Spring RestController를 통해 Client로부터 전달받은 요청(request, input)에 대해 유효성을 검사하고자 한다. Client로부터 들어오는 다음의 3가지 요청 형식에 대해서 유효성 검사를 할 수 있다.

- **request body**
- **path에 포함된 variables** (ex. /foos/{id}의 id)
- **query parameters**

　

### 직접 검증을 하고 싶을 때 사용

```
  @AssertTrue
  @AssertFalse
```

　
### 문자열을 다룰 때 사용
```
  @NotNull // null 불가능
  @NotEmpty // null, 빈 문자열(스페이스 포함X) 불가
  @NotBlank // null, 빈 문자열, 스페이스만 포함한 문자열 불가
  @Size(min=?, max=?) // 최소 길이, 최대 길이 제한
  @Null // null만 가능
```

　

### 숫자를 다룰 때 사용
  
```
  @Positive // 양수만 허용
  @PositiveOrZero // 양수와 0만 허용
  @Negative // 음수만 허용
  @NegativeOrZero // 음수와 0만 허용
  @Min(?) // 최소값 제한
  @Max(?) // 최대값 제한
```

　
### 정규식 관련
```
  @Email // 이메일 형식만가능 (기본 제공)
  @Pattern(regexp="?") // 직접 정규식을 쓸 수 있음
```