package com.atguigu.factory.simplefactory.pizzastore.order;

import com.atguigu.factory.simplefactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza2 {

    public OrderPizza2() {
    }

    //定义一个简单工厂对象
    Pizza pizza;

    public OrderPizza2(SimpleFactory simpleFactory) {
        setFactory();
    }

    public void setFactory() {
        String orderType;
        do {
            orderType = getType();
            pizza = SimpleFactory.createPizza(orderType);
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购不成功");
                break;
            }
        } while (true);
    }


    // 获取用户希望订购披萨的种类
    private String getType() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入披萨:");
            String str = br.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }
}