package com.itheima.mybatis.sqlsession;

/**
 * @Author: LJJ
 * @Program: mybatis-day01-define
 * @Description:
 * @Create: 2020-05-08 01:47:47
 * @Modified By:
 */
public interface SqlSession {
    /**
     * 根据参数创建一个代理对象
     * @param daoInterfaceClass 接口字节码
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();
}
