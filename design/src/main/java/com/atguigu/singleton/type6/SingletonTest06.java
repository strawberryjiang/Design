package com.atguigu.singleton.type6;

/**
 * @description:静态内部类：外部类被装载时，静态内部类不会被装载，（推荐使用）
 * @author: yangjiang
 * @create: 2020-09-23 13:46
 **/
public class SingletonTest06 {
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


    //jvm装载静态内部类时是线程安全的
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();

    }

    public static synchronized Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}