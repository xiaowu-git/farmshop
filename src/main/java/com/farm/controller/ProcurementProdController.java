package com.farm.controller;

import com.alibaba.fastjson.JSONObject;
import com.farm.bean.FsCategory;
import com.farm.bean.FsProcurementProducts;
import com.farm.bean.FsUser;
import com.farm.service.interfaces.IFsCategoryService;
import com.farm.service.interfaces.IFsUserService;
import com.farm.service.interfaces.IFsProcurementProductsService;
import com.farm.utils.FileUtil;
import com.farm.utils.PageUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
public class ProcurementProdController {

    @Autowired
    private IFsProcurementProductsService fsProcurementProductsService;
    @Autowired
    private IFsCategoryService categoryService;

    @Autowired
    private IFsUserService userService;

    private PageUtil pageUtil = new PageUtil();

    //首次加载，分页展示所有商品
    @RequestMapping(value = "/procurement-list", method = RequestMethod.GET)
    public String getFsProcurementProducts(HttpServletRequest request, Map<String, Object> requestMap, @RequestParam("page") Integer page) {
        List<FsProcurementProducts> fsProcurementProducts  = fsProcurementProductsService.getFsProcurementProducts();
        requestMap.put("fsProcurementProducts", fsProcurementProducts);
        List<FsCategory> categoryList = categoryService.getAllFsCategory();
        requestMap.put("categoryList", categoryList);

        List<FsProcurementProducts> pageprocurementProds = new ArrayList();
        Map map = pageUtil.getPaging(page, fsProcurementProducts, pageprocurementProds);

        requestMap.put("pageMax", map.get("pageMax"));
        requestMap.put("pagePoint", map.get("pagePoint"));
        requestMap.put("pageprocurementProds", map.get("listPage"));
        return "home/procurement";
    }

    //单个商品详情展示
    @RequestMapping(value = "/procurement-tail-show",method = RequestMethod.GET)
    public String getFsProcurementProductsById (HttpServletRequest request,Map<String, Object> requestMap, @RequestParam("procurementProductsId") int procurementProductsId) {
        FsProcurementProducts fsProcurementProduct = fsProcurementProductsService.getFsProcurementProductById(procurementProductsId);
        FsUser fsUser = userService.getUserById(fsProcurementProduct.getUserId());
        requestMap.put("ProcureFsUser", fsUser);
        requestMap.put("fsProcurementProducts", fsProcurementProduct);
        return "home/procureinfo";
    }

    //搜索
    @RequestMapping(value = "/search-procurement-show",method = RequestMethod.GET)
    public String getFsProcurementProductsByName (HttpServletRequest request,Map<String, Object> requestMap,@RequestParam("page") Integer page,
                                                  @RequestParam("procurementProductsName") String procurementProductsName) {
        if (StringUtils.isBlank(procurementProductsName) || procurementProductsName.length() < 0 || procurementProductsName.length() > 6) {
            requestMap.put("msg", "请输入正确的商品名称！");
            requestMap.put("success", false);
            return "home/procurement";
        } else {
            List<FsProcurementProducts> fsProcurementProducts = fsProcurementProductsService.getFsProcurementProducts();
            requestMap.put("fsProcurementProducts", fsProcurementProducts);

            List<FsProcurementProducts> pageprocurementProds = new ArrayList();
            Map map = pageUtil.getPaging(page, fsProcurementProducts, pageprocurementProds);

            requestMap.put("pageMax", map.get("pageMax"));
            requestMap.put("pagePoint", map.get("pagePoint"));
            requestMap.put("pageprocurementProds", map.get("listPage"));
            return "home/procurement";
        }
    }


    @RequestMapping("/getBycategory")
    public String getBycategoryId(HttpServletRequest request,Map<String, Object> requestMap,@RequestParam("page") Integer page,
                                  @RequestParam("categoryId") Integer categoryId) {
        List<FsCategory> categoryList = categoryService.getAllFsCategory();
        requestMap.put("categoryList", categoryList);
        List<FsProcurementProducts> procurementProductsList = fsProcurementProductsService.getBycategoryId(categoryId);
        List<FsProcurementProducts> pageprocurementProds = new ArrayList();
        Map map = pageUtil.getPaging(page, procurementProductsList, pageprocurementProds);
        requestMap.put("categoryId", categoryId);
        requestMap.put("pageMax", map.get("pageMax"));
        requestMap.put("pagePoint", map.get("pagePoint"));
        requestMap.put("pageprocurementProds", map.get("listPage"));
        return "home/procurement";
    }

