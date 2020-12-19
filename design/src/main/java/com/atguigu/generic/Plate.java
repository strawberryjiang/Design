package com.atguigu.generic;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-12-19 14:59
 **/
public class Plate<T> {
    private T item;


    public Plate(T t) {
        this.item = t;
    }

    public T get() {
        return item;
    }

    public void set(T item) {
        this.item = item;
    }
}
