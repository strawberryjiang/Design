package com.atguigu.singleton.type2;

/**
 * @description:饿汉式
 * @author: yangjiang
 * @create: 2020-09-23 13:46
 **/
public class SingletonTest02{
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());

    }

}

//饿汉式（静态变量）
class Singleton {


    //1、构造器私有化
    private Singleton() {

    }


    //2、本类内部创建对象实例
    private  static Singleton instance;

    static {
        instance=new Singleton();
    }


    public static Singleton getInstance() {
        return instance;
    }
}