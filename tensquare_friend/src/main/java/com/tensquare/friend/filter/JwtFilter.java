package com.tensquare.friend.filter;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @autor a2008q
 */
@Component
public class JwtFilter extends HandlerInterceptorAdapter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("经过了添加好友的拦截器");

        final String header=request.getHeader("Authorization");

        if (header!=null&&header.startsWith("Bearer")){
            String token=header.substring(7);

            Claims claims=jwtUtil.parseJWT(token);
            if (claims!=null){
                if ("admin".equals(claims.get("roles"))){
                    request.setAttribute("admin_claims",claims);
                }
                if ("user".equals(claims.get("roles"))){
                    request.setAttribute("user_claims",claims);
                }
            }

        }
        return true;
    }
}
