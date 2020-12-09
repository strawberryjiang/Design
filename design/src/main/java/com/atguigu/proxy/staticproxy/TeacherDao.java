package com.atguigu.proxy.staticproxy;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-12-09 15:07
 **/
public class TeacherDao implements ITeacherDao{
    @Override
    public void teach() {
        System.out.println(" 老师授课中	。。。。。");
    }
}
