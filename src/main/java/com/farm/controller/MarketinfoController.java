package com.farm.controller;

import com.farm.bean.FsMarketinfo;
import com.farm.service.interfaces.IFsMarketInfoService;
import com.farm.utils.PageUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MarketinfoController {

    @Autowired
    private IFsMarketInfoService fsMarketInfoService;

    private PageUtil pageUtil = new PageUtil();

    @RequestMapping(value = "/marketinfo-list")
    public String marketinfoList(){
        return "home/marketinfo";
    }


    //首次加载，分页展示所有行情信息
    @RequestMapping(value = "/marketinfo-list", method = RequestMethod.GET)
    public String getFsMarketinfo(HttpServletRequest request, Map<String, Object> requestMap, @RequestParam("page") Integer page) {
//        int num = fsMarketInfoService.saveFsMarketinfoBProduct();
        List<FsMarketinfo> fsMarketinfo  = fsMarketInfoService.getAllFsMarketinfo();
        requestMap.put("fsMarketinfo", fsMarketinfo);

        List<FsMarketinfo> pagefsMarketinfos = new ArrayList();
        Map map = pageUtil.getPaging(page, fsMarketinfo, pagefsMarketinfos);

        requestMap.put("pageMax", map.get("pageMax"));
        requestMap.put("pagePoint", map.get("pagePoint"));
        requestMap.put("pagefsMarketinfos", map.get("listPage"));
        return "home/marketinfo";
    }




    /**
     * 3.具体行情信息详情展示
     *
     * @return home/marketinfo.jsp
     */


    @RequestMapping(value = "/user-marketinfo-show", method = RequestMethod.GET)
    public String userMarketinfoShow(Map<String, Object> requestMap,@RequestParam("marketinfoId") String marketinfoId){
        FsMarketinfo fsMarketinfo = fsMarketInfoService.getFsMarketinfoById(Integer.valueOf(marketinfoId));
        requestMap.put("fsMarketinfo",fsMarketinfo);
        return "home/marketinfoshow";
    }

    /*@RequestMapping("/user-marketinfo-show")
    public String supplyProd_show (HttpServletRequest request){
        return "home/marketinfoshow";
    }*/

    @RequestMapping(value = "/admin-market-list-show",method = RequestMethod.GET)
    public String adminMarketinfoList (HttpServletRequest request,Map<String, Object> requestMap,@RequestParam("page") Integer page){
        requestMap.put("nav", "market");
        List<FsMarketinfo> fsMarketinfo = fsMarketInfoService.getAllFsMarketinfo();
        requestMap.put("fsMarketinfo",fsMarketinfo);
        List<FsMarketinfo> pageMarketinfo = new ArrayList();
        Map map = pageUtil.getPaging(page, fsMarketinfo, pageMarketinfo);

        requestMap.put("pageMax", map.get("pageMax"));
        requestMap.put("pagePoint", map.get("pagePoint"));
        requestMap.put("pageMarketinfo", map.get("listPage"));
        return "admin/marketinfo_list";
    }

    @RequestMapping(value = "admin-market-search-show", method = RequestMethod.GET)
    public String searchMarketinfoShow(Map<String, Object> requestMap, @RequestParam("marketinfoName") String marketinfoName) {
        requestMap.put("nav", "market");
        if(StringUtils.isNotBlank(marketinfoName)){
            ArrayList<FsMarketinfo> fsMarketinfo = (ArrayList<FsMarketinfo>) fsMarketInfoService.getFsMarketinfoByName(marketinfoName);
            requestMap.put("pageMarketinfo", fsMarketinfo);
            return "admin/marketinfo_list";
        }else{
            ArrayList<FsMarketinfo> fsMarketinfo = (ArrayList<FsMarketinfo>) fsMarketInfoService.getAllFsMarketinfo();
            requestMap.put("pageMarketinfo", fsMarketinfo);
            return "admin/marketinfo_list";
        }

    }


    /**
     * 后台用户删除
     * @param id
     * @return
     */
    @RequestMapping(value = "admin-market-remove-execute/{id}", method = RequestMethod.GET)
    public String adminRemoveMarketExecute(@PathVariable Integer id) {
        FsMarketinfo fsSupplyProducts = fsMarketInfoService.selectByPrimaryKey(id);
        fsSupplyProducts.setIsDeleted("1");
        fsMarketInfoService.updateByPrimaryKeySelective(fsSupplyProducts);
        return "redirect:/admin-market-list-show?page=1";
    }



}
