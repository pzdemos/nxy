package com.ahead.bean;

public class Tiaojian {
    String name;
    Integer typesId;
    Integer isDesc;
    Integer row;
    Integer nums;

    public Tiaojian() {
    }

    public Tiaojian(String name, Integer typesId, Integer isDesc, Integer row, Integer nums) {
        this.name = name;
        this.typesId = typesId;
        this.isDesc = isDesc;
        this.row = row;
        this.nums = nums;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypesId() {
        return typesId;
    }

    public void setTypesId(Integer typesId) {
        this.typesId = typesId;
    }

    public Integer getIsDesc() {
        return isDesc;
    }

    public void setIsDesc(Integer isDesc) {
        this.isDesc = isDesc;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }
}
