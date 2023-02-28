package com.ddrd.management.gather.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class GatherDto {
    private Long gatherNo;
    private String gatherName;
    private int gatherCount;
    private String gatherSong;
    private String gatherSinger;
    private String gatherWeek;
    private int gatherMaxNumber;
    private Long materialNo;
    private String gatherStart;
    private String gatherTime;
    private String gatherNoti;
    private Long regNo;
    private LocalDateTime regDt;
    private String delYn;
    private LocalDateTime updDt;
    private Long updNo;

}
