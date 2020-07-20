package com.faujor.demo.dao.bean;

/**
 * @author xiazhitao
 * @create 2020/7/17 15:55
 * @desc ...
 **/
public class Sort {

    /**
     * 可以field1,field2,field3, 数据库表字段
     */
    private String field;
    /**
     * desc ,asc  排序规则
     */
    private String sortType;

    public Sort(String field, String sortType) {
        this.field = field;
        this.sortType = sortType;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }
}
