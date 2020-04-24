package com.zhu.mybatisplus.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: zhu
 * @date: 2018/8/19 10:34
 */
@Data
//@TableName(value = "tb_employee")
public class Employee extends Model<Employee> {
    //value与数据库主键列名一致，若实体类属性名与表主键列名一致可省略value
    //@TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    //若没有开启驼峰命名，或者表中列名不符合驼峰规则，可通过该注解指定数据库表中的列名，exist标明数据表中有没有对应列
    //@TableField(value = "last_name",exist = true)
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
