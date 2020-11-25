package com.myself.meijv;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-11-24 23:11
 **/
public class Season {

    private final String name;
    private Season(String name){
        this.name=name;

    }

    public static final Season Spring=new Season("春天");

    public String getName() {
        return name;
    }


}
