package com.farm.controller;


import com.alibaba.fastjson.JSONObject;
import com.farm.bean.FsCategory;
import com.farm.bean.FsSupplyProducts;
import com.farm.bean.FsUser;
import com.farm.service.interfaces.IFsCategoryService;
import com.farm.service.interfaces.IFsSupplyProductsService;
import com.farm.utils.FileUtil;
import com.farm.utils.PageUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
public class SupplyProdController {

    @Autowired
    private IFsSupplyProductsService fsSupplyProductsService;

    @Autowired
    private IFsCategoryService fsCategoryService;

    private PageUtil pageUtil = new PageUtil();

    @RequestMapping(value = "/supply-list",method = RequestMethod.GET)
    public String supply (HttpServletRequest request,Map<String, Object> requestMap,@RequestParam("page") Integer page){
        List<FsSupplyProducts> fsSupplyProducts = null;
        fsSupplyProducts = fsSupplyProductsService.getFsSupplyProducts();
        requestMap.put("fsSupplyProducts",fsSupplyProducts);

        List<FsCategory> categoryList = fsCategoryService.getAllFsCategory();
        requestMap.put("categoryList", categoryList);

        List<FsSupplyProducts> pageSupplyProds = new ArrayList();
        Map map = pageUtil.getPaging(page, fsSupplyProducts, pageSupplyProds);

        requestMap.put("pageMax", map.get("pageMax"));
        requestMap.put("pagePoint", map.get("pagePoint"));
        requestMap.put("pageSupplyProds", map.get("listPage"));
        return "home/supply";
    }


    /**
     * 1.供应商品显示
     *
     * @return home/csupply.jsp
     */
    @RequestMapping(value = "/supply-prod-list-show", method = RequestMethod.GET)
    public String fsSupplyProductsList(Map<String, Object> requestMap,@RequestParam("supplyProdCategory") String supplyProdCategory){
        List<FsSupplyProducts> fsSupplyProducts = null;
        fsSupplyProducts = fsSupplyProductsService.getFsSupplyProducts();

        List<FsSupplyProducts> supplyProductsSearch = new ArrayList<>();
        if(fsSupplyProducts.size()>8){
            for(int i = 0; i < 8; i++){
                supplyProductsSearch.add(fsSupplyProducts.get(i));
            }
            requestMap.put("pageSupplyProds",supplyProductsSearch);
        }else {
            requestMap.put("pageSupplyProds",fsSupplyProducts);
        }
        return "home/supply";
    }


    /**
     * 2.供应产品详情展示
     *
     * @return home/csupply.jsp
     */


    @RequestMapping(value = "/user-supplyProd-show", method = RequestMethod.GET)
    public String userSupplyProdShow(Map<String, Object> requestMap,@RequestParam("supplyProdId") String supplyProdId){
        FsSupplyProducts fsSupplyProduct = fsSupplyProductsService.getFsSupplyProductById(Integer.valueOf(supplyProdId));
        requestMap.put("supplyProdShow",fsSupplyProduct);
        return "home/introduction";
    }

    @RequestMapping(value = "/getbycatgoryId", method = RequestMethod.GET)
    public String getByCatgory(Map<String, Object> requestMap,@RequestParam("categoryId") Integer categoryId, @RequestParam("page") Integer page){
        List<FsSupplyProducts> fsSupplyProducts = fsSupplyProductsService.getFsSupplyProductByCategoryId(categoryId);
        List<FsCategory> categoryList = fsCategoryService.getAllFsCategory();
        requestMap.put("categoryList", categoryList);

        List<FsSupplyProducts> pageSupplyProds = new ArrayList();
        Map map = pageUtil.getPaging(page, fsSupplyProducts, pageSupplyProds);

        requestMap.put("pageMax", map.get("pageMax"));
        requestMap.put("pagePoint", map.get("pagePoint"));
        requestMap.put("pageSupplyProds", map.get("listPage"));
        return "home/supply";
    }

