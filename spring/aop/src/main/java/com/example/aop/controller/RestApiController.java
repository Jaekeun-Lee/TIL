package com.example.aop.controller;

import com.example.aop.annotation.Decode;
import com.example.aop.annotation.Timer;
import com.example.aop.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public ResponseEntity get(@PathVariable Long id, @RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK).body(id + " / " + name);
    }

    @PostMapping("/post")
    public ResponseEntity<User> post(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {

        // db logic
        Thread.sleep(1000 * 2);
    }

    @Decode
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user) {
        System.out.println(user);
        return ResponseEntity.ok(user);
    }
}
