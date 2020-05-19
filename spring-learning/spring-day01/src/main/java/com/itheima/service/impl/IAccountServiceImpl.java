package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.IAccountDaoImpl;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Author: LJJ
 * @Program: spring-day01
 * @Description:
 * @Create: 2020-05-07 15:22:22
 * @Modified By:
 */
@Component(value = "accountService")
public class IAccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

//    public void setAccountDao(IAccountDao accountDao){
//        this.accountDao = accountDao;
//    }

    public void saveAccount(Account account) {
        accountDao.save(account);
    }

    public void updateAccount(Account account) {
        accountDao.update(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.delete(accountId);
    }

    public Account findById(Integer accountId) {
        return accountDao.findById(accountId);
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
