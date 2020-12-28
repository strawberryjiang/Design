package com.atguigu.template;

/**
 * @description:红豆豆浆
 * @author: yangjiang
 * @create: 2020-12-28 14:36
 **/
public class RedBeanSoyMilk extends SoyMilk {

    @Override
    void addCondiments() {
        System.out.println("加入上好的红豆");
    }
}
