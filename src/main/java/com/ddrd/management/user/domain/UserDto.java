package com.ddrd.management.user.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private long userNo;
    private String userName;
    private String userId;
    private String userPassword;
    private String userPhoneNumber;
    private String userGender;

    @Override
    public String toString() {
        return "UserDto{" +
                "userNo=" + userNo +
                ", userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userGender='" + userGender + '\'' +
                '}';
    }
}