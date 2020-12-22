package com.springboottemplate.designpattern.factory.simple;

public class FactoryTest {
	/*
	 * 简单工厂模式Simple Factory：不利于产生系列产品；
	 * 通过传递字符串判断---生成的是那个对象
	 */
	public static void main(String[] args) {
		FactoryTest factoryTest=new FactoryTest();
		factoryTest.produce(2).show();;
	}

	public Sender produce(int i) {
		if (i == 1) {
			return new Sender1();
		}
		if (i == 2) {
			return new Sender3();
		} else {
			System.out.println("输入正确类型");
			return null;
		}

	}

}
