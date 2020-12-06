package com.springboottemplate.page1_100.jicheng;

import org.apache.commons.lang3. StringUtils;
import org.junit.Test;

public class Student extends Person {
	int a = 2;
	int b = 3;
	public static final String ALLOW_SB_NSRZT = "01,02,03,06,07";
	public static  String ALLOW_SB_NSRZT_YHS = "01,02,03,06,07";

	public Student() {
		super.ALLOW_SB_NSRZT_YHS = "1,2,3";
	}

	private static void show() {
		System.out.println("pppppppppp");
	}

	public void show1() {
		System.out.println("show1");
		System.out.println(super.a);
		System.out.println(this.a);
		show2();

	}

	public void show2() {
		System.out.println("show2");
	}

	public static void main(String[] args) {
		Person p = new Student();
		Student s = new Student();

		s.show1();

	}

	@Test
	public void test() {
		if (StringUtils.contains(ALLOW_SB_NSRZT, "07")) {
			System.out.println("aaaaaaaaa");
		}

		System.out.println("bbbbbbbbbbb");
		sysALLOW_SB_NSRZT();
		SysMethod();
		super.SysMethod();



	}

	void SysMethod() {
		System.out.println("子类在打印");
	}
}
