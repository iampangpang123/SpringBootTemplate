package com.springboottemplate.p273_329;

/*
 * 懒汉式
 */
public class LazyDesign {
	/*
	 * 所谓懒汉式，就是在初始化的时候并不给该类对象赋值属性，为null.
	 * 只用当调用该方法时，进行判断如果值为null,则新建一个内存对象赋值给该对象，返回该对象
	 * 否则则认为该对象以存在，返回原来的对象，确保对象的唯一性。
	 */
	private static LazyDesign lazyDesign=null;
	private LazyDesign(){

	}

	public static LazyDesign getLazyDesign(){
		if(lazyDesign==null){//检查实例，如果不存在就进入同步区
			synchronized (LazyDesign.class) {////静态变量在方法区进内存中，因为本类没有被实例化，没有本类对象，但是有该类对应的字节码文件对象     类.class
				if(lazyDesign==null){//再检查一次，如果仍是null，才创建
					lazyDesign=new LazyDesign();
				}

			}
		}
		return lazyDesign;
	}
}
