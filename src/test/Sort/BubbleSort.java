package src.test.Sort;

import java.util.Arrays;

import org.junit.Test;

public class BubbleSort {
	public static void main(String[] args) {

		/*
		 * 定义数组的两种方法 1.int[] arr={1,2,3,4}//引用类型数组不建议使用 2.String[] arr=new String[3];
		 *
		 */
		int[] arr = { 9, 8, 7, 6, 5 };
		for (int i = 0; i <arr.length-1; i++) {//因为到最后，最后一个数5已经变成最大的了，不用再对比了
			//为社么j是0？，因为第数字开始排序，依然要重第一个数字开始，
			for (int j = 0; j < arr.length - i -1; j++) {

				if (arr[j] > arr[j + 1]) {
					System.out.println(arr.length - 1 - i);
					int t = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = t;
					System.out.println(Arrays.toString(arr));

				}
			}
		}

		// 遍历方式2

		/*
		 * for (int i : arr) { System.out.println(i); }
		 */
		// 遍历方式3
		System.out.println("最后结果"+Arrays.toString(arr));

		// 遍歷方式1
		/*
		 * for(int m=0;i<arr.length;m++) { System.out.println(arr[m]); }
		 */
	}
	@Test
	public void test() {
		int[] arr = { 9, 8, 7, 6, 5 };
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp =arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}

			}
		//System.out.println(Arrays.toString(arr));

		}

		for(int m:arr) {
			System.out.println(m);
		}

	}

}
