package com.farm.dao;

import com.farm.bean.FsCategory;

import java.util.List;

public interface FsCategoryMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(FsCategory record);

    int insertSelective(FsCategory record);

    FsCategory selectByPrimaryKey(Integer categoryId);
    FsCategory selectFsCategoryBySeq(Integer categorySeq);


    int updateByPrimaryKeySelective(FsCategory record);

    int updateByPrimaryKey(FsCategory record);

    List<FsCategory> selectAllFsCategory();

    List<FsCategory> selectAllChildFsCategory();
}