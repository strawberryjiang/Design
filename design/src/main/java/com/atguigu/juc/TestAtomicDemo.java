package com.atguigu.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-10-18 21:32
 **/
public class TestAtomicDemo {
    /**
     * int i=10;
     * i=i++;
     * 实际上
     * 等同于：int tmp=i;
     * i=i+1;
     * i=tmp;
     *
     * */

    public static void main(String[] args) {
        AtomicDemo atomicDemo=new AtomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(atomicDemo).start();
        }

    }

}


/**
 * 原子变量:1、volatile:保证内存可见性
 * 2、CAS算法保证数据的原子性:CAS算法是硬件对于并发操作共享数据的支持
 * CAS包含了三个值：内存值V，预估值A，更新值B，当且仅当V==A时，才会V=B，否则将不会进行任何操作。
 *
 *
 *
 * */
class AtomicDemo implements Runnable{
    private AtomicInteger serialNumber=new AtomicInteger();

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":"+getSerialNumber());
    }


    public int getSerialNumber(){
        return serialNumber.getAndIncrement();
    }
}