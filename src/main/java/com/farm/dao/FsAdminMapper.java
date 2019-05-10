package com.farm.dao;

import com.farm.bean.FsAdmin;

import java.util.List;

public interface FsAdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(FsAdmin record);

    int insertSelective(FsAdmin record);

    FsAdmin selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(FsAdmin record);

    int updateByPrimaryKey(FsAdmin record);

    List<FsAdmin> selectAllFsAdmin();

    List<FsAdmin> getFsAdminByNameLike(String name);

    FsAdmin selectAdminByPhone(String adminPhone);

    FsAdmin selectAdminByName(String adminName);
}