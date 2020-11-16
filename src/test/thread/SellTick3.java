package src.test.thread;

/**
 * @Description:特点，售票，我只new了这一个SellTick3 sellTick = new
 *                                       SellTick3();类对象，所以说他是共用属性的，可以看跟TestSekkTick截然不同
 * @author: 唐涛
 * @date: 2019年7月13日 上午10:41:13
 *
 */
public class SellTick3 implements Runnable {

	public static void main(String[] args) {
		SellTick3 sellTick3 = new SellTick3();
		Thread t1 = new Thread(sellTick3);
		Thread t2 = new Thread(sellTick3);
		Thread t3 = new Thread(sellTick3);

		t1.setName("售票员1");
		t2.setName("售票员2");
		t3.setName("售票员3");
		t1.start();
		t2.start();
		t3.start();

	}

	Object object = new Object();
	// 必须为成员变量
	 int  count = 20;

	@Override
	public void run() {

		while (count > 0) {

			synchronized (object) {
				if (count > 0) {
					System.out.println(Thread.currentThread().getName() + "卖出了第" + count + "张票");
					count--;
				} else {

					System.out.println("票卖光了");
				}

			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// 提示票卖光了，写在这里的话，会出现3次票卖光了，因为三个线程都是单独的代码，只能放在while里面。这样当小于零的时候，其他的线程不会进去了
		// System.out.println("票卖光了");

	}

}
