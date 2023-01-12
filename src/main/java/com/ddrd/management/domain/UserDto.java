package com.ddrd.management.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private long user_id;
    private String user_name;
    private String user_phone_number;
    private String user_gender;
}