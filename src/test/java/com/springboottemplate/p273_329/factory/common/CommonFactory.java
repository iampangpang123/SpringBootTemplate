package com.springboottemplate.p273_329.factory.common;

import static org.hamcrest.CoreMatchers.nullValue;

/*
 * 因为是有接口的，所以这属于jdk的动态代理，
 */

public class CommonFactory {
	private static CommonFactory commonFactory=new CommonFactory();//这里我采用饿汉式，当然也可以不用
	private CommonFactory() {
		// TODO Auto-generated constructor stub
		/*
		 * 私有化构造器目的是不允许其他类中实例本对象
		 */
	}
	public static CommonFactory getCommonFactory(){
		return commonFactory;
	}
	public  Sender getSender(String type){//因为这里有很多实现类，传入一个属性选择自己要的实现类
		//我们这里不写成静态的了，因为我们采用饿汉式，直接生成了对象
		if(type.equals("1")){
			return new SendImpl1();
		}
		if(type.equals("2")){
			return new SendImpl2();
		}else {
			System.out.println("传入的类型错误");
			return null;
		}



	}

}
