package com.zhu.mybatisplus.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhu.mybatisplus.entity.User;

/**
 * @author: zhu
 * @date: 2018/8/23 16:27
 */
public interface UserDao extends BaseMapper<User> {
    int deleteAll();
}
