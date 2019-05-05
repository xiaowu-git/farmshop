package com.farm.dao;

import com.farm.bean.FsFarmStudy;

import java.util.List;

public interface FsFarmStudyMapper {
    int deleteByPrimaryKey(Integer farmstudyId);

    int insert(FsFarmStudy record);

    int insertSelective(FsFarmStudy record);

    FsFarmStudy selectByPrimaryKey(Integer farmstudyId);

    int updateByPrimaryKeySelective(FsFarmStudy record);

    int updateByPrimaryKey(FsFarmStudy record);

    List<FsFarmStudy> selectAllFarmStudy();

    List<FsFarmStudy> selectFarmStudyByName(String farmstudyName);

}