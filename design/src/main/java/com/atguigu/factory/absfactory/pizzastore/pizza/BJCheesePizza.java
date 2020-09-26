package com.atguigu.factory.absfactory.pizzastore.pizza;

public class BJCheesePizza extends Pizza {

	@Override
	public void prepare() {
		setName("北京奶酪pizza");
		System.out.println(" ����������pizza ׼��ԭ����");
	}

}
