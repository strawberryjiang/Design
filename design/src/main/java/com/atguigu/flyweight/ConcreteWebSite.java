package com.atguigu.flyweight;

/**
 * @description:
 * @author: yangjiang
 * @create: 2021-03-15 15:41
 **/
public class ConcreteWebSite implements WebSite{

    //共享的部分，内部状态
    private String type = ""; //网站发布的形式(类型)

    //构造器
    public ConcreteWebSite(String type) {
        this.type = type;
    }


    @Override
    public void use(User user) {
// TODO Auto-generated method stub
        System.out.println("网站的发布形式为:" + type + " 在使用中 .. 使用者是" + user.getName());
    }
}
