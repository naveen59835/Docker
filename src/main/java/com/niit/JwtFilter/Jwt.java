/*
 * Author : Naveen Kumar
 * Date : 06-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.JwtFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

public class Jwt extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        String headers=request.getHeader("authorization");
        if(headers==null||!headers.startsWith("Bearer")){
            throw new ServletException("Missing Token");

        }else{
            String token=headers.substring(7);
            Claims claims= Jwts.parser().setSigningKey("hello").parseClaimsJws(token).getBody();
            System.out.println("claims: " + claims);
            filterChain.doFilter(request,response);

        }

    }
}
