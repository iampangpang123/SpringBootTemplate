package cn.tang.web1.Sort;

import java.util.Arrays;

import org.junit.Test;

public class InsertionSort {
	public static void main(String[] args) {

		int[] arr = { 8, 7, 9, 5, 6, 4 };

		for (int i = 1; i < arr.length; i++) {// 从第二个数开始循环，跟第一个数字进行比较
			int temp = arr[i];// 记录要插的数据.......temp是要插入的数据
			System.out.println("要插入数字"+temp);
			int j = 0;//只是个声明，因为要是生命在for语句中，成为局部变量了。下面这个语句arr[j + 1] = temp；无法执行
			for (j = i - 1; j >= 0; j--) {//从有往左边比较，一直找到比他小的停止
				if (arr[j] > temp) {//如果左边的比要插入的大，要插入的数字覆盖左边的值
					System.out.println("j="+j);
					arr[j + 1] = arr[j];
				} else {
				 	break;
				}
			}
			arr[j + 1] = temp;// 交换
			System.out.println("交换后"+Arrays.toString(arr));
		}

		System.out.println(Arrays.toString(arr));

		/*
		 * 方法二
		 */

	}


}
