package com.farm.service.interfaces;

import com.farm.bean.FsFarmStudy;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhongjh
 * Date: 2019/4/18 0018
 * Time: 1:13
 * To change this template use File | Settings | File Templates.
 * Description:
 */

public interface IFsFarmStudyService {

    List<FsFarmStudy> getAllFarmStudy();

    FsFarmStudy getFarmStudyById(Integer farmstudyId);

    List<FsFarmStudy>  getFsFarmnewsByName(String farmstudyName);

    int insertSelective(FsFarmStudy record);

    int updateByPrimaryKeySelective(FsFarmStudy record);

}
