package com.farm.service.impl;

import com.farm.bean.FsOrderUser;
import com.farm.dao.FsOrderUserMapper;
import com.farm.service.interfaces.IFsOrderUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FsOrderUserServiceImpl implements IFsOrderUserService {
    @Autowired
    private FsOrderUserMapper fsOrderUserMapper;


    @Override
    public boolean addOrder(FsOrderUser fsOrderUser) {
        int num = fsOrderUserMapper.insertSelective(fsOrderUser);
        if(num>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void removeOrder(Integer orderId) {

    }

    @Override
    public List<FsOrderUser> getAllOrder() {
        return fsOrderUserMapper.selectAllOrder();
    }

    @Override
    public FsOrderUser getOrderById(Integer orderId) {
        return  fsOrderUserMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public List<FsOrderUser> getOrderByUser(Integer userId) {
        return fsOrderUserMapper.getOrderUserByUser(userId);
    }

    @Override
    public List<FsOrderUser> getOrderBySeller(Integer userId) {
        return fsOrderUserMapper.getOrderUserBySeller(userId);
    }

    @Override
    public List<FsOrderUser> getOrderUserChangeByUser(Integer userId) {
        return fsOrderUserMapper.getOrderUserChangeByUser(userId);
    }

    @Override
    public List<FsOrderUser> getFsOrderUserByorderNumber(String orderNumber) {
        return fsOrderUserMapper.getFsOrderUserByorderNumber(orderNumber);
    }

    @Override
    public int deleteByPrimaryKey(Integer orderId) {
        int deleteNum = fsOrderUserMapper.deleteByPrimaryKey(orderId);
        return deleteNum;
    }

    @Override
    public int insert(FsOrderUser record) {
        int insertNum = fsOrderUserMapper.insert(record);
        return insertNum;
    }

    @Override
    public int insertSelective(FsOrderUser record) {
        int insertNum = fsOrderUserMapper.insertSelective(record);
        return insertNum;
    }

    @Override
    public FsOrderUser selectByPrimaryKey(Integer orderId) {
        FsOrderUser fsOrderUser = fsOrderUserMapper.selectByPrimaryKey(orderId);
        return fsOrderUser;
    }

    @Override
    public int updateByPrimaryKeySelective(FsOrderUser record) {
        int updateNum = fsOrderUserMapper.updateByPrimaryKeySelective(record);
        return updateNum;
    }

    @Override
    public int updateByPrimaryKey(FsOrderUser record) {
        int updateNum = fsOrderUserMapper.updateByPrimaryKey(record);
        return updateNum;
    }

    @Override
    public List<FsOrderUser> getOrderUser() {
        List<FsOrderUser> fsOrderUsers = fsOrderUserMapper.getOrderUser();
        return fsOrderUsers;
    }

    @Override
    public List<FsOrderUser> getOrderUserByUser(Integer userId) {
        List<FsOrderUser> fsOrderUsers = fsOrderUserMapper.getOrderUserByUser(userId);
        return fsOrderUsers;
    }
}
