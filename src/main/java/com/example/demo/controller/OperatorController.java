package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.*;
import com.example.demo.entity.Process;
import com.example.demo.service.DataService;
import com.example.demo.service.EquipService;
import com.example.demo.service.MaterialService;
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
import sun.util.resources.ms.CalendarData_ms_MY;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/operator")
public class OperatorController {
    @Autowired
    private Tool tools;

    @Autowired
    private OperatorService operatorService;

    @Autowired
    private ProcessService processService;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private EquipService equipService;
    @Autowired
    private DataService dataService;

    Logger logger = LoggerFactory.getLogger(getClass());

    //登录
    @PostMapping("/wx_login_operator")
    @ResponseBody
    public MyJsonResult wx_login(@RequestBody Operator operator,HttpServletRequest request){
        // 获取openid
        Map<String, String> param = new HashMap<>();
        param.put("appid", tools.WX_LOGIN_APPID);
        param.put("secret", tools.WX_LOGIN_SECRET);
        param.put("js_code", operator.getOp_id());
        param.put("grant_type", tools.WX_LOGIN_GRANT_TYPE);
        // 发送请求
        String wxResult = HttpClientUtil.doGet(tools.WX_LOGIN_URL, param);
        JSONObject jsonObject = JSONObject.parseObject(wxResult);
        // 获取参数返回的
        String open_id = jsonObject.get("openid").toString();

//        String pwdMD5 = tools.pwdMD5(pwd).substring(8, 24);
//        Operator operator = operatorService.wx_login_operator(phone,pwdMD5);

        Operator tempOperator = operatorService.wx_login_operator(operator.getOp_phone(),operator.getOp_pwd());

        request.getSession().setMaxInactiveInterval(120*60);//以秒为单位，即在没有活动120分钟后，session将失效
        String sessionid = request.getSession().getId();

        if(tempOperator != null)
        {
            String wx_openid = tempOperator.getWx_openid();
            logger.info("操作员登录："+tempOperator.getOp_phone());
            if(wx_openid==null){
                operatorService.wx_bind(tempOperator.getOp_id(),open_id);//绑定微信
                operator.setWx_openid(open_id);
                request.getSession().setAttribute("operator",tempOperator);
                return MyJsonResult.build(200,"初次登陆 已绑定当前微信",sessionid);
            }else{
                request.getSession().setAttribute("operator",tempOperator);
                return MyJsonResult.build(200,"",sessionid);
            }

        }

        return MyJsonResult.errorMsg("not found you");

    }

    //显示所有自己的订单 byopid
    @GetMapping("/wx_show_orders")
    @ResponseBody
    public JSONArray wx_show_orders(HttpServletRequest request){
        Operator operator = (Operator) request.getSession().getAttribute("operator");//获取存储的操作员id
        List<Order> list = operatorService.wx_show_orders(operator.getOp_id());
        logger.info(JSON.toJSONString(list));
        return JSONArray.parseArray(JSON.toJSONString(list));

    }

    //展示操作员的所有流程信息 别忘记筛选
    @GetMapping("/wx_show_processes")
    @ResponseBody
    public JSONArray wx_show_processes(HttpServletRequest request){
        Operator operator = (Operator) request.getSession().getAttribute("operator");//获取存储的操作员id
        List<Process> list = processService.get_my_process(operator.getOp_id());
        return JSONArray.parseArray(JSON.toJSONString(list));
    }



    //物料列表返回给前台
    @GetMapping("/wx_show_material")
    @ResponseBody
    public JSONArray wx_show_material(HttpServletRequest request){
        List<Material> list = materialService.get_material_info();
        logger.info(JSON.toJSONString(list));
        return JSONArray.parseArray(JSON.toJSONString(list));
    }

    //物料列表返回给前台
    @GetMapping("/wx_show_equipment")
    @ResponseBody
    public JSONArray wx_show_equipment(HttpServletRequest request){
        List<Equipment> list = equipService.get_equipment_info();
        logger.info(JSON.toJSONString(list));
        return JSONArray.parseArray(JSON.toJSONString(list));
    }

    static class MaterialHolder{
        // 静态内部类
        public String material_id;
        public String apply_num;
    }

    //申请物料--     !是否要加入回滚的机制？
    @PostMapping("/check_material")
    @ResponseBody
    public MyJsonResult apply_ma(@RequestBody MaterialHolder[] list, HttpServletRequest request){
        /*
        * 前台以json数组的形式传入后台{material_id:id;apply_num:num},{...}
        * 先解析为数组，进行遍历，查询是否满足请求条件，不满足提示前台
        * 进行物料请求操作
        * */
//        for (MaterialHolder h: list) {
//            System.out.println(h.material_id +" !!"+ h.apply_num);
//        }
//        System.out.println("123");

        List<Material> materialList = materialService.get_material_info();
        Map<String, Material> materialMap = new HashMap<>();
        for (Material m: materialList) {
            materialMap.put(m.getMaterial_id(), m);
        }

        boolean contain = true; String result = "";

        for (MaterialHolder m: list) {
//            String material_id = null; int apply_num = 0;
//            for (Map.Entry<String, String> entry: m.entrySet()) {
//                System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue() + ";");
//                if(material_id == null)
//                    material_id = entry.getKey();
//                else
//                    apply_num = Integer.parseInt(entry.getValue());
//            }

            // 是否满足
            if(materialMap.get(m.material_id).getMa_number() < Integer.parseInt(m.apply_num)){
                contain = false;
                result  = result + materialMap.get(m.material_id).getMa_name() +"库存不足，仅剩"
                        + materialMap.get(m.material_id).getMa_number() + "个/n";
            }
        }

        if(!contain){
            logger.info("物料请求失败"+result);
            return MyJsonResult.errorMsg("物料请求失败"+result);
        }else{
            // 物料操作
            for (MaterialHolder m: list) {
                Material material = materialMap.get(m.material_id);
                material.setMa_number(material.getMa_number() - Integer.parseInt(m.apply_num));
                materialService.update_material_info(material);

                // 申请表

                logger.info(m.material_id+"物料请求"+m.apply_num);
            }
        }
        return MyJsonResult.buildData("ok");
    }


