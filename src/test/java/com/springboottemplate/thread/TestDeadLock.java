package cn.tang.web1.thread;

public class TestDeadLock extends Thread{
	/*
	 * 继承Thread类的实现
	 */
	public static void main(String[] args) {
		TestDeadLock deadLock1=new TestDeadLock();
		TestDeadLock deadLock2=new TestDeadLock();

		deadLock1.setName("线程1");
		deadLock2.setName("-------------线程2");

		deadLock1.start();
		deadLock2.index=2;

		deadLock2.start();

	}

	static Object o1 = new Object();
	static Object o2 = new Object();
	int index=1;


	@Override
	public void run() {

		if (index == 1) {
			synchronized (o1) {
				System.out.println(Thread.currentThread().getName() + "获取到对象object1");
				try {
					Thread.sleep(2000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (o2) {
					System.out.println(Thread.currentThread().getName() + "获取到对象object2");
					System.out.println("*********线程1运行完毕");
				}
			}

		}
		if(index==2) {
			synchronized (o2) {
				System.out.println(Thread.currentThread().getName() + "获取到对象object2");
				try {
					Thread.sleep(2000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (o1) {
					System.out.println(Thread.currentThread().getName() + "获取到对象object1");
					System.out.println("**********线程2运行完毕");
				}
			}

		}

	}

}
