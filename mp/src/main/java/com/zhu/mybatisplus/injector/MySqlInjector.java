package com.zhu.mybatisplus.injector;

import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.mapper.AutoSqlInjector;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

/**
 * @author: zhu
 * @date: 2018/8/25 10:16
 * 自定义全局操作
 */
public class MySqlInjector extends AutoSqlInjector {
    @Override
    public void inject(Configuration configuration, MapperBuilderAssistant builderAssistant, Class<?> mapperClass,
                       Class<?> modelClass, TableInfo table) {
        /* 添加一个自定义方法 */
        deleteAllUser(mapperClass, modelClass, table);
        System.out.println(table.getTableName());
    }

    public void deleteAllUser(Class<?> mapperClass, Class<?> modelClass, TableInfo table) {
        /* 执行 SQL ，动态 SQL 参考类 SqlMethod */
        String sql = "delete from " + table.getTableName();
        /* mapper 接口方法名一致 */
        String method = "deleteAll";
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        this.addDeleteMappedStatement(mapperClass, method, sqlSource);
    }

}
