package com.springboottemplate.jihe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class TestConllection {
	@Test
	public void test1() {
		Set<String> set = new HashSet<String>();
		set.add("张三");
		set.add("李四");
		set.add("王五");
		set.add("王五");
		System.out.println(set.toString());
		System.out.println(set.size());
		for (int i = 0; i < set.size(); i++) {
			if (set.contains("王五")) {
				set.remove("王五");

			}

		}
		System.out.println(set.toString());
	}

}
