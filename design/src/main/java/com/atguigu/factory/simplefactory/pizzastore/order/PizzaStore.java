package com.atguigu.factory.simplefactory.pizzastore.order;

//披萨店
public class PizzaStore {

    public static void main(String[] args) {
        new OrderPizza(new SimpleFactory());
    }

}
