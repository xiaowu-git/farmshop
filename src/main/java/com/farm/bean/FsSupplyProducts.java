package com.farm.bean;

import java.util.Date;

public class FsSupplyProducts {
    private Integer supplyProdId;

    private Integer userId;

    private String supplyProdName;

    private String supplyProdPrice;

    private String supplyProdNum;

    private String supplyProdPicture;

    private String supplyProdInfo;

    private Integer categoryId;

    private String supplyProdAddress;

    private Integer supplyProdState;

    private Date createTime;

    private Date effectiveTime;

    private Date expirationTime;

    private String isDeleted;

    public Integer getSupplyProdId() {
        return supplyProdId;
    }

    public void setSupplyProdId(Integer supplyProdId) {
        this.supplyProdId = supplyProdId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSupplyProdName() {
        return supplyProdName;
    }

    public void setSupplyProdName(String supplyProdName) {
        this.supplyProdName = supplyProdName == null ? null : supplyProdName.trim();
    }

    public String getSupplyProdPrice() {
        return supplyProdPrice;
    }

    public void setSupplyProdPrice(String supplyProdPrice) {
        this.supplyProdPrice = supplyProdPrice == null ? null : supplyProdPrice.trim();
    }

    public String getSupplyProdNum() {
        return supplyProdNum;
    }

    public void setSupplyProdNum(String supplyProdNum) {
        this.supplyProdNum = supplyProdNum == null ? null : supplyProdNum.trim();
    }

    public String getSupplyProdPicture() {
        return supplyProdPicture;
    }

    public void setSupplyProdPicture(String supplyProdPicture) {
        this.supplyProdPicture = supplyProdPicture == null ? null : supplyProdPicture.trim();
    }

    public String getSupplyProdInfo() {
        return supplyProdInfo;
    }

    public void setSupplyProdInfo(String supplyProdInfo) {
        this.supplyProdInfo = supplyProdInfo == null ? null : supplyProdInfo.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getSupplyProdAddress() {
        return supplyProdAddress;
    }

    public void setSupplyProdAddress(String supplyProdAddress) {
        this.supplyProdAddress = supplyProdAddress == null ? null : supplyProdAddress.trim();
    }

    public Integer getSupplyProdState() {
        return supplyProdState;
    }

    public void setSupplyProdState(Integer supplyProdState) {
        this.supplyProdState = supplyProdState;
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