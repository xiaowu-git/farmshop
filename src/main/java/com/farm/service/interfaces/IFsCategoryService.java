package com.farm.service.interfaces;

import com.farm.bean.FsCategory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhongjh
 * Date: 2019/4/13 0013
 * Time: 10:30
 * To change this template use File | Settings | File Templates.
 * Description:
 */

public interface IFsCategoryService {

    /**
     * 1.获取所有行情信息
     * @return
     */
    List<FsCategory> getAllFsCategory();

    List<FsCategory> getAllChildFsCategory();

    FsCategory getFsCategoryById(Integer FsCategoryId);

    FsCategory getFsCategoryBySeq(Integer fsCategorySeg);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(FsCategory record);

    int insertSelective(FsCategory record);

    FsCategory selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(FsCategory record);

    int updateByPrimaryKey(FsCategory record);

    List<FsCategory> selectAllFsCategory();

    List<FsCategory> selectAllChildFsCategory();
}
