package com.ddrd.management.common.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class LoginRequest {
    private long userNo;
    private String userName;
    private String userId;
    private String password;
}
