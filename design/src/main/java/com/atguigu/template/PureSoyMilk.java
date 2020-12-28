package com.atguigu.template;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-12-28 14:55
 **/
public class PureSoyMilk extends  SoyMilk {
    @Override
    void addCondiments() {
        //纯豆浆，不需要添加原料
    }

    @Override
    boolean customerWantCondiments() {
        return false;
    }
}
