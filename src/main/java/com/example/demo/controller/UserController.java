package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.tools.JsonResult;
import com.example.demo.tools.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserController {

    private Tool tools = new Tool();

    @Autowired
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id){
        System.out.println(id);
        return userService.Sel(id).toString();
    }


    @GetMapping(value = "/login")
    public JsonResult login(@RequestParam("user_phone") String userPhone,
                        @RequestParam("user_pwd") String userPwd)
    {
        // 进行MD5加密，并取16位
        String pwdMD5 = tools.pwdMD5(userPwd).substring(8, 24);
        User user = userService.login_user(userPhone, pwdMD5);
        if(user != null)
        {
            user.setUser_pwd("");
            return JsonResult.buildData(user);
        }
        return JsonResult.errorMsg("not such user");
    }
    @RequestMapping(value ="/register/check")
    public JsonResult checkPhone(@RequestParam("user_phone") String userPhone) {
        //判断手机号是否注册
        if (userService.findUserPhone(userPhone)) {
            return JsonResult.errorMsg("the phone had been registered");
        }
        return JsonResult.buildData("ok");
    }

    /**
     * 用户注册功能：
     * 1、前端先进行用户手机号检测（异步请求），所以注册时，不再检查手机号码是否注册
     * 2、同一个人可以用多个手机号注册，不需要检查人名，而且可能有同名同姓的人
     */
    @RequestMapping(value ="/register/ok")
    public JsonResult register(@RequestBody User user) {
        // 根据时间值随机生成用户ID
        String userId = tools.createUserId(0, 1);
        user.setUser_id(userId);
        // 对用户密码进行MD5加密,取16位
        String pwd = tools.pwdMD5(user.getUser_pwd()).substring(8, 24);
        user.setUser_pwd(pwd);
        // 存入数据库
        if(userService.save_user(user)){
            user.setUser_pwd("");
            return JsonResult.buildData(user);
        }
        return JsonResult.errorMsg("register error");
    }

}
















