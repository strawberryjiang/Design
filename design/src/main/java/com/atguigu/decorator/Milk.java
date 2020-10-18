package com.atguigu.decorator;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-10-13 20:54
 **/
public class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
        setDes("牛奶");
        setPrice(2.0f);//调味品的价格
    }
}
