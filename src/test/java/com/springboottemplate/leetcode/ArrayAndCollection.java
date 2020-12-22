package com.springboottemplate.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.junit.Test;

public class ArrayAndCollection {

	public static void main(String[] args) {
		ArrayAndCollection andCollection = new ArrayAndCollection();
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
	}

	/**
	 **
	 * @Description:将数组放在集合中
	 * @param:
	 * @return: void
	 */
	@Test
	public void test() {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		System.out.println(set.toString());// 1, 2, 3, 4, 5, 6, 7, 8
		for (Integer integer : set) {
			System.out.println(integer);
			list.add(integer);
		}
		System.out.println(list.toString());// [1, 2, 3, 4, 5, 6, 7, 8]
		for (Integer integer : list) {
			map.put(UUID.randomUUID().toString(), integer);
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {

			System.out.println("map" + entry.getValue());
		}
		System.out.println(map.toString());

	}

	@Test
	public void test2() {
		int num = 5;

		for (int i = 1; i < num; i++) {
			System.out.println(0 + "-" + i);
		}
		for (int i = 1; i < num - 1; i++) {
			System.out.println(i + "-" + (i + 1));
		}
	}

	@Test
	public void test3() {
		int newX = 0;
		int newY = 0;
		// 矩阵翻转
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int arr2[][] = new int[3][3];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println(arr[i][j]);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				newX = j;
				newY = 2 - i;
				arr2[newX][newY] = arr[i][j];

			}
		}

		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				System.out.println(arr2[i][j]);
			}
		}
	}

	@Test
	public void test4() {

		// 矩阵反转
		// 新矩阵的横坐标等于旧矩阵的纵坐标
		// 纵坐标就是2-x
		int newX = 0;
		int newY = 0;
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int newArr[][] = new int[3][3];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				newX = j;
				newY = 2 - i;
				newArr[newX][newY] = arr[i][j];

			}

		}
		for (int i = 0; i < newArr.length; i++) {
			for (int j = 0; j < newArr[i].length; j++) {
				System.out.println(newArr[i][j]);

			}

		}
	}

	@Test
	public void test6() {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		for (Integer setValues : set) {

			list.add(setValues);
		}
		for (Integer listValues : list) {

			map.put(UUID.randomUUID().toString().replace("-", ""), listValues);
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getValue());

		}
		System.out.println(map.toString());

	}
}
