package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: LJJ
 * @Program: spring-day01
 * @Description:
 * @Create: 2020-05-07 15:21:21
 * @Modified By:
 */
public class IAccountDaoImpl implements IAccountDao {
    private QueryRunner runner;
    private ConnectionUtils connectionUtils;

    public void setRunner(QueryRunner runner){
        this.runner = runner;
    }
    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void save(Account account) {
        try{
            runner.update(connectionUtils.getThreadConnection(),"insert into account(name,money)values(?,?)", account.getName(), account.getMoney());
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void update(Account account) {
        try{
            runner.update(connectionUtils.getThreadConnection(),"update account set name=?,money=? where id=?",account.getName(), account.getMoney(),account.getId());
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void delete(Integer accountId) {
        try{
            runner.update(connectionUtils.getThreadConnection(),"delete from account where id=?",accountId);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Account findById(Integer accountId) {
        try{
            return runner.query(connectionUtils.getThreadConnection(),"select * from account where id=?", new BeanHandler<Account>(Account.class), accountId);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<Account> findAll() {
        try{
            return runner.query(connectionUtils.getThreadConnection(),"select * from account", new BeanListHandler<Account>(Account.class));
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Account findByName(String name) {
        try{
            return runner.query(connectionUtils.getThreadConnection(), "select * from account where name=?", new BeanHandler<Account>(Account.class), name);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }


}
