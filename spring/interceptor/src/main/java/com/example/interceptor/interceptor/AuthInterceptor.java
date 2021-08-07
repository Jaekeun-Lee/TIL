package com.example.interceptor.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURL().toString();
        log.info("Request URL : {}", url);

        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI()).query(request.getQueryString()).build().toUri();
        log.info("Request URI : {}", uri);

        boolean hasAnnotation = checkAnnotation(handler, AuthInterceptor.class);

        if (hasAnnotation) {
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }

        return false;
    }

    private boolean checkAnnotation(Object handler, Class clazz) {

        //resource, javascript, html
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        //annotation check
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (handlerMethod.getMethodAnnotation(clazz) != null) {
            return true;
        }

        return false;
    }
}
