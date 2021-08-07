package com.example.client.service;

import com.example.client.dto.Req;
import com.example.client.dto.UserRequest;
import com.example.client.dto.UserResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {

    // GET :: http://localhost:9090/api/server/hello
    public String hello() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .encode()
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());

        return result.getBody();
    }

    // GET :: http://localhost:9090/api/server/name/{user-name}/age/{user-age}
    public UserResponse user() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/name/{user-name}/age/{user-age}")
                .encode()
                .buildAndExpand("lee", 20)
                .toUri();

        UserRequest userRequest = new UserRequest();
        userRequest.setName("jack");
        userRequest.setAge(26);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> userResponseResponseEntity = restTemplate.postForEntity(uri, userRequest, UserResponse.class);

        System.out.println(userResponseResponseEntity.getStatusCode());
        System.out.println(userResponseResponseEntity.getBody());

        return userResponseResponseEntity.getBody();

    }

    public UserResponse exchange() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/exchange")
                .encode()
                .build()
                .toUri();

        UserRequest userRequest = new UserRequest();
        userRequest.setName("jack");
        userRequest.setAge(26);

        RequestEntity<UserRequest> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "abcd")
                .header("custom-header", "ffffff")
                .body(userRequest);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.exchange(requestEntity, UserResponse.class);

        return response.getBody();
    }

    public Req<UserResponse> genericExchange() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/generic-exchange")
                .encode()
                .build()
                .toUri();

        UserRequest userRequest = new UserRequest();
        userRequest.setName("jack");
        userRequest.setAge(26);


        Req req = new Req<UserRequest>();
        req.setHeader(new Req.Header());
        req.setBody(userRequest);

        RequestEntity<Req<UserRequest>> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "abcd")
                .header("custom-header", "ffffff")
                .body(req);


        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Req<UserResponse>> responseEntity
                = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<>() {
        });


        return responseEntity.getBody();

    }

}
