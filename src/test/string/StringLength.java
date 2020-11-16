package src.test.string;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class StringLength {
	@Test
	public void test() throws UnsupportedEncodingException {

		String a = "12345678912345678911";
		int num = a.getBytes("utf-8").length;
		System.out.println(num);
		a = "中文";
		System.out.println(a.length());// 长度为2
		System.out.println(a.getBytes("utf-8").length);// 长度为6

	}

	@Test
	public void test1() throws UnsupportedEncodingException {

		String a = "2|财政票据";
		String b = "è´¢æ¿ç¥¨æ®";
		String substring = a.substring(0, 1);
		System.out.println(b.length());
		b = new String(b.getBytes("ISO-8859-1"), "utf-8");
		System.out.println(b);
	}

	@Test
	public void test2() throws UnsupportedEncodingException {
		double a = 0.0;
		double b = Double.valueOf(a);
		System.out.println(b);
	}

	@Test
	public void test3() throws UnsupportedEncodingException {
		String a = "0.98,0.96,0.97";
		String[] split = a.split(",");
		Arrays.sort(split);
		for (String string : split) {
			System.out.println(string.toString());
		}
		//System.out.println(split[0]);

		String b = "0.98";
		String[] splitB = b.split(",");
		for (String string : splitB) {
			System.out.println(string.toString());
		}
		System.out.println(splitB.length);
	}
	@Test
	public void test4() throws UnsupportedEncodingException {
        List<Map<String, String>> listMap=new ArrayList<Map<String,String>>();
        System.out.println(listMap.size());//0
        System.out.println(listMap.isEmpty());//true
        if(listMap.isEmpty()) {
        	System.out.println("0000");//0000
        }
        listMap.add(new HashMap<String, String>());
        Map<String, String> map = listMap.get(0);
        System.out.println(listMap.size());//1


        String sssqq="2019-07-01";
		String newSssqq = sssqq.replace("-", "");
		System.out.println(newSssqq);
		if (newSssqq.compareTo("20190701") >= 0 && newSssqq.compareTo("20241231") <= 0) {
		System.out.println(1);
		}


	}
}
