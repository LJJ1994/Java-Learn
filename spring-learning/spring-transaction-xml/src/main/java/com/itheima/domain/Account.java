package com.itheima.domain;

import java.io.Serializable;

/**
 * @Author: LJJ
 * @Program: spring-transaction-xml
 * @Description:
 * @Create: 2020-05-07 23:02:02
 * @Modified By:
 */
public class Account implements Serializable {
    private String name;
    private Float money;
    private Integer id;

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
