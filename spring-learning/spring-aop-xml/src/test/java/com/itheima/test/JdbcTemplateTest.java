package com.itheima.test;

import com.itheima.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author: LJJ
 * @Program: spring-aop-xml
 * @Description:
 * @Create: 2020-05-07 22:19:19
 * @Modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class JdbcTemplateTest {

    @Test
    public void testQuery(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate template = (JdbcTemplate) ac.getBean("jdbcTemplate");

        template.execute("insert into account (name,money)values('LJJ', 100)");
    }

    @Test
    public void testSave(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate template = (JdbcTemplate) ac.getBean("jdbcTemplate");

        template.update("insert into account (name,money)values(?,?)", "HLP", 1000);
    }

    @Test
    public void testUpdate(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate template = (JdbcTemplate) ac.getBean("jdbcTemplate");

        template.update("update account set money=? where id=?", 2000L, 6);
    }

    @Test
    public void testDelete(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate template = (JdbcTemplate) ac.getBean("jdbcTemplate");

        template.update("delete from account where id=?", 6);
    }

    @Test
    public void testfindAll(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate template = (JdbcTemplate) ac.getBean("jdbcTemplate");

        List<Account> list = template.query("select * from account where money > ?", new AccountRowMapper(), 100);
        for (Account account : list) {
            System.out.println(account.getName());
        }
    }
}

class AccountRowMapper implements RowMapper<Account>{

    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}
