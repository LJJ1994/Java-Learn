package com.option.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

public class MyRealm1 implements Realm {
    public String getName() {
        return "myrealm";
    }

    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = new String((char []) token.getCredentials());
        if (!"zhang".equalsIgnoreCase(username)){
            throw new UnknownAccountException("用户名错误");
        }
        if (!"123".equals(password)){
            throw new IncorrectCredentialsException("密码错误");
        }

        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
