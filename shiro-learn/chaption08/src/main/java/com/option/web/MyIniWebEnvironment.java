package com.option.web;

import org.apache.shiro.util.ClassUtils;
import org.apache.shiro.web.env.IniWebEnvironment;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.apache.shiro.web.filter.mgt.*;

import javax.servlet.Filter;

public class MyIniWebEnvironment extends IniWebEnvironment {
    @Override
    protected FilterChainResolver createFilterChainResolver() {
        //1、创建FilterChainResolver
        PathMatchingFilterChainResolver filterChainResolver = new PathMatchingFilterChainResolver();
        //2、创建FilterChainManager
        DefaultFilterChainManager filterChainManager = new DefaultFilterChainManager();
        ////3、注册Filter
        for (DefaultFilter filter : DefaultFilter.values()) {
            filterChainManager.addFilter(filter.name(), (Filter) ClassUtils.newInstance(filter.getFilterClass()));
        }
        //4、注册URL-Filter的映射关系
        filterChainManager.addToChain("/toLogin.jsp", "authc");
        filterChainManager.addToChain("/unauthorized.jsp", "anon");
        filterChainManager.addToChain("/**", "authc");
        filterChainManager.addToChain("/**", "roles", "admin");
        //5、设置Filter的属性
        FormAuthenticationFilter formAuthenticationFilter = (FormAuthenticationFilter) filterChainManager.getFilter("authc");
        formAuthenticationFilter.setLoginUrl("/login.jsp");
        RolesAuthorizationFilter rolesAuthorizationFilter = (RolesAuthorizationFilter) filterChainManager.getFilter("roles");
        rolesAuthorizationFilter.setUnauthorizedUrl("/unauthorized.jsp");

        filterChainResolver.setFilterChainManager(filterChainManager);
        return filterChainResolver;
    }
}
