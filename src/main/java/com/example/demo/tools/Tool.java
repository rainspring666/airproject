package com.example.demo.tools;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;
import java.util.UUID;

@Component
public class Tool {
    // 请求的网址
    public static final String WX_LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session";
    // 你的appid
    public static final String WX_LOGIN_APPID = "wx0656326b8fdbe56f";
    // 你的密匙
    public static final String WX_LOGIN_SECRET = "b362e4f05db990c3c4833d3a16049afe";
    // 固定参数
    public static final String WX_LOGIN_GRANT_TYPE = "authorization_code";

    //服务器上传图片的总目录
    public static final String UPLOAD_PICTURE_PATH= "C:/Users/mhh/Desktop/";

    public  String pwdMD5(String pwd)  {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(pwd.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String createUserId(int areaCode,int identity) {
        Date date = new Date();
        String timestamp = String.valueOf(date.getTime());
        String s = areaCode + timestamp + identity;
        return s;
    }

    public  String createOrderId() {
        String uniqueId = UUID.randomUUID().toString().replaceAll("-", "");
        return uniqueId;
    }
}
