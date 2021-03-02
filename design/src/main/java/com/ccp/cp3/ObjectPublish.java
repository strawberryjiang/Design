package com.ccp.cp3;

import org.junit.Test;

/**
 * @description: 对象的共享
 * @author: yangjiang
 * @create: 2021-03-01 16:43
 **/
public class ObjectPublish {

    private String[] states = new String[]{"AK", "AL", "AM"};

    public String[] getStates() {
        return states;
    }

}
