package com.itheima.controller;

import com.itheima.domain.Account;
import com.itheima.domain.User;
import com.itheima.exception.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * @Author: LJJ
 * @Program: springmvc-day1
 * @Description:
 * @Create: 2020-05-10 03:17:17
 * @Modified By:
 */
@RequestMapping("/account")
@Controller
public class AccountController {

    @PostMapping("/saveAccount")
    public String save(Account account){
        System.out.println("保存了账户");
        System.out.println(account);
        return "success";
    }

    @PostMapping("/updateAccount")
    public String update(User user){
        System.out.println("更新了账户");
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/deleteAccount")
    public String delete(Date date){
        System.out.println("删除了账户.." + date);
        return "success";
    }

    @GetMapping("/error")
    public String testException() throws CustomException {
        System.out.println("异常执行。。。。。。。");
        try{
            int a = 1/0;
        } catch (Exception e){
            throw new CustomException("出现错误.....");
        }
        return "success";
    }

    @GetMapping("/interceptor")
    public String interceptor(){
        System.out.println("控制器中的方法执行啦....");
        return "success";
    }
}
