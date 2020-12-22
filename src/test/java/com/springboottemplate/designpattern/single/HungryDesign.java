package com.springboottemplate.designpattern.single;

/*
 * 饿汉式。
 *
 * 饿汉式”是在不管你用的用不上，一开始就建立这个单例对象：
 * 注意：所谓饿汉式，在代码块初始化的时候，就会生成一个对象，
                    并且向外提供一个公有的方法，直接返回太对象。
                   由于方法语句只有一句，所以不存在锁的情况
 *
 */
public class HungryDesign {
	private static HungryDesign hungryDesign = new HungryDesign();// 注意要是静态的，普通属性无法直接返回

	private HungryDesign() {

	}

	public static HungryDesign getHungryDesign() {
		return hungryDesign;
	}
 /*
  * 在其他类中想要得到这个对象就这样写,因为其构造器的私有的，只能在苯类实例化
  * HungryDesign design=HungryDesign.getHungryDesign();
  * 而不是。HungryDesign design=new HungryDesig();
  */
}
