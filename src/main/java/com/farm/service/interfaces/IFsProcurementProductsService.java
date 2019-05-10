package com.farm.service.interfaces;

import com.farm.bean.FsProcurementProducts;
import com.farm.bean.FsSupplyProducts;

import java.util.List;

public interface IFsProcurementProductsService {

    /**
     * 1.获取所有采购商品
     * @return
     */
    List<FsProcurementProducts> getFsProcurementProducts();

    /**
     * 2.获取所有采购商品 后台使用
     * @return
     */
    List<FsProcurementProducts> getAllFsProcurementProducts();



    /**
     * 3.根据ID查询单条商品详情
     * @return
     */
    FsProcurementProducts getFsProcurementProductById(int procurementProductsId);

    /**
     * 4.根据商品名模糊查询
     * @return
     */
    List<FsProcurementProducts> getFsProcurementProductsByName(String procurementProductsName);

    boolean addFsProcurementProducts(FsProcurementProducts fsProcurementProducts);

    int deleteByPrimaryKey(Integer procurementProdId);

    int insert(FsProcurementProducts record);

    int insertSelective(FsProcurementProducts record);

    FsProcurementProducts selectByPrimaryKey(Integer procurementProdId);

    int updateByPrimaryKeySelective(FsProcurementProducts record);

    int updateByPrimaryKey(FsProcurementProducts record);

    List<FsProcurementProducts> getFsProcurementByState(Integer state);

    List<FsProcurementProducts> getFsProcurementByUserId(Integer userId);


    List<FsProcurementProducts> getBycategoryId(Integer categoryId);
}
