package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Author: LJJ
 * @Program: mybatis-annotation
 * @Description:
 * @Create: 2020-05-09 22:27:27
 * @Modified By:
 */
public class UserAnnotationTest {
    private InputStream in;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws Exception{
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindById(){
        User byId = userDao.findById(41);
        System.out.println(byId);
    }

    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUserName("test");
        user.setUserAddress("广州");
        user.setUserSex("男");
        user.setUserBirthday(new Date());
        int i = userDao.saveUser(user);
        System.out.println(i);
    }

    @Test
    public void testUpdateUser(){
        User user = userDao.findById(53);
        user.setUserName("test2");
        int i = userDao.updateUser(user);
        System.out.println(i);
    }

    @Test
    public void testDeleteUser(){
        int i = userDao.deleteUser(53);
        System.out.println(i);
    }
}
