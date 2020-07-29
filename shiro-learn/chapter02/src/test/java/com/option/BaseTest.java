package com.option;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;

public abstract class BaseTest {
    @After
    public void tearDown(){
        ThreadContext.unbindSubject();
    }

    protected void login(String config, String username, String password){
        IniSecurityManagerFactory managerFactory = new IniSecurityManagerFactory(config);
        SecurityManager securityManager = managerFactory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
    }

    public Subject subject(){
        return SecurityUtils.getSubject();
    }
}
