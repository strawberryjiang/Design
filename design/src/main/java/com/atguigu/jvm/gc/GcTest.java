package com.atguigu.jvm.gc;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-10-15 17:22
 **/
public class GcTest {
    public static void main(String[] args) {
        GcTest gcTest = new GcTest();
        GcTest gcTest2=new GcTest();
        gcTest=gcTest2;
        gcTest2=gcTest;
        gcTest=null;
        gcTest2=null;
    }
}
