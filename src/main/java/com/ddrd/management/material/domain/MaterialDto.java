package com.ddrd.management.material.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
public class MaterialDto {
    private long materialNo;
    private String materialName;
    private String materialLatitude;
    private String materialLongitude;
    private String materialNewAddr;
    private String materialOldAddr;
    private String materialNoti;
    private String materialSecretNoti;
    private long regNo;
    private LocalDateTime regDate;
    private long updNo;
    private LocalDateTime updDate;
}
