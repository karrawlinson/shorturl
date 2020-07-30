package com.neuda.shorturl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

public class AnalyticsFilter implements Filter {
 
    @Override
    public void doFilter(
      ServletRequest request, 
      ServletResponse response, 
      FilterChain chain) throws IOException, ServletException {
 
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        System.err.println(
          "Logging Request  {} : {}" + req.getMethod() + 
          req.getRequestURI());
        chain.doFilter(request, response);
        System.err.println(
          "Logging Response :{}" +
          res.getContentType());
    }
 
    // other methods
}

