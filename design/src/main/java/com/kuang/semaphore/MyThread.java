package com.kuang.semaphore;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-11-05 20:00
 **/
public class MyThread extends Thread {

    private SemaphoreService service;

    public MyThread(String name, SemaphoreService service) {
        super();
        this.setName(name);
        this.service = service;
    }

    @Override
    public void run() {
        service.doSomething();
    }
}
