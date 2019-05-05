package com.farm.dao;

import com.farm.bean.FsSupplyProducts;

import java.util.List;
public interface FsSupplyProductsMapper {
    int deleteByPrimaryKey(Integer supplyProdId);

    int insert(FsSupplyProducts record);

    int insertSelective(FsSupplyProducts record);

    FsSupplyProducts selectByPrimaryKey(Integer supplyProdId);

    int updateByPrimaryKeySelective(FsSupplyProducts record);

    int updateByPrimaryKey(FsSupplyProducts record);

    List<FsSupplyProducts> selectAllFsSupplyProducts();

    Integer selectFsSupplyProductsNum();

    List<FsSupplyProducts> getFsSupplyProductsByName(String supplyProdCategory);

    List<FsSupplyProducts> getFsSupplyProductsByState(Integer supplyProdState);

    List<FsSupplyProducts> selectAllFsSupply();

    List<FsSupplyProducts> getFsSupplyProductByUserId(Integer userId);

    List<FsSupplyProducts>  selectFsSupplyByFruits();

    List<FsSupplyProducts>  selectFsSupplyByVegetables();

}