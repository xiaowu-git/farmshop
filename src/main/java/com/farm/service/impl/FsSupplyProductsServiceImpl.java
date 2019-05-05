package com.farm.service.impl;

import com.farm.bean.FsSupplyProducts;
import com.farm.dao.FsSupplyProductsMapper;
import com.farm.service.interfaces.IFsSupplyProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FsSupplyProductsServiceImpl implements IFsSupplyProductsService {

    @Autowired
    private FsSupplyProductsMapper fsSupplyProductsMapper;

    @Override
    public List<FsSupplyProducts> getFsSupplyProducts() {
        List<FsSupplyProducts> fsSupplyProducts = fsSupplyProductsMapper.selectAllFsSupplyProducts();
        return fsSupplyProducts;
    }

    @Override
    public List<FsSupplyProducts> getFsSupplyByFruits() {
        return fsSupplyProductsMapper.selectFsSupplyByFruits();
    }

    @Override
    public List<FsSupplyProducts> getFsSupplyByVegetables() {
        return fsSupplyProductsMapper.selectFsSupplyByVegetables();
    }

    @Override
    public Integer getSupplyProductsCount() {
        Integer fsSupplyProductsNum = fsSupplyProductsMapper.selectFsSupplyProductsNum();
        return fsSupplyProductsNum;
    }

    @Override
    public FsSupplyProducts getFsSupplyProductById(Integer supplyProdId) {
        FsSupplyProducts fsSupplyProducts = fsSupplyProductsMapper.selectByPrimaryKey(supplyProdId);
        return fsSupplyProducts;
    }

    @Override
    public List<FsSupplyProducts> getFsSupplyProductsByName(String supplyProdCategory){
        return fsSupplyProductsMapper.getFsSupplyProductsByName(supplyProdCategory);
    }

    @Override
    public int updateFsSupplyProducts(FsSupplyProducts fsSupplyProducts) {
        return fsSupplyProductsMapper.updateByPrimaryKeySelective(fsSupplyProducts);
    }

    @Override
    public boolean addFsSupplyProducts(FsSupplyProducts fsSupplyProducts) {
        int num = fsSupplyProductsMapper.insertSelective(fsSupplyProducts);
        if(num>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int deleteByPrimaryKey(Integer supplyProdId) {
        int deleteNum = fsSupplyProductsMapper.deleteByPrimaryKey(supplyProdId);
        return deleteNum;
    }

    @Override
    public int insert(FsSupplyProducts record) {
        int insertNum = fsSupplyProductsMapper.insert(record);
        return insertNum;
    }

    @Override
    public int insertSelective(FsSupplyProducts record) {
        int insertNum = fsSupplyProductsMapper.insertSelective(record);
        return insertNum;
    }

    @Override
    public FsSupplyProducts selectByPrimaryKey(Integer supplyProdId) {
        FsSupplyProducts fsSupplyProducts = fsSupplyProductsMapper.selectByPrimaryKey(supplyProdId);
        return fsSupplyProducts;
    }

    @Override
    public int updateByPrimaryKeySelective(FsSupplyProducts record) {
        int updateNum = fsSupplyProductsMapper.updateByPrimaryKeySelective(record);
        return updateNum;
    }

    @Override
    public int updateByPrimaryKey(FsSupplyProducts record) {
        int updateNum = fsSupplyProductsMapper.updateByPrimaryKey(record);
        return updateNum;
    }

    @Override
    public List<FsSupplyProducts> getAllFsSupply() {
        List<FsSupplyProducts> fsSupplyProducts = fsSupplyProductsMapper.selectAllFsSupply();
        return fsSupplyProducts;
    }

    @Override
    public List<FsSupplyProducts> getFsSupplyProductsByState(Integer state) {
        return fsSupplyProductsMapper.getFsSupplyProductsByState(state);
    }

    @Override
    public List<FsSupplyProducts> getFsSupplyProductByUserId(Integer userId) {
        return fsSupplyProductsMapper.getFsSupplyProductByUserId(userId);
    }


}
