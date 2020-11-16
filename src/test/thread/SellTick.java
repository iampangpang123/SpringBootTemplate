package src.test.thread;

/**
 * @Description:
 * @author: 唐涛
 * @date:   2020年3月12日 下午7:49:59
 *
 */
//多个线程行为一致共同操作一个数据 ，卖票是典型的多个线程行为一致共同操作一个数据
public class SellTick implements Runnable {

	public static void main(String[] args) throws InterruptedException {

		SellTick sellTick1 = new SellTick();
		/*
		 * SellTick sellTick2 = new SellTick(); SellTick sellTick3 = new SellTick();
		 */
		Thread t1 = new Thread(sellTick1);
		Thread t2 = new Thread(sellTick1);
		Thread t3 = new Thread(sellTick1);
		t1.setName("售票員票1");
		t2.setName("售票員票2");
		t3.setName("售票員票3");
		t1.start();
		t2.start();
		t3.start();
	}


	 int tick = 20;
	Object ob = new Object();



	/*
	 * 要注意的最重要的一点就是，因为是多线程，你要考虑到每个线程跑的都是单独的代码， 只要跑自己单独的代码的时候，需要判断object对象有没有被别人占用而已
	 *
	 * 如果你没考虑到上面我说的，你就会发现，你提示票买完的时候会打印三次
	 */
	@Override
	public void run() {
		while (tick > 0) {
			//synchronized (ob) {
				// 这个很重要，必须使用一个锁， // 进去的人会把钥匙拿在手上，出来后才把钥匙拿让出来
				if (tick > 0) {
					System.out.println(Thread.currentThread().getName() + "卖出了第" + tick + "张票");
					tick--;
					//sleep(1000);如果sleep放在這裏面,线程不会释放锁。其他线程没有执行机会，所以sleep必须放在synchronized 关键字外面
				} else {
					System.out.println("票卖完了");
				}

		//	}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
}
}
