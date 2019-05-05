package com.farm.service.impl;

import com.farm.bean.FsAccount;
import com.farm.dao.FsAccountMapper;
import com.farm.service.interfaces.IFsAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FsAccountServiceImpl implements IFsAccountService {

    @Autowired
    private FsAccountMapper fsAccountMapper;

    @Override
    public int deleteByPrimaryKey(Integer accountId) {
        int deleteNum = fsAccountMapper.deleteByPrimaryKey(accountId);
        return deleteNum;
    }

    @Override
    public int insert(FsAccount record) {
        int insertNum = fsAccountMapper.insert(record);
        return insertNum;
    }

    @Override
    public int insertSelective(FsAccount record) {
        int insertNum = fsAccountMapper.insertSelective(record);
        return insertNum;
    }

    @Override
    public FsAccount selectByPrimaryKey(Integer accountId) {
        FsAccount fsAccount = fsAccountMapper.selectByPrimaryKey(accountId);
        return fsAccount;
    }

    @Override
    public int updateByPrimaryKeySelective(FsAccount record) {
        int updateNum = fsAccountMapper.updateByPrimaryKeySelective(record);
        return updateNum;
    }

    @Override
    public int updateByPrimaryKey(FsAccount record) {
        int updateNum = fsAccountMapper.updateByPrimaryKey(record);
        return updateNum;
    }
}
