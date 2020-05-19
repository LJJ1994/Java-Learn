package com.itheima.mybatis.sqlsession.proxy;

import com.itheima.mybatis.cfg.Mapper;
import com.itheima.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @Author: LJJ
 * @Program: mybatis-day01-define
 * @Description:
 * @Create: 2020-05-08 02:08:08
 * @Modified By:
 */
public class MapperProxy implements InvocationHandler {
    //map的key是全限定类名+方法名
    private Map<String, Mapper> mappers;
    private Connection con;

    public MapperProxy(Map<String, Mapper> mappers, Connection con){
        this.mappers = mappers;
        this.con = con;
    }

    /**
     * 用于对方法进行增强的，我们的增强其实就是调用selectList方法
     *
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();
        String key = className + "." + methodName;
        Mapper mapper = mappers.get(key);
        if (mapper == null){
            throw new IllegalArgumentException("输入参数有误");
        }

        //6.调用工具类执行查询所有
        return new Executor().selectList(mapper,con);
    }
}
