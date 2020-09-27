package com.atguigu.builder;

public class CommonHouse extends AbstractHouse {

    @Override
    public void buildBasic() {
        System.out.println("普通房子打地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子铺瓦");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子封顶");
    }

}
