package com.farm.service.interfaces;

import com.farm.bean.FsOrderUser;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhongjh
 * Date: 2019/4/6 0006
 * Time: 14:09
 * To change this template use File | Settings | File Templates.
 * Description:
 */

public interface IFsOrderUserService {

    /**
     * 1.添加订单记录
     * @return
     */
    boolean addOrder(FsOrderUser fsOrderUser);

    /**
     * 2.按照id删除订单记录
     * @param orderId
     * @return
     */
    void removeOrder(Integer orderId);

    /**
     * 3.获取所有订单记录
     * @return
     */
    List<FsOrderUser> getAllOrder();

    /**
     * 4.根据id查询订单记录
     * @return
     */
    FsOrderUser getOrderById(Integer orderId);

    List<FsOrderUser> getOrderByUser(Integer userId);

    List<FsOrderUser> getOrderBySeller(Integer userId);

    List<FsOrderUser> getOrderUserChangeByUser(Integer userId);

    List<FsOrderUser> getFsOrderUserByorderNumber(String orderNumber);

    int deleteByPrimaryKey(Integer orderId);

    int insert(FsOrderUser record);

    int insertSelective(FsOrderUser record);

    FsOrderUser selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(FsOrderUser record);

    int updateByPrimaryKey(FsOrderUser record);

    List<FsOrderUser> getOrderUser();

    List<FsOrderUser> getOrderUserByUser(Integer userId);

}
