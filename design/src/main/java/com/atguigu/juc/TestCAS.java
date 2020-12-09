package com.atguigu.juc;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-10-18 21:55
 **/
public class TestCAS {
    public static void main(String[] args) {
        final CompareAndSwap cas=new CompareAndSwap();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                int expectedValue=cas.get();
                boolean b=cas.compareAndSet(expectedValue,(int)(Math.random()*101));
                System.out.println(b);
            }).start();

        }

    }
}


class CompareAndSwap{
    private int value;

    //获取内存值
    public synchronized int get(){
        return value;
    }

    //比较
    public synchronized int compareAndSwap(int expectValue,int newValue){
        int oldValue=value;
        if(oldValue==expectValue){
            this.value=newValue;
        }
        return oldValue;
    }

    //设置
    public synchronized boolean compareAndSet(int expectValue,int newValue){
        return expectValue==compareAndSwap(expectValue,newValue);

    }
}