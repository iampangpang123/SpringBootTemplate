package cn.tang.web1.thread;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class TestSynnc implements Runnable {
	Timer timer = new Timer();

	@Override
	public void run() {
		timer.add(Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		TestSynnc ts = new TestSynnc();
		Thread t1 = new Thread(ts);
		Thread t2 = new Thread(ts);

		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();

	}

}

class Timer {

	private static int num = 0;

	public void add(String name) {
		synchronized (this) {//this代表synchronized{里面的内容}，里面代码在执行过程中不会被别的线程打断
	//	public synchronized void add(String name){}这样写也行。简单写法，代表这个方法在运行时候不被打断
			num++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			System.out.println(name + "你是第" + num + "使用timer线程的");

		}
	}

}
