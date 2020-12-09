package com.atguigu.proxy.dynamic;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-12-09 15:24
 **/
public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("正在授课");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}
