package com.springboottemplate.page1_100.jicheng;

public class Person {
	public static final String ALLOW_SB_NSRZT = "01,02,03,06";
	public static  String ALLOW_SB_NSRZT_YHS = "01,02,03,06,07";
	int a = 1;

	public static void main(String[] args) {

		Person p1 = new Person();

		Person p2 = new Person();
		p1.a = 2;
		p2.a = 3;
		System.out.println(p1.a);
	}

	void sysALLOW_SB_NSRZT() {
		System.out.println(ALLOW_SB_NSRZT);
		System.out.println(ALLOW_SB_NSRZT_YHS);

	}
	void SysMethod() {
		System.out.println("父类在打印");
	}
}
