package cn.tang.web1.string;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

import org.junit.Test;

public class StringIsNullTest {

	@Test
	public void test4() {
		// StringBuilder builder=new StringBuilder();
		// builder.append(null);
		String result1 = new HashMap<String, String>().get("1");
		String result2 = new HashMap<String, String>().get("1");
		if (StringUtils.isBlank(result1)) {
			System.out.println("现在resutt1和2都是null");
		}
		String result1_result2 = result1 + result2;
		if (result1_result2.equals("nullnull")) {
			System.out.println("两个空字相加变成【nullnull】");
		}
		String result3 = "a";
		String result3_result1 = result3 + result1;

		if (result3_result1.equals("anull")) {
			System.out.println("一个空字+a相加变成【anull】");
		}

		result3_result1 = result3_result1.replace("null", "").trim();
		System.out.println("替换过null的result3_result1：" + result3_result1);
		// 两个字符串相加出现nullnull的原因时，因为底层调用的时StringBuilder。append（）方法，当参数为空的时候，会添加一个char【】类型的数组，里面存的是null
	}

	@Test
	public void test3() {
		String aa = "101140101|1.0升（含）以下的乘用车";
		String bb = "101140101|1.0升（含）以下的乘用车";
		String[] split = bb.split("\\|");
		System.out.println(split[0]);
		;
		System.out.println(aa.substring(0, 9));
		System.out.println("************************");
		String cc = "A";

		System.out.println(cc.length());
		System.out.println(cc.toLowerCase());
		System.out.println(cc.toUpperCase());
		String result1 = cc.toLowerCase();
		String result2 = new HashMap<String, String>().get("1");
		String result3 = new HashMap<String, String>().get("1");
		System.out.println("result1:" + result1);
		System.out.println("result2:" + result2);

		String result = result1 + result2;
		if (result.equals("anull")) {
			System.out.println("BBBBBBBBBBBB");

		}
		result = "";
		System.out.println("替换空之后:" + result.replace("null", ""));

		if ((result2 + result3).equals("nullnull")) {
			System.out.println("ccccccccccccccc");
		}

	}

	/**
	 **
	 * @Description:判断字符串为空
	 * @param:
	 * @return: void
	 */
	@Test
	public void test1() {
		String aa = null;
		System.out.println("aa".equals(aa));// false
		// System.out.println(aa.equals("aa"));空指针
		if (StringUtils.isEmpty(aa)) {
			System.out.println("aa");
		}
		System.out.println(aa.charAt(0));
		int data[] = new int[3];
		String arr[] = new String[3];

	}

	/**
	 **
	 * @Description:字符串判断
	 * @param:
	 * @return: void
	 */
	@Test
	public void test2() {
		String aa = null;
		String bb = "";
		System.out.println(bb.substring(5));

		/*
		 * aa.equals("")等效于 aa.length()==0
		 *
		 */
		if (aa == null || aa.equals("")) {
			// 只要a是null或者null
			System.out.println("只要a是null或者null");
		}

		System.out.println(aa.length());// 空指针

	}

}
