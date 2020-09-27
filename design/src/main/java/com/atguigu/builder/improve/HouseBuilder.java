package com.atguigu.builder.improve;

/**
 * @description:抽象的建造者
 * @author: yangjiang
 * @create: 2020-09-27 12:45
 **/
public abstract class HouseBuilder {

    protected House house=new House();

    //将建造的流程写好
    public abstract void buildBase();
    public abstract void buildWalls();
    public abstract void roofed();


    //建造房子好后，将产品（房子）返回
    public House buildHouse(){
        return house;
    }

}
