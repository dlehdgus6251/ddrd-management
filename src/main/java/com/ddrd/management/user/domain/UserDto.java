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
@ToString
public class UserDto {
    private long userNo;
    private String delYn;
    private LocalDateTime finalDt;
    private String joinDt;
    private String password;
    private LocalDateTime regDt;
    private long regNo;
    private LocalDateTime updDt;
    private long updNo;
    private String userAddress;
    private String userGender;
    private String userId;
    private String userLevel;
    private String userName;
    private String userPhoneNumber;
    private String userRank;
    private List<AuthorityEntity> userAuthority = new ArrayList<>();
}