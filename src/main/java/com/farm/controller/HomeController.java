package com.farm.controller;

import javax.servlet.http.HttpServletRequest;

import com.farm.bean.FsCategory;
import com.farm.bean.FsFarmnews;
import com.farm.bean.FsSupplyProducts;
import com.farm.service.interfaces.IFsCategoryService;
import com.farm.service.interfaces.IFsFarmnewsService;
import com.farm.service.interfaces.IFsSupplyProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

	@Autowired
	private IFsSupplyProductsService fsSupplyProductsService;

	@Autowired
	private IFsFarmnewsService fsFarmnewsService;

	@Autowired
	private IFsCategoryService fsCategoryService;

	@RequestMapping("/home")
	public String home (HttpServletRequest request, Map<String, Object> requestMap){
		List<FsSupplyProducts> fruits =	fsSupplyProductsService.getFsSupplyByFruits();
		List<FsSupplyProducts> vegetables =	fsSupplyProductsService.getFsSupplyByVegetables();
		requestMap.put("fruits",fruits);
		requestMap.put("vegetables",vegetables);

		List<FsFarmnews> fsFarmnewsList = fsFarmnewsService.getAllFsFarmnews();
		List<FsFarmnews> fsFarmnewsListHome = new ArrayList<>();
		if(fsFarmnewsList != null && fsFarmnewsList.size()>4){
			for(int i = 0; i < 4; i++){
				fsFarmnewsListHome.add(fsFarmnewsList.get(i));
			}
			requestMap.put("fsFarmnewsListHome",fsFarmnewsListHome);
		}else {
			requestMap.put("fsFarmnewsListHome",fsFarmnewsList);
		}

		List<FsCategory> fsCategoryList = fsCategoryService.getAllChildFsCategory();
		requestMap.put("fsCategoryListHome",fsCategoryList);
		return "home/home";
	}

	//地市测试
	@RequestMapping("/address_test")
	public String login (HttpServletRequest request){
		return "common/address_test";
	}



}
