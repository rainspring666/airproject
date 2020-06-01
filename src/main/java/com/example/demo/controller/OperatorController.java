package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Operator;
import com.example.demo.entity.Order;
import com.example.demo.entity.Process;
import com.example.demo.service.OperatorService;
import com.example.demo.service.ProcessService;
import com.example.demo.tools.HttpClientUtil;
import com.example.demo.tools.MyJsonResult;
import com.example.demo.tools.Tool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/operator")
public class OperatorController {
    @Autowired
    private Tool tools;

    @Autowired
    private OperatorService operatorService;

    @Autowired
    private ProcessService processService;

    Logger logger = LoggerFactory.getLogger(getClass());

    //登录
    @PostMapping("/wx_login_operator")
    @ResponseBody
    public MyJsonResult wx_login(@RequestParam("user_phone") String phone,
                                 @RequestParam("user_pwd") String pwd,
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

        String pwdMD5 = tools.pwdMD5(pwd).substring(8, 24);
        Operator operator = operatorService.wx_login_operator(phone,pwdMD5);

        request.getSession().setMaxInactiveInterval(120*60);//以秒为单位，即在没有活动120分钟后，session将失效
        String sessionid = request.getSession().getId();

        if(operator != null)
        {
            String wx_openid = operator.getWx_openid();
            logger.info("操作员登录："+operator.getOp_phone());
            if(wx_openid==null){
                operatorService.wx_bind(operator.getOp_id(),open_id);//绑定微信
                operator.setWx_openid(open_id);
                return MyJsonResult.build(200,"初次登陆 已绑定当前微信",sessionid);
            }else{
                request.getSession().setAttribute("operator",operator);
                return MyJsonResult.build(200,"",sessionid);
            }

        }
        return MyJsonResult.errorMsg("not found you");

    }

    //显示所有自己的订单 byopid
    @PostMapping("wx_show_orders")
    @ResponseBody
    public JSONArray wx_show_orders(HttpServletRequest request){
        String userId = request.getSession().getAttribute("userID").toString();//获取存储的操作员id
        List<Order> list = operatorService.wx_show_orders(userId);
        return JSONArray.parseArray(JSON.toJSONString(list));

    }

    //展示操作员的所有流程信息 别忘记筛选
    @PostMapping("wx_show_processes")
    @ResponseBody
    public JSONArray wx_show_processes(HttpServletRequest request){
        Operator operator = (Operator) request.getSession().getAttribute("operator");//获取存储的操作员id
        List<Process> list = processService.get_my_process(operator.getOp_id());
        return JSONArray.parseArray(JSON.toJSONString(list));
    }

    //查看一个订单的详情--显示对应的流程



    //对流程进行编辑---现场操作功能


    //图片上传
    @RequestMapping("/upload_pictures")
    @ResponseBody
    public MyJsonResult upload(HttpServletRequest request,
                               @RequestParam(value = "file", required = false) MultipartFile file) {
        String path = null;
        try {
            request.setCharacterEncoding("UTF-8");
            String op_id = request.getSession().getAttribute("userID").toString();
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();

                String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
                if (type != null) {
                    if ("PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                        // 自定义的文件名称 以后还要加上orderid 区分多张图片
                        String trueFileName = String.valueOf(op_id + System.currentTimeMillis()) + fileName;
                        // 设置存放图片文件的路径
                        path = tools.UPLOAD_PICTURE_PATH  + trueFileName;
                        File dir = new File(tools.UPLOAD_PICTURE_PATH);
                        if (!dir.exists()) {
                            dir.mkdir();
                        }
                        file.transferTo(new File(path));
                    } else {
                        return MyJsonResult.errorMsg("文件类型错误");
                    }
                } else {
                    return MyJsonResult.errorMsg("文件类型空");
                }
            } else {
                return MyJsonResult.errorMsg("貌似你的图片上传失败了呢");
            }
        } catch (IOException e){
            System.out.println("图片上传这里有异常");
        }
        return MyJsonResult.buildData(path);//成功的话 返回图片在服务器的路径 暂时只能一张图片
    }


    //后台添加操作员用户
    @PostMapping("bg_add_operator")
    @ResponseBody
    public MyJsonResult br_add_operator(@RequestBody Operator operator,
                                     HttpServletRequest request){
        operator.setOp_id(tools.createUserId(0,1));
        if(operatorService.bg_add(operator))
            return MyJsonResult.buildData("用户创建成功");
        return MyJsonResult.errorMsg("失败");
    }


}
