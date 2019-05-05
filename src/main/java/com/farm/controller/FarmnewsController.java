package com.farm.controller;

import com.alibaba.fastjson.JSONObject;
import com.farm.bean.FsFarmnews;
import com.farm.service.interfaces.IFsAdminService;
import com.farm.service.interfaces.IFsCategoryService;
import com.farm.service.interfaces.IFsFarmnewsService;
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
public class FarmnewsController {

    @Autowired
    private IFsFarmnewsService fsFarmnewsService;

    @Autowired
    private IFsAdminService fsAdminService;

    @Autowired
    private IFsCategoryService fsCategoryService;

    private PageUtil pageUtil = new PageUtil();

    @RequestMapping(value = "/farmnews-list")
    public String farmnewsList(){
        return "home/farmnews";
    }

    @RequestMapping(value = "/user-farmnews-show", method = RequestMethod.GET)
    public String userFarmnewsShow(Map<String, Object> requestMap, @RequestParam("farmnewsId") String farmnewsId){
        FsFarmnews fsFarmnews = fsFarmnewsService.getFsFarmnewsById(Integer.valueOf(farmnewsId));
        requestMap.put("fsFarmnews",fsFarmnews);
        return "home/farmnewsshow";
    }

    //首次加载，分页展示所有行情信息
    @RequestMapping(value = "/farmnews-list", method = RequestMethod.GET)
    public String getFsFarmnews(HttpServletRequest request, Map<String, Object> requestMap, @RequestParam("page") Integer page) {
        List<FsFarmnews> fsFarmnews  = fsFarmnewsService.getAllFsFarmnews();
        requestMap.put("fsFarmnews", fsFarmnews);

        List<FsFarmnews> pagefsFarmnews = new ArrayList();
        Map map = pageUtil.getPaging(page, fsFarmnews, pagefsFarmnews);

        requestMap.put("pageMax", map.get("pageMax"));
        requestMap.put("pagePoint", map.get("pagePoint"));
        requestMap.put("pagefsFarmnews", map.get("listPage"));
        return "home/farmnews";
    }


    @RequestMapping(value = "/admin-farmnews-list-show",method = RequestMethod.GET)
    public String adminFarmnewsList (HttpServletRequest request,Map<String, Object> requestMap,@RequestParam("page") Integer page){
        requestMap.put("nav", "farmnews");
        List<FsFarmnews> fsFarmnews = fsFarmnewsService.getAllFsFarmnews();
        requestMap.put("fsFarmnews",fsFarmnews);
        List<FsFarmnews> pageFarmnews = new ArrayList();
        Map map = pageUtil.getPaging(page, fsFarmnews, pageFarmnews);

        requestMap.put("pageMax", map.get("pageMax"));
        requestMap.put("pagePoint", map.get("pagePoint"));
        requestMap.put("pageFarmnews", map.get("listPage"));
        return "admin/farmnews_list";
    }

    @RequestMapping(value = "admin-farmnews-search-show", method = RequestMethod.GET)
    public String searchFarmnewsShow(Map<String, Object> requestMap, @RequestParam("farmnewsName") String farmnewsName) {
        requestMap.put("nav", "farmnews");
        if(StringUtils.isNotBlank(farmnewsName)){
            ArrayList<FsFarmnews> fsFarmnews = (ArrayList<FsFarmnews>) fsFarmnewsService.getFsFarmnewsByName(farmnewsName);
            requestMap.put("pageFarmnews", fsFarmnews);
            return "admin/farmnews_list";
        }else{
            ArrayList<FsFarmnews> fsFarmnews = (ArrayList<FsFarmnews>) fsFarmnewsService.getAllFsFarmnews();
            requestMap.put("pageFarmnews", fsFarmnews);
            return "admin/farmnews_list";
        }

    }

    @RequestMapping(value = "admin-farmnews-addFarmnews-show", method = RequestMethod.GET)
    public String addCarShow() {
        return "admin/farmnews_add";
    }


    @ResponseBody
    @RequestMapping(value = "/admin-addfarmnews-execute", method = RequestMethod.POST)
    public Object addFarmnewsExecute(HttpSession session, HttpServletRequest request, @RequestParam("farmnewsUser") String farmnewsUser, @RequestParam("farmnewsType") String farmnewsType,
                                     @RequestParam("farmnewsName") String farmnewsName, @RequestParam("farmnewsTime") String farmnewsTime, @RequestParam("farmnewsInfo") String farmnewsInfo,
                                     @RequestParam(value = "farmnewsPicture", required = false) MultipartFile farmnewsPicture) throws ParseException {

        JSONObject jsonObject = new JSONObject();
        if(StringUtils.isNotBlank(farmnewsUser) && StringUtils.isNotBlank(farmnewsType) && StringUtils.isNotBlank(farmnewsName)
                && StringUtils.isNotBlank(farmnewsTime)&& StringUtils.isNotBlank(farmnewsInfo)&& farmnewsPicture != null){
            String realPath = request.getSession().getServletContext().getRealPath("/resources/upload");
            FileUtil fileUtil = new FileUtil();
            String farmnewsPictureName =  fileUtil.uploadFile(farmnewsPicture,"NEWS" ,realPath);
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Date effectiveTime = sf.parse(farmnewsTime);


            FsFarmnews farmnews = new FsFarmnews();
            farmnews.setUserId(Integer.valueOf(farmnewsUser));
            farmnews.setCategoryId(Integer.valueOf(farmnewsType));
            farmnews.setFarmnewsName(farmnewsName);
            farmnews.setFarmnewsTitle(farmnewsName);
            farmnews.setCreateTime(new Date());
            farmnews.setEffectiveTime(effectiveTime);
            if(farmnewsInfo.length()>400){
                int length = farmnewsInfo.length();
                String info1 = farmnewsInfo.substring(0,length/2);
                String info2 = farmnewsInfo.substring(length/2);
                farmnews.setFarmnewsInfo1(info1);
                farmnews.setFarmnewsInfo2(info2);
            }else {
                farmnews.setFarmnewsInfo1(farmnewsInfo);
            }
            farmnews.setFarmnewsState(2);
            farmnews.setFarmnewsPicture("resources/upload/"+farmnewsPictureName);
            int num = fsFarmnewsService.insertSelective(farmnews);
            if(num>0){
                jsonObject.put("msg","添加成功!");
                jsonObject.put("success",true);
                return jsonObject;
            }else {
                jsonObject.put("msg","添加失败!");
                jsonObject.put("success",false);
                return jsonObject;
            }
        }else {
            jsonObject.put("msg","添加失败!缺少相关参数");
            jsonObject.put("success",false);
            return jsonObject;
        }
    }


