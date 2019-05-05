package com.farm.bean;

import java.util.Date;

public class FsProcurementProducts {
    private Integer procurementProdId;

    private Integer userId;

    private String procurementProdName;

    private String procurementProdPrice;

    private String procurementProdNum;

    private String procurementProdPicture;

    private String procurementProdInfo;

    private Integer categoryId;

    private String procurementProdAddress;

    private Integer procurementProdState;

    private Date createTime;

    private Date effectiveTime;

    private Date expirationTime;

    private String isDeleted;

    public Integer getProcurementProdId() {
        return procurementProdId;
    }

    public void setProcurementProdId(Integer procurementProdId) {
        this.procurementProdId = procurementProdId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProcurementProdName() {
        return procurementProdName;
    }

    public void setProcurementProdName(String procurementProdName) {
        this.procurementProdName = procurementProdName == null ? null : procurementProdName.trim();
    }

    public String getProcurementProdPrice() {
        return procurementProdPrice;
    }

    public void setProcurementProdPrice(String procurementProdPrice) {
        this.procurementProdPrice = procurementProdPrice == null ? null : procurementProdPrice.trim();
    }

    public String getProcurementProdNum() {
        return procurementProdNum;
    }

    public void setProcurementProdNum(String procurementProdNum) {
        this.procurementProdNum = procurementProdNum == null ? null : procurementProdNum.trim();
    }

    public String getProcurementProdPicture() {
        return procurementProdPicture;
    }

    public void setProcurementProdPicture(String procurementProdPicture) {
        this.procurementProdPicture = procurementProdPicture == null ? null : procurementProdPicture.trim();
    }

    public String getProcurementProdInfo() {
        return procurementProdInfo;
    }

    public void setProcurementProdInfo(String procurementProdInfo) {
        this.procurementProdInfo = procurementProdInfo == null ? null : procurementProdInfo.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getProcurementProdAddress() {
        return procurementProdAddress;
    }

    public void setProcurementProdAddress(String procurementProdAddress) {
        this.procurementProdAddress = procurementProdAddress == null ? null : procurementProdAddress.trim();
    }

    public Integer getProcurementProdState() {
        return procurementProdState;
    }

    public void setProcurementProdState(Integer procurementProdState) {
        this.procurementProdState = procurementProdState;
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