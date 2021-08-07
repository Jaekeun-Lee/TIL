package com.example.server.controller;

import com.example.server.dto.Req;
import com.example.server.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    private final Logger log = LoggerFactory.getLogger(ServerApiController.class);

    @GetMapping("/hello")
    public User hello() {

        User user = new User();
        user.setName("Lee");
        user.setAge(10);

        return user;
    }

    @PostMapping("/name/{user-name}/age/{user-age}")
    public User user(@RequestBody User user, @PathVariable("user-age") int userAge, @PathVariable("user-name") String userName) {

        user.setName(userName);
        user.setAge(userAge);

        return user;
    }

    @PostMapping("/exchange")
    public User exchange(@RequestBody User user,
                         @RequestHeader("x-authorization") String authorization,
                         @RequestHeader("custom-header") String customHeader) {


        log.info("user : {}", user);
        log.info("x-authorization : {}",authorization);
        log.info("custom-header : {}", customHeader);

        return user;
    }

    @PostMapping("/generic-exchange")
    public Req<User> genericExchange(//HttpEntity<String> httpEntity,
                                     @RequestBody Req<User> user,
                                     @RequestHeader("x-authorization") String authorization,
                                     @RequestHeader("custom-header") String customHeader) {


        //순수한 http요청 검사 가능
        //log.info("httpEntity : {}", httpEntity);

        Req.Header responseHeader = new Req.Header();
        responseHeader.setResponseCode("200 ok");
        user.setHeader(responseHeader);

        log.info("user : {}", user.getBody());
        log.info("x-authorization : {}",authorization);
        log.info("custom-header : {}", customHeader);

        return user;
    }


}
