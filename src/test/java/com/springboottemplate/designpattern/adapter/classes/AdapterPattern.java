package com.springboottemplate.designpattern.adapter.classes;
/*
 * 将一个类的接口转换成客户期望的另一个接口，适配器让原本接口不兼容的类可以相互合作。这个定义还好，说适配器的功能就是把一个接口转成另一个接口。
 */
public class AdapterPattern {
	public static void main(String[] args) {
		Targetable targetable = new Adapter();
		targetable.method1();
		targetable.method2();//给对象新增的方法
	}

}
