package com.itheima.mybatis.sqlsession.defaut;

import com.itheima.mybatis.cfg.Configuration;
import com.itheima.mybatis.sqlsession.SqlSession;
import com.itheima.mybatis.sqlsession.SqlSessionFactory;

/**
 * @Author: LJJ
 * @Program: mybatis-day01-define
 * @Description:
 * @Create: 2020-05-08 02:00:00
 * @Modified By:
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration configuration;
    public DefaultSqlSessionFactory(Configuration configuration){
        this.configuration = configuration;
    }
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
