package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.mybatis.annotation.Select;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有操作
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
