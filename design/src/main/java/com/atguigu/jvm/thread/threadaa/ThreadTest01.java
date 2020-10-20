package com.atguigu.jvm.thread.threadaa;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-10-15 19:11
 **/
public class ThreadTest01 extends Thread {
    @Override
    public void run() {
        System.out.println("ThreadTest01启动");
    }
}
