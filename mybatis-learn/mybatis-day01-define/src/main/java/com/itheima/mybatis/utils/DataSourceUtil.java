package com.itheima.mybatis.utils;

import com.itheima.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Author: LJJ
 * @Program: mybatis-day01-define
 * @Description: 用于创建数据源的工具类
 * @Create: 2020-05-08 02:03:03
 * @Modified By:
 */
public class DataSourceUtil {
    public static Connection getConnection(Configuration cfg){
        try{
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
