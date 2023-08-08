package com.ddrd.management.gather.domain;

import com.ddrd.management.common.domain.AuthorityEntity;
import com.ddrd.management.material.domain.MaterialEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "ddrd_gather")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
public class GatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    @Comment("모임 번호")
    @Column(name = "gather_no")
    private Long id;
    @Nullable
    @Column(length = 50)
    @Comment("모임명")
    private String gatherName;
    @Nullable
    @Column(length = 10)
    @Comment("모임노래명")
    private String gatherSong;
    @Nullable
    @Column(length = 10)
    @Comment("모임노래가수")
    private String gatherSinger;
    @Nullable
    @Column(length = 5)
    @Comment("모임주차")
    private String gatherWeek;
    @Nullable
    @Column(length = 5)
    @Comment("최대인원수")
    private int gatherMaxNumber;
    @Nullable
    @Column(length = 10)
    @Comment("모임시작날짜")
    private String gatherStart;
    @Nullable
    @Column(length = 5)
    @Comment("모임시작시간")
    private String gatherTime;
    @Nullable
    @Column(length = 500)
    @Comment("메모")
    @Lob
    private String gatherNoti;
    @Nullable
    @Comment("등록인 정보")
    private Long regNo;
    @Nullable
    @CreationTimestamp
    @Comment("등록일시")
    private LocalDateTime regDt = LocalDateTime.now();
    @Comment("수정인 정보")
    private Long updNo;

    @UpdateTimestamp
    @Comment("수정일시")
    private LocalDateTime updDt = LocalDateTime.now();
    @Nullable
    @Column(length = 2)
    @Comment("삭제여부")
    @ColumnDefault("'N'")
    private String delYn;

    @JoinColumn(name = "material_no")
    @ManyToOne//(fetch = FetchType.LAZY)
    private MaterialEntity materialEntity;

    public void setMaterialEntity(MaterialEntity materialEntity) {
        this.materialEntity = materialEntity;
    }
}
