package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.demo.entity.Process;
import com.example.demo.entity.Report;
import com.example.demo.mapper.ReportMapper;
import com.example.demo.service.*;
import com.example.demo.tools.MyJsonResult;
import com.example.demo.tools.SystemClock;
import com.example.demo.tools.Tool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/report")
public class ReportController {

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
    public MyJsonResult add_describes_for_report(HttpServletRequest request, @RequestParam("process_id") String process_id,
                                                 @RequestParam("describes") String describes){
        logger.info("施工报告添加描述。process_id:" + process_id + ";describes:" + describes);
        Process process = processService.get_one_info(process_id);

        Report report = get_report_by_process_id(process);

        // 添加描述
        report.setDescribes(report.getDescribes() + describes + "#"); // 每次在末尾添加特殊的字符串！！！
        reportMapper.update_report_info(report);
        return MyJsonResult.buildData("添加描述成功");
    }

    // 施工报告添加图片
    @PostMapping("/add_report_pic")
    @ResponseBody
    public MyJsonResult add_pic_for_report(HttpServletRequest request,@RequestParam("process_id") String process_id,
                                           @RequestParam(value = "file", required = false) MultipartFile file){

        logger.info("施工报告上传图片...");
        Process process = processService.get_one_info(process_id);

        Report report = get_report_by_process_id(process);

        String path = null,imgDir = "report_img";
        try {
            request.setCharacterEncoding("UTF-8");
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();

                String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
                if (type != null) {
                    if ("PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                        // 自定义的文件名称 使用UUID
                        String trueFileName = tools.createOrderId() + "." +type;
                        Calendar calendar = Calendar.getInstance();
                        // 设置存放图片文件的路径    report_img/年/月/日/图片

                        String temp =  imgDir+ "/"+ Integer.toString(calendar.get(calendar.YEAR)) + "/"
                                + Integer.toString(calendar.get(calendar.MONTH)+1) + "/"+ Integer.toString(calendar.get(calendar.DAY_OF_MONTH)) + "/";

                        path = temp  + trueFileName;
                        File dir = new File(tools.UPLOAD_PICTURE_PATH +temp);
                        if (!dir.exists()) {
                            dir.mkdirs();
                        }
                        file.transferTo(new File(tools.UPLOAD_PICTURE_PATH +path));

                        // 添加新图片路径
                        report.setPicurl(report.getPicurl() + path + "@");
                        reportMapper.update_report_info(report);
                        logger.info("图片上传成功，地址:" + path);
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
        report.setPicurl(report.getPicurl() + "#"); // 作为一轮图片上传操作的结束标识

        reportMapper.update_report_info(report);
        logger.info("一轮图片上传结束");
        return MyJsonResult.buildData("一轮图片上传结束");
    }

    // 上传消杀方案
    @PostMapping("/add_report_plan")
    @ResponseBody
    public MyJsonResult add_report_plan(HttpServletRequest request,@RequestParam("process_id") String process_id, @RequestParam("plan") String plan){
        Process process = processService.get_one_info(process_id);

        Report report = get_report_by_process_id(process);
        report.setOperate_plan(plan);

        reportMapper.update_report_info(report);
        logger.info("上传消杀方案：" + plan);
        return MyJsonResult.buildData("消杀方案上传成功");
    }

    // 上传现场描述
    @PostMapping("/add_report_condition")
    @ResponseBody
    public MyJsonResult add_report_site_condition(HttpServletRequest request,@RequestParam("process_id") String process_id, @RequestParam("condition") String condition){
        Process process = processService.get_one_info(process_id);

        Report report = get_report_by_process_id(process);
        report.setSite_condition(condition);

        reportMapper.update_report_info(report);
        logger.info("上传现场描述：" + condition);
        return MyJsonResult.buildData("现场描述上传成功");
    }

    // 上传效果验证
    @PostMapping("/add_report_validation")
    @ResponseBody
    public MyJsonResult add_report_validation(HttpServletRequest request,@RequestParam("process_id") String process_id, @RequestParam("validation") String validation){
        Process process = processService.get_one_info(process_id);

        Report report = get_report_by_process_id(process);
        report.setValidation(validation);

        reportMapper.update_report_info(report);
        logger.info("效果验证：" + validation);
        return MyJsonResult.buildData("效果验证上传成功");
    }


    //选用StringBuffer作为参数

    private String[] getResult(StringBuffer descrip, StringBuffer picurl){
        List<String> list = new LinkedList<>();
        int index_des = descrip.indexOf("#");
        int index_pic = picurl.indexOf("#");
        if(index_des == -1 || index_pic == -1) //说明描述与图片不匹配，数据库出错
            return null;
        // 进行截取
        String desTemp = descrip.substring(0, index_des);
        String picTemp = picurl.substring(0, index_pic);

        // 修改传入参数的引用
        descrip = descrip.delete(0, index_des+1);
        picurl = picurl.delete(0, index_pic+1);

//        descrip = new StringBuffer(descrip.substring(index_des+1));
//        picurl = new StringBuffer(picurl.substring(index_pic+1));

        // 填入描述
        list.add(desTemp);

        // 插入图片路径
        while (picTemp.contains("@")){
            // 截取路径
            int index = picTemp.indexOf("@");
            String temp = picTemp.substring(0, index);
            list.add(temp);
            picTemp = picTemp.substring(index+1);

        }
        return list.toArray(new String[0]);
    }

    // 施工流程信息展示  返回值：一个String[][],其中每一行代表一轮流程，按顺序分别是本轮的描述、第一张图片、第二张图片。。。
    @PostMapping("/show_report_info")
    @ResponseBody
    public MyJsonResult show_report(HttpServletRequest request, @RequestParam("order_id") String order_id){
        logger.info("order_id"+order_id);
        Process process = processService.get_one_info2(order_id);

        Report report = get_report_by_process_id(process);

        StringBuffer descrip = new StringBuffer(report.getDescribes());
        StringBuffer picurl = new StringBuffer(report.getPicurl());

        List<String[]> resultList = new LinkedList<>();

        /*
        * 此下代码逻辑可能有误，经过测试看是否需要修改！！！！
        * */
        while(!"".equals(descrip.toString()) && !"".equals(picurl.toString())){
            String[] temp = getResult(descrip, picurl);
            if (temp == null)
                return MyJsonResult.errorMsg("数据库出错");
            resultList.add(temp);
        }
        logger.info("施工流程信息"+JSON.toJSONString(resultList));
        return MyJsonResult.buildData(JSONArray.parseArray(JSON.toJSONString(resultList)));
    }

}
