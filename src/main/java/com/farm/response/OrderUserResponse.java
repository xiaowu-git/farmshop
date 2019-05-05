package com.farm.response;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: zhongjh
 * Date: 2019/4/7 0007
 * Time: 1:20
 * To change this template use File | Settings | File Templates.
 * Description:
 */

public class OrderUserResponse {
    private Integer orderId;

    private String orderNumber;

    private Integer prodId;

    private Integer userId;

    private String userPhone;

    private String sellerId;

    private String sellerPhone;

    private String orderState;

    private String stationStart;

    private String stationEnd;

    private Date createTime;

    private Date payTime;

    private Date receiveTime;

    private Date expirationTime;

    private BigDecimal orderAmount;

    private String orderRemark;

    private String isDeleted;

    private String userName;

    private String prodName;

    private String prodPicture;

    public OrderUserResponse() {
    }

    public OrderUserResponse(Integer orderId, String orderNumber, Integer prodId, Integer userId, String sellerPhone, String orderState, String stationStart, String stationEnd,
                             Date payTime, Date receiveTime, Date expirationTime, BigDecimal orderAmount, String orderRemark,  String prodName, String prodPicture) {
        this.orderId = orderId;
        this.orderNumber = orderNumber;
        this.prodId = prodId;
        this.userId = userId;
        this.sellerPhone = sellerPhone;
        this.orderState = orderState;
        this.stationStart = stationStart;
        this.stationEnd = stationEnd;
        this.payTime = payTime;
        this.receiveTime = receiveTime;
        this.expirationTime = expirationTime;
        this.orderAmount = orderAmount;
        this.orderRemark = orderRemark;
        this.prodName = prodName;
        this.prodPicture = prodPicture;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    public String getSellerPhone() {
        return sellerPhone;
    }

    public void setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone == null ? null : sellerPhone.trim();
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState == null ? null : orderState.trim();
    }

    public String getStationStart() {
        return stationStart;
    }

    public void setStationStart(String stationStart) {
        this.stationStart = stationStart == null ? null : stationStart.trim();
    }

    public String getStationEnd() {
        return stationEnd;
    }

    public void setStationEnd(String stationEnd) {
        this.stationEnd = stationEnd == null ? null : stationEnd.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark == null ? null : orderRemark.trim();
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdPicture() {
        return prodPicture;
    }

    public void setProdPicture(String prodPicture) {
        this.prodPicture = prodPicture;
    }
}
