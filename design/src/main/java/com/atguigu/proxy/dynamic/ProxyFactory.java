package com.atguigu.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-12-09 15:24
 **/
public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

   /**
    * 第一个参数为当前目标对象的类加载器；第二个参数为目标对象实现的接口，使用泛型来确认类型
    * 第三个参数为 时间处理器，当执行目标方法时，会触发事件处理器的方法
    * */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("JDK 代理开始~~");
                    Object returnVal = method.invoke(target, args);
                    System.out.println("JDK 代理提交");
                    return returnVal;
                });
    }


}
