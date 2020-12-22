package com.springboottemplate.thread;

/**
 * @Description:题目一：子线程循环2次，主线程循环2次，然后子线程循环2次，主线程循环2次，这样循环10次； 由於是每次四次，所以控制臺一共打印40次
 * @author: 唐涛
 * @date: 2019年3月17日 下午9:41:44
 *
 */
public class LoopOut implements Runnable {
	public static void main(String[] args) {
		LoopOut loopOut1 = new LoopOut();//我们是通过接口实现的，所以只new一个实例

		Thread t1 = new Thread(loopOut1);
		Thread t2 = new Thread(loopOut1);
		t1.start();
	t2.start();

	}

	private boolean flag = true;// 代表是否等待
	static int count = 0;

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			//爲什麽是i=5
			//因为啊，每次循环都是打印4次
			count++;

			try {
				mainRun();
				subRun();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i ==5) {
				System.out.println(count);
			}
		}

	}

	public synchronized void mainRun() throws Exception {
		while (!flag) {// 如果是ture
			this.wait();
		}
		for (int i = 1; i <= 2; i++) {
			System.out.println("我是主线程-----" + i);

		}
		flag = false;// 執行玩后改稱flase
		this.notify();

	}

	public synchronized void subRun() throws Exception {
		while (flag) {//如果是flag
			this.wait();
		}
		for (int i = 1; i <= 2; i++) {
			System.out.println("我zi主线程------------" + i);
		}
		flag = true;// 執行玩后改稱true
		this.notify();

	}

}
