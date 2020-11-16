package src.test.jihe;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

public class TestSet {

	/**
	 **
	 * @Description:测试hashset添加null对象
	 * @param:
	 * @return: void
	 */
	@Test
	public void test3() {

		Set set = new HashSet();
		set.add(null);
		set.add(null);
		set.add(null);
		System.out.println(set.size());//1(set可以添加多个空对象，但是添加多个，set会自动覆盖)

	}

	/**
	 **
	 * @Description:判断集合是否存在某个元素
	 * @param:
	 * @return: void
	 */
	@Test
	public void test1() {
		Set<String> set = new HashSet<String>();
		set.add("CWBBYSBQC");
		set.add("CWBBLXQC");
		set.add("CWBBZCZEQC");

//		System.out.println(set.contains("CWBBYSBQC")==false);
//		System.out.println(set.contains("CWBBYSC"));

		if (set.contains("CWBBYSBC") || set.contains("CWBBYSBQC") || set.contains("CWBBYSBQC")) {

			System.out.println("true");
		} else {
			System.out.println("false");
		}

	}

	@Test
	public void test2() {

		Set<String> set = new HashSet<String>();
		set.add("CWBBYSBQC");
		set.add("CWBBLXQC");
		set.add("CWBBZCZEQC");

		// 普通for循环不能遍历set，因为是无序的，没有索引
		for (int i = 0; i < set.size(); i++) {
		}
		// 方法1 集合类的通用遍历方式, 从很早的版本就有, 用迭代器迭代
		Iterator it1 = set.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}

		// 方法2 集合类的通用遍历方式, 从很早的版本就有, 用迭代器迭代
		for (Iterator it2 = set.iterator(); it2.hasNext();) {
			System.out.println(it2.next());
		}
		// 方法3 增强型for循环遍历
		for (String value : set) {
			System.out.println(value);

		}

	}
}
