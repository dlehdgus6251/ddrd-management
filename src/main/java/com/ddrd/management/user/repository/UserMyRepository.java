package com.ddrd.management.user.repository;

import com.ddrd.management.user.domain.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMyRepository {
    List<UserDto> getUsers();
    UserDto getUser();
}
