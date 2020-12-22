package com.springboottemplate.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/*
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的
 *  ，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 */
public class RepeatNumber {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 6, 8, 4, 2, 2, 6, 7 ,6,6,6,2};
		int[] arr2={2, 3, 1, 0, 2, 5};
		RepeatNumber number = new RepeatNumber();
		number.examine(arr);
		number.examine(arr2);
	}

	public void examine(int[] arr) {//原始方法实现
	  int count=0;
	  Map maps=new HashMap<Integer, Object>();
	//  List<Integer> list=new java.util.LinkedList<Integer>();//这个集合是可以重复的，
	  Set set=new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
             if(maps.containsKey(arr[i])) {
            	 set.add(arr[i]);
            	continue;
             }
             maps.put(arr[i], "");


		}
		System.out.println(set.toString());

	}

}
