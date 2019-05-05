package com.farm.dao;

import com.farm.bean.FsOrderUser;

import java.util.List;

public interface FsOrderUserMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(FsOrderUser record);

    int insertSelective(FsOrderUser record);

    FsOrderUser selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(FsOrderUser record);

    int updateByPrimaryKey(FsOrderUser record);

    List<FsOrderUser> getOrderUser();

    List<FsOrderUser> getOrderUserByUser(Integer userId);

    List<FsOrderUser> getOrderUserBySeller(Integer sellerId);

    List<FsOrderUser> getOrderUserChangeByUser(Integer userId);

    List<FsOrderUser> selectAllOrder();

    List<FsOrderUser> getFsOrderUserByorderNumber(String orderNumber);


}