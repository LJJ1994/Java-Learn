package com.itheima.dao;

import com.itheima.domain.QueryVo;
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
    User findById(int userId);

    void saveUser(User user);

    void updateUser(User user);

    int deleteUser(int userId);

    List<User> findByName(String name);

    List<User> findByUser(User user);

    List<User> findByQueryVo(QueryVo queryVo);

    List<User> findAll();

    List<User> findList();
}