    //搜索
    @RequestMapping(value = "/search-supplyProd-show",method = RequestMethod.GET)
    public String getFsSupplyProductsByName (HttpServletRequest request,Map<String, Object> requestMap, @RequestParam("supply_prod_name") String supplyProdName) throws UnsupportedEncodingException {
        //String supplyProdCategoryEncode = new String(supplyProdCategory.getBytes("iso-8859-1"),"utf-8");
        supplyProdName = new String(supplyProdName.getBytes("iso-8859-1"),"utf-8");
        System.out.println("--------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + supplyProdName);
        if (StringUtils.isBlank(supplyProdName) || supplyProdName.length() < 0 || supplyProdName.length() > 6) {
            requestMap.put("msg", "请输入正确的农产品名称！");
            requestMap.put("success", false);
            return "home/supply";
        } else {
            List<FsSupplyProducts> fsSupplyProducts = fsSupplyProductsService.getFsSupplyProductsByName(supplyProdName);
            requestMap.put("fsSupplyProducts", fsSupplyProducts);
            System.out.println( "结果长度： -------------------------》" + fsSupplyProducts.size());
            List<FsSupplyProducts> pageSupplyProds = new ArrayList();
            Map map = pageUtil.getPaging(1, fsSupplyProducts, pageSupplyProds);
            requestMap.put("supplyProdName", supplyProdName);
            requestMap.put("pageMax", map.get("pageMax"));
            requestMap.put("pagePoint", map.get("pagePoint"));
            requestMap.put("pageSupplyProds", map.get("listPage"));
            return "home/supply";
        }
    }

    @RequestMapping("/user-wanttosupply-show")
    public String userWantToSupplyShow (HttpServletRequest request,Map<String, Object> requestMap){
        requestMap.put("nav","wanttosupply");
        return "person/wanttosupply";
    }

    //后台加载所有的类别
    @ResponseBody
    @RequestMapping(value = "/AddProdCategorys" ,method=RequestMethod.POST)
    public  ArrayList<FsCategory> AddProdCategorys(HttpServletRequest request, HttpServletResponse response){
        ArrayList<FsCategory> fsCategories = (ArrayList<FsCategory>) fsCategoryService.getAllChildFsCategory();
        return  fsCategories;
    }

    @ResponseBody
    @RequestMapping(value = "/user-wantsupply-execute", method = RequestMethod.POST)
    public Object wantsupplyExecute(HttpSession session, HttpServletRequest request, @RequestParam("prodType") String prodType, @RequestParam("prodName") String prodName,
                                    @RequestParam("prodMoney") String prodMoney,@RequestParam("prodNum") String prodNum,@RequestParam("prodInfo") String prodInfo,
                                    @RequestParam(value = "prodPicture", required = false) MultipartFile prodPicture) {
        JSONObject jsonObject = new JSONObject();
        FsUser user = (FsUser) session.getAttribute("obj");
        if(user == null){
            jsonObject.put("msg","请前往登录页面登录!");
            jsonObject.put("success",false);
            return jsonObject;
        }else {
            if(user.getUserIdcard() == null){
                jsonObject.put("msg","请前往实名认证页面实名认证!");
                jsonObject.put("success",false);
                return jsonObject;
            } else if(user.getUserAddress() == null){
                jsonObject.put("msg","请前往个人信息页面补全个人信息!");
                jsonObject.put("success",false);
                return jsonObject;
            }
        }
        if(StringUtils.isBlank(prodType)|| StringUtils.isBlank(prodName)|| StringUtils.isBlank(prodMoney)
                || StringUtils.isBlank(prodNum)|| StringUtils.isBlank(prodInfo)|| prodPicture == null){
            jsonObject.put("msg","请填满相关数据再提交!");
            jsonObject.put("success",false);
            return jsonObject;
        }else {
            String realPath = request.getSession().getServletContext().getRealPath("/resources/upload");
            FileUtil fileUtil = new FileUtil();
            String supplyProdPicture =  fileUtil.uploadFile(prodPicture,"SUPPLY" ,realPath);
            FsSupplyProducts fsSupplyProducts = new FsSupplyProducts();
            fsSupplyProducts.setCategoryId(Integer.valueOf(prodType));
            fsSupplyProducts.setUserId(user.getUserId());
            fsSupplyProducts.setSupplyProdName(prodName);
            fsSupplyProducts.setSupplyProdPrice(prodMoney);
            fsSupplyProducts.setSupplyProdNum(prodNum);
            fsSupplyProducts.setSupplyProdInfo(prodInfo);
            fsSupplyProducts.setCreateTime(new Date());
            fsSupplyProducts.setSupplyProdAddress(user.getUserAddress());
            fsSupplyProducts.setSupplyProdState(1);
            fsSupplyProducts.setSupplyProdPicture("resources/upload/"+supplyProdPicture);

            boolean flag = fsSupplyProductsService.addFsSupplyProducts(fsSupplyProducts);
            if(flag) {
                jsonObject.put("msg","添加成功!");
                jsonObject.put("success",true);
                return jsonObject;
            } else {
                jsonObject.put("msg","添加失败!");
                jsonObject.put("success",false);
                return jsonObject;
            }
        }
    }


    @RequestMapping("/user-supply-list")
    public String userSupplyList (HttpSession session,HttpServletRequest request,Map<String, Object> requestMap){
        requestMap.put("nav","usersupplylist");
        FsUser user = (FsUser) session.getAttribute("obj");
        List<FsSupplyProducts> fsSupplyProducts = fsSupplyProductsService.getFsSupplyProductByUserId(user.getUserId());
        requestMap.put("fsSupplyProducts",fsSupplyProducts);
        return "person/usersupplylist";
    }


    /**
     * 前台用户删除
     * @param id
     * @return
     */
    @RequestMapping(value = "user-supply-remove-execute/{id}", method = RequestMethod.GET)
    public String userRemoveSupplyExecute(@PathVariable Integer id) {
        FsSupplyProducts fsSupplyProducts = fsSupplyProductsService.selectByPrimaryKey(id);
        fsSupplyProducts.setIsDeleted("1");
        fsSupplyProductsService.updateByPrimaryKeySelective(fsSupplyProducts);
        return "redirect:/user-supply-list";
    }

    /**
     * 前台用户下架
     * @param id
     * @return
     */
    @RequestMapping(value = "user-supply-stop-execute/{id}", method = RequestMethod.GET)
    public String userStopSupplyExecute(@PathVariable Integer id) {
        FsSupplyProducts fsSupplyProducts = fsSupplyProductsService.selectByPrimaryKey(id);
        fsSupplyProducts.setSupplyProdState(3);
        fsSupplyProducts.setExpirationTime(new Date());
        fsSupplyProductsService.updateByPrimaryKeySelective(fsSupplyProducts);
        return "redirect:/user-supply-list";
    }











    @RequestMapping(value = "/admin-supply-list-show",method = RequestMethod.GET)
    public String adminSupplyList (HttpServletRequest request,Map<String, Object> requestMap,@RequestParam("page") Integer page,@RequestParam("state") Integer state){
        requestMap.put("nav", "supply"+state);
        requestMap.put("state", state);
        List<FsSupplyProducts> fsSupplyProducts = fsSupplyProductsService.getFsSupplyProductsByState(state);
        requestMap.put("fsSupplyProducts",fsSupplyProducts);
        List<FsSupplyProducts> pageSupplyProds = new ArrayList();
        Map map = pageUtil.getPaging(page, fsSupplyProducts, pageSupplyProds);

        requestMap.put("pageMax", map.get("pageMax"));
        requestMap.put("pagePoint", map.get("pagePoint"));
        requestMap.put("pageSupplyProds", map.get("listPage"));
        return "admin/supply_list";
    }

    @RequestMapping(value = "admin-supply-search-show", method = RequestMethod.GET)
    public String searchSupplyShow(Map<String, Object> requestMap, @RequestParam("supplyProdName") String supplyProdName) {
        requestMap.put("nav", "supply");
        if(StringUtils.isNotBlank(supplyProdName)){
            ArrayList<FsSupplyProducts> fsSupplyProducts = (ArrayList<FsSupplyProducts>) fsSupplyProductsService.getFsSupplyProductsByName(supplyProdName);
            requestMap.put("pageSupplyProds", fsSupplyProducts);
            return "admin/supply_list";
        }else{
            ArrayList<FsSupplyProducts> fsSupplyProducts = (ArrayList<FsSupplyProducts>) fsSupplyProductsService.getFsSupplyProducts();
            requestMap.put("pageSupplyProds", fsSupplyProducts);
            return "admin/supply_list";
        }

    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "admin-supply-remove-execute/{id}", method = RequestMethod.GET)
    public String removeSupplyExecute(@PathVariable Integer id) {
        FsSupplyProducts fsSupplyProducts = fsSupplyProductsService.selectByPrimaryKey(id);
        fsSupplyProducts.setIsDeleted("1");
        fsSupplyProductsService.updateByPrimaryKeySelective(fsSupplyProducts);
        return "redirect:/admin-supply-list-show?page=1&state=1";
    }

    /**
     * 审核
     * @param id
     * @return
     */
    @RequestMapping(value = "admin-supply-audit-execute/{id}", method = RequestMethod.GET)
    public String auditSupplyExecute(@PathVariable Integer id) {
        FsSupplyProducts fsSupplyProducts = fsSupplyProductsService.selectByPrimaryKey(id);
        fsSupplyProducts.setSupplyProdState(2);
        fsSupplyProducts.setEffectiveTime(new Date());
        fsSupplyProductsService.updateByPrimaryKeySelective(fsSupplyProducts);
        return "redirect:/admin-supply-list-show?page=1&state=2";
    }

    /**
     * 下架
     * @param id
     * @return
     */
    @RequestMapping(value = "admin-supply-stop-execute/{id}", method = RequestMethod.GET)
    public String stopSupplyExecute(@PathVariable Integer id) {
        FsSupplyProducts fsSupplyProducts = fsSupplyProductsService.selectByPrimaryKey(id);
        fsSupplyProducts.setSupplyProdState(3);
        fsSupplyProducts.setExpirationTime(new Date());
        fsSupplyProductsService.updateByPrimaryKeySelective(fsSupplyProducts);
        return "redirect:/admin-supply-list-show?page=1&state=3";
    }




}
