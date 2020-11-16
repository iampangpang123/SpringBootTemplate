package src.test.thread;
/*
 * 编写10个线程，第一个线程从1加到10，第二个线程从11加到20.....第十个线程从91加到100，最后再把10个线程结果相加。
 */
public class ThreeThreadSum extends Thread {
	int number;
	public static int sum;
	public ThreeThreadSum(int n) //构造函数
	{
		number=n;
	}
	public static synchronized void add(int num){  //同步方法
		sum += num;
		}
	public void run()
	{
		int count=0;
		for(int i=0;i<10;i++)
		{
			count+=number+i;
		}
		System.out.println("第"+((int)number/10+1)+"个进程相加结果为："+count);
		add(count);
//		System.out.println("Sum is : " + sum);//测试
	}
	public static void main(String[] args)throws Exception
	{
		for(int i=0;i<10;i++)
		{
			int j=i*10+1;
			ThreeThreadSum a=new ThreeThreadSum(j);
			a.start();
			a.join(); //thread.Join把指定的线程加入到当前线程，可以将交替执行的线程合并为顺序执行的线程。
		}
		System.out.println("10个进程相加结果为： " + sum);


}
}
