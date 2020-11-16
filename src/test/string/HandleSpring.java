package src.test.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * @Description:操作字符串
 * @author: 唐涛
 * @date: 2020年3月20日 上午9:49:25
 *
 */
public class HandleSpring {

	@Test
	public void test2() {
		List<Map<String, String>> rsList = new ArrayList<Map<String, String>>();
		Map<String, String> createMap = null;
		createMap = new HashMap<String, String>();
		createMap.put("hbjgdm", "123,156");
		rsList.add(createMap);
		createMap = new HashMap<String, String>();
		createMap.put("hbjgdm", "234");
		rsList.add(createMap);
		createMap = new HashMap<String, String>();
		createMap.put("hbjgdm", "234");
		rsList.add(createMap);
		createMap = new HashMap<String, String>();
		createMap.put("hbjgdm", "345");
		rsList.add(createMap);
		createMap = new HashMap<String, String>();
		createMap.put("hbjgdm", "456");
		rsList.add(createMap);
		createMap = new HashMap<String, String>();
		createMap.put("hbjgdm", "789");
		rsList.add(createMap);
		System.out.println("*****数据制造完毕*******");

		List<Map<String, String>> returnListMap = new ArrayList<Map<String, String>>();
		Set<String> set = new HashSet<String>();
		Map<String, String> tempMap = null;
		for (Map<String, String> map : rsList) {
			String[] split = map.get("hbjgdm").split(",");
			for (int i = 0; i < split.length; i++) {
				String hbjgdm = split[i];
				if (!set.contains(hbjgdm)) {
					tempMap = new HashMap<String, String>();
					tempMap.put(hbjgdm, "AAA");
					returnListMap.add(tempMap);
					set.add(hbjgdm);
				} else {
					System.out.println(hbjgdm + "：已经存在，被过滤");

				}

			}
		}
		System.out.println("处理完毕");

		for (Map temp : returnListMap) {
			System.out.println(temp.toString());
		}
	}

	@Test
	public void test1() {

		String a = "510600000";
		String b = "510600000,510600000";
		String[] splitA = a.split(",");
		String[] splitB = b.split(",");
		System.out.println(splitA.length);
		System.out.println(splitB.length);
		System.out.println("----------------");
		for (int i = 0; i < splitA.length; i++) {
			String string = splitB[i];
			System.out.println(string);
		}

		for (int i = 0; i < splitB.length; i++) {
			String string = splitB[i];
			System.out.println(string);
		}

	}
}
