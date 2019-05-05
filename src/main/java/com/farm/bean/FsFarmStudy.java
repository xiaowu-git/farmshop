package com.farm.bean;

import java.util.Date;

public class FsFarmStudy {
    private Integer farmstudyId;

    private Integer adminId;

    private String farmstudyName;

    private Integer studylistId;

    private String farmstudyTitle;

    private String farmstudyPicture;

    private String farmstudyInfo1;

    private String farmstudyInfo2;

    private Integer farmstudyState;

    private Date createTime;

    private Date effectiveTime;

    private Date expirationTime;

    private String isDeleted;

    public Integer getFarmstudyId() {
        return farmstudyId;
    }

    public void setFarmstudyId(Integer farmstudyId) {
        this.farmstudyId = farmstudyId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getFarmstudyName() {
        return farmstudyName;
    }

    public void setFarmstudyName(String farmstudyName) {
        this.farmstudyName = farmstudyName == null ? null : farmstudyName.trim();
    }

    public Integer getStudylistId() {
        return studylistId;
    }

    public void setStudylistId(Integer studylistId) {
        this.studylistId = studylistId;
    }

    public String getFarmstudyTitle() {
        return farmstudyTitle;
    }

    public void setFarmstudyTitle(String farmstudyTitle) {
        this.farmstudyTitle = farmstudyTitle == null ? null : farmstudyTitle.trim();
    }

    public String getFarmstudyPicture() {
        return farmstudyPicture;
    }

    public void setFarmstudyPicture(String farmstudyPicture) {
        this.farmstudyPicture = farmstudyPicture == null ? null : farmstudyPicture.trim();
    }

    public String getFarmstudyInfo1() {
        return farmstudyInfo1;
    }

    public void setFarmstudyInfo1(String farmstudyInfo1) {
        this.farmstudyInfo1 = farmstudyInfo1 == null ? null : farmstudyInfo1.trim();
    }

    public String getFarmstudyInfo2() {
        return farmstudyInfo2;
    }

    public void setFarmstudyInfo2(String farmstudyInfo2) {
        this.farmstudyInfo2 = farmstudyInfo2 == null ? null : farmstudyInfo2.trim();
    }

    public Integer getFarmstudyState() {
        return farmstudyState;
    }

    public void setFarmstudyState(Integer farmstudyState) {
        this.farmstudyState = farmstudyState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }
}