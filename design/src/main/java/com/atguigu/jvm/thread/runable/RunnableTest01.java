package com.atguigu.jvm.thread.runable;

import lombok.Data;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-10-16 09:38
 **/
@Data
public class RunnableTest01 implements Runnable {
    private int num = 10;
    public CountDownLatch countDownLatch;

    public RunnableTest01(int num, CountDownLatch countDownLatch) {
        this.num = num;
        this.countDownLatch = countDownLatch;

    }


    @Override
    public void run() {

            try {
                while (true) {
                    if (num <= 0) {
                        break;
                    }
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "拿到了" + num-- + "当前的countDownLatch为" + countDownLatch.getCount());
                }

            } finally {
                countDownLatch.countDown();
            }



    }


}
