package src.test.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class CalendarTest {


	public static void main(String[] args) {
		String addDays = addDays("2019-12-31",1);
		System.out.println(addDays);
	}
    /**
     * <p><b>功能描述和使用场景:</b>获取会计年月对应的月报属期起</p>
     * <p><b>实现流程:</b></p>
     *      <br/>
     * @param kjny 会计年月
     * @return String 所属时期起
     */
	@Test
    public void  getSssqQByKjny() {
    	String kjny="202004";
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(kjny.substring(0, 4)), Integer.parseInt(kjny.substring(4, 6)) - 1, 1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(cal.getTime()));

    }

    /**
     * <p><b>功能描述和使用场景:</b>获取会计年月对应的月报属期止</p>
     * <p><b>实现流程:</b></p>
     *      <br/>
     * @param kjny 会计年月
     * @return String 所属时期止
     */
    public static String getSssqZByKjny(String kjny) {
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(kjny.substring(0, 4)), Integer.parseInt(kjny.substring(4, 6)), 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(cal.getTime());
    }
	/**
	 **
	 * @Description:得到上个月份
	 * @param:
	 * @return: void
	 */
	@Test
    public  void getKjny() {
        Calendar rightNow = Calendar.getInstance();
        rightNow.add(Calendar.MONTH, -1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        System.out.println(dateFormat.format(rightNow.getTime()));

    }

	@Test
	public void test() {
		Calendar cale = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String firstday, lastday;
		// 获取上个月的今天

		// 获取第一天
		cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, 0);
		cale.set(Calendar.DAY_OF_MONTH, 1);
		firstday = format.format(cale.getTime());
		// 获取最后一天
		cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, 1);
		cale.set(Calendar.DAY_OF_MONTH, 0);
		lastday = format.format(cale.getTime());
		System.out.println("本月第一天和最后一天分别是 ： " + firstday + " and " + lastday);

	}

	@Test
	public void test1() {
		LocalDate today = LocalDate.now();
		today = today.minusMonths(1);
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM");
		System.out.println(formatters.format(today));

	}

	@Test
	public void test2() {
		// TODO Auto-generated method stub
		String firstDay,lastDay;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		//获取前月的第一天
		Calendar cal_1=Calendar.getInstance();//获取当前日期
		cal_1.add(Calendar.MONTH, -1);
		cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
		firstDay = format.format(cal_1.getTime());
		System.out.println("-----1------firstDay:"+firstDay);
		//获取前月的最后一天
		Calendar cale = Calendar.getInstance();
		cale.set(Calendar.DAY_OF_MONTH,0);//设置为1号,当前日期既为本月第一天
		lastDay = format.format(cale.getTime());
		System.out.println("-----2------lastDay:"+lastDay);

	}


	@Test
	public void test3() {//获取上个月第一天

		String firstDay;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//获取前月的第一天
		Calendar cal_1=Calendar.getInstance();//获取当前日期
		cal_1.add(Calendar.MONTH, -1);
		cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
		firstDay = format.format(cal_1.getTime());
		System.out.println("-----1------firstDay:"+firstDay);
	}


	@Test
	public void test4() {//获取上个月最后一天
		String lastDay;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//获取前月的最后一天
		Calendar cale = Calendar.getInstance();
		cale.set(Calendar.DAY_OF_MONTH,0);//设置为1号,当前日期既为本月第一天
		lastDay = format.format(cale.getTime());
		System.out.println("-----2------lastDay:"+lastDay);
	}


	/**
	 * <p>
	 * <b>功能描述和使用场景:</b>获取N天后日期字符串
	 * </p>
	 * <p>
	 * <b>实现流程:</b>
	 * </p>
	 * <br/>
	 *
	 * @param dateStr
	 *            日期串
	 * @param days
	 *            天数
	 * @return String 增加后的日期
	 */
	public static String addDays(String dateStr, int days) {
		if (days == 0) {
			return dateStr;
		}
		Calendar calendar = Calendar.getInstance();
		String formatter = null;
		if (dateStr.indexOf('-') != -1 && dateStr.length() >= 8) {
			String[] dateTemp = dateStr.split("-");
			calendar.set(Integer.parseInt(dateTemp[0]), Integer.parseInt(dateTemp[1]) - 1,
					Integer.parseInt(dateTemp[2]));
			formatter = "yyyy-MM-dd";
		} else {
			String year = dateStr.substring(0, 4);
			String month = dateStr.substring(4, 6);
			String day = dateStr.substring(6, 8);
			calendar.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day));
			formatter = "yyyyMMdd";
		}
		SimpleDateFormat myFmt = new SimpleDateFormat(formatter);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		String timeStr = myFmt.format(calendar.getTime()).toString();
		return timeStr;
	}
}
