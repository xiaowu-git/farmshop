package com.farm.service.interfaces;

import com.farm.bean.FsFarmnews;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhongjh
 * Date: 2019/4/2 0002
 * Time: 1:21
 * To change this template use File | Settings | File Templates.
 * Description:
 */

public interface IFsFarmnewsService {

    /**
     * 1.获取所有行情信息
     * @return
     */
    List<FsFarmnews> getAllFsFarmnews();

    FsFarmnews getFsFarmnewsById(Integer FarmnewsId);

    int deleteByPrimaryKey(Integer farmnewsId);

    int insert(FsFarmnews record);

    int insertSelective(FsFarmnews record);

    FsFarmnews selectByPrimaryKey(Integer farmnewsId);

    int updateByPrimaryKeySelective(FsFarmnews record);

    int updateByPrimaryKey(FsFarmnews record);

    List<FsFarmnews> getFsFarmnewsByName(String farmnewsName);
}
