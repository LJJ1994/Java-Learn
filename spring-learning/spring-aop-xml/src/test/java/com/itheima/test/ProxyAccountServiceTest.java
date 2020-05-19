package com.itheima.test;

import com.itheima.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: LJJ
 * @Program: spring-aop-xml
 * @Description:
 * @Create: 2020-05-07 21:03:03
 * @Modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class ProxyAccountServiceTest {
//    @Autowired
//    @Qualifier("proxyAccountService")
//    private IAccountService accountService;
//
//    @Test
//    public void testTransfer(){
//        String source = "aaa";
//        String target = "bbb";
//        float money = 100L;
//        accountService.transfer(source, target, money);
//    }
}
