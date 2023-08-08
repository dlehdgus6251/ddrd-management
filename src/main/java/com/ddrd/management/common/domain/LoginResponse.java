package com.ddrd.management.common.domain;

import com.ddrd.management.user.domain.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private long userNo;
    private String userName;
    private String userId;
    private String password;
    private List<AuthorityEntity> userAuthority = new ArrayList<>();
    private String token;

    public LoginResponse(UserEntity userEntity) {
        this.userNo = userEntity.getId();
        this.userName = userEntity.getUserName();
        this.userId = userEntity.getUserId();
        this.password = userEntity.getPassword();
        this.userAuthority = userEntity.getUserAuthority();
    }
}
