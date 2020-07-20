package com.faujor.demo.dao.mapper;

import com.faujor.demo.dao.bean.BaseMapper;
import com.faujor.demo.dao.bean.Condition;
import com.faujor.demo.dao.bean.Sort;
import com.faujor.demo.dao.model.SysEmail;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SysEmailMapper extends BaseMapper<SysEmail> {

    @Override
    int deleteByPrimaryKey(String id);

    @Override
    int insert(SysEmail record);

    @Override
    int insertSelective(SysEmail record);

    @Override
    SysEmail selectByPrimaryKey(String id);

    @Override
    int updateByPrimaryKeySelective(SysEmail record);

    @Override
    int updateByPrimaryKey(SysEmail record);

    // conditions 这个参数，就是我们传进来的条件，在Sql中根据conditions这个list拼接sql语句
    @Override
    List<SysEmail> getByConditions(Map<String, Object> conditions);
    // 同上：不过的是Condition类 其中有3个属性：key opt value;key表示的是表的字段，opt表示 操作类型：locate模糊查询、in查询、为空的时候就是等值查询
    @Override
    List<SysEmail> getByConditionList(List<Condition> conditions);
    // 同上 、 添加了 排序信息，Sort这个类有两个参数 ： field表示要排序的字段，sortType表示排序的方式
    @Override
    List<SysEmail> getSortedResultByConditionList(List<Condition> conditions, Sort sort);
    // field 表示要查询的字段，set里表示给值的内容
    @Override
    List<SysEmail> getByIn(String field, Set<Object> set);
}