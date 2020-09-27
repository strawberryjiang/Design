package com.atguigu.builder.improve;

public class HighBuilding extends HouseBuilder {

    @Override
    public void buildBase() {
        System.out.println("高楼打地基100米");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼砌墙20cm");
    }

    @Override
    public void roofed() {
        System.out.println("高楼透明的屋顶");
    }

}
