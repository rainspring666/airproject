package com.example.demo.tools;

/**
 * @author mhh
 * @date 2020/6/7
 */
public enum OrderStateEnum {
    // 订单状态
    PENDING("未处理", 0), PROCESSING("处理中", 1), FINISH("已完成", 2),PDF("已生成", 3),
    // 操作员状态
    WORKING("工作中",10),KONGXIAN("空闲",11),XIUJIA("休假",12),
    // 流程状态
    PROCESS_ZERO("初始化",20),PROCESS_ONE("设备申请",21),PROCESS_TWO("现场施工",22),
    PROCESS_THREE("空气检测",23),PROCESS_FOUR("空气取样",24);

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
