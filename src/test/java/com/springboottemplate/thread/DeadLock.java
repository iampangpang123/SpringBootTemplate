package cn.tang.web1.thread;

public class DeadLock implements Runnable {
	static Object o1 = new Object();
	static Object o2 = new Object();
	public int flag = 1;//flag不能声明称静态的。他们在源文件中的作用域有差异

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(flag);
		if (flag == 1) {
			synchronized (o1) {// 指的是锁住o1对象
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (o2) {
					System.out.println("线程1执行完毕");
				}
			}

		}
		if (flag == 2) {
			synchronized (o2) {// 指的是锁住o2对象
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (o1) {
					System.out.println("线程2执行完毕");
				}
			}

		}
	}

	public static void main(String[] args) {

		DeadLock deadLock1 = new DeadLock();
		DeadLock deadLock2 = new DeadLock();


		Thread t1 = new Thread(deadLock1);
		Thread t2 = new Thread(deadLock2);
		t1.start();
		deadLock2.flag = 2;
		t2.start();
	}

}
