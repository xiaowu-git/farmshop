package com.farm.service.impl;

import com.farm.bean.FsMarketinfo;
import com.farm.dao.FsMarketinfoMapper;
import com.farm.service.interfaces.IFsMarketInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FsMarketInfoServiceImpl implements IFsMarketInfoService {

    @Autowired
    private FsMarketinfoMapper fsMarketinfoMapper;

    @Override
    public List<FsMarketinfo> getAllFsMarketinfo() {
        return fsMarketinfoMapper.selectAllFsMarketinfo();
    }

    @Override
    public FsMarketinfo getFsMarketinfoById(Integer marketinfoId) {
        return fsMarketinfoMapper.selectByPrimaryKey(marketinfoId);
    }

    @Override
    public int deleteByPrimaryKey(Integer marketinfoId) {
        int deleteNum = fsMarketinfoMapper.deleteByPrimaryKey(marketinfoId);
        return deleteNum;
    }

    @Override
    public int insert(FsMarketinfo record) {
        int insertNum = fsMarketinfoMapper.insert(record);
        return insertNum;
    }

    @Override
    public int insertSelective(FsMarketinfo record) {
        int insertNum = fsMarketinfoMapper.insertSelective(record);
        return insertNum;
    }

    @Override
    public FsMarketinfo selectByPrimaryKey(Integer marketinfoId) {
        FsMarketinfo fsMarketinfo = fsMarketinfoMapper.selectByPrimaryKey(marketinfoId);
        return fsMarketinfo;
    }

    @Override
    public int updateByPrimaryKeySelective(FsMarketinfo record) {
        int updateNum = fsMarketinfoMapper.updateByPrimaryKeySelective(record);
        return updateNum;
    }

    @Override
    public int updateByPrimaryKey(FsMarketinfo record) {
        int updateNum = fsMarketinfoMapper.updateByPrimaryKey(record);
        return updateNum;
    }

    @Override
    public List<FsMarketinfo> getFsMarketinfoByName(String marketinfoName) {
        List<FsMarketinfo> fsMarketinfos = fsMarketinfoMapper.selectFsMarketinfoByName(marketinfoName);
        return fsMarketinfos;
    }

    @Override
    public List<FsMarketinfo> getAll() {
        return null;
    }

    @Override
    public int saveFsMarketinfoBProduct() {
        return fsMarketinfoMapper.saveFsMarketinfoBProduct();
    }


}
