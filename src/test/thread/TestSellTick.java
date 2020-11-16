package src.test.thread;

public class TestSellTick implements Runnable {

	private Ticket tickets;

	public TestSellTick(Ticket tickets) {
		super();
		this.tickets = tickets;
	}

	public static void main(String[] args) {
		Ticket ticket = new Ticket();
//只能new一个对象 ，我这里new三个，就是另一种写法，跟SellTick3截然不同
		TestSellTick sellTick1 = new TestSellTick(ticket);
		TestSellTick sellTick2 = new TestSellTick(ticket);
		TestSellTick sellTick3 = new TestSellTick(ticket);
		Thread t1 = new Thread(sellTick1);
		Thread t2 = new Thread(sellTick2);
		Thread t3 = new Thread(sellTick3);
		t1.setName("售票员1");
		t2.setName("售票员2");
		t3.setName("售票员3");
		t1.start();
		t2.start();
		t3.start();

	}

	@Override
	public void run() {
		while (tickets.count > 0) {
			synchronized (tickets) {
				// 这个很重要，必须使用一个锁， // 进去的人会把钥匙拿在手上，出来后才把钥匙拿让出来
				if (tickets.count > 0) {
					System.out.println(Thread.currentThread().getName() + "卖出了第" + tickets.count + "张票");
					tickets.count--;
					// sleep(1000);如果sleep放在這裏面,线程不会释放锁。其他线程没有执行机会，所以sleep必须放在synchronized 关键字外面
				} else {
					System.out.println("票卖完了");
				}

			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}

class Ticket {

	static int count = 20;

}
