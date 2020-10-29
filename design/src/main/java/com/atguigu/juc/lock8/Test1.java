package com.atguigu.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-10-29 20:13
 **/




/**
 * 1、标准情况下，两个线程先发短信还是打电话？1、发短信 2、打电话
 * 2、发短信等待四秒，两个线程先发短信还是打电话？1、发短信 2、打电话
 *
 *
 *
 * */
public class Test1 {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(()->{
            phone.sendSms();
        },"A").start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            phone.call();
        },"B").start();

    }


}

class Phone{

    public synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }
}
