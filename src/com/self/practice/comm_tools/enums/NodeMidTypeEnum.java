package com.self.practice.comm_tools.enums;

public enum NodeMidTypeEnum {
    EVEN_PRE(1,"中线前一个节点"),//默认
    EVEN_AFT(2,"中线后一个节点"),
    ODD_MID(3,"奇数正中心"),//默认
    ODD_MID_PRE(4,"奇数中心前一个节点"),
    ODD_MID_AFT(5,"奇数中心后一个节点");

    /**
     * 类别值
     */
    private Integer value;
    /**
     * 类别名称
     */
    private String name;

    NodeMidTypeEnum(Integer value, String name) {
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
