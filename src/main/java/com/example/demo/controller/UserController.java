package com.example.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.tools.HttpClientUtil;
import com.example.demo.tools.MyJsonResult;
import com.example.demo.tools.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private Tool tools;

    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping(value = "/login_by_code")
    @ResponseBody
    public MyJsonResult login(@RequestParam("code") String code,HttpServletRequest request)
    {
        // 获取openid
        Map<String, String> param = new HashMap<>();
        param.put("appid", tools.WX_LOGIN_APPID);
        param.put("secret", tools.WX_LOGIN_SECRET);
        param.put("js_code", code);//code
        param.put("grant_type", tools.WX_LOGIN_GRANT_TYPE);
        // 发送请求
        String wxResult = HttpClientUtil.doGet(tools.WX_LOGIN_URL, param);
        JSONObject jsonObject = JSONObject.parseObject(wxResult);
        // 获取参数返回的
        String open_id = jsonObject.get("openid").toString();
        User user = userService.getUserByOpenid(open_id);
        if(user != null)
        {
            //注册sessionid
            request.getSession().setMaxInactiveInterval(120*60);//以秒为单位，即在没有活动120分钟后，session将失效
            request.getSession().setAttribute("userid",user.getUser_id());//用户名存入该用户的session 中
            request.getSession().setAttribute("myuser",user);
            String sessionid = request.getSession().getId();
            logger.info("login-by-openid:"+user.getUser_phone());
            user.setUser_pwd("");
            return MyJsonResult.build(200,sessionid,user);
        }
        return MyJsonResult.errorMsg("请使用账号密码登录");
    }

    @PostMapping("/wx_login_user")
    @ResponseBody
    public MyJsonResult wx_login(@RequestBody User user,
                                 HttpServletRequest request
                                 ){
        // 获取openid
        Map<String, String> param = new HashMap<>();
        param.put("appid", tools.WX_LOGIN_APPID);
        param.put("secret", tools.WX_LOGIN_SECRET);
        param.put("js_code", user.getUser_id());//code
        param.put("grant_type", tools.WX_LOGIN_GRANT_TYPE);
        // 发送请求
        String wxResult = HttpClientUtil.doGet(tools.WX_LOGIN_URL, param);
        JSONObject jsonObject = JSONObject.parseObject(wxResult);
        // 获取参数返回的
        String pwdMD5 = tools.pwdMD5(user.getUser_pwd()).substring(8, 24);
        User myuser = userService.login_user(user.getUser_phone(), pwdMD5);
        //String open_id = jsonObject.get("openid").toString();
        if(myuser != null)
        {
            //注册sessionid
            request.getSession().setMaxInactiveInterval(120*60);//以秒为单位，即在没有活动120分钟后，session将失效
            request.getSession().setAttribute("userid",myuser.getUser_id());//用户名存入该用户的session 中
            request.getSession().setAttribute("myuser",myuser);
            //request.getSession().setAttribute("openid",open_id);
            String sessionid = request.getSession().getId();
            logger.info("user {} login:",myuser.getUser_phone());
            myuser.setUser_pwd("");
            return MyJsonResult.build(200,sessionid,myuser);
        }
        logger.info("user {} login failure：",user.getUser_phone());
        return MyJsonResult.errorMsg("密码错误");

    }

    //异步检查用户手机号是否已经注册---id-phone 都是唯一的等效
    @GetMapping(value ="/register/check_phone")
    @ResponseBody
    public MyJsonResult checkPhone(@RequestParam("user_phone") String userPhone) {
        //判断手机号是否注册
        if (userService.findUserPhone(userPhone)) {
            return MyJsonResult.errorMsg("the phone had been registered");
        }
        return MyJsonResult.buildData("ok");
    }


    /**
     * 用户注册功能：
     * 1、前端先进行用户手机号检测（异步请求），所以注册时，不再检查手机号码是否注册
     * 2、同一个人可以用多个手机号注册，不需要检查人名，而且可能有同名同姓的人
     */
    @RequestMapping(value ="/register/ok")
    public MyJsonResult register(@RequestBody User user) {
        // 根据时间值随机生成用户ID
        String userId = tools.createUserId(0, 1);
        user.setUser_id(userId);
        // 对用户密码进行MD5加密,取16位
        String pwd = tools.pwdMD5(user.getUser_pwd()).substring(8, 24);
        user.setUser_pwd(pwd);
        // 存入数据库
        if(userService.save_user(user)){
            user.setUser_pwd("");
            return MyJsonResult.buildData(user);
        }
        return MyJsonResult.errorMsg("register error");
    }

    @PostMapping(value ="/wx_register")
    @ResponseBody
    public MyJsonResult wx_register(@RequestBody User user,
                                  HttpServletRequest request) {
        // 获取openid
        Map<String, String> param = new HashMap<>();
        param.put("appid", tools.WX_LOGIN_APPID);
        param.put("secret", tools.WX_LOGIN_SECRET);
        param.put("js_code", user.getUser_id());//前台把code通过这个参数临时传过来，后面改成openid
        param.put("grant_type", tools.WX_LOGIN_GRANT_TYPE);
        // 发送请求
        //System.out.println(user.getUser_id());
        String wxResult = HttpClientUtil.doGet(tools.WX_LOGIN_URL, param);
        JSONObject jsonObject = JSONObject.parseObject(wxResult);
        // 获取参数返回的
        String open_id = jsonObject.get("openid").toString();
        user.setUser_id(tools.createUserId(0,1));
        // 对用户密码进行MD5加密,取16位
        String pwdMD5 = tools.pwdMD5(user.getUser_pwd()).substring(8, 24);
        user.setUser_pwd(pwdMD5);
        user.setUser_name("");//默认名字为空
        user.setUser_gender(1);//默认性别为男
        // 保存open_id
        user.setOpen_id(open_id);
        // 存入数据库
        if(userService.save_user(user)){
            logger.trace("new user {} register ",user.getUser_phone());
            return MyJsonResult.buildData("ok");
        }
        return MyJsonResult.errorMsg("register error");
    }
    @PostMapping(value ="/change_user_info")
    @ResponseBody
    public MyJsonResult change_user_info(@RequestBody User user,HttpServletRequest request){
        User myuser = (User) request.getSession().getAttribute("myuser");
        if(myuser != null){
            String name = user.getUser_name();
            int gender = user.getUser_gender();
            myuser.setUser_name(name);
            myuser.setUser_gender(gender);
            userService.update_info(myuser.getUser_id(),name,gender);
            return MyJsonResult.buildData("ok");
        }
        return MyJsonResult.errorMsg("请先登录");

    }

}
















