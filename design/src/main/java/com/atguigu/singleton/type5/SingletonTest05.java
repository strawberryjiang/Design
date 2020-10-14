package com.atguigu.singleton.type5;

/**
 * @description:双重检查：线程安全，延迟加载，效率较高（推荐使用）
 * @author: yangjiang
 * @create: 2020-09-23 13:46
 **/
public class SingletonTest05 {
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

    //如果不加volatile关键字，那么jvm指令重排序时，会发生错误
    //2、本类内部创建对象实例
    private static volatile Singleton instance;


    //双重检查
    public static synchronized Singleton getInstance() {
        if (null == instance) {
            synchronized (Singleton.class) {
                if (null == instance) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}