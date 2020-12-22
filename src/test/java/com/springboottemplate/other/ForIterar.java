package com.springboottemplate.other;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ForIterar {

	@Test
	public void test1() {

		int a = 1;

		Integer b = 2;
		int d = a==b ? b : a;
		System.out.println(d);
		return;

	}

	/**
	 **
	 * @Description:double类型数字过长防止出现科学计数法
	 * @param:
	 * @return: void
	 */
	@Test
	public void test2() {

		double aa = 22222222222445.3345;
		DecimalFormat df = new DecimalFormat("0.000");// 精度自己控制保留几位小数点
		String c = df.format(aa);
		System.out.println(c);

		double cc = aa;
		System.out.println(cc);

		double dd = 2.2222222222445336E13;
		System.out.println(aa = dd);
		if (aa == dd) {
			System.out.println("aaaaaaaaaaaaaaa");
			System.out.println(aa == dd);
		}

	}

	@Test
	public void test3() {

		List<String> list=new ArrayList<String>();
		if(list.isEmpty()) {
			System.out.println("aaaaaaa");
		}else  {
			System.out.println("bbbbbb");
		}
		test1();
		test2();

		System.out.println("cccccccc");
	}

}
