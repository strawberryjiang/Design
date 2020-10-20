package com.atguigu.jvm.thread.callable;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-10-16 14:29
 **/
public class StaticProxy {
    public static void main(String[] args) {
        Wedding wedding = new Wedding(new You());
        wedding.happyMarry();
    }
}

interface Marry {
    void happyMarry();
}

class You implements Marry{
    @Override
    public void happyMarry() {
        System.out.println("恭喜结婚");
    }
}

class Wedding implements Marry{

    public Marry marry;

    public Wedding(Marry marry) {
        this.marry = marry;
    }



    @Override
    public void happyMarry() {
        before();
        marry.happyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚之后很痛苦");
    }

    private void before() {
        System.out.println("结婚之前布置现场");
    }
}