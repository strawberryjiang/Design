package com.atguigu.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-10-18 22:33
 **/
public class TestCountDownLatch {

    /**
     * CountDownLatch:闭锁，在完成某些运算时，只有所有其他线程的运算全部完成时，当前运算才会继续执行
     */
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(5);
        LatchDemo latchDemo = new LatchDemo(latch);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            new Thread(latchDemo).start();

        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗费时间为" + (end - start));


    }
}

class LatchDemo implements Runnable {
    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;

    }

    @Override
    public void run() {

            try {
                for (int i = 0; i < 50000; i++) {
                    if (i % 2 == 0) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(i);

                    }

                }

            } finally {
                latch.countDown();

            }

        }



}