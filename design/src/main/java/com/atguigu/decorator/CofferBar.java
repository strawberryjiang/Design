package com.atguigu.decorator;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-10-13 20:58
 **/
public class CofferBar {
    public static void main(String[] args) {
        Drink order = new LongBlack();
        System.out.println("费用="+order.cost());
        System.out.println("描述="+order.getDes());

        order = new Milk(order);
        System.out.println("费用="+order.cost());
        System.out.println("描述="+order.getDes());


        order = new Chocolate(order);
        System.out.println("费用="+order.cost());
        System.out.println("描述="+order.getDes());

    }
}
