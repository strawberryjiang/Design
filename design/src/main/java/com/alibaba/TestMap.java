package com.alibaba;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @description:
 * @author: yangjiang
 * @create: 2021-02-01 14:42
 **/
public class TestMap {


    @Test
    public void test01() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("hollis1", "hollischuang");
        map.put("hollis2", "hollischuang");
        map.put("hollis3", "hollischuang");
        map.put("hollis4", "hollischuang");
        map.put("hollis5", "hollischuang");
        map.put("hollis6", "hollischuang");
        map.put("hollis7", "hollischuang");
        map.put("hollis8", "hollischuang");
        map.put("hollis9", "hollischuang");
        map.put("hollis10", "hollischuang");
        map.put("hollis11", "hollischuang");
        map.put("hollis12", "hollischuang");
        Class<?> mapType = map.getClass();

        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map));

        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size : " + size.get(map));

        Field threshold = mapType.getDeclaredField("threshold");
        threshold.setAccessible(true);
        System.out.println("threshold : " + threshold.get(map));

        Field loadFactor = mapType.getDeclaredField("loadFactor");
        loadFactor.setAccessible(true);
        System.out.println("loadFactor : " + loadFactor.get(map));

        map.put("hollis13", "hollischuang");
        Method capacity1 = mapType.getDeclaredMethod("capacity");
        capacity1.setAccessible(true);
        System.out.println("capacity : " + capacity1.invoke(map));

        Field size1 = mapType.getDeclaredField("size");
        size1.setAccessible(true);
        System.out.println("size : " + size1.get(map));

        Field threshold1 = mapType.getDeclaredField("threshold");
        threshold1.setAccessible(true);
        System.out.println("threshold : " + threshold1.get(map));

        Field loadFactor1 = mapType.getDeclaredField("loadFactor");
        loadFactor1.setAccessible(true);
        System.out.println("loadFactor : " + loadFactor1.get(map));

    }


    @Test
    public void test02() throws Exception{
//        BigDecimal bigDecimal = new BigDecimal(1);
//
//        BigDecimal bigDecimal1 = new BigDecimal(1);
//
//        System.out.println(bigDecimal.equals(bigDecimal1));//true
//
//
//        BigDecimal bigDecimal2 = new BigDecimal(1);
//
//        BigDecimal bigDecimal3 = new BigDecimal(1.0);
//
//        System.out.println(bigDecimal2.equals(bigDecimal3));


        BigDecimal bigDecimal4 = new BigDecimal("1");
        Class<?> aClass = bigDecimal4.getClass();
        Field scale = aClass.getDeclaredField("scale");
        scale.setAccessible(true);
        System.out.println(scale.get(bigDecimal4));
        BigDecimal bigDecimal = BigDecimal.valueOf(0.56d);
        BigDecimal bigDecimal5 = new BigDecimal("1.0000");
        Field scale1 = aClass.getDeclaredField("scale");
        scale1.setAccessible(true);
        System.out.println(scale.get(bigDecimal5));

        System.out.println(bigDecimal4.compareTo(bigDecimal5));
    }


    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("abc");
            }
        }, 2000 , 100);
    }
}
