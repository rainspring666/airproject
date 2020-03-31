package com.example.demo.tools;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Tool {
    public String intToString(int num_int)
    {
        return Integer.toString(num_int);
    }
    public int stringToInt(String str)
    {
        return Integer.parseInt(str);
    }

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

}
