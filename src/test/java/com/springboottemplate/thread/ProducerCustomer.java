package cn.tang.web1.thread;

public class ProducerCustomer {
	public static void main(String[] args) {
		SyncStack ss=new SyncStack();
		Producer p=new Producer(ss);
		Producer p1=new Producer(ss);
		Customer c=new Customer(ss);
		Thread t1=new Thread(p);
		Thread t2=new Thread(p1);
		Thread t3=new Thread(c);
		t1.start();
		t2.start();
		t3.start();
	}

}
class WoTou{
	int id;
	public WoTou(int id) {
		this.id=id;
      }
	public String toString(){
  	  return "窝头："+id;
	}
}
class SyncStack{
	int index=0;
	WoTou[] arrWT=new WoTou[6];

  public synchronized void push(WoTou wt){
	  if(index==arrWT.length){
		 try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	  }
	  this.notify();
	  arrWT[index]=wt;
		index++;
	}
	//??????
   public synchronized	WoTou pop(){
	   while(index==0){
		   try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	   }
	   this.notify();
		index--;
		return arrWT[index];
	}
}
class Producer implements Runnable{
	SyncStack ss=null;
	public Producer(SyncStack ss){
		this.ss=ss;
	}
	public void run() {
		for(int i=0;i<20;i++){
			WoTou wt=new WoTou(i);
			ss.push(wt);
			System.out.println("生产了"+wt);
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
class Customer implements Runnable{
	SyncStack ss=null;
	public Customer(SyncStack ss) {
		this.ss=ss;
	}
	public void run() {
        for(int i=0;i<20;i++){
        	WoTou wt=ss.pop();
        	System.out.println("消费了"+wt);
        	try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
        }
	}
}
