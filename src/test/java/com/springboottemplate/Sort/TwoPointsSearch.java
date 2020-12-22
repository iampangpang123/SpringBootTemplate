package com.springboottemplate.Sort;

import org.junit.Test;

/*
 * 时间复杂度为log2N。由于辅助空间是常数级别的所以：
空间复杂度是O(1);
 */
public class TwoPointsSearch {
	public static void main(String[] args) {
		TwoPointsSearch pointsSearch = new TwoPointsSearch();

		int arr2[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		int arr[]= {0, 1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8, 8, 9, 9};
		int p = 8;// 数组中查找p这个元素
		// System.out.println(pointsSearch.test2(arr, p));
		System.out.println(pointsSearch.test3(arr, p));


	}

	/**
	 * @Description:二分查找 ;这样写有个缺点，就是当找不到的时候无法提示找不到，必须改成return
	 * @return void 返回类型
	 */
	@Test
	public void test() {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		int p = 6;// 数组中查找p这个元素
		int lift = 0;
		int right = arr.length - 1;
		int mid;

		while (lift <= right) {
			mid = arr.length / 2;
			if (p == arr[mid]) {
				System.out.println(arr[mid]);
				break;
			} else if (p > arr[mid]) {
				lift = mid + 1;
			} else if (p < arr[mid]) {
				right = mid - 1;
			}

		}

	}

	public StringBuilder test2(int arr[], int p) {

		int lift = 0;
		int right = arr.length - 1;
		int mid;
		StringBuilder success = new StringBuilder("数组中存在这个数，这个数是：");
		StringBuilder error = new StringBuilder("数组中不存在这个数");

		while (lift <= right) {
			mid = (lift + right) / 2;
			if (p == arr[mid]) {
				success.append(arr[mid]);
				return success;
			} else if (p > arr[mid]) {
				lift = mid + 1;
			} else if (p < arr[mid]) {
				right = mid - 1;
			}

		}
		return error;
	}

	/**
	 * @Description:3-9练习二分算法
	 * @return void 返回类型
	 */
	@Test
	public int test3(int arr[], int p) {
		int low = 0;
		int hight = arr.length - 1;

		while (low < hight) {
			int mid = (low + hight) / 2;
			if (p == arr[mid]) {
				return 1;
			} else if (p < arr[mid]) {
				hight = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}


}
