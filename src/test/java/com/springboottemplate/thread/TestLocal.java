package cn.tang.web1.thread;

public class TestLocal implements Runnable {
	/*
	 *
	 * 实现Runnable接口的实现
	 */
	public static void main(String[] args) {
		TestLocal testLocal1 = new TestLocal();
		TestLocal testLocal2 = new TestLocal();
		Thread t1 = new Thread(testLocal1);
		Thread t2 = new Thread(testLocal2);
		t1.setName("线程1");
		t2.setName("-------------线程2");

		t1.start();
		testLocal2.index=2;

		t2.start();

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
