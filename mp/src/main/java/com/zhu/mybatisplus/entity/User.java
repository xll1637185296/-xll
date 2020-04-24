package com.zhu.mybatisplus.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zhu
 * @date: 2018/8/23 16:05
 * 演示使用activerecord
 */
@Data
public class User extends Model<User> {
    /** id */
    private Integer id;
    /** name */
    @TableField(fill = FieldFill.INSERT_UPDATE)//插入和更新时填充
    private String name;
    /** age */
    private Integer age;
    /** gender */
    private Integer gender;
    /** 逻辑删除标记 */
    @TableLogic //标记逻辑删除属性
    private Integer logicFlag;

    //重写这个方法，指定当前类的主键属性
    @Override
    protected Serializable pkVal() {
        return id;
    }
}
