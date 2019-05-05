package com.farm.service.interfaces;


import com.farm.bean.FsMarketinfo;

import java.util.List;

public interface IFsMarketInfoService {

    /**
     * 1.获取所有行情信息
     * @return
     */
    List<FsMarketinfo> getAllFsMarketinfo();

    FsMarketinfo getFsMarketinfoById(Integer marketinfoId);

    int deleteByPrimaryKey(Integer marketinfoId);

    int insert(FsMarketinfo record);

    int insertSelective(FsMarketinfo record);

    FsMarketinfo selectByPrimaryKey(Integer marketinfoId);

    int updateByPrimaryKeySelective(FsMarketinfo record);

    int updateByPrimaryKey(FsMarketinfo record);

    List<FsMarketinfo> getFsMarketinfoByName(String marketinfoName);

    List<FsMarketinfo> getAll();

    int saveFsMarketinfoBProduct();

}
