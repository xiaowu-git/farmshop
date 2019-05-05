package com.farm.service.impl;

import com.farm.bean.FsProcurementProducts;
import com.farm.dao.FsProcurementProductsMapper;
import com.farm.service.interfaces.IFsProcurementProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class FsProcurementProductsServiceImpl implements IFsProcurementProductsService {

    @Autowired
    private FsProcurementProductsMapper fsProcurementProductsMapper;

    @Override
    public List<FsProcurementProducts> getFsProcurementProducts() {
        List<FsProcurementProducts> fsProcurementProductsList = fsProcurementProductsMapper.getFsProcurementProducts();
        return fsProcurementProductsList;
    }

    @Override
    public List<FsProcurementProducts> getAllFsProcurementProducts() {
        return fsProcurementProductsMapper.getAllFsProcurementProducts();
    }

    @Override
    public FsProcurementProducts getFsProcurementProductById(int procurementProductsId) {
        FsProcurementProducts fsProcurementProducts = fsProcurementProductsMapper.selectByPrimaryKey(procurementProductsId);
        return fsProcurementProducts;
    }

    @Override
    public List<FsProcurementProducts> getFsProcurementProductsByName(String procurementProductsName) {
        List<FsProcurementProducts> FsProcurementProductsByNameList = fsProcurementProductsMapper.getFsProcurementProductsByName(procurementProductsName);
        return FsProcurementProductsByNameList;
    }

    @Override
    public boolean addFsProcurementProducts(FsProcurementProducts fsProcurementProducts) {
        int num = fsProcurementProductsMapper.insertSelective(fsProcurementProducts);
        if(num>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int deleteByPrimaryKey(Integer procurementProdId) {
        int deleteNum = fsProcurementProductsMapper.deleteByPrimaryKey(procurementProdId);
        return deleteNum;
    }

    @Override
    public int insert(FsProcurementProducts record) {
        int insertNum = fsProcurementProductsMapper.insert(record);
        return insertNum;
    }

    @Override
    public int insertSelective(FsProcurementProducts record) {
        int insertNum = fsProcurementProductsMapper.insertSelective(record);
        return insertNum;
    }

    @Override
    public FsProcurementProducts selectByPrimaryKey(Integer procurementProdId) {
        FsProcurementProducts fsProcurementProducts = fsProcurementProductsMapper.selectByPrimaryKey(procurementProdId);
        return fsProcurementProducts;
    }

    @Override
    public int updateByPrimaryKeySelective(FsProcurementProducts record) {
        int updateNum = fsProcurementProductsMapper.updateByPrimaryKeySelective(record);
        return updateNum;
    }

    @Override
    public int updateByPrimaryKey(FsProcurementProducts record) {
        int updateNum = fsProcurementProductsMapper.updateByPrimaryKey(record);
        return updateNum;
    }

    @Override
    public List<FsProcurementProducts> getFsProcurementByState(Integer state) {
        return fsProcurementProductsMapper.getFsProcurementByState(state);
    }

    @Override
    public List<FsProcurementProducts> getFsProcurementByUserId(Integer userId) {
        return fsProcurementProductsMapper.getFsProcurementByUserId(userId);
    }

}
