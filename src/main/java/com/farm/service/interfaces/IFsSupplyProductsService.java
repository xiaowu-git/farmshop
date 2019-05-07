package com.farm.service.interfaces;

import com.farm.bean.FsSupplyProducts;

import java.util.List;

public interface IFsSupplyProductsService {

    /**
     * 1.获取所有供应商品
     * @return
     */
    List<FsSupplyProducts> getFsSupplyProducts();

    /**
     * 2.获取所有供应商品
     * @return
     */
    List<FsSupplyProducts> getFsSupplyByFruits();

    /**
     * 3.获取所有供应商品
     * @return
     */
    List<FsSupplyProducts> getFsSupplyByVegetables();

    /**
     * 4.获取所有供应商品数量
     * @return
     */
    Integer getSupplyProductsCount();

    FsSupplyProducts getFsSupplyProductById(Integer supplyProdId);

    /**
     * 4.按名字搜索供应商品
     * @return
     */
    List<FsSupplyProducts> getFsSupplyProductsByName(String supplyProdName);

    /**
     * 5.更改供应商品信息
     * @param fsSupplyProducts
     * @return
     */
    int updateFsSupplyProducts(FsSupplyProducts fsSupplyProducts);

    /**
     * 添加
     * @param fsSupplyProducts
     * @return
     */
    boolean addFsSupplyProducts(FsSupplyProducts fsSupplyProducts);

    int deleteByPrimaryKey(Integer supplyProdId);

    int insert(FsSupplyProducts record);

    int insertSelective(FsSupplyProducts record);

    FsSupplyProducts selectByPrimaryKey(Integer supplyProdId);

    int updateByPrimaryKeySelective(FsSupplyProducts record);

    int updateByPrimaryKey(FsSupplyProducts record);

    List<FsSupplyProducts> getAllFsSupply();

    List<FsSupplyProducts> getFsSupplyProductsByState(Integer state);

    List<FsSupplyProducts> getFsSupplyProductByUserId(Integer userId);

    List<FsSupplyProducts> getFsSupplyProductByCategoryId(Integer categoryId);
}
