package com.example.demo.tools;

/**
 * @author mhh
 * @date 2020/6/7
 */
public enum OrderStateEnum {
    PENDING("未处理", 0), PROCESSING("处理中", 1), FINISH("已完成", 2);

    private String name;
    private int index;

    private OrderStateEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static String getName(int index) {
        for (OrderStateEnum o : OrderStateEnum.values()) {
            if (o.getIndex() == index) {
                return o.name;
            }
        }
        return null;
    }
}
