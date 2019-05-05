package com.farm.service.interfaces;

import com.farm.bean.FsAccount;

public interface IFsAccountService {

    int deleteByPrimaryKey(Integer accountId);

    int insert(FsAccount record);

    int insertSelective(FsAccount record);

    FsAccount selectByPrimaryKey(Integer accountId);

    int updateByPrimaryKeySelective(FsAccount record);

    int updateByPrimaryKey(FsAccount record);
}
