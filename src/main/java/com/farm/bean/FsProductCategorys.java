package com.farm.bean;

public class FsProductCategorys {
    private Integer prodCategoryId;

    private String prodCategoryName;

    private String prodState;

    private String isDeleted;

    public Integer getProdCategoryId() {
        return prodCategoryId;
    }

    public void setProdCategoryId(Integer prodCategoryId) {
        this.prodCategoryId = prodCategoryId;
    }

    public String getProdCategoryName() {
        return prodCategoryName;
    }

    public void setProdCategoryName(String prodCategoryName) {
        this.prodCategoryName = prodCategoryName == null ? null : prodCategoryName.trim();
    }

    public String getProdState() {
        return prodState;
    }

    public void setProdState(String prodState) {
        this.prodState = prodState == null ? null : prodState.trim();
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }
}