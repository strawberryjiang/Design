package com.atguigu.jvm.thread.threadaa;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-10-15 19:11
 **/
public class MyThreadTest {
    public static void main(String[] args) {
        ThreadTest01 threadTest01 = new ThreadTest01();
        ThreadTest02 threadTest02 = new ThreadTest02();

        threadTest01.start();

    }
}
