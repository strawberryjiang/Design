package com.atguigu.singleton.type7;

/**
 * @description:枚举可以防止反序列化重新创建新的对象（推荐使用）
 * @author: yangjiang
 * @create: 2020-09-23 13:46
 **/
public class SingletonTest07{
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());

    }

}

//饿汉式（静态变量）
enum  Singleton {
INSTANCE;
public void sayOK(){
    System.out.println("ok");
}
}