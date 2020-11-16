package src.test.jihe;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class ArrayTest {

	private final String SDS_HDZSQY_SRZEMXB = "003.xml";

	@Test
	public void test1() {
//		 if (SDS_HDZSQY_SRZEMXB.indexOf("001.xml") > -1) {
//            System.out.println("1");
//         }
		 System.out.println(SDS_HDZSQY_SRZEMXB.indexOf("005.xml"));
	}

	@Test
	public void test2() {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
//		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
//
//		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//		System.out.println(new SimpleDateFormat("yyyyMMdd").format(new Date()));
//		List list=null;
//		System.out.println(list.size());

		String aa="2012-12-12-11";
		System.out.println(aa.substring(0,10));
		String aaa="";
		System.out.println(aaa.substring(0,10));//java.lang.StringIndexOutOfBoundsException: String index out of range: 10
	}

}
