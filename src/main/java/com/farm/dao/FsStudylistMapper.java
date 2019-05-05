package com.farm.dao;

import com.farm.bean.FsStudylist;

import java.util.List;

public interface FsStudylistMapper {
    int deleteByPrimaryKey(Integer studylistId);

    int insert(FsStudylist record);

    int insertSelective(FsStudylist record);

    FsStudylist selectByPrimaryKey(Integer studylistId);
    FsStudylist selectStudyListBySeq(Integer studylistSeq);


    int updateByPrimaryKeySelective(FsStudylist record);

    int updateByPrimaryKey(FsStudylist record);

    List<FsStudylist> selectAllFsStudylist();

    List<FsStudylist> selectAllChildFsStudylist();
}