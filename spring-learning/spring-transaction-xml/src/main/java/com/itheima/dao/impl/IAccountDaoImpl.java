package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.mapper.AccountRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @Author: LJJ
 * @Program: spring-transaction-xml
 * @Description:
 * @Create: 2020-05-07 23:06:06
 * @Modified By:
 */
public class IAccountDaoImpl extends JdbcDaoSupport implements IAccountDao{
    public Account findAccountById(Integer accountId) {
        List<Account> query = getJdbcTemplate().
                query("select * from account where id=?", new AccountRowMapper(), accountId);
        if (query.isEmpty()){
            return null;
        }
        return query.get(0);
    }

    public Account findAccountByName(String name) {
        List<Account> query = getJdbcTemplate().query("select * from account where name=?", new AccountRowMapper(), name);
        if (query.isEmpty()){
            return null;
        }
        if (query.size() > 1){
            throw new RuntimeException("结果集不唯一。");
        }
        return query.get(0);
    }

    public void updateAccount(Account account) {
        getJdbcTemplate().update("update account set money=? where id=?",account.getMoney(), account.getId());
    }
}
