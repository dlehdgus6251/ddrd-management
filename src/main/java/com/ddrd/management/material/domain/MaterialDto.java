package com.ddrd.management.material.domain;

import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @Override
    public String toString() {
        return "MaterialDto{" +
                "materialNo=" + materialNo +
                ", materialName='" + materialName + '\'' +
                ", materialLatitude='" + materialLatitude + '\'' +
                ", materialLongitude='" + materialLongitude + '\'' +
                ", materialNewAddr='" + materialNewAddr + '\'' +
                ", materialOldAddr='" + materialOldAddr + '\'' +
                ", materialNoti='" + materialNoti + '\'' +
                ", materialSecretNoti='" + materialSecretNoti + '\'' +
                ", regNo=" + regNo +
                ", regDate=" + regDate +
                ", updNo=" + updNo +
                ", updDate=" + updDate +
                '}';
    }
}
