package com.faujor.demo.dao.bean;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xiazhitao
 * @create 2020/7/17 15:52
 * @desc ... 数据库统一操作mapper
 **/
public interface BaseMapper<T> {
    int deleteByPrimaryKey(String id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    // conditions 这个参数，就是我们传进来的条件，在Sql中根据conditions这个list拼接sql语句
    List<T> getByConditions(@Param("conditions") Map<String, Object> conditions);

    // 同上：不过的是Condition类 其中有3个属性：key opt value;key表示的是表的字段，opt表示 操作类型：locate模糊查询、in查询、为空的时候就是等值查询
    List<T> getByConditionList(@Param("conditions") List<Condition> conditions);

    // 同上 、 添加了 排序信息，Sort这个类有两个参数 ： field表示要排序的字段，sortType表示排序的方式
    List<T> getSortedResultByConditionList(@Param("conditions") List<Condition> conditions,
                                           @Param("sorter") Sort sort);
    // field 表示要查询的字段，set里表示给值的内容
    List<T> getByIn(@Param("field") String field, @Param("set") Set<Object> set);
}
