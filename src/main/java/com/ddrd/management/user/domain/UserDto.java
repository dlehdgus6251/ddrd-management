package com.ddrd.management.user.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {
    private long userNo;
    private String userName;
    private String userPhoneNumber;
    private String userGender;
    private LocalDateTime joinDate;
    private String userId;
    private String userPassword;
    private String userLevel;
    private String userRank;
    private String userAddress;
    private LocalDateTime finalDate;
    private String delYn;
    private LocalDateTime updateDate;
    private long updateNo;

    @Override
    public String toString() {
        return "UserDto{" +
                "userNo=" + userNo +
                ", userName='" + userName + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userGender='" + userGender + '\'' +
                ", joinDate=" + joinDate +
                ", userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userLevel='" + userLevel + '\'' +
                ", userRank='" + userRank + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", finalDate=" + finalDate +
                ", delYn='" + delYn + '\'' +
                ", updateDate=" + updateDate +
                ", updateNo=" + updateNo +
                '}';
    }
}