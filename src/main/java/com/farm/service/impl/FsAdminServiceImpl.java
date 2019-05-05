package com.farm.service.impl;

import com.farm.bean.FsAdmin;
import com.farm.dao.FsAdminMapper;
import com.farm.service.interfaces.IFsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class FsAdminServiceImpl implements IFsAdminService {

    @Autowired
    private FsAdminMapper fsAdminMapper;

    @Override
    public int deleteByPrimaryKey(Integer adminId) {
        int deleteNum = fsAdminMapper.deleteByPrimaryKey(adminId);
        return deleteNum;
    }

    @Override
    public int insert(FsAdmin record) {
        int insertNum = fsAdminMapper.insert(record);
        return insertNum;
    }

    @Override
    public int insertSelective(FsAdmin record) {
        int insertNum = fsAdminMapper.insertSelective(record);
        return insertNum;
    }

    @Override
    public FsAdmin getFsAdminById(Integer adminId) {
        FsAdmin fsAdmin = fsAdminMapper.selectByPrimaryKey(adminId);
        return fsAdmin;
    }

    @Override
    public int updateByPrimaryKeySelective(FsAdmin record) {
        int updateNum = fsAdminMapper.updateByPrimaryKeySelective(record);
        return updateNum;
    }

    @Override
    public int updateByPrimaryKey(FsAdmin record) {
        int updateNum = fsAdminMapper.updateByPrimaryKey(record);
        return updateNum;
    }

    @Override
    public List<FsAdmin> getAllFsAdmin() {
        return fsAdminMapper.selectAllFsAdmin();
    }

    @Override
    public List<FsAdmin> getFsAdminByNameLike(String name) {
        return fsAdminMapper.getFsAdminByNameLike(name);
    }

    @Override
    public int removeFsAdmin(Integer adminId) {
        FsAdmin fsAdmin = fsAdminMapper.selectByPrimaryKey(adminId);
        int updateNum = fsAdminMapper.updateByPrimaryKeySelective(fsAdmin);
        return updateNum;
    }

    @Override
    public FsAdmin getAdminByPhone(String adminPhone) {
        FsAdmin fsAdmin = fsAdminMapper.selectAdminByPhone(adminPhone);
        return fsAdmin;
    }


}
