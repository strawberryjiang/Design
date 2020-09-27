package com.atguigu.prototype.deepclone;

public class Client {

	public static void main(String[] args) throws Exception {
		DeepProtoType p = new DeepProtoType();
		p.name = "小明";
		p.deepCloneableTarget = new DeepCloneableTarget("今天", "吃饭");

		DeepProtoType p2 = (DeepProtoType) p.deepClone();
		
		System.out.println("p.name=" + p.name + "p.deepCloneableTarget=" + p.deepCloneableTarget.hashCode());
		System.out.println("p2.name=" + p.name + "p2.deepCloneableTarget=" + p2.deepCloneableTarget.hashCode());
	
	}

}
