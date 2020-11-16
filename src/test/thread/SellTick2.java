package src.test.thread;

public class SellTick2 extends Thread {
	public static void main(String[] args) {
		SellTick2 tick1=new SellTick2("售票員1");
		SellTick2 tick2=new SellTick2("售票員2");
		SellTick2 tick3=new SellTick2("售票員3");
		tick1.start();
		tick2.start();
		tick3.start();
	}

	// 通过构造方法给线程名字赋值
	public SellTick2(String name) {
		super(name);
		// 给线程名字赋值
	}

	// 为了保持票数的一致，票数要静态，因为继承Thread创建线程，需要new 三个Thread类，不是静态的话，每个对象tick都是20，
	//如果实现的是runable接口就没这个问题了，因为实现的是runable接口他们共享的是一个对象
	static int tick = 20;
	// 创建一个静态钥匙
	static Object ob = "aa";// 值是任意的
	// 重写run方法，实现买票操作

	@Override
	public void run() {
		while (tick > 0) {
			synchronized (ob) {
				// 这个很重要，必须使用一个锁， // 进去的人会把钥匙拿在手上，出来后才把钥匙拿让出来
				if (tick > 0) {
					System.out.println(getName() + "卖出了第" + tick + "张票");
					tick--;
					//sleep(1000);如果sleep放在這裏面,线程不会释放锁。其他线程没有执行机会，所以sleep必须放在synchronized 关键字外面
				} else {
					System.out.println("票卖完了");
				}
			}
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
