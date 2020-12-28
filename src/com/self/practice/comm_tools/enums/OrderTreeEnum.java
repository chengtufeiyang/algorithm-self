package com.self.practice.comm_tools.enums;

public enum OrderTreeEnum {

    PRE(0,"前序遍历"),
    MID(1,"中序遍历"),
    POST(2,"后序遍历");


    /**
     * 类别值
     */
    private Integer value;
    /**
     * 类别名称
     */
    private String name;


    OrderTreeEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
