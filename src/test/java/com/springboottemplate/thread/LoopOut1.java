package com.springboottemplate.thread;
/*
 * 这个是一个线程打印A-Z,一个打印1000-1010：同时打印
 */
public class LoopOut1 implements Runnable {
	public static void main(String[] args) throws InterruptedException {
		LoopOut1 loopOut1 = new LoopOut1();
		Thread t1 = new Thread(loopOut1);
		t1.start();
		mainRun();
	}

	@Override
	public void run() {
		try {
			subRun();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static 	void  mainRun() throws InterruptedException {
		for (int i = 1000; i < 1010; i++) {
		//	sleep(1000);//只有继承Thread类才能直接调用sleep方法
			Thread.sleep(1000);
			System.out.println("线程1：" + i);
		}

	}

	void subRun() throws InterruptedException {
		for (int i = 0; i < 26; i++) {
			Thread.sleep(200);
			//System.out.println("线程2：" + (char) (97 + i));//小写
			System.out.println("线程2：" + (char) (65 + i));//大写
		}

	}

}
