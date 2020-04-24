package com.zhu.mybatisplus.handler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * @author: zhu
 * @date: 2018/8/26 09:33
 * 公共字段填充处理器
 */
public class MyMetaObjectHandler extends MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //获取需要填充的字段
        Object fieldValue = getFieldValByName("name",metaObject);
        //如果该字段没有设置值
        if(fieldValue == null){
            //那就将其设置为"林志玲"
            setFieldValByName("name","林志玲",metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //获取需要填充的字段
        Object fieldValue = getFieldValByName("name",metaObject);
        //如果该字段没有设置值
        if(fieldValue == null){
            //那就将其设置为"朱茵"
            setFieldValByName("name","朱茵",metaObject);
        }
    }
}
