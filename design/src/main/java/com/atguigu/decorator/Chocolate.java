package com.atguigu.decorator;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-10-13 20:54
 **/
public class Chocolate extends Decorator{
    public Chocolate(Drink obj) {
        super(obj);
        setDes("巧克力");
        setPrice(3.0f);//调味品的价格
    }
}
