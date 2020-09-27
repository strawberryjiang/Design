package com.atguigu.builder.improve;

public class CommonHouse extends HouseBuilder {

    @Override
    public void buildBase() {
        System.out.println("普通房子打地基5米");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子10cm");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子朴实的房顶");
    }

}
