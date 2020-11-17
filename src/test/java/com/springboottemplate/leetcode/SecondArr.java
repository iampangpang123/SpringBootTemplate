package cn.tang.web1.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * Given target = 5, return true.
Given target = 20, return false.
 */
public class SecondArr {
	public static void main(String[] args) {

		int[][] arr = { { 1, 4, 7, 11, 5 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };

		SecondArr secondArr = new SecondArr();
		int target = 5;
		secondArr.test(arr, target);

	}

	public void test(int[][] arr, int target) {
		Map maps = new HashMap();
		int i;
		int j = 0;
		for (i = 0; i < arr.length; i++) {// 遍历每一个一维数组
			for (j = 0; j < arr[i].length; j++) {
				System.out.println(arr[i][j]);
				maps.put(arr[i][j], "");
			}
		}
		if(maps.containsKey(target)) {
			System.out.println("T");
		}else {
			System.out.println("F");
		}

	}

}
