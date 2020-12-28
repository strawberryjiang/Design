package com.atguigu.decorator;

import lombok.Data;

/**
 * @description: component
 * @author: yangjiang
 * @create: 2020-10-13 20:36
 **/

@Data
public abstract class Drink {
    private String des;
    private float price = 1.0f;

    public abstract float cost();
}
