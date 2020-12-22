package com.springboottemplate.suanfa;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.junit.Test;

/*
 * java集合里如何判断中出现最多的元素
 */
public class CountNumber {

	@Test
	public void test1() {
		int[] array = { 2, 3, 1, 2, 2, 5, 6, 8, 2, 3, 2, 4, 2 };
		Map<Integer, Integer> maps = new HashedMap<Integer, Integer>();/// 第一个值为出现的数字，第二个值为出现的次数
		for (int i = 0; i < array.length; i++) {
			if (maps.containsKey(array[i])) {
				Integer value = (Integer) maps.get(array[i]);
				maps.put(array[i], value + 1);
			} else {
				maps.put(array[i], 1);
			}
		}
		Collection<Integer> count = maps.values();
		int maxCount = Collections.max(count);
		int maxnum = 0;
		for (Map.Entry<Integer, Integer> entry : maps.entrySet()) {
			if (maxCount == entry.getValue()) {
				maxnum = entry.getKey();
			}
		}
		System.out.println("出现次数最多的数字为"+maxnum);
		System.out.println("改次数一共出现了"+maxCount+"次");
	}
}
