package com.springboottemplate.thread;

public class TestThread1 {
	public static void main(String[] args) {
		Runner1 r1 = new Runner1();
		Thread t1 = new Thread(r1);// 同过new thre产生一个线程，把我们的线程类对象R1传进去。

		Runner2 t2 = new Runner2();// 同过new thre产生一个线程，把我们的线程类对象R1传进去。
        t2.start();//因为Runner2是直接继承的Thread类

		t1.start();//线程开始
		t2.start();
		/*
		 * 下面是主方法又是一个线程。当运行时可以发行两个 线程在同时运行。其实在计算机底层还是交替运行的
		 */
		for (int i = 0; i < 1000; i++) {
			System.out.println("main Thread" + i + "-----------");
		}

	}

}

class Runner1 implements Runnable {

	public void run() {

		for (int i = 0; i < 1000; i++) {
			System.out.println("Runner1 thread" + i);
		}
	}

}

class Runner2 extends Thread{

public void run() {

		for(int i=0;i<1000;i++) {
			System.out.println("Runner2 thread"+i);
		}
	}
}
