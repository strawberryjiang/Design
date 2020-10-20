package com.atguigu.jvm.thread.callable;

import java.util.concurrent.Callable;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-10-16 14:17
 **/
public class CallableTest implements Callable {
    @Override
    public String call() throws Exception {
        return "dasdadad";
    }
}
