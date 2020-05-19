package com.itheima.test;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.IUserDao;
import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @Author: LJJ
 * @Program: mybatis-day02
 * @Description:
 * @Create: 2020-05-09 20:12:12
 * @Modified By:
 */
public class AccountUserTest {
    private InputStream in;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private IAccountDao accountUser;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sqlSessionFactory.openSession();
        accountUser = sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void destroy() throws Exception{
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<AccountUser> all = accountUser.findAll();
        for (AccountUser user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindList(){
        List<Account> list = accountUser.findList();
        for (Account account : list) {
            System.out.println(account.getUser());
        }
    }
}
