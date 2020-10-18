package com.atguigu.decorator;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-10-13 20:40
 **/
public class Coffee extends Drink{
    @Override
    public float cost() {
        return super.getPrice();
    }
}
