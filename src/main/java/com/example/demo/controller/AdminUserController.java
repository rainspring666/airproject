package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.User;
import com.example.demo.entity.UserHolder;
import com.example.demo.entity.User_info;
import com.example.demo.entity.User_role;
import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.service.UserInfoService;
import com.example.demo.service.UserService;
import com.example.demo.service.User_roleService;
import com.example.demo.tools.MyJsonResult;
import com.example.demo.tools.PageInfoTool;
import com.example.demo.tools.Tool;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/bg/admin")
public class AdminUserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private User_roleService user_roleService;

    @Autowired
    private Tool tools;

    Logger logger = LoggerFactory.getLogger(getClass());



    @GetMapping(value = "/user/show_all_user")
    @ResponseBody
    public Map<String,Object> selectAllUser(@RequestParam(required = false,defaultValue = "1") int page,
                                             @RequestParam(required = false,defaultValue = "15") int limit)
    {
//        PageHelper.startPage(page, limit);

        List<User> userList = userService.selectAllUser(2);
        List<User> employeeList = userService.selectAllUser(3);
        List<User> tempUserList = userService.selectAllUser(4);


        List<UserHolder> userHolders = new LinkedList<>();

        pushData(userList, userHolders, 1);

        pushData(employeeList, userHolders, 2);

        pushData(tempUserList, userHolders, 3);

        PageInfo pageInfo = PageInfoTool.list2PageInfo(userHolders, page, limit);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        // return map;

        if (!userHolders.isEmpty()){
            map.put("msg","操作成功");
            return map;
        }
        map.put("msg","操作失败");
        return map;
    }

    @GetMapping("/user/search")
    @ResponseBody
    public Map<String,Object> search_user(HttpServletRequest request){

        JSONObject searchParams = JSONObject.parseObject(request.getParameter("searchParams"));
        //PageHelper.startPage(1, 20);

        String user_id = searchParams.getString("user_id");
        String user_name = searchParams.getString("user_name");
        String user_phone = searchParams.getString("user_phone");
        //多条件搜索
        List<User> userList = userService.selectUserByParams(user_id, user_name, user_phone, 2);
        List<User> employeeList = userService.selectUserByParams(user_id, user_name, user_phone, 3);

        List<User> tempUserList = userService.selectAllUser(4);

        List<UserHolder> userHolders = new LinkedList<>();
        pushData(userList, userHolders, 1);
        pushData(employeeList, userHolders, 2);
        pushData(tempUserList, userHolders, 3);

        PageInfo pageInfo = PageInfoTool.list2PageInfo(userHolders, 1, 10);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        if (!userHolders.isEmpty()){
            map.put("msg","操作成功");
            return map;
        }
        map.put("msg","操作失败");
        return map;
    }

    @PostMapping("/bg_add_user")
    @ResponseBody
    public MyJsonResult add_user(@RequestBody UserHolder userHolder){

        logger.info("userHolder:"+userHolder.toString());
        // 创建user、user_role、user_info
        User user = new User();
        String user_id = tools.createUserId(0,1);
        user.setUser_id(user_id);
        user.setUser_name(userHolder.getUser_name());
        user.setUser_pwd(userHolder.getUser_pwd());
        user.setUser_gender(userHolder.getUser_gender().equals("男")?1:0);
        user.setUser_phone(userHolder.getUser_phone());

        User_role user_role = new User_role();
        user_role.setUser_id(user_id);
        user_role.setRole_id(userHolder.getRole_desc().equals("普通用户")?2:3);

        User_info user_info = new User_info();
        user_info.setUser_id(user_id);
        user_info.setUser_address(userHolder.getUser_address());
        user_info.setUser_gender(userHolder.getUser_gender().equals("男")?1:0);
        user_info.setUser_name(userHolder.getUser_name());
        user_info.setUser_nickname(userHolder.getUser_nickname());


        logger.info("添加新用户：user:"+user.toString()+"user_info:"+user_info.toString());
        // firm_id 未设置，如果用到请在此处添加！！！！！
        if(userService.save_user(user) && user_roleService.add_user_role(user_role)
                && userInfoService.add_user_info(user_info))
            return MyJsonResult.buildData("ok");

        return MyJsonResult.errorMsg("error");
    }

    @PostMapping("/reset_user")
    @ResponseBody
    public MyJsonResult reset_User(@RequestBody String user_id){
        System.out.println(user_id);
        logger.info("reset_user----user_id:"+user_id);

        if(userService.reset_user(user_id))
            return MyJsonResult.buildData("ok");

        return MyJsonResult.errorMsg("error");
    }

    @PostMapping("/del_user")
    @ResponseBody
    public MyJsonResult del_User(@RequestBody String user_id){
        System.out.println(user_id);
        logger.info("del_user----user_id:"+user_id);

        if(userInfoService.del_user_info(user_id) && user_roleService.del_user_role(user_id)
                && userService.del_user(user_id))
            return MyJsonResult.buildData("ok");

        return MyJsonResult.errorMsg("error");
    }

    public void pushData(List<User> userList, List<UserHolder> userHolders, int kind){
        for (User i :userList){
            User_info user_info = userInfoService.get_user_info_by_id(i.getUser_id());
            UserHolder userHolder = new UserHolder();
            userHolder.setUser_id(i.getUser_id());
            userHolder.setUser_pwd(i.getUser_pwd());
            userHolder.setUser_nickname(user_info.getUser_nickname());
            userHolder.setUser_name(user_info.getUser_name());
            userHolder.setUser_gender(user_info.getUser_gender() == 1? "男" : "女");
            userHolder.setUser_phone(i.getUser_phone());
            userHolder.setUser_address(user_info.getUser_address());
            if(kind == 1){
                userHolder.setRole_desc("普通用户");
            }else if(kind == 2){
                userHolder.setRole_desc("企业用户");
            }else
                userHolder.setRole_desc("游客用户");
            userHolders.add(userHolder);
        }
    }
}
