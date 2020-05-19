package com.itheima.service;

import com.itheima.domain.Account;

public interface IAccountService {
    Account findByAccountId(Integer accountId);
    void transfer(String source, String target, float money);
}
