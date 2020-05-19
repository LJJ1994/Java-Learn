package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IAccountDao {

    @Select("select * from account")
    @Results(id = "accountMap",
            value = {
                    @Result(column = "id", property = "id", id = true),
                    @Result(column = "uid", property = "uid"),
                    @Result(column = "money", property = "money"),
                    @Result(column = "uid",
                            property = "user",
                            one = @One(select = "com.itheima.dao.IUserDao.findById", fetchType = FetchType.LAZY))
    })
    List<Account> findAll();

    @Select("select * from account where id=#{id}")
    @ResultMap("accountMap")
    Account findById(Integer id);

    @Select("select * from account where uid=#{uid}")
    List<Account> findByUid(Integer uid);
}
