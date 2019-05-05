package com.farm.controller;

import com.alibaba.fastjson.JSONObject;
import com.farm.service.interfaces.IFsAdminService;
import com.farm.service.interfaces.IFsCategoryService;
import com.farm.service.interfaces.IFsFarmStudyService;
import com.farm.service.interfaces.IFsStudyListService;
import com.farm.utils.FileUtil;
import com.farm.utils.PageUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.farm.bean.FsFarmStudy;
import com.farm.bean.FsStudylist;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class FarmStudyController {

    @Autowired
    private IFsStudyListService studyListService;

    @Autowired
    private IFsFarmStudyService farmStudyService;

    @Autowired
    private IFsAdminService fsAdminService;

    @Autowired
    private IFsCategoryService fsCategoryService;

    private PageUtil pageUtil = new PageUtil();

    //后台加载所有的惠农学堂类型
    @ResponseBody
    @RequestMapping(value = "/admin-allStudylist-list" ,method=RequestMethod.POST)
    public  ArrayList<FsStudylist> allStudylist(HttpServletRequest request, HttpServletResponse response){
        ArrayList<FsStudylist> fsStudylists = (ArrayList<FsStudylist>) studyListService.getAllChildFsStudylist();
        return  fsStudylists;
    }


    @RequestMapping(value = "/study-list")
    public String farmstudyList(){
        return "home/farmstudy";
    }

    //首次加载，分页展示所有行情信息
    @RequestMapping(value = "/study-list", method = RequestMethod.GET)
    public String getFsFarmstudy(HttpServletRequest request, Map<String, Object> requestMap, @RequestParam("page") Integer page) {
        List<FsFarmStudy> fsFarmstudy  = farmStudyService.getAllFarmStudy();
        requestMap.put("fsFarmstudy", fsFarmstudy);

        List<FsFarmStudy> pageFarmStudies = new ArrayList();
        Map map = pageUtil.getPaging(page, fsFarmstudy, pageFarmStudies);

        requestMap.put("pageMax", map.get("pageMax"));
        requestMap.put("pagePoint", map.get("pagePoint"));
        requestMap.put("pageFarmStudies", map.get("listPage"));
        return "home/farmstudy";
    }

    @RequestMapping(value = "/user-farmstudy-show", method = RequestMethod.GET)
    public String userFarmstudyShow(Map<String, Object> requestMap, @RequestParam("studyId") String farmstudyId){
        FsFarmStudy fsFarmstudy = farmStudyService.getFarmStudyById(Integer.valueOf(farmstudyId));
        requestMap.put("fsFarmstudy",fsFarmstudy);
        return "home/farmstudyshow";
    }

    @RequestMapping(value = "/admin-farmstudy-list-show",method = RequestMethod.GET)
    public String adminFsFarmStudyList (HttpServletRequest request,Map<String, Object> requestMap,@RequestParam("page") Integer page){
        requestMap.put("nav", "farmstudy");
        List<FsFarmStudy> fsFarmStudies = farmStudyService.getAllFarmStudy();
        requestMap.put("fsFarmStudies",fsFarmStudies);
        List<FsFarmStudy> pageFarmStudies = new ArrayList();
        Map map = pageUtil.getPaging(page, fsFarmStudies, pageFarmStudies);

        requestMap.put("pageMax", map.get("pageMax"));
        requestMap.put("pagePoint", map.get("pagePoint"));
        requestMap.put("pageFarmStudies", map.get("listPage"));
        return "admin/farmstudy_list";
    }

    @RequestMapping(value = "admin-addFarmstudy-show", method = RequestMethod.GET)
    public String addStudyShow() {
        return "admin/farmstudy_add";
    }

    @RequestMapping(value = "admin-farmstudy-search-show", method = RequestMethod.GET)
    public String searchFarmstudyShow(Map<String, Object> requestMap, @RequestParam("farmstudyName") String farmstudyName) {
        requestMap.put("nav", "farmstudy");
        if(StringUtils.isNotBlank(farmstudyName)){
            ArrayList<FsFarmStudy> fsFarmStudies = (ArrayList<FsFarmStudy>) farmStudyService.getFsFarmnewsByName(farmstudyName);
            requestMap.put("pageFarmStudies", fsFarmStudies);
            return "admin/farmstudy_list";
        }else{
            ArrayList<FsFarmStudy> fsFarmStudies = (ArrayList<FsFarmStudy>) farmStudyService.getAllFarmStudy();
            requestMap.put("pageFarmStudies", fsFarmStudies);
            return "admin/farmstudy_list";
        }

    }

    @ResponseBody
    @RequestMapping(value = "/admin-addfarmstudy-execute", method = RequestMethod.POST)
    public Object addFarmstudyExecute(HttpSession session, HttpServletRequest request, @RequestParam("farmstudyUser") String farmstudyUser, @RequestParam("farmstudyType") String farmstudyType,
                                     @RequestParam("farmstudyName") String farmstudyName, @RequestParam("farmstudyTime") String farmstudyTime, @RequestParam("farmstudyInfo") String farmstudyInfo,
                                     @RequestParam(value = "farmstudyPicture", required = false) MultipartFile farmstudyPicture) throws ParseException, ParseException {

        JSONObject jsonObject = new JSONObject();
        if(StringUtils.isNotBlank(farmstudyUser)&& StringUtils.isNotBlank(farmstudyType)&& StringUtils.isNotBlank(farmstudyName)
                && StringUtils.isNotBlank(farmstudyTime)&& StringUtils.isNotBlank(farmstudyInfo) && farmstudyPicture != null){
            String realPath = request.getSession().getServletContext().getRealPath("/resources/upload");
            FileUtil fileUtil = new FileUtil();
            String farmstudyPictureName =  fileUtil.uploadFile(farmstudyPicture,"STUDY" ,realPath);
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Date effectiveTime = sf.parse(farmstudyTime);


            FsFarmStudy farmstudy = new FsFarmStudy();
            farmstudy.setAdminId(Integer.valueOf(farmstudyUser));
            farmstudy.setStudylistId(Integer.valueOf(farmstudyType));
            farmstudy.setFarmstudyName(farmstudyName);
            farmstudy.setFarmstudyTitle(farmstudyName);
            farmstudy.setCreateTime(new Date());
            farmstudy.setEffectiveTime(effectiveTime);
            if(farmstudyInfo.length()>400){
                int length = farmstudyInfo.length();
                String info1 = farmstudyInfo.substring(0,length/2);
                String info2 = farmstudyInfo.substring(length/2);
                farmstudy.setFarmstudyInfo1(info1);
                farmstudy.setFarmstudyInfo2(info2);
            }else {
                farmstudy.setFarmstudyInfo1(farmstudyInfo);
            }
            farmstudy.setFarmstudyState(2);
            farmstudy.setFarmstudyPicture("resources/upload/"+farmstudyPictureName);
            int num = farmStudyService.insertSelective(farmstudy);
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
    @RequestMapping(value = "admin-farmstudy-remove-execute/{id}", method = RequestMethod.GET)
    public String adminRemoveFarmstudyExecute(@PathVariable Integer id) {
        FsFarmStudy farmStudy = farmStudyService.getFarmStudyById(id);
        farmStudy.setIsDeleted("1");
        farmStudyService.updateByPrimaryKeySelective(farmStudy);
        return "redirect:/admin-farmstudy-list-show?page=1";
    }

    /**
     * 后台显示修改页面
     * @param id
     * @return
     */
    @RequestMapping(value = "admin-farmstudy-edit-show/{id}", method = RequestMethod.GET)
    public String adminEditFarmstudyShow(@PathVariable Integer id,Map<String, Object> requestMap) {
        FsFarmStudy farmStudy = farmStudyService.getFarmStudyById(id);
        requestMap.put("listName",studyListService.getStudyListBySeq(farmStudy.getStudylistId()).getStudylistName());
        requestMap.put("farmStudyUser",fsAdminService.getFsAdminById(farmStudy.getAdminId()).getAdminName());
        requestMap.put("farmStudy",farmStudy);
        return "admin/farmstudy_edit";
    }

    /**
     * 后台修改提交
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin-farmstudy-edit-execute", method = RequestMethod.POST)
    public Object adminEditFarmstudyExecute(HttpSession session, HttpServletRequest request, @RequestParam("farmstudyId") String farmstudyId, @RequestParam("farmstudyUser") String farmstudyUser, @RequestParam("farmstudyType") String farmstudyType,
                                      @RequestParam("farmstudyName") String farmstudyName, @RequestParam("farmstudyTime") String farmstudyTime, @RequestParam("farmstudyInfo") String farmstudyInfo,
                                      @RequestParam(value = "farmstudyPicture", required = false) MultipartFile farmstudyPicture) throws ParseException, ParseException {

        FsFarmStudy farmstudy  =  farmStudyService.getFarmStudyById(Integer.valueOf(farmstudyId));
        JSONObject jsonObject = new JSONObject();
        if(StringUtils.isNotBlank(farmstudyId) && StringUtils.isNotBlank(farmstudyUser) && StringUtils.isNotBlank(farmstudyType) && StringUtils.isNotBlank(farmstudyName)
                && StringUtils.isNotBlank(farmstudyTime) && StringUtils.isNotBlank(farmstudyInfo)){
            if(farmstudyPicture != null){
                String realPath = request.getSession().getServletContext().getRealPath("/resources/upload");
                FileUtil fileUtil = new FileUtil();
                String farmstudyPictureName =  fileUtil.uploadFile(farmstudyPicture,"STUDY" ,realPath);
                farmstudy.setFarmstudyPicture("resources/upload/"+farmstudyPictureName);
            }

            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Date effectiveTime = sf.parse(farmstudyTime);

            farmstudy.setAdminId(Integer.valueOf(farmstudyUser));
            farmstudy.setStudylistId(Integer.valueOf(farmstudyType));
            farmstudy.setFarmstudyName(farmstudyName);
            farmstudy.setFarmstudyTitle(farmstudyName);
            farmstudy.setCreateTime(new Date());
            farmstudy.setEffectiveTime(effectiveTime);
            if(farmstudyInfo.length()>400){
                int length = farmstudyInfo.length();
                String info1 = farmstudyInfo.substring(0,length/2);
                String info2 = farmstudyInfo.substring(length/2);
                farmstudy.setFarmstudyInfo1(info1);
                farmstudy.setFarmstudyInfo2(info2);
            }else {
                farmstudy.setFarmstudyInfo1(farmstudyInfo);
            }
            farmstudy.setFarmstudyState(2);
            int num = farmStudyService.updateByPrimaryKeySelective(farmstudy);
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
