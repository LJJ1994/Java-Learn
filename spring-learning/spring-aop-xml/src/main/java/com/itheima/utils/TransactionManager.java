package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 和事务管理相关的工具类，它包含了，开启事务，提交事务，回滚事务和释放连接
 * 通知类
 */
public class TransactionManager {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public  void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public  void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public  void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 释放连接
     */
    public  void release(){
        try {
            connectionUtils.getThreadConnection().close();//还回连接池中
            connectionUtils.removeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 环绕通知方法
     * @param pjp
     * @return
     * @throws Throwable
     */
    public Object transactionAround(ProceedingJoinPoint pjp) throws Throwable {
        Object rtValue = null;
        try{
            // 获取方法执行的参数
            Object[] args = pjp.getArgs();
            // 前置通知，开启事务
            beginTransaction();
            //执行方法
            rtValue = pjp.proceed(args);
            //后置通知，提交事务
            commit();
        } catch (Throwable a){
            //异常通知，回滚事务
            rollback();
            a.printStackTrace();
        }finally{
            // 最终通知，释放连接
            release();
        }
        return rtValue;
    }
}
