package cn.tang.web1.suanfa;

import java.util.Arrays;

import org.junit.Test;
/*
 *
 * 时间复杂度为log2N。由于辅助空间是常数级别的所以：
空间复杂度是O(1);
 */

public class TestTwoPointsSearch {

	@Test
	public void test() {
		/*
		 * 联系二分查找以及冒泡排序
		 */
		int[] arr = { 9, 8, 6, 4, 9, 8, 7, 2, 2, 3, 4, 1, 0, 6, 5 };
		int[] arr2 = { 9, 8, 7, 6, 5 };
		// Arrays.sort(arr);//别人提供的排序方法
		// 我们使用冒泡排序手动排序
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		//排序后就可以二分了
		int temp=8;
		int left=0;
		int right=arr.length-1;
		while(left<right) {
			int mid=(left+right)/2;
			if(temp<arr[mid]) {
				right=mid-1;
			}else if (temp>arr[mid]) {
				left=mid+1;
			}else {
				System.out.println("存在目標數字：" +temp + "---这个数字数组下表为：" + mid + "---值为:" + arr[mid]);
				return;// break指的是跳出whlie循环，return，是后面代码都不执行了
			}

		}







	}
}
