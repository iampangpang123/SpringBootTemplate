package src.test.Sort;

import java.util.Arrays;

import org.junit.Test;

public class Test1 {

	/*
	 * 冒泡排序( 6, 3, 5, 8, 2, 7 )从小到大排序
	 *
	 * 第一步：6 3比较，6大，交换位置 后变为3，6，5，8，2，7
	 *
	 * 第二步：6 5比较,6大，交换位置 后变为3，5，6，8，2，7 第三步；6 8比较，8大，位置不变 第四步：8 2比较，8大，交换位置
	 * 后变为3，5，6，2，8，7 第四步：8 7比较，8大，交换位置后变为3，5，6，2，7，8
	 *
	 * 所以第一回合，就把最大的弄到最后了，说谁哦一第二轮循环，就不用比较最后一个数字了。所以是j < arr.length - i - 1
	 */
	@Test
	public void bubbleSort() {
		int[] arr = { 6, 3, 5, 8, 2, 7 };
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int t = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = t;
					System.out.println(Arrays.toString(arr));
				}
			}
		}
		System.out.println(Arrays.toString(arr));

	}

	/*
	 * 选择排序{ 6, 3, 5, 8, 2, 7 }从小到大过程
	 * 1.第一个数字6与后面的每一个数字进行比较，如果比da就交换顺序。可以看出，2换到前面了，
	 *
	 * 可以看出第一轮就把最小的数字弄到前面来了
	 * 2.此时，i变成了1=8，j成2了=5。；所以就是8与后面的每一个数进行比较，8跟5比，8大，8跟5换位置。
	 * 3.此时，序列成为2，5，8，6，3，7；j变为3=6，所以5在跟6比。小，所以不变化，在跟3比，大，变换 4.重复，就可以把数列排出来
	 * 总结；第一个数与后面每一个数进行比较，第一轮就把最小的弄到第一位了
	 *
	 * 第二次，第二个数与后面每个数进行比较
	 *
	 */
	@Test
	public void xuanZhe() {
		int[] arr = { 6, 3, 5, 8, 2, 7 };
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int t = arr[j];
					arr[j] = arr[i];
					arr[i] = t;
					System.out.println(Arrays.toString(arr));
				}
			}

		}
		System.out.println(Arrays.toString(arr));

	}

	/*
	 * 插入排序
	 */
	@Test
	public void insertionSort(){

		int[] arr = { 6, 3, 5, 8, 2, 7 };

	}
}
