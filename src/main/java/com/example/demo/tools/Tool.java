package com.example.demo.tools;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;
import java.util.UUID;

public class Tool {
    // 请求的网址
    public static final String WX_LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session";
    // 你的appid
    public static final String WX_LOGIN_APPID = "wx8012f0274569429b";
    // 你的密匙
    public static final String WX_LOGIN_SECRET = "028ab7c0a0515783cc6e47080041985b";
    // 固定参数
    public static final String WX_LOGIN_GRANT_TYPE = "authorization_code";

    //服务器上传图片的总目录
    public static final String UPLOAD_PICTURE_PATH= "url";

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

    public static String createOrderId() {
        String uniqueId = UUID.randomUUID().toString().replaceAll("-", "");
        return uniqueId;
    }
}