    @RequestMapping("/user-wanttoprocurement-show")
    public String userWantToProcurementShow (HttpServletRequest request,Map<String, Object> requestMap){
        requestMap.put("nav","wanttoprocurement");
        return "person/wanttoprocurement";
    }

    @ResponseBody
    @RequestMapping(value = "/user-wantprocurement-execute", method = RequestMethod.POST)
    public Object wantProcurementExecute(HttpSession session, HttpServletRequest request, @RequestParam("prodType") String prodType, @RequestParam("prodName") String prodName,
                                    @RequestParam("prodMoney") String prodMoney, @RequestParam("prodNum") String prodNum, @RequestParam("prodInfo") String prodInfo,
                                         @RequestParam("prodEexpiration") String prodEexpiration,
                                    @RequestParam(value = "prodPicture", required = false) MultipartFile prodPicture) throws ParseException {

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
            }else if(user.getUserAddress() == null){
                jsonObject.put("msg","请前往个人信息页面补全个人信息!");
                jsonObject.put("success",false);
                return jsonObject;
            }
        }
        if(StringUtils.isBlank(prodType)|| StringUtils.isBlank(prodName)|| StringUtils.isBlank(prodMoney)
                || StringUtils.isBlank(prodNum)|| StringUtils.isBlank(prodInfo) || StringUtils.isBlank(prodEexpiration) || prodPicture == null){
            jsonObject.put("msg","请填满相关数据再提交!");
            jsonObject.put("success",false);
            return jsonObject;
        }else {
            //获得SimpleDateFormat类，我们转换为yyyy-MM-dd的时间格式
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Date EexpirationDate = sf.parse(prodEexpiration);

            String realPath = request.getSession().getServletContext().getRealPath("/resources/upload");
            FileUtil fileUtil = new FileUtil();
            String ProcurementProdPicature =  fileUtil.uploadFile(prodPicture,"PROCURE" ,realPath);
            FsProcurementProducts fsProcurementProducts = new FsProcurementProducts();
            fsProcurementProducts.setCategoryId(Integer.valueOf(prodType));
            fsProcurementProducts.setUserId(user.getUserId());
            fsProcurementProducts.setProcurementProdName(prodName);
            fsProcurementProducts.setProcurementProdPrice(prodMoney);
            fsProcurementProducts.setProcurementProdNum(prodNum);
            fsProcurementProducts.setProcurementProdInfo(prodInfo);
            fsProcurementProducts.setCreateTime(new Date());
            fsProcurementProducts.setProcurementProdAddress(user.getUserAddress());
            fsProcurementProducts.setProcurementProdState(1);
            fsProcurementProducts.setProcurementProdPicture("resources/upload/"+ProcurementProdPicature);
            fsProcurementProducts.setExpirationTime(EexpirationDate);

            boolean flag = fsProcurementProductsService.addFsProcurementProducts(fsProcurementProducts);
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





    @RequestMapping("/user-procurement-list")
    public String userSupplyList (HttpSession session,HttpServletRequest request,Map<String, Object> requestMap){
        requestMap.put("nav","userprocurementlist");
        FsUser user = (FsUser) session.getAttribute("obj");
        List<FsProcurementProducts> fsProcurementProducts = fsProcurementProductsService.getFsProcurementByUserId(user.getUserId());
        requestMap.put("fsProcurementProducts",fsProcurementProducts);
        return "person/userprocurementlist";
    }



    /**
     * 前台用户删除
     * @param id
     * @return
     */
    @RequestMapping(value = "user-procurement-remove-execute/{id}", method = RequestMethod.GET)
    public String userRemoveProcurementExecute(@PathVariable Integer id) {
        FsProcurementProducts fsProcurementProducts = fsProcurementProductsService.selectByPrimaryKey(id);
        fsProcurementProducts.setIsDeleted("1");
        fsProcurementProductsService.updateByPrimaryKeySelective(fsProcurementProducts);
        return "redirect:/user-procurement-list";
    }

    /**
     * 前台用户下架
     * @param id
     * @return
     */
    @RequestMapping(value = "user-procurement-stop-execute/{id}", method = RequestMethod.GET)
    public String userStopProcurementExecute(@PathVariable Integer id) {
        FsProcurementProducts fsProcurementProducts = fsProcurementProductsService.selectByPrimaryKey(id);
        fsProcurementProducts.setProcurementProdState(3);
        fsProcurementProducts.setExpirationTime(new Date());
        fsProcurementProductsService.updateByPrimaryKeySelective(fsProcurementProducts);
        return "redirect:/user-procurement-list";
    }




    @RequestMapping(value = "/admin-procurement-list-show",method = RequestMethod.GET)
    public String adminProcurementList (HttpServletRequest request,Map<String, Object> requestMap,@RequestParam("page") Integer page,@RequestParam("state") Integer state){
        requestMap.put("nav", "procurement"+state);
        requestMap.put("state", state);
        List<FsProcurementProducts> fsProcurementProducts = fsProcurementProductsService.getFsProcurementByState(state);
        requestMap.put("fsProcurementProducts",fsProcurementProducts);
        List<FsProcurementProducts> pageprocurementProds = new ArrayList();
        Map map = pageUtil.getPaging(page, fsProcurementProducts, pageprocurementProds);

        requestMap.put("pageMax", map.get("pageMax"));
        requestMap.put("pagePoint", map.get("pagePoint"));
        requestMap.put("pageProcurementProds", map.get("listPage"));
        return "admin/procurement_list";
    }

    @RequestMapping(value = "admin-procurement-search-show", method = RequestMethod.GET)
    public String searchProcurementShow(Map<String, Object> requestMap, @RequestParam("procurementProdName") String procurementProdName) {
        requestMap.put("nav", "procurement");
        if(StringUtils.isNotBlank(procurementProdName)){
            ArrayList<FsProcurementProducts> fsProcurementProducts = (ArrayList<FsProcurementProducts>) fsProcurementProductsService.getFsProcurementProductsByName(procurementProdName);
            requestMap.put("pageProcurementProds", fsProcurementProducts);
            return "admin/procurement_list";
        }else{
            ArrayList<FsProcurementProducts> fsProcurementProducts = (ArrayList<FsProcurementProducts>) fsProcurementProductsService.getAllFsProcurementProducts();
            requestMap.put("pageProcurementProds", fsProcurementProducts);
            return "admin/procurement_list";
        }

    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "admin-procurement-remove-execute/{id}", method = RequestMethod.GET)
    public String removeProcurementExecute(@PathVariable Integer id) {
        FsProcurementProducts fsProcurementProducts = fsProcurementProductsService.selectByPrimaryKey(id);
        fsProcurementProducts.setIsDeleted("1");
        fsProcurementProductsService.updateByPrimaryKeySelective(fsProcurementProducts);
        return "redirect:/admin-procurement-list-show?page=1&state=1";
    }

    /**
     * 审核
     * @param id
     * @return
     */
    @RequestMapping(value = "admin-procurement-audit-execute/{id}/{state}", method = RequestMethod.GET)
    public String auditProcurementExecute(@PathVariable("id") Integer id, @PathVariable("state") Integer state) {
        FsProcurementProducts fsProcurementProducts = fsProcurementProductsService.selectByPrimaryKey(id);
        fsProcurementProducts.setProcurementProdState(state);
        fsProcurementProducts.setEffectiveTime(new Date());
        fsProcurementProductsService.updateByPrimaryKeySelective(fsProcurementProducts);
        return "redirect:/admin-procurement-list-show?page=1&state=" + state;
    }

    /**
     * 下架
     * @param id
     * @return
     */
    @RequestMapping(value = "admin-procurement-stop-execute/{id}", method = RequestMethod.GET)
    public String stopProcurementExecute(@PathVariable Integer id) {
        FsProcurementProducts fsProcurementProducts = fsProcurementProductsService.selectByPrimaryKey(id);
        fsProcurementProducts.setProcurementProdState(3);
        fsProcurementProducts.setExpirationTime(new Date());
        fsProcurementProductsService.updateByPrimaryKeySelective(fsProcurementProducts);
        return "redirect:/admin-procurement-list-show?page=1&state=3";
    }



}