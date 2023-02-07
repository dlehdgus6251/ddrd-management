package com.ddrd.management.user.repository;

import com.ddrd.management.user.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository  extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUserId(String userId);


}
