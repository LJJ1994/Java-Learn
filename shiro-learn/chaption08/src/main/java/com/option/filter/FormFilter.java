package com.option.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.security.auth.Subject;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FormFilter extends PathMatchingFilter {
    private String loginUrl = "/login.jsp";
    private String redirectUrl = "/";

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        if (SecurityUtils.getSubject().isAuthenticated()){
            return true; // 登陆过
        }
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        if (isLoginRequest(httpServletRequest)){
            if ("post".equalsIgnoreCase(httpServletRequest.getMethod())){
                boolean login = login(httpServletRequest);
                if (login){
                    redirectToSuccessfulUrl(httpServletRequest, httpServletResponse);
                }
            }
            return true;
        }else{
            saveAndRedirectToLogin(httpServletRequest, httpServletResponse);
            return false;
        }
    }

    private boolean login(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try{
            SecurityUtils.getSubject().login(new UsernamePasswordToken(username,password));
            return true;
        }catch (Exception e){
            request.setAttribute("shiroLoginFailure", e.getMessage());
            return false;
        }
    }

    private boolean redirectToSuccessfulUrl(HttpServletRequest request, HttpServletResponse response){
        try{
            WebUtils.redirectToSavedRequest(request, response, redirectUrl);
            return false;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

    private void saveAndRedirectToLogin(HttpServletRequest request, HttpServletResponse response){
        try{
            WebUtils.saveRequest(request);
            WebUtils.issueRedirect(request, response, loginUrl);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private boolean isLoginRequest(HttpServletRequest request){
        return pathsMatch(loginUrl, WebUtils.getPathWithinApplication(request));
    }
}
