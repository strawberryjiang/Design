package com.atguigu.jvm.gc;

/**
 * @description: 对象已死的判定
 * @author: yangjiang
 * @create: 2020-10-21 15:43
 **/
public class FinalizeEscapeGC {


    public static FinalizeEscapeGC fegc;

    public static void main(String[] args) throws Throwable {
        fegc = new FinalizeEscapeGC();


        fegc = null;
        System.gc();
        Thread.sleep(500);//finalize方法线程执行需要sleep，因为优先级很低
        if (fegc != null) {
            fegc.isAlive();
        } else {
            System.out.println("i'm dead ");
        }

        fegc = null;
        System.gc();
        Thread.sleep(500);//finalize方法线程执行需要sleep，因为优先级很低
        if (fegc != null) {
            fegc.isAlive();
        } else {
            System.out.println("i'm dead ");
        }

    }

    public void isAlive() {
        System.out.println("i'm still alive");
    }

    @Override
    //finalize方法只会执行一次,前提是你要重写这个finalize方法。只要是在这个方法中让即将被GC的对象重新引用到GCrootS就可以了
    protected void finalize() throws Throwable {
        super.finalize();
        fegc = this;
        System.out.println("finalize执行了");
    }
}
