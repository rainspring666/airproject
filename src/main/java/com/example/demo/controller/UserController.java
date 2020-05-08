package com.example.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.tools.HttpClientUtil;
import com.example.demo.tools.MyJsonResult;
import com.example.demo.tools.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private Tool tools;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public MyJsonResult login(@RequestParam("user_phone") String userPhone,
                              @RequestParam("user_pwd") String userPwd)
    {
        // 进行MD5加密，并取16位
        System.out.println(userPhone);
        System.out.println(userPwd);
        String pwdMD5 = tools.pwdMD5(userPwd).substring(8, 24);
        User user = userService.login_user(userPhone, pwdMD5);
        if(user != null)
        {
            user.setUser_pwd("");
            return MyJsonResult.buildData(user);
        }
        return MyJsonResult.errorMsg("not such user");
    }

    @PostMapping("/wx_login_user")
    @ResponseBody
    public MyJsonResult wx_login(@RequestParam("user_phone") String userPhone,
                                 @RequestParam("user_pwd") String userPwd,
                                 @RequestParam("code") String code,
                                 HttpServletRequest request){
        // 获取openid
        Map<String, String> param = new HashMap<>();
        param.put("appid", tools.WX_LOGIN_APPID);
        param.put("secret", tools.WX_LOGIN_SECRET);
        param.put("js_code", code);
        param.put("grant_type", tools.WX_LOGIN_GRANT_TYPE);
        // 发送请求
        String wxResult = HttpClientUtil.doGet(tools.WX_LOGIN_URL, param);
        JSONObject jsonObject = JSONObject.parseObject(wxResult);
        // 获取参数返回的
        String open_id = jsonObject.get("openid").toString();

        String pwdMD5 = tools.pwdMD5(userPwd).substring(8, 24);
        User user = userService.login_user(userPhone, pwdMD5);

        if(user != null)
        {
            //注册sessionid
            request.getSession().setMaxInactiveInterval(120*60);//以秒为单位，即在没有活动120分钟后，session将失效
            request.getSession().setAttribute("openid",open_id);//用户名存入该用户的session 中
            String sessionid = request.getSession().getId();
            return MyJsonResult.buildData(sessionid);
        }
        return MyJsonResult.errorMsg("请先注册绑定");

    }

    //异步检查用户手机号是否已经注册---id-phone 都是唯一的等效
    @RequestMapping(value ="/register/check_phone")
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

    @RequestMapping(value ="/wx_register")
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
        String wxResult = HttpClientUtil.doGet(tools.WX_LOGIN_URL, param);
        JSONObject jsonObject = JSONObject.parseObject(wxResult);
        // 获取参数返回的
        String open_id = jsonObject.get("openid").toString();
        user.setUser_id(open_id);
        // user.setUser_picture("temp_path");//参数禁用
        // 对用户密码进行MD5加密,取16位
        String pwd = tools.pwdMD5(user.getUser_pwd()).substring(8, 24);
        user.setUser_pwd(pwd);

        // 存入数据库
        if(userService.save_user(user)){
            return MyJsonResult.buildData("ok");
        }
        return MyJsonResult.errorMsg("register error");
    }

}
















