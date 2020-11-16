package src.test.thread;

import java.util.Date;

public class OutTime2 implements Runnable{

	public static void main(String[] args) throws Exception {
		OutTime2 ot=new OutTime2();
		Thread t=new Thread(ot);
		t.start();

	}
	@Override
	public void run() {

			while(true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(new Date().toLocaleString());
			}
	}



}
