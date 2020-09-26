package com.atguigu.prototype.improve;


/**
 * 浅拷贝：1、对于数据类型是基本数据类型的成员变量，浅拷贝会进行值传递，也就是将该属性复制一份给新的对象
 * 2、对于数据类型是引用数据类型的成员变量，那么浅拷贝会进行引用传递，也就是将该成员变量的引用值（内存地址）
 * 复制一份给新的对象。在这种情况下，在一个对象内部修改该成员变量会影响到另一个对象的该成员变量值
 * 3、浅拷贝是使用默认的clone()方法
 *
 *
 * */
public class Client {

	public static void main(String[] args) {

		Sheep sheep = new Sheep("tom", 1, "黑色");
		Sheep sheep21 = new Sheep("jack", 2, "白色");
		sheep.friend = sheep21;
		
		Sheep sheep2 = (Sheep)sheep.clone();
		Sheep sheep3 = (Sheep)sheep.clone();
		Sheep sheep4 = (Sheep)sheep.clone();
		Sheep sheep5 = (Sheep)sheep.clone();
		sheep21.setAge(100);

		System.out.println("sheep2 =" + sheep2 + "sheep2.friend=" + sheep2.friend);
		System.out.println("sheep3 =" + sheep3 + "sheep3.friend=" + sheep3.friend);
		System.out.println("sheep4 =" + sheep4 + "sheep4.friend=" + sheep4.friend);
		System.out.println("sheep5 =" + sheep5 + "sheep5.friend=" + sheep5.friend);
	}

}
