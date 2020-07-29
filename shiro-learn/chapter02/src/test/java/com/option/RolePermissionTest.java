package com.option;

import junit.framework.Assert;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.Arrays;

public class RolePermissionTest {
    @Test
    public void test(){
        IniSecurityManagerFactory managerFactory = new IniSecurityManagerFactory("classpath:shiro-role.ini");
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

        Assert.assertTrue(subject.hasRole("role1"));
        Assert.assertTrue(subject.hasRole("role2"));
        Assert.assertTrue(subject.hasAllRoles(Arrays.asList("role1", "role2")));
        subject.checkRole("role6");
    }

    @Test
    public void testIsPermission(){
        IniSecurityManagerFactory managerFactory = new IniSecurityManagerFactory("classpath:shiro-permission.ini");
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

        Assert.assertTrue(subject.isPermitted("user:create"));
        Assert.assertTrue(subject.isPermitted("user:update"));
        Assert.assertTrue(subject.isPermittedAll("user:create", "user:update", "user:delete"));
    }


}
