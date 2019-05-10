package com.farm.controller;

import com.farm.bean.FsAdmin;
import com.farm.bean.FsFarmnews;
import com.farm.bean.FsUser;
import com.farm.exception.BusinessException;
import com.farm.service.interfaces.IFsAdminService;
import com.farm.service.interfaces.IFsFarmnewsService;
import com.farm.service.interfaces.IFsSupplyProductsService;
import com.farm.service.interfaces.IFsUserService;
import com.farm.utils.MD5;
import com.farm.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AdminIndexController {

    @Autowired
    private IFsAdminService adminService;

    @Autowired
    private IFsUserService userService;

    @Autowired
    private IFsSupplyProductsService fsSupplyProductsService;

    @Autowired
    private IFsFarmnewsService farmnewsService;

    private MD5 md5 = new MD5();
    private PageUtil pageUtil = new PageUtil();

    /**
     * 1.后台管理页面首页显示
     *
     * @return index/index_content.jsp
     */
    @RequestMapping(value = "admin-index-show", method = RequestMethod.GET)
    public String indexShow(Map<String, Object> requestMap) {
        //导航栏active
        requestMap.put("nav", "index");
        //用户数量
        requestMap.put("userCount", userService.getUserCount());
        //商品数量
        requestMap.put("supplyCount", fsSupplyProductsService.getSupplyProductsCount());
        List<FsAdmin> adminList = adminService.getAllFsAdmin();
        requestMap.put("adminList", adminList);
        //行业资讯
        List<FsFarmnews> farmnewsList = farmnewsService.getAllFsFarmnews();
        List<FsFarmnews> fsFarmnewsListIndex = new ArrayList<>();
        if(farmnewsList != null && farmnewsList.size()>5){
            for(int i = 0; i < 5; i++){
                fsFarmnewsListIndex.add(farmnewsList.get(i));
            }
            requestMap.put("fsFarmnewsListIndex",fsFarmnewsListIndex);
        }else {
            requestMap.put("fsFarmnewsListIndex",fsFarmnewsListIndex);
        }


        return "admin/index_content";
    }

    /**
     * 2.后台管理登录页面显示
     */
    @RequestMapping(value = "/index-login-show", method = RequestMethod.GET)
    public String loginShow() {
        return "admin/admin_login";
    }

    /**
     * 3.管理员登录执行
     *
     * @return index/index_content.jsp
     */
    @RequestMapping(value = "index-login-execute", method = RequestMethod.POST)
    public String loginExecute(Map<String, Object> requestMap, HttpSession session,
                               @RequestParam("username") String username, @RequestParam("password") String password) {

        String view = "redirect:/admin-index-show";
        FsAdmin admin = adminService.getAdminByName(username);
        if(admin != null && admin.getAdminPassword().equals(md5.getMD5ofStr(password))){
            requestMap.put("admin", admin);
            session.setAttribute("admin", admin);
        }else { //登录失败
            requestMap.put("adminLoginError", "1");
            view = "admin/admin_login";
        }
        return view;
    }

    /**
     * 4.修改账户显示
     *
     * @return index/index_edit.jsp
     */
    @RequestMapping(value = "admin-index-edit-show", method = RequestMethod.GET)
    public String editShow(@RequestParam("adminId") Integer adminId, Model model) {
        FsAdmin admin = adminService.getFsAdminById(adminId);
        model.addAttribute("admin", admin);
        return "admin/admin_index_edit";
    }

    /**
     * 5.修改信息执行
     *
     * @return
     */
    @RequestMapping(value = "admin-index-edit-execute", method = RequestMethod.POST)
    public String editAdminExecute(@RequestParam("id") Integer id,@RequestParam("phone") String phone,
                                   @RequestParam("name") String name, @RequestParam("password") String password,
                                   @RequestParam("email") String email, HttpSession session) {

        String view = "redirect:/admin-index-edit-show";

        if ("".equals(name) || "".equals(phone) || "".equals(password) || "".equals(email)) {
            return view;
        }else {
            FsAdmin fsAdmin = adminService.getFsAdminById(id);
            fsAdmin.setAdminEmail(email);
            fsAdmin.setAdminName(name);
            fsAdmin.setAdminPhone(phone);
            if (!fsAdmin.getAdminPassword().equals(password)){
                fsAdmin.setAdminPassword(md5.getMD5ofStr(password));
            }
            adminService.updateByPrimaryKeySelective(fsAdmin);
            FsAdmin sessionAdmin = (FsAdmin) session.getAttribute("admin");
            if(sessionAdmin.getAdminName().equals(name)){
                session.setAttribute("admin", fsAdmin);
                return "redirect:/admin-index-show";
            }
            view = "redirect:/admin-admin-list-show?page=1";
            return view;
        }
    }

    /**
     * 6.退出登录
     *
     * @return index/index_login.jsp
     */
    @RequestMapping(value = "admin-index-exit-execute", method = RequestMethod.GET)
    public String exitExecute(HttpSession session) {
        session.removeAttribute("admin");
        session.removeAttribute("advanced");
        return "redirect:/admin-index-login-show";
    }


    /**
     * 1.用户列表显示
     * @return admin/user_list.jsp
     */
    @RequestMapping(value="admin-member-list-show", method= RequestMethod.GET)
    public String listShow(Map<String, Object> requestMap, @RequestParam("page") Integer page) {
        requestMap.put("nav", "user");
        ArrayList<FsUser> users = (ArrayList<FsUser>) userService.getAllFsUser();
        requestMap.put("users", users);

        List<FsUser> pageUsers = new ArrayList();
        Map map = pageUtil.getPaging(page, users, pageUsers);

        requestMap.put("pageMax", map.get("pageMax"));
        requestMap.put("pagePoint", map.get("pagePoint"));
        requestMap.put("pageUsers", map.get("listPage"));
        return "admin/user_list";
    }

    /**
     * 2.根据id删除用户执行
     * @param id 用户id
     * @return user_list.jsp
     */
    @RequestMapping(value="admin-admin-removemember-execute/{id}",method=RequestMethod.GET)
    public String removeUserExecute(@PathVariable Integer id){
        FsUser fsUser = userService.getUserById(id);
        if (fsUser.getIsDeleted().equals("1")){
            fsUser.setIsDeleted("0");
        }else {
            fsUser.setIsDeleted("1");
        }
        userService.updateByPrimaryKeySelective(fsUser);
//        userService.removeUser(id);
        return "redirect:/admin-member-list-show?page=1";
    }

    /**
     * 3.通过用户名搜索显示
     * @return admin/user_list.jsp
     */
    @RequestMapping(value="admin-member-search-show",method=RequestMethod.GET)
    public String searchUserShow(Map<String, Object> requestMap,@RequestParam("username") String username) throws BusinessException {
        try {
            if (null != username && !"".equals(username)) {
                requestMap.put("nav", "user_list");
                System.out.println("-------------------->>>>>>>>>>>>>>>>>" + username);
                username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
                List<FsUser> users = userService.findUserByName(username);
                requestMap.put("pageUsers", users);
            }else {
                List<FsUser> users = userService.getAllFsUser();
                requestMap.put("pageUsers", users);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "admin/user_list";
    }

}
