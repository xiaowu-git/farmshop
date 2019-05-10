package com.farm.dao;

import com.farm.bean.FsProcurementProducts;
import java.util.List;

public interface FsProcurementProductsMapper {
    int deleteByPrimaryKey(Integer procurementProdId);

    int insert(FsProcurementProducts record);

    int insertSelective(FsProcurementProducts record);

    FsProcurementProducts selectByPrimaryKey(Integer procurementProdId);

    int updateByPrimaryKeySelective(FsProcurementProducts record);

    int updateByPrimaryKey(FsProcurementProducts record);
    List<FsProcurementProducts> getFsProcurementProducts();

    List<FsProcurementProducts> getAllFsProcurementProducts();

    List<FsProcurementProducts> getFsProcurementProductsByName(String procurementProductsName);

    List<FsProcurementProducts> getFsProcurementByState(Integer procurementProdState);

    List<FsProcurementProducts> getFsProcurementByUserId(Integer userId);

    List<FsProcurementProducts> getBycategoryId(Integer categoryId);
}