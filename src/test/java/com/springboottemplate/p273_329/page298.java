package com.springboottemplate.p273_329;

public class page298 {
public static void main(String[] args) {

	int a=3;
	int b=3;
	if(a==3){
		a=4;
	}
	System.out.println(a);
	System.out.println(b);
	AA aa=new AA("aa",1);
	AA bb=aa;
	aa.setAge(2);
	aa.setName("aaa");
	System.out.println(aa);
	System.out.println(bb);
	/*
	 * 总结：基本数据类型的引用，一个数的改变不会影响另一个数
	 *    但是引用数据类型，一个对象发生改变，另一个对象由于引用的是被改变的饿对象，会发生改变
	 *    因为打印aa对象与比bb对象可以发现，他们的内存地址是一样的，这里的内存地址指的是对空间的地址
	 */

}
}

class AA{
	String name;
	int age;

	public AA(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}



}
