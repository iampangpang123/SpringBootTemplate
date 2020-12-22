package com.springboottemplate.Sort;

import java.util.Arrays;

import org.junit.Test;

public class XuanZeSort {
	/*
	 *
	 * 选择排序{ 6, 3, 5, 8, 2, 7 }从小到大过程 1.第一个数字6与后面的每一个数字进行比较，如果比da就交换顺序。可以看出，2换到前面了，
	 *
	 * 可以看出第一轮就把最小的数字弄到前面来了 2.此时，i变成了1=8，j成2了=5。；所以就是8与后面的每一个数进行比较，8跟5比，8大，8跟5换位置。
	 * 3.此时，序列成为2，5，8，6，3，7；j变为3=6，所以5在跟6比。小，所以不变化，在跟3比，大，变换 4.重复，就可以把数列排出来
	 * 总结；第一个数与后面每一个数进行比较，第一轮就把最小的弄到第一位了
	 *
	 * 第二次，第二个数与后面每个数进行比较
	 *
	 */

	@Test
	public void test1() {
		int[] arr = { 5, 6, 2, 9, 8, 7 };
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[i]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}

		}
		System.out.println(Arrays.toString(arr));
	}

	@Test
	public void test2() {
		int[] arr = { 9,5, 6, 2, 9, 8, 7 };
		for (int i = 0; i < arr.length - 1; i++) {

			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]<arr[j]) {

					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}

			}
		}
		System.out.println(Arrays.toString(arr));
	}

	@Test
	public void test3() {
		int[] arr = { 9,5, 6, 2, 9, 8, 7 };
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]>arr[j]) {

					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));

	}



}
