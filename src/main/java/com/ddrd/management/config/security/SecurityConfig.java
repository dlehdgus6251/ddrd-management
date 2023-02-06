package com.ddrd.management.config.security;

import com.ddrd.management.config.jwt.JwtAuthenticationFilter;
import com.ddrd.management.config.jwt.JwtLoginFilter;
import com.ddrd.management.config.jwt.JwtProvider;
import com.ddrd.management.user.UserRoleType;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

import java.io.IOException;

@Configuration  //메모리에 올라갈 수 있게함
@RequiredArgsConstructor
@EnableWebSecurity  //스프링 시큐리티 필터가 스프링 필터체인에 등록이 됨
public class SecurityConfig {
    private final JwtProvider jwtProvider;
    private final CorsFilter corsFilter;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 쿠키 기반이 아닌 JWT 기반이므로 사용하지 않음
                .csrf().disable()

                // httpBasic : anthorization 에 ID,PW 를 담아서 인증하는 방식(JWT은 anthorization 에 토큰을 담아야하게때문에 disable)
                .httpBasic().disable()
                // Spring Security 세션 정책 : 세션을 생성 및 사용하지 않음
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // CORS 설정
                .addFilter(corsFilter)
                // JWT 인증 필터 적용
                .addFilterBefore(new JwtAuthenticationFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class)

                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers( "/", "/main", "/login", "/login/**", "/api/v1/**", "/material", "/material/**").permitAll() // 설정된 url은 인증되지 않더라도 누구든 접근 가능
                        //권한 보유 depth USER(사용자) < MANAGER(운영진) < MASTER(모임장) < ADMIN(어플관리자) < DEVELOPER(개발자)
                        .requestMatchers("/user","/user/**").hasAnyRole(UserRoleType.USER.roleName()) // 유저 이상 권한 부여
                        .requestMatchers("/manager", "/manager/**").hasAnyRole(UserRoleType.MANAGER.roleName()) // 운영진 이상 권한 부여
                        .requestMatchers("/admin", "/admin/**").hasAnyRole(UserRoleType.ADMIN.roleName()) // 어플 관리자 이상 권한부여
                        .requestMatchers("/developer", "/developer/**").hasAnyRole(UserRoleType.DEVELOPER.roleName()) // 개발자 권한부여
                        .anyRequest().authenticated() // 위 페이지 외 인증이 되어야 접근가능
                )
                // form login 방식을 사용하지 않겠다
                .formLogin().disable();
//                .loginPage("/login") // 로그인 페이지 지정(미인증, 미인가시 이동할 url)
//                .loginProcessingUrl("/signUp")  // 로그인 처리 url 지정(시큐리티가 인증 처리 진행)
//                .successForwardUrl("/") // 로그인 성공 URL을 설정함
//                .failureForwardUrl("/index").permitAll()
//                .and()

                // 에러 핸들링
                http.exceptionHandling()
                .accessDeniedHandler(new AccessDeniedHandler() {
                    @Override
                    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws ServletException, IOException {
                        // 권한 문제가 발생했을 때 이 부분을 호출한다.
                        response.setStatus(403);
                        response.setCharacterEncoding("utf-8");
                        response.setContentType("text/html; charset=UTF-8");
                        response.getWriter().write("권한이 없는 사용자입니다.");
                    }
                })
                .authenticationEntryPoint(new AuthenticationEntryPoint() {
                    @Override
                    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws ServletException, IOException {
                        // 인증문제가 발생했을 때 이 부분을 호출한다.
                        response.setStatus(401);
                        response.setCharacterEncoding("utf-8");
                        response.setContentType("text/html; charset=UTF-8");
                        response.getWriter().write("인증되지 않은 사용자입니다.");
                    }
                });


        return http.build();
    }


    //    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//
//        String password = passwordEncoder.encode("1234");
//        manager.createUser(User.withUsername("dlehdgus")
//                .password(password)
//                .roles(UserRoleType.USER.roleName())
//                .build());
//
//        manager.createUser(User.withUsername("qkrtjdwls")
//                .password(password)
//                .roles(UserRoleType.ADMIN.roleName())
//                .build());
//
//        manager.createUser(User.withUsername("qkrwldnjs")
//                .password(password)
//                .roles(UserRoleType.MANAGER.roleName())
//                .build());
//        return manager;
//    }
    @Bean
    WebSecurityCustomizer ignoringCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/resources/**");
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
