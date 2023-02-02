package com.ddrd.management.user.domain;

import com.ddrd.management.common.domain.AuthorityEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "ddrd_user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private long userNo;
    @Nullable
    @Column(length = 10)
    private String userName;
    @Nullable
    @Column(length = 15)
    private String userPhoneNumber;
    @Nullable
    @Column(length = 2)
    private String userGender;
    @Temporal(TemporalType.TIMESTAMP)
    @Nullable
    private LocalDateTime joinDate;
    @Nullable
    @Column(length = 30, unique = true)
    private String userId;
    @Nullable
    private String password;
    @Column(length = 10)
    private String userLevel;
    @Nullable
    @Column(length = 10)
    private String userRole;
    @OneToMany(mappedBy = "userEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Builder.Default
    private List<AuthorityEntity> userAuthority = new ArrayList<>();
    @Nullable
    @Column(length = 10)
    private String userRank;
    @Nullable
    @Column(length = 30)
    private String userAddress;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime finalDate;
    @Nullable
    @Column(length = 2)
    private String delYn;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updateDate;
    private long updateNo;
    public void setUserAuthority(List<AuthorityEntity> authority) {
        this.userAuthority = authority;
        authority.forEach(o -> o.setUserEntity(this));
    }
}
