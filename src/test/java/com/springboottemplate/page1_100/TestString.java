package com.springboottemplate.page1_100;

public class TestString {

	public static void main(String[] args) {

		String money1 = "20";
		int i=Integer.parseInt(money1);
		System.out.println(i);
		String a=String.valueOf(20);
		String text="hello word";
		System.out.println(	text.length());//空格也算一个字节
		System.out.println(text.lastIndexOf("l"));
		System.out.println(text.indexOf("l"));
		System.out.println(text.substring(0,5));
		System.out.println(text.charAt(0));//就去指定位置字符
		System.out.println(text.isEmpty());
		System.out.println(text.toLowerCase());

	}


}
