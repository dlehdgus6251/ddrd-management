package com.ddrd.management.config;

import com.ddrd.management.user.UserRoleType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.PathVariable;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()// 세션을 사용하지 않고 JWT 토큰을 활용하여 진행, csrf토큰검사를 비활성화
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers( "/","/main","/signUp", "/api/v1/**").permitAll() // 설정된 url은 인증되지 않더라도 누구든 접근 가능
                        //권한 보유 depth USER(사용자) < MANAGER(운영진) < MASTER(모임장) < ADMIN(어플관리자) < DEVELOPER(개발자)
                        .requestMatchers("/user","/user/**").hasAnyRole(UserRoleType.USER.roleName(), UserRoleType.MANAGER.roleName(), UserRoleType.MASTER.roleName(), UserRoleType.ADMIN.roleName(), UserRoleType.DEVELOPER.roleName()) // 블랙회원 제외 권한 부여
                        .requestMatchers("/manager", "/manager/**").hasAnyRole(UserRoleType.MANAGER.roleName(), UserRoleType.MASTER.roleName(), UserRoleType.ADMIN.roleName(), UserRoleType.DEVELOPER.roleName()) // 운영진 이상 권한 부여
                        .requestMatchers("/admin", "admin/**").hasAnyRole(UserRoleType.ADMIN.roleName(), UserRoleType.DEVELOPER.roleName()) // 어플 관리자 이상 권한부여
                        .requestMatchers("/developer", "developer/**").hasAnyRole(UserRoleType.DEVELOPER.roleName()) // 개발자 권한부여
                        .anyRequest().authenticated() // 위 페이지 외 인증이 되어야 접근가능(ROLE에 상관없이)
                )
                .formLogin()
                .loginPage("/login") // 접근이 차단된 페이지 클릭시 이동할 url
                .loginProcessingUrl("/loginProc") // 로그인시 맵핑되는 url
                .usernameParameter("userId")    // view form 태그 내에 로그인 할 id 에 맵핑되는 name ( form 의 name )
                .passwordParameter("password")  // view form 태그 내에 로그인 할 password 에 맵핑되는 name ( form 의 name )
                .defaultSuccessUrl("/main", true)
                .permitAll()
                .and()
                .logout() // 8
                .logoutSuccessUrl("/login") // 로그아웃 성공시 리다이렉트 주소
                .invalidateHttpSession(true); // 세션 날리기

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        String password = passwordEncoder.encode("1234");
        manager.createUser(User.withUsername("dlehdgus")
                .password(password)
                .roles(UserRoleType.USER.roleName())
                .build());

        manager.createUser(User.withUsername("qkrtjdwls")
                .password(password)
                .roles(UserRoleType.ADMIN.roleName())
                .build());

        manager.createUser(User.withUsername("qkrwldnjs")
                .password(password)
                .roles(UserRoleType.MANAGER.roleName())
                .build());
        return manager;
    }
    @Bean
    WebSecurityCustomizer ignoringCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/resources/**");
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable();
        return http.build();
    }
}
