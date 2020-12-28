package com.atguigu.template;

/**
 * @description:花生豆浆
 * @author: yangjiang
 * @create: 2020-12-28 14:36
 **/
public class PeanutSoyMilk extends SoyMilk {

    @Override
    void addCondiments() {
        System.out.println("加入上好的花生");
    }

}
