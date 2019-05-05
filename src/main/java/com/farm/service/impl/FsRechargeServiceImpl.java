package com.farm.service.impl;

import com.farm.bean.FsRecharge;
import com.farm.dao.FsRechargeMapper;
import com.farm.service.interfaces.IFsRechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FsRechargeServiceImpl implements IFsRechargeService {

    @Autowired
    private FsRechargeMapper fsRechargeMapper;

    @Override
    public int deleteByPrimaryKey(Integer rechargeId) {
        int deleteNum = fsRechargeMapper.deleteByPrimaryKey(rechargeId);
        return deleteNum;
    }

    @Override
    public int insert(FsRecharge record) {
        int insertNum = fsRechargeMapper.insert(record);
        return insertNum;
    }

    @Override
    public int insertSelective(FsRecharge record) {
        int insertNum = fsRechargeMapper.insertSelective(record);
        return insertNum;
    }

    @Override
    public FsRecharge selectByPrimaryKey(Integer rechargeId) {
        FsRecharge fsRecharge = fsRechargeMapper.selectByPrimaryKey(rechargeId);
        return fsRecharge;
    }

    @Override
    public int updateByPrimaryKeySelective(FsRecharge record) {
        int updateNum = fsRechargeMapper.updateByPrimaryKeySelective(record);
        return updateNum;
    }

    @Override
    public int updateByPrimaryKey(FsRecharge record) {
        int updateNum = fsRechargeMapper.updateByPrimaryKey(record);
        return updateNum;
    }
}
