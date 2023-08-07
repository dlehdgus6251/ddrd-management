package com.ddrd.management.common.service;

import com.ddrd.management.common.domain.AuthorityEntity;
import com.ddrd.management.common.domain.LoginRequest;
import com.ddrd.management.common.domain.LoginResponse;
import com.ddrd.management.config.jwt.JwtProvider;
import com.ddrd.management.user.UserRoleType;
import com.ddrd.management.user.domain.UserEntity;
import com.ddrd.management.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class LoginService {
    private final UserRepository userEntityRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public LoginResponse login(LoginRequest request) throws Exception {
        UserEntity userEntity = userEntityRepository.findByUserId(request.getUserId()).orElseThrow(() ->
                new UsernameNotFoundException("존재하지 않는 계정입니다."));

        if (!passwordEncoder.matches(request.getPassword(), userEntity.getPassword())) {
            throw new BadCredentialsException("비밀번호가 틀렸습니다.");
        }
        log.info("login 시도 :: {}", userEntity.toString());

        return LoginResponse.builder()
                .userNo(userEntity.getUserNo())
                .userId(userEntity.getUserId())
                .userName(userEntity.getUserName())
                .userAuthority(userEntity.getUserAuthority())
                .token(jwtProvider.createToken(userEntity.getUserId(), userEntity.getUserAuthority()))
                .build();

    }

    public boolean register(LoginRequest request) throws Exception {
        try {
            UserEntity userEntity = UserEntity.builder()
                    .userId(request.getUserId())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .userName(request.getUserName())
                    .build();

            userEntity.setUserAuthority(Collections.singletonList(AuthorityEntity.builder().userAuthority(UserRoleType.USER.roleName()).build()));

            userEntityRepository.save(userEntity);
        } catch (Exception e) {
            log.error("### JWT TOKEN REGISTER ERROR :: {}", e.getMessage());
            throw new Exception("잘못된 요청입니다.");
        }
        return true;
    }

    public LoginResponse getuserEntity(String userId) throws Exception {
        UserEntity userEntity = userEntityRepository.findByUserId(userId)
                .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));
        return new LoginResponse(userEntity);
    }

}
