package com.itheima.domain;

import java.io.Serializable;

/**
 * @Author: LJJ
 * @Program: springmvc-day1
 * @Description:
 * @Create: 2020-05-10 03:15:15
 * @Modified By:
 */
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Float money;
    private Address address;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", address=" + address +
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
