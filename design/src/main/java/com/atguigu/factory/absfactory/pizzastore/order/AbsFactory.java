package com.atguigu.factory.absfactory.pizzastore.order;

import com.atguigu.factory.absfactory.pizzastore.pizza.Pizza;

//抽象工厂模式
public interface AbsFactory {

     Pizza createPizza(String orderType);
}
