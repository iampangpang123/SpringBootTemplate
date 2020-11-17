package cn.tang.web1.designpattern.prototype;

/*
 *
 * 原型模式的克隆分为浅克隆和深克隆，Java 中的 Object 类提供了浅克隆的 clone() 方法
 * ，具体原型类只要实现 Cloneable 接口就可实现对象的浅克隆，
 * 这里的 Cloneable 接口就是抽象原型类。其代码如下：
 */
//原型模式通常适用于以下场景。
//对象之间相同或相似，即只是个别的几个属性不同的时候。
//对象的创建过程比较麻烦，但复制比较简单的时候
////具体原型类
public class Realizetype implements Cloneable {
	public Realizetype() {
		System.out.println("具体原型创建成功！");
	}
	public Object clone() throws CloneNotSupportedException {
		System.out.println("具体原型复制成功！");
		return (Realizetype)super.clone();
	}

}
