package com.atguigu.jvm.thread;

import com.atguigu.jvm.thread.callable.CallableTest;
import com.atguigu.jvm.thread.runable.RunnableTest01;

import java.util.concurrent.*;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-10-15 19:11
 **/
public class MyThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        final CountDownLatch countDownLatch = new CountDownLatch(4);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            RunnableTest01 runnableTest01;
            if (i % 2 == 0) {
                runnableTest01 = new RunnableTest01(5, countDownLatch);
            } else {
                runnableTest01 = new RunnableTest01(6, countDownLatch);
            }
            executorService.execute(runnableTest01);
            System.out.println("成功执行");

        }

        executorService.shutdown();
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("耗费时间为" + (end - start));


    }
}
