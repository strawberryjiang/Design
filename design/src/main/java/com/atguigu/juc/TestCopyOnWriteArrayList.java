package com.atguigu.juc;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-10-18 22:24
 **/
public class TestCopyOnWriteArrayList {
    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread();
        for (int i = 0; i < 10; i++) {
            new Thread(helloThread).start();
        }
    }
}

class HelloThread implements Runnable {


    //private static List<String> list = Collections.synchronizedList(new ArrayList<>());

    //适合迭代
    private static CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<>();//写入并复制

    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
        list.add("DD");
    }

    @Override
    public void run() {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            list.add("AA");
        }
    }
}