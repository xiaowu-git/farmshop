package com.farm.dao;

import com.farm.bean.FsMarketinfo;

import java.util.List;

public interface FsMarketinfoMapper {
    int deleteByPrimaryKey(Integer marketinfoId);

    int insert(FsMarketinfo record);

    int insertSelective(FsMarketinfo record);

    FsMarketinfo selectByPrimaryKey(Integer marketinfoId);

    int updateByPrimaryKeySelective(FsMarketinfo record);

    int updateByPrimaryKey(FsMarketinfo record);

    List<FsMarketinfo> selectAllFsMarketinfo();

    List<FsMarketinfo> selectFsMarketinfoByName(String marketinfoName);

    int saveFsMarketinfoBProduct();
}