package cn.tang.web1.thread;

/**
 * @Description:题目一：子线程循环2次，主线程循环2次，然后子线程循环2次，主线程循环2次，这样循环10次； 由於是每次四次，所以控制臺一共打印40次
 * @author: 唐涛
 * @date: 2019年3月17日 下午9:41:44
 *
 */
public class TestLoopOut extends Thread {
	public static void main(String[] args) throws Exception {
		TestLoopOut t1 = new TestLoopOut();
		TestLoopOut t2 = new TestLoopOut();

		t1.start();
		t2.start();

	}

	static boolean flag = true;

	@Override
	public synchronized void run() {

		try {
			for (int i = 0; i < 50; i++) {
				mainRun();
				subnRun();

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	synchronized void mainRun() throws Exception {

		while (flag == false) {
			this.wait();

		}
		for (int i = 0; i < 2; i++) {
			System.out.println("主线程：---------------" + i);
		}
		flag = false;
		this.notify();

	}

	synchronized void subnRun() throws Exception {
		while (flag == true) {
			this.wait();

		}
		for (int i = 0; i < 2; i++) {
			System.out.println("zi线程：" + i);
		}
		flag = true;
		this.notify();

	}

}
