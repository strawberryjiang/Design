package com.atguigu.singleton.type4;

/**
 * @description:饿汉式
 * @author: yangjiang
 * @create: 2020-09-23 13:46
 **/
public class SingletonTest04 {
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
    private static Singleton instance;


    //提供一个静态的线程安全的公有方法，使用时才会创建对象
    public static synchronized Singleton getInstance() {
        if (null == instance) {
            instance = new Singleton();
        }

        return instance;
    }
}