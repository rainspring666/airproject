package com.example.demo.tools;

public class MyJsonResult {

    //响应状态码
    private Integer status;

    //响应消息
    private String msg;

    //响应数据
    private Object data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public MyJsonResult(Integer status, String msg, Object data) {
        super();
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public MyJsonResult(Object data) {
        super();
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public MyJsonResult() {
        super();
    }

    public static MyJsonResult build(Integer status, String msg, Object data) {
        return new MyJsonResult(status,msg,data);
    }

    public static MyJsonResult buildData(Object data) {
        return new MyJsonResult(data);
    }

    public static MyJsonResult errorMsg(String msg) {
        return new MyJsonResult(500, msg, null);
    }


}
