package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: LJJ
 * @Program: spring-day02
 * @Description:
 * @Create: 2020-05-07 18:20:20
 * @Modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class AnnotationTest {
    @Autowired
    private IAccountService accountService;

    @Test
    public void testFindAll(){
        List<Account> all = accountService.findAll();
        for (Account account : all) {
            System.out.println(account.getName());
        }
    }
}
