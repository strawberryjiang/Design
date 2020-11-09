package com.kuang;

import java.util.concurrent.CyclicBarrier;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-11-04 09:29
 **/
public class Bb {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,()->{
            System.out.println("成功执行五次");
        });
        for (int i = 0; i <4 ; i++) {
            new Thread(new CyclicBarrierDemo(cyclicBarrier)).start();
        }
    }



}

class CyclicBarrierDemo implements Runnable {


    CyclicBarrier barrier;

    public CyclicBarrierDemo(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " 到达栅栏 A");
            barrier.await();
            System.out.println(Thread.currentThread().getName() + " 冲破栅栏 A");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
