package com.ddrd.management.config.jwt;

import com.ddrd.management.common.domain.LoginRequest;
import com.ddrd.management.common.domain.LoginResponse;
import com.ddrd.management.common.service.LoginService;
import com.ddrd.management.config.security.SecurityUserDetail;
import com.ddrd.management.user.domain.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;

import static org.springframework.security.config.Elements.JWT;

@Slf4j
@RequiredArgsConstructor
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    private final LoginService loginService;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException{

        ObjectMapper om = new ObjectMapper();
        try {

            LoginRequest user = om.readValue(request.getInputStream(), LoginRequest.class);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user.getUserId(), user.getPassword());
            // JpaUserDetailsService의 loadUserByUsername() 함수가 실행됨
            Authentication authentication =
                    authenticationManager.authenticate(authenticationToken);

            SecurityUserDetail loginResponse = (SecurityUserDetail) authentication.getPrincipal();
            //authentication 객체가 session 영역에 저장됨. => 로그인이 되었다
            return authentication;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        super.successfulAuthentication(request,response,chain,authResult);
    }
}
