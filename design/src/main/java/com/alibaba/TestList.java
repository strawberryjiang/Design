package com.alibaba;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: yangjiang
 * @create: 2021-02-02 09:35
 **/
public class TestList {
    public static void main(String[] args) {
      List<Object> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(1);
            if(i==89){
                System.out.println("haha");
            }

        }
    }
}
