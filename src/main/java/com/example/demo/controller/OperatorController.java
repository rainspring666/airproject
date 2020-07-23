package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.demo.entity.Process;
import com.example.demo.entity.*;
import com.example.demo.mapper.ReportMapper;
import com.example.demo.service.*;
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
import java.text.ParseException;
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
    @Autowired
    private ReportMapper reportMapper;

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
        // 有时会报空指针异常
        String op_id = operator.getOp_id();
        List<Order> list = operatorService.wx_show_orders(op_id);
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
        List<ApplyHolder> applyHolders = new ArrayList<>();
        for (Material i: list) {
            if(i.getMa_number() >0 ){
                ApplyHolder applyHolder = new ApplyHolder();
                applyHolder.name = i.getMa_name();
                applyHolder.num = 0;
                applyHolder.stock = i.getMa_number();
                applyHolders.add(applyHolder);
            }
        }
        logger.info(JSON.toJSONString(applyHolders));
        return JSONArray.parseArray(JSON.toJSONString(applyHolders));
    }

    //物料列表返回给前台
    @GetMapping("/wx_show_equipment")
    @ResponseBody
    public JSONArray wx_show_equipment(HttpServletRequest request){
        List<Equipment> list = equipService.get_equipment_info();

        Map<String, Integer> map = new HashMap<>();

        List<ApplyHolder> applyHolders = new ArrayList<>();
        for (Equipment i: list) {
            if(i.getEq_inner_num() >0 && i.getEq_state() == 0){
                // 现有数量大于0且未被禁用
                if(map.containsKey(i.getEq_type())){
                    int temp = map.get(i.getEq_type());
                    temp += i.getEq_inner_num();
                    map.put(i.getEq_type(), temp);
                }else{
                    map.put(i.getEq_type(), i.getEq_inner_num());
                }
            }
        }

        // 构造数组
        for(Map.Entry<String, Integer> entry:map.entrySet()){
            ApplyHolder applyHolder = new ApplyHolder();
            applyHolder.name = entry.getKey();
            applyHolder.num = 0;
            applyHolder.stock = entry.getValue();
            applyHolders.add(applyHolder);
        }

        logger.info(JSON.toJSONString(applyHolders));
        return JSONArray.parseArray(JSON.toJSONString(applyHolders));
    }

    static class ApplyHolder{
        // 静态内部类
        public String name;
        public int num;
        public int stock;

        @Override
        public String toString() {
            return "ApplyHolder{" +
                    "name='" + name + '\'' +
                    ", num='" + num + '\'' +
                    ", stock='" + stock + '\'' +
                    '}';
        }
    }

    //申请物料--     !是否要加入回滚的机制？
    @PostMapping("/check_material")
    @ResponseBody
    public MyJsonResult apply_ma(@RequestBody JSONObject jsonObject, HttpServletRequest request){
        /*
        * 前台以ApplyHolder数组的形式传入后台
        * 先解析为数组，进行遍历，查询是否满足请求条件，不满足提示前台
        * 进行物料请求操作
        * */
        JSONArray jsonArray = jsonObject.getJSONArray("applyList");
        List<ApplyHolder> applyList = JSONArray.parseArray(jsonArray.toString(), ApplyHolder.class);

        List<Material> materialList = materialService.get_material_info();
        Map<String, Material> materialMap = new HashMap<>();
        for (Material m: materialList) {
            materialMap.put(m.getMa_name(), m);
        }

        boolean contain = true; String result = "";

        for (ApplyHolder m: applyList) {

            // 是否满足
            if(materialMap.get(m.name).getMa_number() < m.num){
                contain = false;
                result  = result + m.name +"库存不足，仅剩"
                        + materialMap.get(m.name).getMa_number() + "个/n";
            }
        }

        if(!contain){
            logger.info("物料请求失败"+result);
            return MyJsonResult.errorMsg("物料请求失败"+result);
        }else{
            // 物料操作
            for (ApplyHolder m: applyList) {
                Material material = materialMap.get(m.name);
                material.setMa_number(material.getMa_number() - m.num);
                materialService.update_material_info(material);

                // 申请表

                logger.info(m.name+"物料请求"+m.num);
            }
        }
        return MyJsonResult.buildData("ok");
    }


    //申请仪器---没完成啊-不知道怎么写好
    @PostMapping("/check_equipment")
    @ResponseBody
    public MyJsonResult apply_ep(@RequestBody JSONObject jsonObject,HttpServletRequest request){

        JSONArray jsonArray = jsonObject.getJSONArray("applyList");
        List<ApplyHolder> applyList = JSONArray.parseArray(jsonArray.toString(), ApplyHolder.class);
        Map<String, List<Equipment>> equipmentMap = new HashMap<>();

        List<Equipment> equipmentList = equipService.get_equipment_info();
        for (Equipment e: equipmentList) {
            if(e.getEq_state() == 0 && e.getEq_inner_num() >0){
                // 现有数量大于0且未被禁用
                if(equipmentMap.containsKey(e.getEq_type())){
                    List<Equipment> equipmentList1 = equipmentMap.get(e.getEq_type());
                    equipmentList1.add(e);
                    equipmentMap.put(e.getEq_type(), equipmentList1);
                }else{
                    List<Equipment> equipmentList1 = new ArrayList<>();
                    equipmentList1.add(e);
                    equipmentMap.put(e.getEq_type(), equipmentList1);
                }
            }

        }

        boolean contain = true; String result = "";

        for (ApplyHolder i: applyList) {
            // 查看是否在使用
            List<Equipment> equipmentList1 = equipmentMap.get(i.name);
            int totalNum = 0;
            for (Equipment e: equipmentList1) {
                if(e.getEq_state() == 0 && e.getEq_inner_num() > 0)
                    totalNum += e.getEq_inner_num();
            }
            if(totalNum < i.num){
                // 超出请求
                contain = false;
                result = result + i.name + "库存不足";
            }
        }

        if(!contain){
            logger.info("设备请求失败"+result);
            return MyJsonResult.errorMsg("设备请求失败"+result);
        }else{
            // 设备请求
            for (ApplyHolder i: applyList) {
                List<Equipment> equipmentList1 = equipmentMap.get(i.name);
                // 按顺序请求设备
                int apply_num =i.num;
                for (Equipment e: equipmentList1) {
                    if(apply_num == 0)
                        break;
                    if(e.getEq_state() != 0 || e.getEq_inner_num() <= 0 )
                        continue;
                    if(e.getEq_inner_num() >= apply_num){
                        e.setEq_inner_num(e.getEq_inner_num() - apply_num);
                        apply_num = 0;
                    }else{
                        e.setEq_inner_num(0);
                        apply_num = apply_num - e.getEq_inner_num();
                    }
                    equipService.update_equipment_info(e);

                    //申请表


                }
                logger.info("设备请求"+i.name+i.num+"个");

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


        Process process = processService.get_one_info(data.getProcess_id());
        if(process == null){
            return MyJsonResult.errorMsg("error--");
        }
        process.setDdata_id(data_id);//补充process的dataid
        logger.info(data.toString());
        if(dataService.add_data(data)){
            processService.update_info(process);
            return MyJsonResult.buildData("ok");
        }
        else
            return MyJsonResult.errorMsg("error load data");

    }

    /**
     * 开始监测 记录开始时间 更新状态
     *
     * @param tempProcess 流程ID
     * @return MyJsonResult
     */
    @PostMapping("/start_detection")
    @ResponseBody
    public MyJsonResult start_1(HttpServletRequest request,@RequestBody Process tempProcess){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);

        Process process = processService.get_one_info(tempProcess.getProcess_id());
        if(process == null){
            return MyJsonResult.errorMsg("error--");
        }
        process.setPro_starttime(dateString);
        process.setPro_state("1");
        // 存储倒计时长
        process.setPro_counttime(tempProcess.getPro_counttime()*60*60);
        if(processService.update_info(process))
            return MyJsonResult.buildData("ok");
        else
            return MyJsonResult.errorMsg("error");

    }
    @PostMapping("/get_count_time")
    @ResponseBody
    public MyJsonResult getCountTime(HttpServletRequest request,@RequestBody Process tempProcess){
        Process process = processService.get_one_info(tempProcess.getProcess_id());
        if(process == null){
            return MyJsonResult.errorMsg("error--");
        } else{
            try {
                // 获得开始时间
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String pro_starttime = process.getPro_starttime();
                Date startDate = formatter.parse(pro_starttime);
                logger.info("倒计时开始时间"+startDate);
                // 计算截止时间
                Calendar cal = Calendar.getInstance();
                cal.setTime(startDate);
                cal.add(Calendar.SECOND, process.getPro_counttime());
                Date endDate = cal.getTime();
                logger.info("倒计时截至时间"+endDate);
                // 当前时间
                Date currentData = new Date();
                logger.info("倒计时当前时间"+currentData);
                // 计算倒计时
                long countSecond = (endDate.getTime() - currentData.getTime())/1000;
                logger.info("返回倒计时："+countSecond);
                if (countSecond <= 0){
                    return MyJsonResult.errorMsg("error--");
                } else {
                    return MyJsonResult.buildData(countSecond);
                }
            } catch (ParseException e) {
                e.printStackTrace();
                return MyJsonResult.errorMsg("error--");
            }
        }
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
    public MyJsonResult get_one_info1(HttpServletRequest request,String process_id){
        Process process = processService.get_one_info(process_id);
        if(process==null)
            return MyJsonResult.errorMsg("error--");
        else
            return MyJsonResult.buildData(process);

    }
    //初步的根据订单获取流程信息
    @PostMapping("/get_one_infoByOrderId")
    @ResponseBody
    public MyJsonResult get_one_info2(HttpServletRequest request,@RequestBody Order order){
        Process process = null;
        process = processService.get_one_info2(order.getOrder_id());
        if(process != null){
            logger.info(process.toString());
            return MyJsonResult.buildData(process);
        } else{
            return MyJsonResult.errorMsg("error--");
        }
    }

    //物流快递信息更新
    @PostMapping("/update_express")
    @ResponseBody
    public MyJsonResult update_express(HttpServletRequest request,@RequestBody Process tempProcess){

        Process process = processService.get_one_info(tempProcess.getProcess_id());
        if(process==null)
            return MyJsonResult.errorMsg("error--");
        process.setExpress_id(tempProcess.getExpress_id());
        process.setExpress_name(tempProcess.getExpress_name());
        if(processService.update_info(process))
            return MyJsonResult.buildData("ok");
        else
            return MyJsonResult.errorMsg("error");

    }


    /*//图片上传
    @RequestMapping("/upload_pictures")
    @ResponseBody
    public MyJsonResult upload(HttpServletRequest request,
                               @RequestParam(value = "file", required = false) MultipartFile file) {
        String path = null;
        try {
            request.setCharacterEncoding("UTF-8");
            Operator operator = (Operator)request.getSession().getAttribute("operator");
            String op_id = operator.getOp_id();
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
    }*/

    //多张图片上传 暂定
    @RequestMapping("/upload_pictures")
    @ResponseBody
    public MyJsonResult upload(HttpServletRequest request,
                               @RequestParam(value = "file", required = false) MultipartFile[] files) {
        String path = null, total = "";

        try {
            request.setCharacterEncoding("UTF-8");
            Operator operator = (Operator)request.getSession().getAttribute("operator");
            String op_id = operator.getOp_id();
            if (files != null && files.length >= 1) {
                for (MultipartFile file: files) {
                    String fileName = file.getOriginalFilename();

                    String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
                    if (type != null) {
                        if ("PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                            // 自定义的文件名称 以后还要加上orderid 区分多张图片
                            String trueFileName = String.valueOf(op_id + System.currentTimeMillis()) + fileName;
                            // 设置存放图片文件的路径
                            path = tools.UPLOAD_PICTURE_PATH  + trueFileName;
                            total = total + path + ";";
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
                }

            } else {
                return MyJsonResult.errorMsg("貌似你的图片上传失败了呢");
            }
        } catch (IOException e){
            System.out.println("图片上传这里有异常");
        }
        return MyJsonResult.buildData(total);//成功的话 返回图片在服务器的路径 暂时只能一张图片
    }

    public Report get_report_by_process_id(Process process){
        String report_id = process.getReport_id();
        Report report = null;

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);

        if(report_id == null ){
            // 第一次进入时，report_id应该设置成什么格式?   暂时使用tool中的uuid
            report = new Report();
            report.setReport_id(tools.createOrderId());
            report.setCreate_time(dateString);
            reportMapper.add_report(report);


            process.setReport_id(report.getReport_id());
            processService.update_info(process);

            logger.info("第一次进入，创建报告，id为:" + report.getReport_id());

        }else{
            report = reportMapper.get_report_by_report_id(report_id);
        }
        logger.info("report的值：" + report.toString());
        return report;
    }

    // 以下两个接口为施工报告上传描述、图片，其中图片为一张张上传！！！！！

    // 施工报告添加描述
    @PostMapping("/add_report_describes")
    @ResponseBody
    public MyJsonResult add_describes_for_report(HttpServletRequest request,@RequestParam("process_id") String process_id,
                                                 @RequestParam("describes") String describes){
        logger.info("施工报告添加描述。process_id:" + process_id + ";describes:" + describes);
        Process process = processService.get_one_info(process_id);

        Report report = get_report_by_process_id(process);

        // 添加描述
        report.setDescribes(report.getDescribes() + describes + "“;”"); // 每次在末尾添加特殊的字符串！！！
        reportMapper.update_report_info(report);
        logger.info("更新后的值：" + report.getDescribes());
        return MyJsonResult.buildData("添加描述成功");
    }

    // 施工报告添加图片
    @PostMapping("/add_report_pic")
    @ResponseBody
    public MyJsonResult add_pic_for_report(HttpServletRequest request,@RequestParam("process_id") String process_id,
                                           @RequestParam(value = "file", required = false) MultipartFile file){

        logger.info("施工报告上传图片");
        Process process = processService.get_one_info(process_id);

        Report report = get_report_by_process_id(process);

        String path = null;
        try {
            request.setCharacterEncoding("UTF-8");
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();

                String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
                if (type != null) {
                    if ("PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                        // 自定义的文件名称
                        String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
                        Calendar calendar = Calendar.getInstance();
                        // 设置存放图片文件的路径    日期/用户id/报告id/图片
                        String temp = tools.UPLOAD_PICTURE_PATH + Integer.toString(calendar.get(calendar.YEAR)) + "/"
                                + Integer.toString(calendar.get(calendar.MONTH)+1) + "/"+ Integer.toString(calendar.get(calendar.DAY_OF_MONTH)) + "/"
                                + process.getUser_id() + "/"+ report.getReport_id() + "/";

                        path = temp  + trueFileName;
                        logger.info("图片地址:" + path);
                        File dir = new File(temp);
                        if (!dir.exists()) {
                            dir.mkdirs();
                        }
                        file.transferTo(new File(path));

                        // 添加新图片路径
                        report.setPicurl(report.getPicurl() + path + ";");
                        reportMapper.update_report_info(report);
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
        return MyJsonResult.buildData(path);
    }

    // 一次操作结束
    @PostMapping("/report_pic_upload_close")
    @ResponseBody
    public MyJsonResult report_pic_upload_close(HttpServletRequest request,@RequestParam("process_id") String process_id){
        Process process = processService.get_one_info(process_id);

        Report report = get_report_by_process_id(process);
        report.setPicurl(report.getPicurl() + "“!”"); // 作为一轮图片上传操作的结束标识

        reportMapper.update_report_info(report);
        logger.info("一轮图片上传结束");
        return MyJsonResult.buildData("一轮图片上传结束");
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


    // 后台更新物料表
    @PostMapping("bg_update_material")
    @ResponseBody
    public MyJsonResult bg_update_material(@RequestBody Material material, HttpServletRequest request){
        if(materialService.update_material_info(material)){
            logger.info("后台更新Material:" + material.toString());
            return MyJsonResult.buildData("ok");
        }else{
            logger.info("后台未能更新Material:" + material.toString());
            return MyJsonResult.errorMsg("更新失败");
        }
    }

    // 后台添加物料表
    @PostMapping("bg_add_material")
    @ResponseBody
    public MyJsonResult bg_add_material(@RequestBody Material material, HttpServletRequest request){

        if(materialService.add_material_info(material)){
            logger.info("后台成功添加Material:" + material.toString());
            return MyJsonResult.buildData("ok");
        }else{
            logger.info("后台未成功添加Material:" + material.toString());
            return MyJsonResult.errorMsg("物料添加失败");
        }
    }
}
