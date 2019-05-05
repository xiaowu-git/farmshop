package com.farm.service.impl;

import com.farm.bean.FsUser;
import com.farm.dao.FsUserMapper;
import com.farm.service.interfaces.IFsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FsUserServiceImpl implements IFsUserService {

    @Autowired
    private FsUserMapper fsUserMapper;
    @Override
    public List<FsUser> getAllFsUser() {
        return fsUserMapper.selectAllFsUser();
    }

    @Override
    public Integer getUserCount() {
        return fsUserMapper.selectUserCount();
    }

    @Override
    public List<FsUser> selectByUserPhone(String userPhone) {
        List<FsUser> fsUsers = fsUserMapper.selectByUserPhone(userPhone);
        return fsUsers;
    }

    @Override
    public boolean login(String username) {
        return false;
    }

    @Override
    public FsUser getUserByName(String username) {
        return null;
    }

    public FsUser getUserById(Integer userId){
        return fsUserMapper.selectByPrimaryKey(userId);
    }

    public boolean updateUser(FsUser fsUser){
        int sum = fsUserMapper.updateByPrimaryKeySelective(fsUser);
        if(sum>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean register(String userPhone,String userName,String userPassword){
        FsUser fsUser = new FsUser();
        fsUser.setUserPhone(userPhone);
        fsUser.setUserName(userName);
        fsUser.setUserPassword(userPassword);
        fsUser.setUserCategory("1");
        fsUser.setUserCreateTime(new Date());
        int sum = fsUserMapper.insertSelective(fsUser);
        if(sum>0){
          return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean removeUser(Integer id) {
        return false;
    }

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        int deleteNum = fsUserMapper.deleteByPrimaryKey(userId);
        return deleteNum;
    }

    @Override
    public int insert(FsUser fsUser) {
        int insertNum = fsUserMapper.insert(fsUser);
        return insertNum;
    }

    @Override
    public int insertSelective(FsUser fsUser) {
        int insertNum = fsUserMapper.insertSelective(fsUser);
        return insertNum;
    }

    @Override
    public FsUser selectByPrimaryKey(Integer userId) {
        FsUser fsUser = fsUserMapper.selectByPrimaryKey(userId);
        return fsUser;
    }

    @Override
    public int updateByPrimaryKeySelective(FsUser fsUser) {
        int updateNum = fsUserMapper.updateByPrimaryKeySelective(fsUser);
        return updateNum;
    }

    @Override
    public int updateByPrimaryKey(FsUser fsUser) {
        int updateNum = fsUserMapper.updateByPrimaryKey(fsUser);
        return updateNum;
    }
}
