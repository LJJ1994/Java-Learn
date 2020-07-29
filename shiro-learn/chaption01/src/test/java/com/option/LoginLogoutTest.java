package com.option;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

public class LoginLogoutTest {
    @Test
    public void testLoginLogout(){
//        IniSecurityManagerFactory managerFactory = new IniSecurityManagerFactory("classpath:shiro.ini");
//        IniSecurityManagerFactory managerFactory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
//        IniSecurityManagerFactory managerFactory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
        IniSecurityManagerFactory managerFactory = new IniSecurityManagerFactory("classpath:shiro-authenticator-all-success.ini");
        SecurityManager securityManager = managerFactory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        try{
            subject.login(token);
        } catch (AuthenticationException e){
            e.printStackTrace();
            throw new RuntimeException("认证失败！");
        }

//        Assert.assertEquals(true, subject.isAuthenticated());
        PrincipalCollection principals = subject.getPrincipals();
        System.out.println(principals);

        subject.logout();

    }
}
