package com.example.swagger.controller;

import com.example.swagger.dto.UserRequest;
import com.example.swagger.dto.UserResponse;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/plu/{x}")
    public int plus(
            @ApiParam(value = "x값")
            @PathVariable int x,
            @ApiParam(value = "y값")
            @RequestParam int y) {
        return x + y;
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "x", value = "x값", required = true, dataType = "int"),
        @ApiImplicitParam(name = "x", value = "y값", required = true, dataType = "int")
    })
    @GetMapping("/plu/{x}")
    public int add(@PathVariable int x, @RequestParam int y) {
        return x + y;
    }

    @ApiResponse(code = 502, message = "사용자의 나이가 10살 이하일 때")
    @ApiOperation(value = "사용자의 이름과 나이를 리턴하는 메소드")
    @GetMapping("/user")
    public UserResponse user(@RequestParam UserRequest userRequest) {
        return new UserResponse(userRequest.getName(), userRequest.getAge());
    }

    @PostMapping("/user")
    public UserResponse userPost(@RequestBody UserRequest userRequest) {
        return new UserResponse(userRequest.getName(), userRequest.getAge());
    }
}
