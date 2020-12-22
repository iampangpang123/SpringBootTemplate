package com.springboottemplate.page1_100;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

public class IO75 {
	/*
	 * 读文件
	 */
	@Test
	public void test1() throws Exception {

		//String path = "F:\\JavaIO\\aaaaaaaa.txt";
		String path = "F:\\JavaIO\\b.txt";
		File file = new File(path);
		FileInputStream fileInputStream = new FileInputStream(file);
		int b = fileInputStream.read();
		while (b != -1) {
			System.out.print((char) b);
			/*
			 * 如果不charb，得到的都是这样的编码数字165 182 165 182 165 180
			 */
			b = fileInputStream.read();

		}
		fileInputStream.close();
	}

	/*
	 * 写文件
	 */


	@Test
	public void test2() throws Exception {

		// 1.创建一个File对象以及要写入的位置
		String path = "F:\\JavaIO\\b.txt";
		File file = new File(path);// 要输出到的文件位置，输出到的文件不存在回自动创建
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		// 3.写入操作
		fileOutputStream.write(new String("i love java").getBytes());// 字符串转成子节数组
		fileOutputStream.close();
	}
	/**
	* @Description:
	* @return void    返回类型
	*/
	@Test
	public void test3() throws Exception {

		String path = "F:\\JavaIO\\aaaaaaaa.txt";
		File file = new File(path);
		FileInputStream fileInputStream = new FileInputStream(file);
		BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);

		int b = fileInputStream.read();
		while (b != -1) {
			System.out.println((char) b);
			/*
			 * 如果不charb，得到的都是这样的编码数字165 182 165 182 165 180
			 */
			b = fileInputStream.read();

		}
		fileInputStream.close();
	}
	/**
	* @Description: 练习读取
	* @return void    返回类型
	 * @throws IOException
	*/
	@Test
	public void test4() throws IOException {
		String path="F:\\\\JavaIO\\\\b.txt";
		File file=new File(path);
		FileInputStream fileInputStream=new FileInputStream(file);
		int b=0;
		while ( b!=-1) {
			b = fileInputStream.read();
			System.out.println((char)b);

		}
	}
}
