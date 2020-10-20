package com.atguigu.jvm.thread.callable;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-10-20 09:50
 **/
public class MainCard {
    public static void main(String[] args) throws Exception{
        ExecutorService executor = Executors.newFixedThreadPool(2);
        System.out.println("提交任务之前 " + getStringDate());
        MyCallable call= new MyCallable();
//        MyCallable2 call2= new MyCallable2();
        Future future = executor.submit(call);
//        Future future2 = executor.submit(call2);
        System.out.println("提交任务之后，获取结果之前 " + getStringDate());
//        System.out.println("获取第二个返回值: " + future2.get());//future的get方法就是一个闭锁，可以用来阻塞线程，只有当这个线程的任务完成后才可以
        System.out.println("获取第一个返回值: " + future.get());//future的get方法就是一个闭锁，可以用来阻塞线程，只有当这个线程的任务完成后才可以
        System.out.println("获取到结果之后 " + getStringDate());
        executor.shutdown();
    }


    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(3000);
            System.out.println("call11方法执行了");
            return "call11方法返回值";
        }
    }

    static class MyCallable2 implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(10000);
            System.out.println("call22方法执行了");
            return "call22方法返回值";
        }
    }

    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

}
