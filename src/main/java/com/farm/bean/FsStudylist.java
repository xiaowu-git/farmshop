package com.farm.bean;

import java.util.Date;

public class FsStudylist {
    private Integer studylistId;

    private String studylistName;

    private Integer parentId;

    private Integer studylistSeq;

    private Integer studylistState;

    private Date createTime;

    private String studylist1ogo;

    private String isDeleted;

    public Integer getStudylistId() {
        return studylistId;
    }

    public void setStudylistId(Integer studylistId) {
        this.studylistId = studylistId;
    }

    public String getStudylistName() {
        return studylistName;
    }

    public void setStudylistName(String studylistName) {
        this.studylistName = studylistName == null ? null : studylistName.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getStudylistSeq() {
        return studylistSeq;
    }

    public void setStudylistSeq(Integer studylistSeq) {
        this.studylistSeq = studylistSeq;
    }

    public Integer getStudylistState() {
        return studylistState;
    }

    public void setStudylistState(Integer studylistState) {
        this.studylistState = studylistState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStudylist1ogo() {
        return studylist1ogo;
    }

    public void setStudylist1ogo(String studylist1ogo) {
        this.studylist1ogo = studylist1ogo == null ? null : studylist1ogo.trim();
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }
}