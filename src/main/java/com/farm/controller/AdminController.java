package com.farm.controller;

import com.farm.bean.FsAdmin;
import com.farm.service.interfaces.IFsAdminService;
import com.farm.utils.MD5;
import com.farm.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 后台管理员页面控制器
 * Created by zhongjh on 2019/4/14.
 */
@Controller
public class AdminController {
    @Autowired
    private IFsAdminService fsAdminService;

    private MD5 md5 = new MD5();
    private PageUtil pageUtil = new PageUtil();

    /**
     * 1.管理员列表页显示
     *
     * @param requestMap
     * @param page
     * @return WEB-INF/jsp/admin/admin_list.jsp
     */
    @RequestMapping(value = "admin-admin-list-show", method = RequestMethod.GET)
    public String listShow(Map<String, Object> requestMap, @RequestParam("page") Integer page) {
        //映射
        requestMap.put("nav", "admin-list");
        //获取管理员列表
        ArrayList<FsAdmin> admins = (ArrayList<FsAdmin>) fsAdminService.getAllFsAdmin();
        requestMap.put("admins", admins);

        List<FsAdmin> pageAdmins = new ArrayList();
        Map map = pageUtil.getPaging(page, admins, pageAdmins);

        requestMap.put("pageMax", map.get("pageMax"));
        requestMap.put("pagePoint", map.get("pagePoint"));
        requestMap.put("pageAdmins", map.get("listPage"));
        return "admin/admin_list";
    }

    /**
     * 2.按名(like)搜索管理员显示
     *
     * @param requestMap
     * @param name
     * @return WEB-INF/jsp/admin/admin_list.jsp
     */
    @RequestMapping(value = "admin-admin-searchadmin-show", method = RequestMethod.GET)
    public String searchAdminShow(Map<String, Object> requestMap, @RequestParam("name") String name) {
        requestMap.put("nav", "admin-list");
        ArrayList<FsAdmin> admins = (ArrayList<FsAdmin>) fsAdminService.getFsAdminByNameLike(name);
        requestMap.put("pageAdmins", admins);
        return "admin/admin_list";
    }

    /**
     * 4.新增管理员显示
     *
     * @return WEB-INF/jsp/admin/admin_register.jsp
     */
    @RequestMapping(value = "admin-admin-register-show", method = RequestMethod.GET)
    public String registerShow() {
        return "admin/admin_register";
    }

    /**
     * 5.新增管理员
     *
     * @param name
     * @param password
     * @param password2
     * @param email
     * @return WEB-INF/jsp/admin/admin_list.jsp
     */
    @RequestMapping(value = "admin-admin-register-execute", method = RequestMethod.POST)
    public String registerExecute(@RequestParam("name") String name,@RequestParam("phone") String phone,
                                  @RequestParam("password") String password, @RequestParam("password2") String password2,
                                  @RequestParam("email") String email) {
        System.out.println(name);
        String view = "admin/admin_register";
        FsAdmin fsAdmin = new FsAdmin();
        if ("".equals(name) || "".equals(phone) || "".equals(password) || "".equals(password2) || "".equals(email)) {
            return view;
        }else {
            if(password.equals(password2)){
                fsAdmin.setAdminEmail(email);
                fsAdmin.setAdminName(name);
                fsAdmin.setAdminPhone(phone);
                fsAdmin.setAdminPassword(md5.getMD5ofStr(password));
                int registerSuccess = fsAdminService.insertSelective(fsAdmin);
                if (registerSuccess>0) {
                    view = "redirect:/admin-admin-list-show?page=1";
                }
            }
            return view;
        }
    }

    /**
     * 6.管理员授权
     *
     * @return WEB-INF/jsp/admin/admin_password.jsp
     */
    @RequestMapping(value = "admin-admin-password-show", method = RequestMethod.GET)
    public String passwordShow() {
        return "admin/admin_password";
    }

    /**
     * 7.管理员授权处理
     *
     * @param requestMap
     * @param session
     * @param password
     * @return WEB-INF/jsp/admin/admin_list.jsp
     */
    @RequestMapping(value = "admin-admin-password-execute", method = RequestMethod.POST)
    public String passwordExecute(Map<String, Object> requestMap, HttpSession session,
                                  @RequestParam String password) {
        if ("root".equals(password)) {
            session.setAttribute("advanced", 1);
        }
        return "redirect:/admin-admin-list-show?page=1";
    }

    /**
     * 8.删除管理员执行
     *
     * @param id
     * @return WEB-INF/jsp/admin/admin_list.jsp
     */
    @RequestMapping(value = "admin-admin-removeadmin-execute/{id}", method = RequestMethod.GET)
    public String removeAdminExecute(@PathVariable Integer id) {
        fsAdminService.removeFsAdmin(id);
        return "redirect:/admin-admin-list-show?page=1";
    }

    /**
     * 9.修改管理员信息显示
     *
     * @param requestMap
     * @param id
     * @return WEB-INF/jsp/admin/admin_list_edit.jsp
     */
    @RequestMapping(value = "admin-admin-editadmin-show/{id}", method = RequestMethod.GET)
    public String editAdminShow(Map<String, Object> requestMap, @PathVariable Integer id) {
        FsAdmin admin = fsAdminService.getFsAdminById(id);
        requestMap.put("admin", admin);
        return "admin/admin_list_edit";
    }

    /**
     * 10.修改管理员信息
     *
     * @param id
     * @param name
     * @param password
     * @param email
     * @return WEB-INF/jsp/admin/admin_message.jsp
     */
    @RequestMapping(value = "admin-admin-editadmin-execute", method = RequestMethod.POST)
    public String editAdminExecute(@RequestParam("id") Integer id,@RequestParam("phone") String phone,
                                   @RequestParam("name") String name, @RequestParam("password") String password,
                                   @RequestParam("email") String email) {

        FsAdmin fsAdmin = fsAdminService.getFsAdminById(id);
        String view = "redirect:/admin-admin-editadmin-show/" + id;
        if ("".equals(name) || "".equals(phone) || "".equals(password) || "".equals(email)) {
            return view;
        }else {
            fsAdmin.setAdminName(name);
            fsAdmin.setAdminPhone(phone);
            fsAdmin.setAdminPassword(md5.getMD5ofStr(password));
            fsAdmin.setAdminEmail(email);
            int editSuccess = fsAdminService.updateByPrimaryKeySelective(fsAdmin);
            if (editSuccess>0) {
                view = "redirect:/admin-admin-list-show?page=1";
            }
            return view;
        }

    }

    //后台加载所有的作者（管理员发布）
    @ResponseBody
    @RequestMapping(value = "/admin-allAdmin-list" ,method=RequestMethod.POST)
    public  ArrayList<FsAdmin> allAdminList(HttpServletRequest request, HttpServletResponse response){
        ArrayList<FsAdmin> fsAdminArrayList = (ArrayList<FsAdmin>) fsAdminService.getAllFsAdmin();
        return  fsAdminArrayList;
    }


}
