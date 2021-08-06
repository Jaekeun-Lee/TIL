package com.example.filter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/api/user/**")
public class GlobalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        /*

        //이 방식을 사용하면 filter에서 내용을 읽었기 때문에 컨트롤러나 다른 부분에서 바디를 읽을 수 없음.
        //전처리
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String url = httpServletRequest.getRequestURI();

        BufferedReader br = httpServletRequest.getReader();

        br.lines().forEach(line -> {
            log.info("url : {}, line : {}", url, line);
        });

        chain.doFilter(httpServletRequest, httpServletResponse);
        */


        //그래서 스프링에서 제공하는 ContentCachingRequestWrapper, ContentCachingResponseWrapper를 사용하여
        //읽은 내용을 캐싱해서 사용용

        //전처리
        ContentCachingRequestWrapper contentCachingRequestWrapper = new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper contentCachingResponseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) response);

        String url = contentCachingRequestWrapper.getRequestURI();

        BufferedReader br = contentCachingRequestWrapper.getReader();

        br.lines().forEach(line -> {
            log.info("url : {}, line : {}", url, line);
        });

        chain.doFilter(contentCachingRequestWrapper, contentCachingResponseWrapper);


        //후처리
        String reqContent = new String(contentCachingRequestWrapper.getContentAsByteArray());
        log.info("request url : {}, request body : {}", url, reqContent);

        String resContent = new String(contentCachingResponseWrapper.getContentAsByteArray());
        int httpStatus = contentCachingResponseWrapper.getStatus();

        contentCachingResponseWrapper.copyBodyToResponse();

        log.info("response status : {}, response body : {}", httpStatus, resContent);




    }
}
