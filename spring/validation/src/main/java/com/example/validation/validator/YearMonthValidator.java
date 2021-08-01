package com.example.validation.validator;

import com.example.validation.annotation.YearMonth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String > {

    private String pattern;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //yyyyMM
        try {
            LocalDateTime localDateTime = LocalDateTime.parse(value+"01", DateTimeFormatter.ofPattern(this.pattern));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