    /**
     * 后台用户删除
     * @param id
     * @return
     */
    @RequestMapping(value = "admin-farmnews-remove-execute/{id}", method = RequestMethod.GET)
    public String adminRemoveFarmnewsExecute(@PathVariable Integer id) {
        FsFarmnews farmnews = fsFarmnewsService.selectByPrimaryKey(id);
        farmnews.setIsDeleted("1");
        fsFarmnewsService.updateByPrimaryKeySelective(farmnews);
        return "redirect:/admin-farmnews-list-show?page=1";
    }

    /**
     * 后台显示修改页面
     * @param id
     * @return
     */
    @RequestMapping(value = "admin-farmnews-edit-show/{id}", method = RequestMethod.GET)
    public String adminEditFarmnewsShow(@PathVariable Integer id,Map<String, Object> requestMap) {
        FsFarmnews farmnews = fsFarmnewsService.selectByPrimaryKey(id);
        requestMap.put("categoryName",fsCategoryService.getFsCategoryBySeq(farmnews.getCategoryId()).getCategoryName());
        requestMap.put("farmnewsUser",fsAdminService.getFsAdminById(farmnews.getUserId()).getAdminName());
        requestMap.put("farmnews",farmnews);
        return "admin/farmnews_edit";
    }


    /**
     * 后台修改提交
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin-farmnews-edit-execute", method = RequestMethod.POST)
    public Object adminEditFarmnewsExecute(HttpSession session, HttpServletRequest request, @RequestParam("farmnewsId") String farmnewsId, @RequestParam("farmnewsUser") String farmnewsUser, @RequestParam("farmnewsType") String farmnewsType,
                                     @RequestParam("farmnewsName") String farmnewsName, @RequestParam("farmnewsTime") String farmnewsTime, @RequestParam("farmnewsInfo") String farmnewsInfo,
                                     @RequestParam(value = "farmnewsPicture", required = false) MultipartFile farmnewsPicture) throws ParseException {

        JSONObject jsonObject = new JSONObject();
        if(StringUtils.isNotBlank(farmnewsId)&& StringUtils.isNotBlank(farmnewsUser)&& StringUtils.isNotBlank(farmnewsType)&& StringUtils.isNotBlank(farmnewsName)
                && StringUtils.isNotBlank(farmnewsTime)&& StringUtils.isNotBlank(farmnewsInfo)){
            FsFarmnews farmnews = fsFarmnewsService.selectByPrimaryKey(Integer.valueOf(farmnewsId));
            FileUtil fileUtil = new FileUtil();
            if(farmnewsPicture != null){
                String realPath = request.getSession().getServletContext().getRealPath("/resources/upload");
                String farmnewsPictureName =  fileUtil.uploadFile(farmnewsPicture,"NEWS" ,realPath);
                farmnews.setFarmnewsPicture("resources/upload/"+farmnewsPictureName);
            }

            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Date effectiveTime = sf.parse(farmnewsTime);

            farmnews.setUserId(Integer.valueOf(farmnewsUser));
            farmnews.setCategoryId(Integer.valueOf(farmnewsType));
            farmnews.setFarmnewsName(farmnewsName);
            farmnews.setFarmnewsTitle(farmnewsName);
            farmnews.setCreateTime(new Date());
            farmnews.setEffectiveTime(effectiveTime);
            if(farmnewsInfo.length()>400){
                int length = farmnewsInfo.length();
                String info1 = farmnewsInfo.substring(0,length/2);
                String info2 = farmnewsInfo.substring(length/2);
                farmnews.setFarmnewsInfo1(info1);
                farmnews.setFarmnewsInfo2(info2);
            }else {
                farmnews.setFarmnewsInfo1(farmnewsInfo);
            }
            farmnews.setFarmnewsState(2);
            int num = fsFarmnewsService.updateByPrimaryKeySelective(farmnews);
            if(num>0){
                jsonObject.put("msg","修改成功!");
                jsonObject.put("success",true);
                return jsonObject;
            }else {
                jsonObject.put("msg","修改失败!");
                jsonObject.put("success",false);
                return jsonObject;
            }
        }else {
            jsonObject.put("msg","修改失败!缺少相关参数");
            jsonObject.put("success",false);
            return jsonObject;
        }
    }






}
