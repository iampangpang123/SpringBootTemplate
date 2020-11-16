package src.test.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class OutTime extends Thread {

	public static void main(String[] args) throws InterruptedException {
		OutTime ot1 = new OutTime();
		Thread t1 = new Thread(ot1);

		while (true) {

			System.out.println(new Date().toLocaleString());// date是日期；DateFormat(日期格式)组

			Thread.sleep(1000); // ot1.sleep(1000);//这样写也可以
		}

	}

	/**
	 * 练习：Calendar:日历
	 *
	 * @Description:打印昨天今天的时刻
	 * @return void 返回类型
	 */
	@Test
	public void test() {
		//　该类被abstract所修饰，说明不能通过new的方式来获得实例，对此，Calendar提供了一个类方法getInstance，以获得此类型的一个通用的对象，
		Calendar cal = Calendar.getInstance();// Calendar是日历\

		cal.add(Calendar.DATE, -1);
		System.out.println(cal.getTime().toLocaleString());

	}

	/**练习：DateFormat:日期格式
	 * @Description:打印昨天今天的时刻
	 * @return void 返回类型
	 */
	@Test
	public void test1() {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		Date date=new Date();
		System.out.println(dateFormat.format(date));

	}

}
