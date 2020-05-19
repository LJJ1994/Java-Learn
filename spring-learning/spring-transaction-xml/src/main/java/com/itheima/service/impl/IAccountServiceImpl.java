package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;

/**
 * @Author: LJJ
 * @Program: spring-transaction-xml
 * @Description:
 * @Create: 2020-05-07 23:04:04
 * @Modified By:
 */
public class IAccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account findByAccountId(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void transfer(String source, String target, float money) {
        Account sourceName = accountDao.findAccountByName(source);
        Account targetName = accountDao.findAccountByName(target);

        sourceName.setMoney(sourceName.getMoney() - money);
        targetName.setMoney(targetName.getMoney() + money);
        accountDao.updateAccount(sourceName);
//        int i = 1/0;
        accountDao.updateAccount(targetName);
    }
}
