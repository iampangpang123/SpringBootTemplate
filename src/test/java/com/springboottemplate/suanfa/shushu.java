package com.springboottemplate.suanfa;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class shushu {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("求0-n的所有素数");
		System.out.println("请输入n的值");
		int count = 0;
		int sum = 0;
		int i = scanner.nextInt();
		int j;
		for (i = 2; i < 101; i++) {
			for (j = 2; j < i; j++) {// 假设i是8；那么j最大只能是7
				if (i % j == 0) {
					break;
				}
			}
			if (i == j) {
				count++;
				sum += i;

				System.out.println(j);
			}
		}
		System.out.println("一共" + count + "个素数");
		System.out.println("素数的和为" + sum);

	}

	/*
	 * 求0-100的素数| 素数：只能被1和自身整除
	 */
	@Test
	public void test1() {

		int[] arr = new int[101];// 指的是有100个元素，不是下标
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		int i, j;

		// System.out.println(Arrays.toString(arr));//0-100
		for (i = 2; i < arr.length; i++) {
			for (j = 2; j < arr[i]; j++) {
				if (arr[i] % j == 0) {
					break;
				}
			}
			if (arr[i] == j) {
				System.out.println(arr[i]);
			}

		}

	}

	/**
	 * @Description:也是练习素数 (求0-任意整数的素数;2也是素数)
	 * @return void 返回类型
	 */
	@Test
	public void test2() {
		System.out.println("求0-n所有素素，请输入n的值");
		int m = new Scanner(System.in).nextInt();
		int j;
		int count = 0;
		int sum = 0;

		System.out.println(m);
		for (int i = 2; i <= m; i++) {

			for (j = 2; j <= i; j++) {
				if (i % j == 0) {
					break;
				}
			}
			if (i == j) {
				System.out.println(j);
				count++;
				sum += i;
			}
		}
		System.out.println(sum);
		System.out.println(count);
	}

	@Test
	public void test3() {
		System.out.println("求0-n所有素素，请输入n的值");
		int m = new Scanner(System.in).nextInt();
		int i;
		int j ;
		int count=0;
		for (i = 2; i < m; i++) {

			for (j = 2; j < i; j++) {
				if (i % j == 0) {
					break;
				}
			}
			if (i == j) {
				count+=1;
                 System.out.println(j);
                 System.out.println(count+"个素数");
			}
		}


	}

}
