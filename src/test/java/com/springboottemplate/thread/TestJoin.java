package com.springboottemplate.thread;

public class TestJoin {
	public static void main(String[] args) {
		MyThread my=new MyThread();
		my.start();

		try {
			my.join();//把这个线程合并到主线程中
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		for(int i=0;i<10;i++) {
			System.out.println("i am 最主线程");
		}

	}

}
class MyThread extends Thread{

	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("i am"+getName());
			 yield();
			try {
				MyThread.sleep(1000);

			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}


	}


}
