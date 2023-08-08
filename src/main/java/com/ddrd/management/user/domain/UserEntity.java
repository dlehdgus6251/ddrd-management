package com.ddrd.management.user.domain;

import com.ddrd.management.common.domain.AuthorityEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "ddrd_user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    @Column(name = "user_no")
    @Comment("USER 번호")
    private long id;
    @Nullable
    @Column(length = 10)
    @Comment("이름")
    private String userName;
    @Nullable
    @Column(length = 15, unique = true)
    @Comment("전화번호")
    private String userPhoneNumber;
    @Nullable
    @Column(length = 2)
    @Comment("성별")
    private String userGender;
    @Temporal(TemporalType.TIMESTAMP)
    @Nullable
    @Column(length = 10)
    @Comment("가입일")
    private String joinDt;
    @Nullable
    @Column(length = 30, unique = true)
    @Comment("아이디")
    private String userId;
    @Nullable
    @Comment("비밀번호")
    private String password;
    @Column(length = 10)
    @Comment("모임내 등급")
    private String userLevel;
//    @Nullable
//    @Column(length = 10)
//    private String userRole;
    @OneToMany(mappedBy = "userEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Builder.Default
    @Comment("계정 권한")
    @ColumnDefault("'USER'")
    private List<AuthorityEntity> userAuthority = new ArrayList<>();
    @Nullable
    @Column(length = 10)
    @Comment("모임내 등급")
    private String userRank;
    @Nullable
    @Column(length = 30)
    @Comment("주소")
    private String userAddress;
    @Temporal(TemporalType.TIMESTAMP)
    @Comment("마지막 정모 참여일")
    private LocalDateTime finalDt;
    @Nullable
    @Column(length = 2)
    @Comment("삭제여부")
    @ColumnDefault("'N'")
    private String delYn;
    @Nullable
    @Comment("등록인 정보")
    private long regNo;
    @Nullable
    @CreationTimestamp
    @Comment("등록일시")
    private LocalDateTime regDt = LocalDateTime.now();

    @Comment("수정인 정보")
    private long updNo;

    @UpdateTimestamp
    @Comment("수정일시")
    private LocalDateTime updDt = LocalDateTime.now();

    public void setUserAuthority(List<AuthorityEntity> authority) {
        this.userAuthority = authority;
        authority.forEach(o -> o.setUserEntity(this));
    }
}
