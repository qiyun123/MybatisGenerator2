package com.faujor.demo.dao.bean;

/**
 * @author xiazhitao
 * @create 2020/7/17 15:54
 * @desc ...
 **/
public class Condition {

    //数据库字段
    private String key;
    /**
     * new Condition("account","like","%" + account + "%") new Condition("account","!=","account")
     */
    //操作类型
    private String opt;
    //值
    private Object value;


    public Condition(String key, String opt, Object value) {
        this.key = key;
        this.opt = opt;
        this.value = value;
    }

    public Condition(String key, Object value) {
        this(key, "=", value);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
