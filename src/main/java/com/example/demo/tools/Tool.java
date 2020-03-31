package com.example.demo.tools;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;
import java.util.UUID;

public class Tool {

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
