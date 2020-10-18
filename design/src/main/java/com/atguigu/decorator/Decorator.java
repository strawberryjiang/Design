package com.atguigu.decorator;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-10-13 20:49
 **/
public class Decorator extends Drink {

    public Decorator(Drink drink) {
        this.obj = drink;
    }

    private Drink obj;

    @Override
    public float cost() {
        return super.getPrice() + obj.cost();
    }

    @Override
    public String getDes() {
        return super.getDes()+""+super.getPrice()+"&&"+obj.getDes();
    }
}
