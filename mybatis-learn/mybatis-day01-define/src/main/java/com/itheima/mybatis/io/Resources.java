package com.itheima.mybatis.io;

import java.io.InputStream;

/**
 * @Author: LJJ
 * @Program: mybatis-day01-define
 * @Description: 使用类加载器读取配置文件的类
 * @Create: 2020-05-08 02:29:29
 * @Modified By:
 */
public class Resources {
    public static InputStream getResourceAsStream(String filepath){
        return Resources.class.getClassLoader().getResourceAsStream(filepath);
    }
}
