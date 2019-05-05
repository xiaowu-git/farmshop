package com.farm.bean;

import java.util.Date;

public class FsCategory {
    private Integer categoryId;

    private String categoryName;

    private Integer parentId;

    private Integer categorySeq;

    private Integer categoryState;

    private Date createTime;

    private String category1ogo;

    private String isDeleted;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getCategorySeq() {
        return categorySeq;
    }

    public void setCategorySeq(Integer categorySeq) {
        this.categorySeq = categorySeq;
    }

    public Integer getCategoryState() {
        return categoryState;
    }

    public void setCategoryState(Integer categoryState) {
        this.categoryState = categoryState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCategory1ogo() {
        return category1ogo;
    }

    public void setCategory1ogo(String category1ogo) {
        this.category1ogo = category1ogo == null ? null : category1ogo.trim();
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }
}