package com.farm.dao;

import com.farm.bean.FsFarmnews;

import java.util.List;

public interface FsFarmnewsMapper {
    int deleteByPrimaryKey(Integer farmnewsId);

    int insert(FsFarmnews record);

    int insertSelective(FsFarmnews record);

    FsFarmnews selectByPrimaryKey(Integer farmnewsId);

    int updateByPrimaryKeySelective(FsFarmnews record);

    int updateByPrimaryKey(FsFarmnews record);

    List<FsFarmnews> selectAllFsFarmnews();

    List<FsFarmnews> selectFsFarmnewsByName(String farmnewsName);

}