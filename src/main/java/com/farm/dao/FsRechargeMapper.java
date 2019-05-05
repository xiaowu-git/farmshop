package com.farm.dao;

import com.farm.bean.FsRecharge;

public interface FsRechargeMapper {
    int deleteByPrimaryKey(Integer rechargeId);

    int insert(FsRecharge record);

    int insertSelective(FsRecharge record);

    FsRecharge selectByPrimaryKey(Integer rechargeId);

    int updateByPrimaryKeySelective(FsRecharge record);

    int updateByPrimaryKey(FsRecharge record);
}