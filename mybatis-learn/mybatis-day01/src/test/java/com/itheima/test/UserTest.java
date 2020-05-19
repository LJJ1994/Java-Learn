package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: LJJ
 * @Program: mybatis-day01
 * @Description:
 * @Create: 2020-05-08 00:59:59
 * @Modified By:
 */
public class UserTest {
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        // 获取IuserDao代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        List<User> all = userDao.findAll();

        for (User user : all) {
            System.out.println(user.getUsername());
        }

        session.close();
        in.close();
    }
}
