package com.springboottemplate.Sort;

import java.util.Arrays;

import org.junit.Test;
/*
 *
 * 时间复杂度为log2N。由于辅助空间是常数级别的所以：
空间复杂度是O(1);
 */

public class TestTwoPointsSearch {

	public static void main(String[] args) {

	}

	@Test
	public void test() {
		/*
		 * 联系二分查找以及冒泡排序
		 */
		int[] arr = { 9, 8, 6, 4, 9, 8, 7, 2, 2, 3, 4, 1, 0, 6, 5 };
		int[] arr2 = { 9, 8, 7, 6, 5 };
		// Arrays.sort(arr);//别人提供的排序方法
		// 我们使用冒泡排序手动排序

		for (int i = 0; i < arr.length - 1; i++) {// 第一次排序
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));// [0, 1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8, 8, 9, 9]
		// 上面排序完成，开始二分查找一个元素
		int target = 8;// 查询目标是5
		int left = 0;
		int right = arr.length - 1;
		//int mid = right / 2;//写在这里是错的，因为mid是动的。
		while (left <=right) {
			int mid=(left+right)/2;
			if (arr[mid] == target) {
				System.out.println("存在目標數字：" + target + "---这个数字数组下表为：" + mid + "---值为:" + arr[mid]);
				return;// break指的是跳出whlie循环，return，是后面代码都不执行了
			}else if (target > arr[mid]) {// 如果目标比mid小，说明在左边
				left = mid + 1;

			} else {
				right = mid - 1;
			}

		}
		System.out.println("不存在数字" + target);

	}

}
