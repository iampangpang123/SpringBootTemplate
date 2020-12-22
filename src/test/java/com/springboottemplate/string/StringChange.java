//package com.springboottemplate.string;
//
//import java.io.UnsupportedEncodingException;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import org.apache.commons.lang3.StringUtils;
//import org.junit.Test;
//
//import cn.tang.web1.jihe.User;
//
//public class StringChange {
//
//	@Test
//	public void test1() {
//		double a = 0.00;
//		double b = 0.0;
//		double c = 0;
//		System.out.println(b == 0);
//		System.out.println(a == 0);
//
//		System.out.println(Double.valueOf(a));
//		test2(c);
//	}
//
//	public void test2(double c) {
//
//	}
//
//	@Test
//	public void test3() {
//		// double valueOf = Double.valueOf("");
//		// System.out.println(valueOf);
//		// System.out.println(Double.valueOf(""));
//		System.out.println(Double.valueOf("0"));
//		System.out.println(Double.valueOf("0.00"));
//
//		Map<String, String> map = new HashMap<String, String>();
//		System.out.println(map.get("aa"));
//
//		int a = 1;
//		double aa = 1.0;
//		double b = 0.9;
//		double c = a - b;
//		System.out.println(a - b);
//		System.out.println(aa - b);
//		System.out.println(aa * 0.9);
//	}
//
//	@Test
//	public void test4() {
//		// double valueOf = Double.valueOf("");
//		// System.out.println(valueOf);
//		// System.out.println(Double.valueOf(""));.
//		Map<String, String> map = new HashMap<String, String>();
//		String valueOf = String.valueOf(map.get("map"));
//		System.out.println(valueOf);
//	}
//
//	/**
//	 **
//	 * @Description:String 常用得方法
//	 * @param:
//	 * @return: void
//	 * @throws UnsupportedEncodingException
//	 */
//	@Test
//	public void test5() throws UnsupportedEncodingException {
//		String name = "tangtao";
//		byte[] bytes = name.getBytes("utf-8");// 将字符转换成byte数组
//		System.out.println(Arrays.toString(bytes));// [116, 97, 110, 103, 116, 97, 111]
//		// 编码需要一致不然会出现乱码
//		String valueOf = new String(bytes, "utf-8");// tangtao
//		System.out.println(valueOf);
//	}
//
//	/**
//	 * 是否含有sql注入，返回true表示含有
//	 *
//	 * @param obj
//	 * @return
//	 */
//	@Test
//	public void containsSqlInjection() {
//		String obj = "where passwoed=1 and 1=1";
//		Pattern pattern = Pattern.compile(
//				"\\b(and|exec|insert|select|drop|grant|alter|delete|update|count|chr|mid|master|truncate|char|declare|or)\\b|(\\*|;|\\+|'|%)");
//		Matcher matcher = pattern.matcher(obj.toString());
//
//		System.out.println(matcher.find());
//	}
//
//	/**
//	 **
//	 * @Description:
//	 * @param:
//	 * @return: void
//	 */
//	@Test
//	public void test6() {
//		User user = new User();
//		user.setUserName("5456164");
//
//		String content = "	<hbssbForm>\r" + "			<djxh>String</djxh>\r"
//				+ "			<nsrsbh>aaaaaaaaaaaaaaaaaaaa</nsrsbh>\r"
//				+ "			<nsrmc>aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</nsrmc>\r"
//				+ "			<skssqq>String</skssqq>\r" + "			<skssqz>String</skssqz>\r"
//				+ "			<sbsxDm1>aa</sbsxDm1>\r" + "			<tbrq>String</tbrq>\r"
//				+ "			<yzpzzlDm>aaaaaaaaaa</yzpzzlDm>\r" + "			<sblx>aa</sblx>\r"
//				+ "		</hbssbForm>";
//		System.out.println(content.indexOf("</hbssbForm>"));
//		content = content.replace("</hbssbForm>",
//				"<sbuuid>" + user.getUserName() + "</sbuuid><pzxh>" + user.getUserName() + "</pzxh></hbssbForm>");
//
//		System.out.println(content);
//	}
//
//	@Test
//	public void test7() {
//		String aaa="张三";
//		int bb=123;
//
//		System.out.println(String.valueOf(aaa));
//		System.out.println(String.valueOf(bb));
//		String.valueOf(null);
//
//	}
//
//	@Test
//	public void test8() {
//
//		String aa = "13101004000";
//		aa=StringUtils.reverse(aa);
//		System.out.println(aa);
//		String temp = null;
//		for (int i = 0; i < aa.length(); i++) {
//			temp = String.valueOf(aa.charAt(i));
//			if (temp.equals("0")) {
//               continue;
//			}else {
//				temp = String.valueOf(aa.substring(i));
//				break;
//			}
//		}
//		System.out.println(StringUtils.reverse(temp));
//
//	}
//
//
//	@Test
//	public void test9() {
//		//执业律师
//        String date="ww1234567819";
//		String regex = "^\\d{7}$|^\\d{8}$|^SW\\d{8}$|^RD\\d{1,10}$|^\\d{13}$";
//		System.out.println( Pattern.compile(regex).matcher(date).matches());
//	}
//
//	@Test
//	public void test10() {
//
//
//
//	}
//	@Test
//	public void test11() {
//
//		String aa="2020.2";
//		String regex = "^\\d+(.\\d{1,2})?$";
//		System.out.println(Pattern.compile(regex).matcher(aa).matches());
//
//	}
//
//	@Test
//	public void test12() {
//		StringBuilder build=new StringBuilder();
//		if (build.toString()==null){
//			System.out.println("aaaa");
//		}
//		if (build.toString().equals("")){
//			System.out.println("bb");//bb
//		}
//		String bb="【张三】【123456】、";
//		System.out.println(	bb=bb.substring(0,bb.length()-1));
//
//
//	}
//
//
//
//
//}
