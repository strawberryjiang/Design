package com.effectivejava.object;

import org.junit.Test;

/**
 * @description:
 * @author: yangjiang
 * @create: 2021-03-08 17:42
 **/
public class BuilderTest {
    public static void main(String[] args) {
        NutritionFacts build = new NutritionFacts.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
        System.out.println(build);
    }

    @Test
    public void test01(){
        long sum=0l;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum+=i;

        }
        System.out.println(sum);
        try {
            Thread.sleep(1000011110);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
