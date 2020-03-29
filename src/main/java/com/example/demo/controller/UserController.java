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
    private Tool tools;

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
        System.out.println(userPwd);
        //String userpwd = tools.pwdMD5(userPwd);
        User user = userService.login_user(userPhone, userPwd);
        //System.out.println(user.getUser_name());

        if(user != null)
        {
            user.setUser_pwd("");
            return JsonResult.buildData(user);
        }
        return JsonResult.errorMsg("not found");

    }

    //用户注册
    @PostMapping("/register")
    public JsonResult register(@RequestBody User user) {
        System.out.println("进来了……");
        System.out.println(user.getUser_name());
        //判断用户名和密码不为空

        //判断用户名是否存在
        if (userService.findUserNickname(user.getUser_nickname())) {
            return JsonResult.errorMsg("the nickname had been used,please try others");
        } else if (userService.findUserPhone(user.getUser_phone())) {
            return JsonResult.errorMsg("the phone had been registered, please login");
        } else {
            try {
                String id = String.valueOf(tools.createUserId(0,1));
                user.setUser_id(id);
                userService.save_user(user);
                user.setUser_pwd("");
                return JsonResult.buildData(user);
            } catch (Exception e) {
                return JsonResult.errorMsg("something error");
            }
        }
    }

}
















