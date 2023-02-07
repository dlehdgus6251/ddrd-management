package com.ddrd.management.user.service;

import com.ddrd.management.user.domain.UserDto;
import com.ddrd.management.user.repository.UserMyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMyRepository userRepository;


    public List<UserDto> getUsers(){
        return userRepository.getUsers();
    }
}
