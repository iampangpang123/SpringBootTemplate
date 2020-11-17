package cn.tang.web1.thread;

/*
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品
 * ，店员会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；
 * 如果店中没有产品了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 */
public class TestProduct {
	public static void main(String[] args){

		Clerk01 clerk01=new Clerk01();
		Productor01 pro=new Productor01(clerk01);
		Consumer01 cos=new Consumer01(clerk01);
		pro.start();
		cos.start();
	}

}

class Clerk01 {
	static int count = 10;

	public synchronized void add() throws Exception {

		if (count >=20) {
			System.out.println("---------剩余商品超过20，稍后生产");
			wait();
			notify();
		} else {
			count++;
			System.out.println("生成了第" + count + "个商品" );
			notify();
		}
	}

	public synchronized void remove() throws Exception {
		if (count <= 0) {
			wait();
			System.out.println("---------商品不足");
			notify();
		} else {

			System.out.println("顾客取走了第" + count + "个商品");
			count--;
			notify();
		}
	}
}

class Productor01 extends Thread {
	Clerk01 clerk01 = null;

	public Productor01(Clerk01 clerk01) {
		this.clerk01 = clerk01;
	}

	@Override
	public void run() {
		System.out.println("開始生產");
		while (true) {
			try {
				sleep((int) (Math.random() * 1000));
				clerk01.add();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Consumer01 extends Thread {
	Clerk01 clerk01 = null;

	public Consumer01(Clerk01 clerk01) {
		this.clerk01 = clerk01;
	}

	@Override
	public void run() {
		System.out.println("開始消费");
		while (true) {
			try {
				sleep((int) (Math.random() * 2000));
				clerk01.remove();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