    //申请仪器---没完成啊-不知道怎么写好
    @PostMapping("/check_equipment")
    @ResponseBody
    public MyJsonResult apply_ep(@RequestBody List<String> applyList,HttpServletRequest request){
        // applyList存储申请设备的id
        for (String i: applyList) {
            System.out.println(i);
        }
        System.out.println("123");

        Map<String, Equipment> equipmentMap = new HashMap<>();

        List<Equipment> equipmentList = equipService.get_equipment_info();
        for (Equipment e: equipmentList) {
            equipmentMap.put(e.getEq_id(), e);
        }

        boolean contain = true; String result = "";

        for (String i: applyList) {
            // 查看是否在使用
            Equipment equipment = equipmentMap.get(i);
            if(equipment.getEq_state().equals("1") ){
                contain = false;
                result = result + equipment.getEq_name()+"被使用";
            }
        }

        if(!contain){
            logger.info("设备请求失败"+result);
            return MyJsonResult.errorMsg("设备请求失败"+result);
        }else{
            // 设备请求
            for (String e: applyList) {
                Equipment equipment = equipmentMap.get(e);
                equipment.setEq_state("1");
                equipService.update_equipment_info(equipment);

                //申请表

                logger.info("设备请求"+equipment.getEq_name());
            }
        }

        return MyJsonResult.buildData("ok");
    }

    //上传空气监测数据
    @PostMapping("/upload_detection_data")
    @ResponseBody
    public MyJsonResult upload_detection_data(@RequestBody Data data, HttpServletRequest request){
        String data_id = tools.createOrderId();
        data.setDdata_id(data_id);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        data.setDdata_time(dateString);
        data.setProcess_id("123124124");


//        Process process = processService.get_one_info(data.getProcess_id());
//        if(process == null){
//            return MyJsonResult.errorMsg("error--");
//        }
//        process.setDdata_id(data_id);//补充process的dataid
        logger.info(data.toString());
        if(dataService.add_data(data)){
//            processService.update_info(process);
            return MyJsonResult.buildData("ok");
        }
        else
            return MyJsonResult.errorMsg("error load data");

    }
    //开始监测 记录开始时间 更新状态
    @PostMapping("/start_detection")
    @ResponseBody
    public MyJsonResult start_1(HttpServletRequest request,@RequestParam("process_id") String process_id){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);

        Process process = processService.get_one_info(process_id);
        if(process==null)
            return MyJsonResult.errorMsg("error--");
        process.setPro_starttime(dateString);
        process.setPro_state("1");
        if(processService.update_info(process))
            return MyJsonResult.buildData("ok");
        else
            return MyJsonResult.errorMsg("error");

    }


    //结束监测 记录结束时间
    @PostMapping("/end_detection")
    @ResponseBody
    public MyJsonResult end_2(HttpServletRequest request,@RequestParam("process_id") String process_id){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);

        Process process = processService.get_one_info(process_id);
        if(process==null)
            return MyJsonResult.errorMsg("error--");
        process.setPro_endtime(dateString);
        process.setPro_state("2");
        if(processService.update_info(process))
            return MyJsonResult.buildData("ok");
        else
            return MyJsonResult.errorMsg("error");

    }

    //获取开始时间，方便前端的倒计时
    @PostMapping("/get_one_infoByProcessId")
    @ResponseBody
    public MyJsonResult get_one_info1(HttpServletRequest request,@RequestParam("process_id") String process_id){
        Process process = processService.get_one_info(process_id);
        if(process==null)
            return MyJsonResult.errorMsg("error--");
        else
            return MyJsonResult.buildData(process);

    }
    //初步的根据订单获取流程信息
    @PostMapping("/get_one_infoByOrderId")
    @ResponseBody
    public MyJsonResult get_one_info2(HttpServletRequest request,@RequestParam("order_id") String order_id){
        Process process = processService.get_one_info2(order_id);
        if(process==null)
            return MyJsonResult.errorMsg("error--");
        else
            return MyJsonResult.buildData(process);

    }

    //物流快递信息更新
    @PostMapping("/update_express")
    @ResponseBody
    public MyJsonResult update_express(HttpServletRequest request,@RequestParam("process_id") String process_id
            ,@RequestParam("express_id") String express_id
            ,@RequestParam("express_name") String express_name){

        Process process = processService.get_one_info(process_id);
        if(process==null)
            return MyJsonResult.errorMsg("error--");
        process.setExpress_id(express_id);
        process.setExpress_name(express_name);
        if(processService.update_info(process))
            return MyJsonResult.buildData("ok");
        else
            return MyJsonResult.errorMsg("error");

    }


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
