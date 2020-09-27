package com.atguigu.builder.improve;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-09-27 12:44
 **/
public class House {
    private String base;
    private String wall;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoofed() {
        return roofed;
    }

    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }

    private String roofed;
}
