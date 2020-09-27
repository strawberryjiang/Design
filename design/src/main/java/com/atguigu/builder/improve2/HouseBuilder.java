package com.atguigu.builder.improve2;


/**
 * Product(产品角色)：一个具体的产品对象
 * Builder(抽象建造者)：创建一个Product对象的各个部件指定的接口/抽象类
 * ConcreteBuilder(具体建造者)：实现接口，构建和装配各个部件
 * Director(指挥者)：构建一个Builder接口的对象。它主要是用于创建一个复杂的对象。
 *
 * */
public abstract class HouseBuilder {

	protected House house = new House();

	public abstract void buildBasic();
	public abstract void buildWalls();
	public abstract void roofed();

	public House buildHouse() {
		return house;
	}
	
}
