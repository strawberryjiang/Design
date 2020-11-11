package com.kuang;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-11-04 09:27
 **/
public class Aa {


    private static Aa aa;

    private Aa() {

    }

    public static Aa getAa() {
        if (aa == null) {
            aa = new Aa();
        }
        System.out.println(aa);
        return aa;
    }


}
