package com.atguigu.proxy.cglib;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-12-09 15:37
 **/
public class TeacherDao {

    public String teach() {
        System.out.println("授课中，我是cglib代理，不需要实现接口");
        return "hello";
    }
}
