package com.atguigu.jvm;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-10-12 15:46
 **/
public class Parent {


    static{
         A=2;}
    public static int A;

}

class Son extends Parent {
    static {
        System.out.println("子类被初始化");
    }
}

