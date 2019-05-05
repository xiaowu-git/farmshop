package com.farm.bean;

import java.util.Date;

public class FsMarketinfo {
    private Integer marketinfoId;

    private String marketinfoName;

    private String marketinfoAddress;

    private String marketinfoProdPrice;

    private String marketinfoInfo;

    private Integer marketinfoState;

    private Date createTime;

    private Date effectiveTime;

    private Date expirationTime;

    private String isDeleted;

    public Integer getMarketinfoId() {
        return marketinfoId;
    }

    public void setMarketinfoId(Integer marketinfoId) {
        this.marketinfoId = marketinfoId;
    }

    public String getMarketinfoName() {
        return marketinfoName;
    }

    public void setMarketinfoName(String marketinfoName) {
        this.marketinfoName = marketinfoName == null ? null : marketinfoName.trim();
    }

    public String getMarketinfoAddress() {
        return marketinfoAddress;
    }

    public void setMarketinfoAddress(String marketinfoAddress) {
        this.marketinfoAddress = marketinfoAddress == null ? null : marketinfoAddress.trim();
    }

    public String getMarketinfoProdPrice() {
        return marketinfoProdPrice;
    }

    public void setMarketinfoProdPrice(String marketinfoProdPrice) {
        this.marketinfoProdPrice = marketinfoProdPrice == null ? null : marketinfoProdPrice.trim();
    }

    public String getMarketinfoInfo() {
        return marketinfoInfo;
    }

    public void setMarketinfoInfo(String marketinfoInfo) {
        this.marketinfoInfo = marketinfoInfo == null ? null : marketinfoInfo.trim();
    }

    public Integer getMarketinfoState() {
        return marketinfoState;
    }

    public void setMarketinfoState(Integer marketinfoState) {
        this.marketinfoState = marketinfoState;
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