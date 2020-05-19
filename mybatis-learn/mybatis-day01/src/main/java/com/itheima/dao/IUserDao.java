package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * @Author: LJJ
 * @Program: mybatis-day01
 * @Description:
 * @Create: 2020-05-08 00:42:42
 * @Modified By:
 */
public interface IUserDao {
    List<User> findAll();
}
