package com.farm.controller;

import com.alibaba.fastjson.JSONObject;
import com.farm.bean.FsUser;
import com.farm.exception.BusinessException;
import com.farm.service.interfaces.IFsUserService;
import com.farm.utils.JedisClient;
import com.farm.utils.MD5;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 用户相关
 */
@Controller
public class UserController {

    @Autowired
    private IFsUserService userService;
    @Autowired
    private JedisClient jedisClient;

    //注册页面显示
    @RequestMapping("/register")
    public String register (HttpServletRequest request){
        return "home/register";
    }

    //登录页面显示
    @RequestMapping("/login")
    public String login (HttpServletRequest request){
        return "home/login";
    }

    //个人中心首页
    @RequestMapping("/userindex")
    public String userindex (HttpServletRequest request, Map<String, Object> requestMap){
        requestMap.put("nav","userindex");
        return "person/userindex";
    }

    //个人信息页面显示
    @RequestMapping("/userinfo")
    public String userinfo (HttpServletRequest request, Map<String, Object> requestMap){
        requestMap.put("nav","userinfo");
        return "person/userinformation";
    }

    //个人实名认证页面显示
    @RequestMapping("/user-idcard-show")
    public String userIdcardShow (HttpServletRequest request,Map<String, Object> requestMap){
        requestMap.put("nav","idcard");
        return "person/useridcard";
    }


    //注册实现
    @ResponseBody
    @RequestMapping(value = "/addUser" , method = RequestMethod.POST)
    public Object addUser(@RequestParam("userPhone") String userPhone,
                            @RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword) {
        JSONObject jsonObject = new JSONObject();
        MD5 md5 = new MD5();
        if(StringUtils.isBlank(userPhone) || StringUtils.isBlank(userName) || StringUtils.isBlank(userPassword)){
            jsonObject.put("msg","注册失败!");
            jsonObject.put("success",false);
            return jsonObject;
        }

        try {
            FsUser users = userService.getUserByName(userName);
            if(null != users) {
                jsonObject.put("msg","该用户已经注册啦!");
                jsonObject.put("success",false);
                return jsonObject;
            }
            //加密
            boolean flag= userService.register(userPhone,userName,md5.getMD5ofStr(userPassword));
            if(flag) {
                jsonObject.put("msg","注册成功!");
                jsonObject.put("success",true);
                return jsonObject;
            } else {
                jsonObject.put("msg","注册失败!");
                jsonObject.put("success",false);
                return jsonObject;
            }

        } catch (BusinessException e) {
            jsonObject.put("msg",e.getMessage());
            return jsonObject;
        }
    }

    //登录实现
    @ResponseBody
    @RequestMapping(value = "/dologin" , method = RequestMethod.POST)
    public Object doLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {

        JSONObject jsonObject = new JSONObject();
        MD5 md5 = new MD5();
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            jsonObject.put("msg","缺少参数!");
            jsonObject.put("success",false);
            return jsonObject;
        }
        try {
            FsUser user = userService.getUserByName(username);
            if(null == user){
                jsonObject.put("msg","该用户未注册,请前去注册!");
                jsonObject.put("success",false);
                return jsonObject;
            }else if(user.getIsDeleted().equals("1")) {
                jsonObject.put("msg","该用户已被禁用，请重新注册!");
                jsonObject.put("success",false);
                return jsonObject;
            } else if(null != user && !md5.getMD5ofStr(password).equals(user.getUserPassword())){
                jsonObject.put("msg","密码错误,请输入正确密码!");
                jsonObject.put("success",false);
                return jsonObject;
            }else{
                session.setAttribute("obj", user);
            }
        } catch (BusinessException e) {
            jsonObject.put("msg",e.getMessage());
            return jsonObject;
        }
        jsonObject.put("success",true);
        return jsonObject;
    }


    /**
     * 退出
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("obj");
        return "home/login";
    }


    @ResponseBody
    @RequestMapping(value = "/user-idcard-execute" , method = RequestMethod.POST)
    public Object idcardExecute(@RequestParam("userId") String userId, @RequestParam("userName") String userName,@RequestParam("userIdcard") String userIdcard, HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        if(StringUtils.isBlank(userId) || StringUtils.isBlank(userName) || StringUtils.isBlank(userIdcard)){
            jsonObject.put("msg","缺少参数!");
            jsonObject.put("success",false);
            return jsonObject;
        }

        try {
            FsUser user = userService.getUserById(Integer.valueOf(userId));
            if(user != null){
                user.setUserName(userName);
                user.setUserIdcard(userIdcard);
                boolean flag = userService.updateUser(user);
                session.setAttribute("obj", user);
                if(flag) {
                    jsonObject.put("msg","实名认证成功!");
                    jsonObject.put("success",true);
                    return jsonObject;
                } else {
                    jsonObject.put("msg","实名认证失败!");
                    jsonObject.put("success",false);
                    return jsonObject;
                }
            }

        } catch (Exception e) {
            jsonObject.put("msg",e.getMessage());
            return jsonObject;
        }
        jsonObject.put("success",true);
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping(value = "/user-edituser-execute" , method = RequestMethod.POST)
    public Object edituser(@RequestParam("userId") String userId, @RequestParam("userPhone") String userPhone,@RequestParam("userAddress") String userAddress, HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        //@RequestParam("userIdcard") String userIdcard,
        if(StringUtils.isBlank(userId) || StringUtils.isBlank(userPhone) || StringUtils.isBlank(userAddress)){
            jsonObject.put("msg","缺少参数!");
            jsonObject.put("success",false);
            return jsonObject;
        }

        List<FsUser> users = null;
        try {
            users = userService.selectByUserPhone(userPhone);
            if (users != null){
                if(users.size() ==1 && (!String.valueOf(users.get(0).getUserId()).equals(userId))){
                    jsonObject.put("msg",userPhone+"手机号码已经使用!");
                    jsonObject.put("success",false);
                    return jsonObject;
                }else if(users.size() >1){
                    jsonObject.put("msg",userPhone+"手机号码已经使用!");
                    jsonObject.put("success",false);
                    return jsonObject;
                }
            }
            FsUser user = userService.getUserById(Integer.valueOf(userId));
            if(user != null){
                user.setUserPhone(userPhone);
                user.setUserAddress(userAddress);
                boolean flag = userService.updateUser(user);
                session.setAttribute("obj", user);
                if(flag) {
                    jsonObject.put("msg","修改信息成功!");
                    jsonObject.put("success",true);
                    return jsonObject;
                } else {
                    jsonObject.put("msg","修改信息失败!");
                    jsonObject.put("success",false);
                    return jsonObject;
                }
            }
        } catch (BusinessException e) {
            jsonObject.put("msg",e.getMessage());
            return jsonObject;
        }
        jsonObject.put("success",true);
        return jsonObject;
    }
}
