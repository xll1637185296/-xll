package com.zhu.mybatisplus.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhu.mybatisplus.entity.Employee;

import javax.xml.ws.soap.Addressing;

/**
 * @author: zhu
 * @date: 2018/8/20 11:31
 */
public interface EmplopyeeDao extends BaseMapper<Employee> {
    //自定义全局操作
    //BaseMapper虽然强大，但是提供的方法也是有限的，总会有需要我们自己定义方法的情况。
    //比如定义A方法，正常情况我们都要在xml文件中对A方法进行实现
    //通过自定义全局操作，就可以不用在xml中实现，可以把A方法也变成BaseMapper内置方法一样
    //首先在mapper中定义方法，然后新建mysqlInjector类
    int deleteAll();
}
