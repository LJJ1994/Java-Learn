package com.itheima.domain;

import java.io.Serializable;

/**
 * @Author: LJJ
 * @Program: mybatis-day02
 * @Description:
 * @Create: 2020-05-09 20:08:08
 * @Modified By:
 */
public class AccountUser extends Account implements Serializable {
    private String username;
    private String address;

    @Override
    public String toString() {
        return "AccountUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
