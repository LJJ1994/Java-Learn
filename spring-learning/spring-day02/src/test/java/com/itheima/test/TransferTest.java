package com.itheima.test;

import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: LJJ
 * @Program: spring-day02
 * @Description:
 * @Create: 2020-05-07 18:46:46
 * @Modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class TransferTest {
    @Autowired
    private IAccountService accountService;

    @Autowired
    private BeanFactory beanFactory;

    @Test
    public void testTransfer(){
        Float money = 100F;
        String source = "aaa";
        String target = "bbb";
        accountService.transfer(source, target, money);
    }

    @Test
    public void testTransferProxy(){
        Float money = 100F;
        String source = "aaa";
        String target = "bbb";
        beanFactory.getAccountService().transfer(source, target, money);
    }
}
