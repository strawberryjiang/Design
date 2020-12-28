package com.atguigu.template;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-12-28 14:35
 **/
public class Client {
    public static void main(String[] args) {
        //制作红豆豆浆
        System.out.println("----制作红豆豆浆----");
        SoyMilk redBeanSoyMilk = new RedBeanSoyMilk();
        redBeanSoyMilk.make();

        System.out.println("---- 制 作 花 生 豆 浆 ----");
        SoyMilk peanutSoyMilk = new PeanutSoyMilk();
        peanutSoyMilk.make();

        System.out.println("---- 制 作 纯 豆 浆 ----");
        PureSoyMilk pureSoyMilk = new PureSoyMilk();
        pureSoyMilk.make();
    }
}