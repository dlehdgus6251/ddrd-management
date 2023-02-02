package com.ddrd.management.user.service;

import com.ddrd.management.config.security.SecurityUserDetail;
import com.ddrd.management.user.domain.UserEntity;
import com.ddrd.management.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserId(userId).orElseThrow(
                () -> new UsernameNotFoundException("잘못된 아이디 입니다")
        );

        return new SecurityUserDetail(userEntity);
    }
}
