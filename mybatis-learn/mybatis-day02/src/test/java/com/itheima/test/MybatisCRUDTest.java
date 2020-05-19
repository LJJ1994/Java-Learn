package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: LJJ
 * @Program: mybatis-day02
 * @Description:
 * @Create: 2020-05-08 23:50:50
 * @Modified By:
 */
public class MybatisCRUDTest {
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
    public void testFindById(){
        User one = userDao.findById(41);
        System.out.println(one.getUsername());
    }

    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUsername("test");
        user.setSex("男");
        user.setAddress("广州");
        user.setBirthday(new Date());
        userDao.saveUser(user);

        System.out.println("保存操作之后："+user);
    }

    @Test
    public void testUpdate(){
        User user = userDao.findById(51);
        user.setUsername("go die!");
        userDao.updateUser(user);

        System.out.println(user);
    }

    @Test
    public void testDelete(){
        int i = userDao.deleteUser(51);
        System.out.println("delete user id: " + i);
    }

    @Test
    public void testFindByName(){
        List<User> users = userDao.findByName("王");
        for (User user : users) {
            System.out.println(user.getUsername());
        }
    }

    @Test
    public void testFindByUser(){
        User user = new User();
        user.setUsername("%王%");
        user.setAddress("%顺义%");
        List<User> byUser = userDao.findByUser(user);
        for (User user1 : byUser) {
            System.out.println(user1.getUsername());
        }
    }

    @Test
    public void testFindByQueryVo(){
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(41);
        ids.add(42);
        ids.add(44);
        QueryVo queryVo = new QueryVo();
        queryVo.setIds(ids);

        List<User> byQueryVo = userDao.findByQueryVo(queryVo);
        for (User user : byQueryVo) {
            System.out.println(user.getUsername());
        }
    }

    @Test
    public void testFindAll(){
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindList(){
        List<User> list = userDao.findList();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
