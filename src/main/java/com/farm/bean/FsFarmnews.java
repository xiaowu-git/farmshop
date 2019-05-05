package com.farm.bean;

import java.util.Date;

public class FsFarmnews {
    private Integer farmnewsId;

    private Integer userId;

    private String farmnewsName;

    private Integer categoryId;

    private String farmnewsTitle;

    private String farmnewsPicture;

    private String farmnewsInfo1;

    private String farmnewsInfo2;

    private Integer farmnewsState;

    private Date createTime;

    private Date effectiveTime;

    private Date expirationTime;

    private String isDeleted;

    public Integer getFarmnewsId() {
        return farmnewsId;
    }

    public void setFarmnewsId(Integer farmnewsId) {
        this.farmnewsId = farmnewsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFarmnewsName() {
        return farmnewsName;
    }

    public void setFarmnewsName(String farmnewsName) {
        this.farmnewsName = farmnewsName == null ? null : farmnewsName.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getFarmnewsTitle() {
        return farmnewsTitle;
    }

    public void setFarmnewsTitle(String farmnewsTitle) {
        this.farmnewsTitle = farmnewsTitle == null ? null : farmnewsTitle.trim();
    }

    public String getFarmnewsPicture() {
        return farmnewsPicture;
    }

    public void setFarmnewsPicture(String farmnewsPicture) {
        this.farmnewsPicture = farmnewsPicture == null ? null : farmnewsPicture.trim();
    }

    public String getFarmnewsInfo1() {
        return farmnewsInfo1;
    }

    public void setFarmnewsInfo1(String farmnewsInfo1) {
        this.farmnewsInfo1 = farmnewsInfo1 == null ? null : farmnewsInfo1.trim();
    }

    public String getFarmnewsInfo2() {
        return farmnewsInfo2;
    }

    public void setFarmnewsInfo2(String farmnewsInfo2) {
        this.farmnewsInfo2 = farmnewsInfo2 == null ? null : farmnewsInfo2.trim();
    }

    public Integer getFarmnewsState() {
        return farmnewsState;
    }

    public void setFarmnewsState(Integer farmnewsState) {
        this.farmnewsState = farmnewsState;
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