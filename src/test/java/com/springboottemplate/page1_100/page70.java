package com.springboottemplate.page1_100;

public class page70 {
	public static void main(String[] args) {
		 char b = 'a';//char类型只能声明一个字符。声明多个会报错
		short s1 = 1;
		s1=(short) (s1+1);//需要强制转化的。因为int+short的运算结果是int类型。int类型赋值给short需要强转，低变量类型赋给高级变量类型无需强转。
		System.out.println(s1);
		s1+=1;//使用+=会自动强转
		System.out.println(s1);
		System.out.println("*********************");
		Integer aa=3;//自动装箱
		int bb=aa;//自动拆箱

	}



}
