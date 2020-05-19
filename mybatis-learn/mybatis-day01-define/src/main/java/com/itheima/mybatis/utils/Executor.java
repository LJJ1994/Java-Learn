package com.itheima.mybatis.utils;

import com.itheima.mybatis.cfg.Mapper;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LJJ
 * @Program: mybatis-day01-define
 * @Description: 负责执行SQL语句，并且封装结果集
 * @Create: 2020-05-08 02:13:13
 * @Modified By:
 */
public class Executor {
    public <T> List<T> selectList(Mapper mapper, Connection con){
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try{
            String queryString = mapper.getQueryString();
            String resultType = mapper.getResultType();
            Class<?> domainClass = Class.forName(resultType);

            pstm = con.prepareStatement(queryString);
            resultSet = pstm.executeQuery();

            // 封装结果集
            List<T> list = new ArrayList<T>();
            while(resultSet.next()){
                //实例化要封装的实体类对象
                T obj = (T)domainClass.newInstance();
                //取出结果集的元信息：ResultSetMetaData
                ResultSetMetaData rsmd = resultSet.getMetaData();
                // 获取总列数
                int columnCount = rsmd.getColumnCount();
                //遍历总列数
                for (int i = 1; i < columnCount; i++) {
                    String columnName = rsmd.getColumnName(i);
                    Object columnValue = resultSet.getObject(columnName);
                    //给obj赋值：使用Java内省机制（借助PropertyDescriptor实现属性的封装)
                    //要求：实体类的属性和数据库表的列名保持一种
                    PropertyDescriptor pd = new PropertyDescriptor(columnName, domainClass);
                    Method writeMethod = pd.getWriteMethod();
                    writeMethod.invoke(obj, columnValue);
                }
                list.add(obj);
            }
            return list;
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            release(pstm, resultSet);
        }
    }

    private void release(PreparedStatement pstm,ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        if(pstm != null){
            try {
                pstm.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
