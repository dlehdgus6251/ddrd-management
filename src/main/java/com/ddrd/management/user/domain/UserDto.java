package com.ddrd.management.user.domain;

import com.ddrd.management.common.domain.AuthorityEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class UserDto {
    private long userNo;

    private String userName;

    private String userPhoneNumber;

    private String userGender;

    private LocalDateTime joinDate;

    private String userId;

    private String password;

    private String userLevel;

    private String userRole;
    private List<AuthorityEntity> userAuthority = new ArrayList<>();
    private String userRank;
    private String userAddress;
    private LocalDateTime finalDate;
    private String delYn;
    private LocalDateTime updateDate;
    private long updateNo;

}