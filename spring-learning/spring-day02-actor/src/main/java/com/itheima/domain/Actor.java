package com.itheima.domain;

/**
 * @Author: LJJ
 * @Program: spring-day02-actor
 * @Description:
 * @Create: 2020-05-07 19:48:48
 * @Modified By:
 */
public class Actor {
    public void basicAct(float money) {
        System.out.println("拿到钱，开始基本表演: " + money);
    }

    public void dangerAct(float money) {
        System.out.println("拿到钱，开始危险表演：" + money);
    }
}
