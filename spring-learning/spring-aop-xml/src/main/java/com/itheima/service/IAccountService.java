package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

public interface IAccountService {
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Integer accountId);
    Account findById(Integer accountId);
    List<Account> findAll();

    void transfer(String source, String target, float money);
}
