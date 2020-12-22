package com.springboottemplate.Sort;

import java.util.Arrays;

import org.junit.Test;

public class Test2 {
	/*
	 * 冒泡排序（小到大）
	 */
	@Test
	public void test1() {
		int[] arr = { 6, 3, 5, 8, 2, 7 };
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j]>arr[j+1]){
					int t = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = t;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	/*
	 * 选择排序（小到大）
	 */
	@Test
	public void test2() {
		int[] arr = { 6, 3, 5, 8, 2, 7 ,1,1,9,8,7  ,9,6};
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if (arr[i]>arr[j]) {
					int t = arr[j];
					arr[j] = arr[i];
					arr[i] = t;

				}
			}

		}

		System.out.println(Arrays.toString(arr));
	}

}
