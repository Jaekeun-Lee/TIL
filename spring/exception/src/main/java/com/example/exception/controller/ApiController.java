package com.example.exception.controller;

import com.example.exception.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class ApiController {


    @GetMapping
    public User get(@RequestParam(required = false) String name, @RequestParam Integer age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);


        return user;
    }

    @PostMapping
    public User post(@Valid @RequestBody User user) {
        System.out.println(user);
        return user;
    }

    //GlobalControllerAdvice 보다 우선순위가 높음.
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
