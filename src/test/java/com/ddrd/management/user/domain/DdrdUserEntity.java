package com.ddrd.management.user.domain;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "ddrd_user", schema = "dev_ddrd", catalog = "")
public class DdrdUserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_no")
    private int userNo;
    @Basic
    @Column(name = "user_name")
    private String userName;
    @Basic
    @Column(name = "user_phone_number")
    private String userPhoneNumber;
    @Basic
    @Column(name = "user_gender")
    private String userGender;
    @Basic
    @Column(name = "join_date")
    private Timestamp joinDate;
    @Basic
    @Column(name = "user_id")
    private String userId;
    @Basic
    @Column(name = "user_level")
    private String userLevel;
    @Basic
    @Column(name = "user_rank")
    private String userRank;
    @Basic
    @Column(name = "user_address")
    private String userAddress;
    @Basic
    @Column(name = "final_date")
    private Timestamp finalDate;
    @Basic
    @Column(name = "del_yn")
    private String delYn;
    @Basic
    @Column(name = "update_date")
    private Timestamp updateDate;
    @Basic
    @Column(name = "update_no")
    private Integer updateNo;

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public Timestamp getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Timestamp joinDate) {
        this.joinDate = joinDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserRank() {
        return userRank;
    }

    public void setUserRank(String userRank) {
        this.userRank = userRank;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Timestamp getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Timestamp finalDate) {
        this.finalDate = finalDate;
    }

    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUpdateNo() {
        return updateNo;
    }

    public void setUpdateNo(Integer updateNo) {
        this.updateNo = updateNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DdrdUserEntity that = (DdrdUserEntity) o;

        if (userNo != that.userNo) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userPhoneNumber != null ? !userPhoneNumber.equals(that.userPhoneNumber) : that.userPhoneNumber != null)
            return false;
        if (userGender != null ? !userGender.equals(that.userGender) : that.userGender != null) return false;
        if (joinDate != null ? !joinDate.equals(that.joinDate) : that.joinDate != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (userLevel != null ? !userLevel.equals(that.userLevel) : that.userLevel != null) return false;
        if (userRank != null ? !userRank.equals(that.userRank) : that.userRank != null) return false;
        if (userAddress != null ? !userAddress.equals(that.userAddress) : that.userAddress != null) return false;
        if (finalDate != null ? !finalDate.equals(that.finalDate) : that.finalDate != null) return false;
        if (delYn != null ? !delYn.equals(that.delYn) : that.delYn != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (updateNo != null ? !updateNo.equals(that.updateNo) : that.updateNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userNo;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPhoneNumber != null ? userPhoneNumber.hashCode() : 0);
        result = 31 * result + (userGender != null ? userGender.hashCode() : 0);
        result = 31 * result + (joinDate != null ? joinDate.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (userLevel != null ? userLevel.hashCode() : 0);
        result = 31 * result + (userRank != null ? userRank.hashCode() : 0);
        result = 31 * result + (userAddress != null ? userAddress.hashCode() : 0);
        result = 31 * result + (finalDate != null ? finalDate.hashCode() : 0);
        result = 31 * result + (delYn != null ? delYn.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (updateNo != null ? updateNo.hashCode() : 0);
        return result;
    }
}
