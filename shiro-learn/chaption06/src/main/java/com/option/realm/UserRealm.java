package com.option.realm;

import com.option.entity.User;
import com.option.service.UserService;
import com.option.service.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class UserRealm extends AuthorizingRealm {
    private UserService userService = new UserServiceImpl();

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        String username = (String) principal.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(userService.findRoles(username));
        info.setStringPermissions(userService.findPermissions(username));
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        User user = userService.findByUsername(username);
        if (user == null){
            throw new UnknownAccountException("未知用户!");
        }
        if (Boolean.TRUE.equals(user.getLocked())){
            throw new LockedAccountException("用户被锁定！");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                user.getUsername(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                getName()

        );
        
        return info;
    }
}
