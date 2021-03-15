package com.atguigu.flyweight;

import lombok.Data;

/**
 * @description:
 * @author: yangjiang
 * @create: 2021-03-15 15:27
 **/
@Data
public class User {
   private String name;

    public User(String name) {
        this.name = name;
    }
}
