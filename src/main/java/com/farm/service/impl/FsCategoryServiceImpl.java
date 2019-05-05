package com.farm.service.impl;

import com.farm.bean.FsCategory;
import com.farm.dao.FsCategoryMapper;
import com.farm.service.interfaces.IFsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FsCategoryServiceImpl implements IFsCategoryService {
    @Autowired
    private FsCategoryMapper fsCategoryMapper;

    @Override
    public List<FsCategory> getAllFsCategory() {
        return fsCategoryMapper.selectAllFsCategory();
    }

    @Override
    public List<FsCategory> getAllChildFsCategory() {
        return fsCategoryMapper.selectAllChildFsCategory();
    }

    @Override
    public FsCategory getFsCategoryById(Integer FsCategoryId) {
        return fsCategoryMapper.selectByPrimaryKey(FsCategoryId);
    }

    @Override
    public FsCategory getFsCategoryBySeq(Integer fsCategorySeg) {
        return fsCategoryMapper.selectFsCategoryBySeq(fsCategorySeg);
    }

    @Override
    public int deleteByPrimaryKey(Integer categoryId) {
        int deleteNum = fsCategoryMapper.deleteByPrimaryKey(categoryId);
        return deleteNum;
    }

    @Override
    public int insert(FsCategory record) {
        int insertNum = fsCategoryMapper.insert(record);
        return insertNum;
    }

    @Override
    public int insertSelective(FsCategory record) {
        int insetNum = fsCategoryMapper.insertSelective(record);
        return insetNum;
    }

    @Override
    public FsCategory selectByPrimaryKey(Integer categoryId) {
        FsCategory fsCategory = fsCategoryMapper.selectByPrimaryKey(categoryId);
        return fsCategory;
    }

    @Override
    public int updateByPrimaryKeySelective(FsCategory record) {
        int updateNum = fsCategoryMapper.updateByPrimaryKeySelective(record);
        return updateNum;
    }

    @Override
    public int updateByPrimaryKey(FsCategory record) {
        int updateNum = fsCategoryMapper.updateByPrimaryKey(record);
        return updateNum;
    }

    @Override
    public List<FsCategory> selectAllFsCategory() {
        List<FsCategory> fsCategories = fsCategoryMapper.selectAllFsCategory();
        return fsCategories;
    }

    @Override
    public List<FsCategory> selectAllChildFsCategory() {
        List<FsCategory> childFsCategories = fsCategoryMapper.selectAllChildFsCategory();
        return childFsCategories;
    }
}
