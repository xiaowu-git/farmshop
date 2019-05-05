package com.farm.controller;



import com.farm.bean.FsSupplyProducts;
import com.farm.service.interfaces.IFsSupplyProductsService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class) //表示整合JUnit4进行测试
@ContextConfiguration(locations={"classpath:spring-*.xml"})//加载spring配置文件
public class SupplyProdControllerTest {

    @Autowired
    private IFsSupplyProductsService fsSupplyProductsService;

    @Test
    public void wantsupplyExecute() {

        FsSupplyProducts fsSupplyProducts = new FsSupplyProducts();
        fsSupplyProducts.setCategoryId(2);
        fsSupplyProducts.setUserId(1);
        fsSupplyProducts.setSupplyProdName("红薯");
        fsSupplyProducts.setSupplyProdPrice("10.0");
        fsSupplyProducts.setSupplyProdNum("100");
        fsSupplyProducts.setSupplyProdInfo("好吃的红薯");
        fsSupplyProducts.setCreateTime(new Date());
        fsSupplyProducts.setSupplyProdAddress("仲恺");
        fsSupplyProducts.setSupplyProdState(1);
        fsSupplyProducts.setSupplyProdPicture("C:\\Users\\Administrator\\Desktop\\farmshop\\src\\main\\" +
                "webapp\\resources\\upload\\news2019041722253700.jpg");
        boolean flag = fsSupplyProductsService.addFsSupplyProducts(fsSupplyProducts);
        Assert.assertEquals(true, flag);
    }
}
