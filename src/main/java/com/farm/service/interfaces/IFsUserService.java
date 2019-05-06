package com.farm.service.interfaces;

import com.farm.bean.FsUser;
import com.farm.exception.BusinessException;

import java.util.List;

/**
 * 用户相关业务逻辑接口
 * Created by zhongjh on 2018/4/28.
 */
public interface IFsUserService {

    /**
     * 4.获取所有用户
     * @return
     */
    List<FsUser> getAllFsUser();

    /**
     * 8.获取用户数量
     * @return
     */
    Integer getUserCount();

    /**
     * 6.通过手机号查询用户(手机号码)
     * @param userPhone
     * @return
     */
    List<FsUser> selectByUserPhone(String userPhone) throws BusinessException;


    /**
     * 1.用户登录(客户端验证码)
     * @param username
     * @return
     */
    boolean login(String username);

    /**
     * 2.根据用户名(手机号)获取信息
     * @param username
     * @return
     */
    FsUser getUserByName(String username) throws BusinessException;

    FsUser getUserById(Integer userId);

    boolean updateUser(FsUser fsUser);

    /**
     * 3.用户注册(手机号)
     * @param userName
     * @return
     */
    boolean register(String userPhone, String userName, String userPassword) throws BusinessException;



    /**
     * 5.删除某个用户
     * @param id
     * @return
     */
    boolean removeUser(Integer id);

    int deleteByPrimaryKey(Integer userId);

    int insert(FsUser fsUser);

    int insertSelective(FsUser fsUser);

    FsUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(FsUser fsUser);

    int updateByPrimaryKey(FsUser fsUser);




}
