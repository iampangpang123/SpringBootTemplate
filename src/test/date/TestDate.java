package src.test.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestDate {


	/**
	 * 判断是否YYYY-MM-DD的日期格式
	 * @param date 手机号
	 * @return boolean true:是  false:否
	 */
	@Test
	public  void isDate() {
		String date="2065-061-06";
		String regex = "((19|20)[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])";
		System.out.println(	Pattern.compile(regex).matcher(date).matches());
	}

	/**
	 **
	 * @Description:字String类型的日期比较大小
	 * @param: @throws ParseException
	 * @return: void
	 */
	@Test
	public void test5()  {
		String str1 = "2019-04-04";
	      str1=str1.replace("-", "").substring(0,6);
		//第一种直接用字符串类的compareTo方法：
		System.out.println(str1+"0101");


	}

	/**
	 **
	 * @Description:字String类型的日期比较大小
	 * @param: @throws ParseException
	 * @return: void
	 */
	@Test
	public void test4()  {
		String str1 = "2019-05-05";
		String str2 = "2019-05-04";
		int a = 1;
		int b = 2;
		System.out.println(a > b);//false
		//第一种直接用字符串类的compareTo方法：
		System.out.println(str1.compareTo(str2));//1


	}

	/**
	 **
	 * @Description:字符串日期转成date
	 * @param: @throws ParseException
	 * @return: void
	 */
	@Test
	public void test() throws ParseException {
		String str = "2019-4-4 13:49:13";
		String format = "yyyy-MM-dd HH:mm:ss";// 日期格式

		Date date = new SimpleDateFormat(format).parse(str);
		System.out.println(date);
	}

	@Test
	public void test1() {
		String a = "1";
		String b = "1";
		System.out.println(a.equals(b));
		System.out.println(a == b);
	}

	@Test
	public void test2() {// 日期转字符串
		/*
		 * SimpleDateFormat sdf = new SimpleDateFormat( "  " );
		 *
		 * String str=sdf.parse(new Date());
		 */

		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(new Date());
		System.out.println(str);

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		String str1 = sdf1.format(new Date());
		System.out.println(str1);


        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String nowDay = sdf2.format(new Date()).substring(5,10);//得到当前时间
        System.out.println(nowDay);

	}

	@Test
	public void test3() {// String 类型日期比较
		String date1 = "20190111";
		String date2 = "20190101";
		System.out.println(date1.compareTo(date2));
		if ((date1.compareTo(date2)) > 0) {
			System.out.println("aaa");
		}

	}

	@Test
	public void test10() {// String 类型日期比较
		String date1 = "2019-01-01";
		String date2 = "2019-01-01";
	  System.out.println(date1.substring(0, 4));

	}
	@Test
	public void test11() {// 日期转字符串
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date d=new Date();
		String str=sdf.format(d);
		System.out.println(str);
	}

}
