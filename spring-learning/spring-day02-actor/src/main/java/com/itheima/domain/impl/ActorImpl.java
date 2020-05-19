package com.itheima.domain.impl;

import com.itheima.domain.iActor;

/**
 * @Author: LJJ
 * @Program: spring-day02-actor
 * @Description:
 * @Create: 2020-05-07 19:39:39
 * @Modified By:
 */
public class ActorImpl implements iActor {
    public void basicAct(float money) {
        System.out.println("拿到钱，开始基本表演: " + money);
    }

    public void dangerAct(float money) {
        System.out.println("拿到钱，开始危险表演：" + money);
    }
}
