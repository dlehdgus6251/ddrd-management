package com.ddrd.management.config.jwt;

import com.ddrd.management.common.domain.LoginRequest;
import com.ddrd.management.common.domain.LoginResponse;
import com.ddrd.management.common.service.LoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    private final LoginService loginService;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException{
        log.info("로그인 시도@!!!@!@!@제발 타라 ㅠㅠ퓨ㅠㅠㅠㅠㅠ");
        ObjectMapper om = new ObjectMapper();
        try {
            LoginRequest loginRequest = om.readValue(request.getInputStream(), LoginRequest.class);
            log.info("로그인 시도 정보 :: {}", loginRequest.toString());
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(loginRequest.getUserId(), loginRequest.getPassword());
            log.info("principal :: {}", authenticationToken.getPrincipal().toString());
            log.info("credentials :: {}", authenticationToken.getCredentials().toString());

            Authentication authentication =
                    authenticationManager.authenticate(authenticationToken);

            LoginResponse loginResponse = (LoginResponse) authentication.getPrincipal();
            log.info("response username :: {}", loginResponse.getUserId());
            log.info("response password :: {}", loginResponse.getPassword());
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
