package src.test.jihe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestMap {

    public static void main(String[] args) {

        Map<String, Object> m3 = new HashMap<String, Object>();

        m3.put("a", "abc");

        m3.put("b", "123");

        m3.put("C", "123");
        m3.put("C", "123");
        m3.put("C", "1211212121");

        m3.put("dD", "123");
        System.out.println("**********"+m3);


        Map<String, Object> m4 = new HashMap<String, Object>();

        m4.put("b", "123");

        m4.put("a", "abc");

        m4.put("cDs", "123");

        m4.put("d", "123");
        System.out.println("将m4数据的key全部转换为大写===" + transformUpperCase(m4));

        System.out.println("将m3数据的key全部转换为小写===" + transformLowerCase(m4));



    }





	// 将map值全部转换为大写

	public  static Map<String, Object> transformUpperCase(Map<String, Object> orgMap) {
		Map<String, Object> resultMap = new HashMap<>();
		if (orgMap == null || orgMap.isEmpty()) {
			return resultMap;
		}
		Set<String> keySet = orgMap.keySet();
		for (String key : keySet) {
			String newKey = key.toUpperCase();
//            newKey = newKey.replace("_", "");
			resultMap.put(newKey, orgMap.get(key));
		}
		return resultMap;
	}

	// 将map值全部转换为小写
	public static Map<String, Object> transformLowerCase(Map<String, Object> orgMap) {
		Map<String, Object> resultMap = new HashMap<>();
		if (orgMap == null || orgMap.isEmpty()) {
			return resultMap;
		}
		Set<String> keySet = orgMap.keySet();
		for (String key : keySet) {
			String newKey = key.toLowerCase();
			resultMap.put(newKey, orgMap.get(key));
		}
		return resultMap;
	}

	/**
	 **
	 * @Description:LinkedHashMap 测试是不是有序的 测试结果:,测试了是有序的
	 * @param:
	 * @return: void
	 */
	@Test
	public void test4() {

		LinkedHashMap<String, String> map = new LinkedHashMap();
		map.put("1", "1");
		map.put("2", "2");
		map.put("4", "4");
		map.put("3", "3");
		// 1. entrySet遍历，在键和值都需要时使用（最常用）
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
		}

		HashMap<String, String> map2 = new HashMap();
		map2.put("1", "1");
		map2.put("2", "2");
		map2.put("4", "4");
		map2.put("3", "3");
		// 1. entrySet遍历，在键和值都需要时使用（最常用）
		for (Map.Entry<String, String> entry : map2.entrySet()) {
			System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
		}

	}

	@Test
	public void test() {

		System.out.println(2 << 3);
	}

	@Test
	public void find() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "张三");
		map.put(2, "李四");
		map.put(3, "王五");
		map.put(4, "孙六");
		// 1. entrySet遍历，在键和值都需要时使用（最常用）
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
		}
		// 2. 通过keySet或values来实现遍历,性能略低于第一种方式
		// 遍历map中的键
		for (Integer key : map.keySet()) {
			System.out.println("key = " + key);
		}
		// 遍历map中的值
		for (String value : map.values()) {
			System.out.println("key = " + value);

		}
		// 3. 使用Iterator遍历
		Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, String> entry = it.next();
			System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
		}

		// 4. java8 Lambda
		// java8提供了Lambda表达式支持，语法看起来更简洁，可以同时拿到key和value，
		// 不过，经测试，性能低于entrySet,所以更推荐用entrySet的方式
		System.out.println("lambda表达式测试遍历map");
		map.forEach((key, value) -> {
			System.out.println(key + ":" + value);
		});

	}

	@Test
	public void test1() {
		Map<String, String> map = new HashMap<String, String>();

		map.put("1", "1");
		map.put("2", "1");
		map.put("3", "1");
		map.remove("5");
		String aa = map.get("4");
		System.out.println(aa);
		if ("".equals(aa)) {
			System.out.println("bb");
		}
		/*
		 * if(aa.equals("4")) { System.out.println(aa); }
		 */
		System.out.println("bb");
	}

	@Test
	public void test2() {
		Map<String, String> map = new HashMap<String, String>();
		Map<String, String> map2 = new HashMap<String, String>();
		Object object = new Object();
		map.put("1", "1");
		map.put("2", "1");
		map.put("3", "1");

		map2.remove("1");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
		}
	}

	@Test
	public void test3() {
		Map<String, String> map = new HashMap<String, String>();

		String a = "1";
		String b = "2";
		System.out.println(a + b);
	}
}
