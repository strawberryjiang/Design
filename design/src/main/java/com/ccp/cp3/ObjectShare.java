package com.ccp.cp3;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 对象的共享
 * @author: yangjiang
 * @create: 2021-03-01 16:43
 **/
public class ObjectShare {

    private static boolean ready;
    private static int number;

    public static final ObjectPublish op=new ObjectPublish();

    public static void main(String[] args) {
        String[] states = op.getStates();
//        states=null;
        for(String s:states){
            System.out.println(s);
        }

    }



    @Test//在没有同步的情况下共享变量,内存不可见
    public void test01(){
        new ReaderThread().start();
        number=12;
        ready=true;
    }

    private static class ReaderThread extends Thread{
        @Override
        public void run() {
            while (!ready){
                Thread.yield();
                System.out.println(number);
            }
        }
    }
}
