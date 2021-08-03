package com.example.aop.aop;

import com.example.aop.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut() {
    }

    @Pointcut("@annotation(com.example.aop.annotation.Decode)")
    private void enableDecode() {
    }

    @Before("cut() && enableDecode()")
    public void decoding(JoinPoint joinPoint) throws UnsupportedEncodingException {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof User) {
                User user = User.class.cast(arg);
                String decodeEmail = new String(Base64.getDecoder().decode(user.getEmail()),"UTF-8");
                user.setEmail(decodeEmail);
            }
        }
    }

    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
    public void encoding(JoinPoint joinPoint, Object returnObj) {
        if (returnObj instanceof User) {
            User user = User.class.cast(returnObj);
            String encodeEmail = Base64.getEncoder().encodeToString(user.getEmail().getBytes());
            user.setEmail(encodeEmail);
        }
    }
}
