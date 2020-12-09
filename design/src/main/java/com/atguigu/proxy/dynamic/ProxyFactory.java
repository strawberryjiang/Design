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

    //给目标对象  生成一个代理对象
    public Object getProxyInstance() {

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("JDK 代理开始~~");
                        Object returnVal = method.invoke(target, args);
                        System.out.println("JDK 代理提交");
                        return returnVal;
                    }
                });
    }


}
