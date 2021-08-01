package com.example.validation.dto;

import com.example.validation.annotation.YearMonth;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    private String name;

    @Max(value = 90)
    private int age;

//    @Email
    private String email;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 일치하지 않습니다. ( 000-000(0)-0000 )")
    private String phoneNumber;

    /*
    @Size(min = 6, max = 6)
    private String requestYearMonth; // yyyyMM
    */

    @YearMonth
    private String requestYearMonth; // yyyyMM


    @Valid //이 어노테이션을 붙혀야 Car클래스 안에 선언한 Validation 체크가 가능하다.
    private List<Car> cars;
    /*

    ==> @YearMonth 어노테이션으로 커스텀

    @AssertTrue(message = "yyyyMM 형식에 맞지 않습니다.")
    public boolean isRequestYearMonthValidation() {

        this.requestYearMonth = getRequestYearMonth() + "01";

        try {
            LocalDateTime localDateTime = LocalDateTime.parse(this.requestYearMonth, DateTimeFormatter.ofPattern("yyyyMMdd"));
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    */
}
