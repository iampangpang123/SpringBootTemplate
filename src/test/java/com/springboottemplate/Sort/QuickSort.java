package cn.tang.web1.Sort;

import java.util.Arrays;

import org.junit.Test;

public class QuickSort {

	public static void main(String[] args) {

		/*
		 * 定义数组的两种方法 1.int[] arr={1,2,3,4}//引用类型数组不建议使用 2.String[] arr=new String[3];
		 *
		 */

		int[] arr = { 4,6,3, 8, 7, 6, 5 };
		int left = 0;
		int right = arr.length - 1;
		int base = arr[0];
		int base1 = arr[0];

		if (left != right) {
			for (int i = right; i >= 0; i--) {
				if (arr[i] < base) {
					arr[left] = arr[i];
					right = i;
				}
			}
			for (int i = left; i <arr.length; i++) {
				if (arr[i] > base) {
					arr[right] = arr[i];
					left = i;
				}
			}

		}
		//arr[0]=base1;
		System.out.println(Arrays.toString(arr));
	}
	@Test
	public void test() {
		int[] arr = { 4,6,9, 8, 7, 6, 5 };
		for(int i=arr.length-1;i>=0;i--) {
			System.out.println(arr[i]);
		}



	}
}
