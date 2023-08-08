package com.ddrd.management.material.domain;

import com.ddrd.management.gather.domain.GatherEntity;
import com.ddrd.management.user.domain.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "ddrd_material")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaterialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    @Comment("소재 번호")
    @Column(name = "material_no")
    private long id;
    @Nullable
    @Column(length = 50)
    @Comment("소재명")
    private String materialName;
    @Nullable
    @Column(length = 10)
    @Comment("소재 위도")
    private String materialLatitude;
    @Nullable
    @Column(length = 10)
    @Comment("소재 경도")
    private String materialLongitude;
    @Nullable
    @Column(length = 50)
    @Comment("소재 구주소")
    private String materialNewAddr;

//    @OneToMany(mappedBy = "materialEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @Builder.Default
//    private List<GatherEntity> gatherEntity = new ArrayList<>();
    @Nullable
    @Column(length = 50)
    @Comment("소재 도로명주소")
    private String materialOldAddr;
    @Nullable
    @Column(length = 500)
    @Comment("소재 메모")
    @Lob
    private String materialNoti;
    @Nullable
    @Column(length = 500)
    @Comment("소재 관리자 메모")
    @Lob
    private String materialSecretNoti;
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
//    public void setGatherEntity(List<GatherEntity> gatherEntity) {
//        this.gatherEntity = gatherEntity;
//        gatherEntity.forEach(o -> o.setMaterialEntity(this));
//    }
}
