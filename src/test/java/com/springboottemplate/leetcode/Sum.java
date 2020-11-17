package cn.tang.web1.leetcode;

import java.util.Arrays;

public class Sum {
	/*
	 * 给定nums = [2,7,11,15]，目标= 9
	 *
	 * 因为nums [ 0 ] + nums [ 1 ] = 2 + 7 = 9 所以返回[ 0,1 ]
	 *
	 */
	public static void main(String[] args) {
		Sum.twoSum();
	}

	public  static int[] twoSum() {
		int index = 17;
		int[] arr = { 2, 7, 11, 15 ,16};
		int[] result = new int[2];
		for (int i = 0; i <= arr.length - 1; i++) {

			for (int j = 0; j < arr.length - 1; j++) {
				if (i == j) {
					continue;
				}
				if (arr[i] + arr[j] == index) {
					result[0] = arr[i];
					result[1] = arr[j];
					//return result;
					break;
				}

			}
		}
		System.out.println(Arrays.toString(result));
		return result;

	}

}
