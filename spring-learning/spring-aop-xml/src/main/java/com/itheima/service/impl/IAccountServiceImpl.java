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
public class IAccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao){
        this.accountDao = accountDao;
    }

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

    public void transfer(String source, String target, float money) {
        System.out.println("transfer....");
        //2.1根据名称查询转出账户
        Account sourceName = accountDao.findByName(source);
        //2.2根据名称查询转入账户
        Account targetName = accountDao.findByName(target);
        //2.3转出账户减钱
        sourceName.setMoney(sourceName.getMoney()-money);
        //2.4转入账户加钱
        targetName.setMoney(targetName.getMoney()+money);
        //2.5更新转出账户
        accountDao.update(sourceName);

            int i=1/0;

        //2.6更新转入账户
        accountDao.update(targetName);
    }
}
