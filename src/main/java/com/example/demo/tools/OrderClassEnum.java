package com.example.demo.tools;

/**
 * @author mhh
 * @date 2020/6/7
 */
public enum OrderClassEnum {
    one("家居", "1"), two("车辆", "2"), three("工装", "3"),four("其他", "4");;

    private String name;
    private String index;

    private OrderClassEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public static String getName(String index) {
        for (OrderClassEnum o : OrderClassEnum.values()) {
            if (o.getIndex().equals(index)) {
                return o.name;
            }
        }
        return null;
    }
}
