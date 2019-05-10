package com.farm.dao;

import com.farm.bean.FsUser;

import java.util.List;

public interface FsUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(FsUser fsUser);

    int insertSelective(FsUser fsUser);

    FsUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(FsUser fsUser);

    int updateByPrimaryKey(FsUser fsUser);

    List<FsUser> selectByUserPhone(String userPhone);

    List<FsUser> selectAllFsUser();

    Integer selectUserCount();

    FsUser selectByUserName(String username);

    List<FsUser> selectUsersByName(String username);
}