package com.atguigu.juc.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 卖票synchronized
 * @author: yangjiang
 * @create: 2020-10-26 19:26
 **/
public class SaleTicketDemo01 {
    //并发：多线程操作同一个资源类
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) ticket.sale();
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) ticket.sale();
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) ticket.sale();
        }, "C").start();
    }
}


//使用
class Ticket {
    //只有属性与方法
    private int number = 50;
    private Lock lock = new ReentrantLock();

    //卖票的方式
    public synchronized void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了第" + number-- + "票,剩余" + number);

            }

        } finally {
            lock.unlock();
        }

    }
}