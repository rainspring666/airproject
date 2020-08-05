package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Operator;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.entity.User_info;
import com.example.demo.entity.User_role;
import com.example.demo.service.OperatorService;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserInfoService;
import com.example.demo.service.UserService;
import com.example.demo.service.User_roleService;
import com.example.demo.tools.MyJsonResult;
import com.example.demo.tools.OrderClassEnum;
import com.example.demo.tools.OrderStateEnum;
import com.example.demo.tools.Tool;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.weaver.ast.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/bg/admin")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OperatorService operatorService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private User_roleService user_roleService;

    @Autowired
    private Tool tools;

    private String user_id_global="";
    private String order_id_global="";

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 展示所有订单信息，列表，sql查询简单排序
     *  * @return
     */

    @GetMapping(value = "/order/show_all_order")
    @ResponseBody
    public Map<String,Object> selectAllOrder(@RequestParam(required = false,defaultValue = "1") int page,
                                             @RequestParam(required = false,defaultValue = "15") int limit)
    {
        PageHelper.startPage(page, limit);
        List<Order> orders = orderService.selectAll();

        /*组装响应数据 便于前端显示*/
        List<Operator> op_list = operatorService.all_op_info();
        List<User_info> User_infos = userInfoService.get_all_user_info();

        // 获得Op_id----------->Op_name
        HashMap<String, String> op_map = new HashMap<String,String>();
        for (Operator operator : op_list) {
            op_map.put(operator.getOp_id(), operator.getOp_name());
        }
        HashMap<String, String> user_map = new HashMap<String,String>();
        for (User_info user_info : User_infos) {
            user_map.put(user_info.getUser_id(), user_info.getUser_name());
        }
        for(int i = 0; i < orders.size(); i++){
            Order order = orders.get(i);
            // 组装操作员信息
            String opId = order.getOp_id();
            order.setOp_id(op_map.get(opId));//更换为操作员的名字
            // 组装订单类别信息
            String orderClass = order.getOrder_class();
            order.setOrder_class(OrderClassEnum.getName(orderClass));
            // 组装订单状态信息
            String orderState = order.getOrder_state();
            order.setOrder_state(OrderStateEnum.getName(Integer.parseInt(orderState)));

            String userId = order.getUser_id();
            order.setUser_id(user_map.get(userId));
        }


        PageInfo pageInfo = new PageInfo(orders);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        // return map;

        if (!orders.isEmpty()){
            map.put("msg","操作成功");
            return map;
        }
        map.put("msg","操作失败");
        return map;
    }

    /**
     *web端 新增一条order记录 游客性质的用户 企业用户
     * @return
     */
    @PostMapping("/order/add_one_order")
    @ResponseBody
    public MyJsonResult add_order(@RequestBody Order order, HttpServletRequest request){
        //补充order必要的信息
        String order_id = tools.createOrderId();
        order.setOrder_id(order_id);
        order.setOrder_state("0");
        order.setOp_id("1");
        order.setOrder_modelf("");
        order.setUser_id((String) request.getSession().getAttribute("temp_user_id"));//临时用户 游客id====
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        order.setOrder_createtime(dateString);

        System.out.println("order:"+order.toString());
        if(orderService.insert(order)){
            logger.info("web add an order："+order.getOrder_id());
            //this.order_id_global=order_id;
            request.getSession().setAttribute("temp_order_id", order_id);
            return MyJsonResult.buildData("ok");
        }

        return MyJsonResult.errorMsg("后台新增订单记录错误");
    }

    /**
     *web端 新增一条userinfo user 记录 游客性质的用户 企业用户
     * @return
     */
    @PostMapping("/order/add_one_order_user_info")
    @ResponseBody
    public MyJsonResult add_user_info(@RequestBody User_info user_info, HttpServletRequest request){
        logger.info("add_one_order_user_info----  user_info:"+user_info.toString());
        String user_id = tools.createUserId(0,1);
        //更新用户
        User user = new User();
        user.setUser_id(user_id);
        user.setUser_pwd("Temp00000000");
        user.setUser_phone(user_info.getUser_id());//phone临时做id
        user.setUser_name(user_info.getUser_name());
        //更新用户信息
        user_info.setFirm_id("0");
        user_info.setUser_id(user_id);

        //更新用户角色
        User_role user_role = new User_role();
        user_role.setUser_id(user_id);
        if(user_info.getUser_nickname().contains("游客"))
            user_role.setRole_id(2);//
        else if (user_info.getUser_nickname().contains("公司"))
            user_role.setRole_id(3);//

        logger.info("add_one_order_user_info ---- user:"+user.toString());
        if(userService.save_user(user) && userInfoService.add_user_info(user_info) &&
                user_roleService.add_user_role(user_role)) {
            logger.info("/order/add_one_order"+user_id);

            // 当并发时，user_id会被多次改变，可能出现问题，因此采用session存储！
            request.getSession().setAttribute("temp_user_id", user_id);
            return MyJsonResult.buildData("ok");
        }

        return MyJsonResult.errorMsg("error");
    }

    /**
     * web端 游客/企业用户 订单户型图上传
     * @param request
     * @param file
     * @return
     */
    @RequestMapping("/other_users/upload_pictures")
    @ResponseBody
    public MyJsonResult upload(HttpServletRequest request,
                               @RequestParam(value = "file", required = false) MultipartFile file) {
        String user_id = (String) request.getSession().getAttribute("temp_user_id");
        String path = null, imgDir = "hx_img_other_users";
        try {
            request.setCharacterEncoding("UTF-8");
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
                if (type != null) {
                    if ("PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {

                        // 自定义的文件名称使用UUID
                        String trueFileName = tools.createOrderId() + "." + type;
                        Calendar calendar = Calendar.getInstance();
                        // 设置存放图片文件的路径    hx_img/年/月/日/图片   考虑是否去掉年份？？？？
                        String temp =  imgDir + "/" + Integer.toString(calendar.get(calendar.YEAR)) + "/"
                                + Integer.toString(calendar.get(calendar.MONTH)+1) + "/"+ Integer.toString(calendar.get(calendar.DAY_OF_MONTH)) + "/";

                        path = temp  + trueFileName;
                        File dir = new File(tools.UPLOAD_PICTURE_PATH +temp);
                        //Process process = processMapper.
                        if (!dir.exists()) {
                            dir.mkdirs();
                        }
                        file.transferTo(new File(tools.UPLOAD_PICTURE_PATH +path));

                        Order order = orderService.selectByPrimaryKey((String) request.getSession().getAttribute("temp_order_id"));
                        order.setOrder_modelf(order.getOrder_modelf() + path + "@");

                        if(orderService.updateOrder_modelf(order)){
                            logger.info("user {} upload picture:{}",user_id,path + "@");
                            return MyJsonResult.buildData("ok");//成功的话 返回图片在服务器的路径 暂时只能一张图片
                        }
                            logger.info("Web 图片上传出错");
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
        return MyJsonResult.errorMsg("error");
    }


    /**
     * web端删除order记录
     * @param order_id
     * @param request
     * @return
     */
    @PostMapping("/order/delete")
    @ResponseBody
    public MyJsonResult delete_order(@RequestParam("chooseOrderID") String order_id,
                                     HttpServletRequest request){
        logger.info("delete"+order_id);
        if(orderService.deleteByPrimaryKey(order_id))
            return MyJsonResult.buildData("ok");

        return MyJsonResult.errorMsg("删除order失败");
    }

    @PostMapping("/del_orders")
    @ResponseBody
    public MyJsonResult del_Orders(@RequestBody String[] arr){

        logger.info("del_equipments----arr:");
        for (String i: arr) {
            System.out.println(i);
        }
        boolean result = true;
        for (String order_id: arr) {
            if(!orderService.deleteByPrimaryKey(order_id)){
                result = false;
                break;
                // 事务回滚
            }
        }
        if(result)
            return MyJsonResult.buildData("ok");

        return MyJsonResult.errorMsg("error");
    }

    /**
     * web端修改编辑更新order记录信息
     * @return
     */
    @PostMapping("/order/change")
    @ResponseBody
    public MyJsonResult change_order(@RequestBody Order order){

        logger.info(order.toString());
        if(orderService.order_change_by_id(order))
            return MyJsonResult.errorMsg("ok");
        return MyJsonResult.errorMsg("error");
    }

    // 已完成
    @GetMapping("/order/search")
    @ResponseBody
    public Map<String,Object> search_order(HttpServletRequest request){

        JSONObject searchParams = JSONObject.parseObject(request.getParameter("searchParams"));
        PageHelper.startPage(1, 20);

        String order_id = searchParams.getString("orderID");
        String phone = searchParams.getString("phone");
        String connect_name = searchParams.getString("connectName");
        String order_state = searchParams.getString("order_state");
         //多条件搜索
        List<Order> orderList = orderService.searchByMultiConditions(order_id,connect_name,phone, order_state);


        /*组装响应数据 便于前端显示*/
        List<Operator> op_list = operatorService.all_op_info();
        List<User_info> User_infos = userInfoService.get_all_user_info();

        // 获得Op_id----------->Op_name
        HashMap<String, String> op_map = new HashMap<String,String>();
        for (Operator operator : op_list) {
            op_map.put(operator.getOp_id(), operator.getOp_name());
        }
        HashMap<String, String> user_map = new HashMap<String,String>();
        for (User_info user_info : User_infos) {
            user_map.put(user_info.getUser_id(), user_info.getUser_name());
        }
        for(int i = 0; i < orderList.size(); i++){
            Order order = orderList.get(i);
            // 组装操作员信息
            String opId = order.getOp_id();
            order.setOp_id(op_map.get(opId));//更换为操作员的名字
            // 组装订单类别信息
            String orderClass = order.getOrder_class();
            order.setOrder_class(OrderClassEnum.getName(orderClass));
            // 组装订单状态信息
            String orderState = order.getOrder_state();
            order.setOrder_state(OrderStateEnum.getName(Integer.parseInt(orderState)));

            String userId = order.getUser_id();
            order.setUser_id(user_map.get(userId));
        }

        PageInfo pageInfo = new PageInfo(orderList);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        if (!orderList.isEmpty()){
            map.put("msg","操作成功");
            return map;
        }
        map.put("msg","操作失败");
        return map;
    }

}
