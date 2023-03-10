package com.ddrd.management.config.jwt;

import com.ddrd.management.common.domain.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//스프링 시큐리티 UsernamePssswordAuthenticationFilter 이전에 실행되는 필터
// /login 요청해서 username, password 전송하면 (post)
// UsernamePssswordAuthenticationFilter 가 동작함 따라서 로그인 시도시 JwtAuthenticationFilter 우선 동작
@Slf4j
@Configuration
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    public JwtAuthenticationFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = jwtProvider.resolveToken(request);
//
//        ObjectMapper om = new ObjectMapper();
//        LoginRequest loginRequest = om.readValue(request.getInputStream(), LoginRequest.class);
//        log.info("로그인 시도 정보 :: {}", loginRequest.toString());
        if (token != null && jwtProvider.validateToken(token)) {
            // check access token
            token = token.split(" ")[1].trim();
            log.info("authentication :: {}", token);
            Authentication auth = jwtProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        filterChain.doFilter(request, response);
    }
}