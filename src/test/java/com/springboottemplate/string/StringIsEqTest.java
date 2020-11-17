package cn.tang.web1.string;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.regex.Pattern;

public class StringIsEqTest {
	String RESURT_GS_SWJGDM = "16201000000,16201050000,16202000000,16203000000,16204000000,16205000000,16221000000,16222000000,16223000000,16224000000,16226000000,16227000000,16228000000,16229000000,16230000000,16295000000,16298000000";

	@Test
	public void test10() {
		//保留两位小数
		String aa=null;
		System.out.println(aa);

	}

	@Test
	public void test9() {
        //保留两位小数
		String aa="2020";
		String regex = "^\\d+(.\\d{1,2})?$";
		System.out.println(Pattern.compile(aa).matcher(regex).matches());
        //日期格式问题
		String date="2020-15-05";
		String regex1 = "((19|20)[0-9]{2})-(0[1-9]|1[012])";
		System.out.println(Pattern.compile(regex1).matcher(date).matches()); ;
	}


	@Test
	public void test8() {
		String jyclhdzk = "中国_502";
		String[] arr=jyclhdzk.split("_");
		System.out.println(arr[0]);
		String aa="020199_原材料-其他";
		aa = aa.replaceAll("[^(\\d+(,\\d+)*)]", "");
		System.out.println(aa);
		String bb="020200_半成品,020402_固定资产-机械机器设备";
		bb = bb.replaceAll("[^(\\d+(,\\d+)*)]", "");
		System.out.println(bb);
		String cc="020200_半成品,020402_固定资产-机械机器设备,020401_固定资产-房屋及建筑物,020101_原材料-来料加工";
		cc = cc.replaceAll("[^(\\d+(,\\d+)*)]", "");
		System.out.println(cc);


	}

	/*
	测试org.apache.commons.lang3.StringUtils
	 */
	@Test
	public void test7() {
		String jyclhdzk = "101140101;101140102;101140103;101140104;101140105;101140106;101140107;101140211;101140212;101140400";
		String YHS_SBZLDMS = "10114";
		System.out.println(jyclhdzk.contains(YHS_SBZLDMS));//true
		System.out.println(jyclhdzk.contains(""));

	}



	@Test
	public void test5() {
		String jyclhdzk = "101140101;101140102;101140103;101140104;101140105;101140106;101140107;101140211;101140212;101140400";
		String YHS_SBZLDMS = "21101";
		System.out.println(jyclhdzk.indexOf("101140102"));//10
		System.out.println(jyclhdzk.indexOf("101140104"));//30
		System.out.println(jyclhdzk.indexOf(101140104));//-1
		System.out.println(jyclhdzk.indexOf("10114010000"));//-1
		System.out.println("第5行：“核定载客”不能为空，且整数，且数值>0，请核实。");
		System.out.println(StringUtils.contains(YHS_SBZLDMS,"21101"));
	}


	/**
	 **
	 * @Description:测试string 的equalsIgnoreCase、toUpperCase、substring
	 * @param:
	 * @return: void
	 */
	@Test
	public void test6() {

	String aa="ABC1234";
	System.out.println(aa.equalsIgnoreCase("abc1234"));//true
	System.out.println("abc1234".toUpperCase());//ABC1234
	String bb="1234";
	System.out.println(bb.equalsIgnoreCase("1234"));//true
	System.out.println(aa.substring(0,4));//ABC1
	}


	/**
	 **
	 * @Description:比较字符串大小
	 * @param:
	 * @return: void
	 */
	@Test
	public void test4() {

		String sssqz = "2020-04-01";

		if ("2020-03-31".compareTo(sssqz) < 0) {
			System.out.println("aaaaaaa");
		} else {
			System.out.println("bbbbbbbb");
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
		String aa = "bb";
		String bb = "bb";
		String cc = new String("bb");

		System.out.println(aa == bb);// true
		System.out.println(aa.equals(bb));// true
		System.out.println(aa == cc);// false
		throw new ClassCastException();
		// System.out.println("aaaaaaaaaaaa");抛异常后后面代码(不止是这个方法得代码不执行，调用他的方法后面代码也不执行了)不用执行了。所以写了也报错

	}

	@Test
	public void test2() {
		String aa = "bb";
		test1();
		System.out.println("aaaaaaaaaaaaa");
	}

	@Test
	public void test22() {
		test2();
		System.out.println("test22");
	}

	/**
	 **
	 * 抛异常,前提（异常被捕获） 1.如果发生异常try()里面剩下的代码不会在执行，try外面的代码会执行 2.
	 *
	 *
	 *
	 */
	@Test
	public void test3() {
		String aa = null;
		int count = 1;
		for (int i = 0; i < 10; i++) {
			System.out.println(count);
			count++;
			try {
				aa.chars();
				System.out.println("aaaaaaaaa");
			} catch (Exception e) {
				System.out.println("抛异常");
				// continue;
			}
			System.out.println("bbbbbbb");
		}
		System.out.println("cccccc");
	}

}
