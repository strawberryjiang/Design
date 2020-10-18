package com.atguigu.jvm;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-10-12 15:56
 **/
public class NotInitialization1 {
    public static void main(String[] args) {
        Parent parent = new Parent();
        System.out.println(parent.A);
    }
}
