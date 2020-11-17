package cn.tang.web1.jihe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SetTest {
	/*
	 * （1）根据需要选择正确的集合类型。比如，如果指定了大小，我们会选用Array而非ArrayList。如果我们想根据插入顺序遍历一个Map，
	 * 我们需要使用TreeMap。如果我们不想重复，我们应该使用Set。
	 * （2）一些集合类允许指定初始容量，所以如果我们能够估计到存储元素的数量，我们可以使用它，就避免了重新哈希或大小调整。
	 * （3）基于接口编程，而非基于实现编程，它允许我们后来轻易地改变实现。 （4）总是使用类型安全的泛型，避免在运行时出现ClassCastException。
	 * （5）使用JDK提供的不可变类作为Map的key，可以避免自己实现hashCode()和equals()。
	 * （6）尽可能使用Collections工具类，或者获取只读、同步或空的集合，而非编写自己的实现。它将会提供代码重用性，它有着更好的稳定性和可维护性。
	 * ———————————————— 版权声明：本文为CSDN博主「李人」的原创文章，遵循 CC 4.0 BY-SA
	 * 版权协议，转载请附上原文出处链接及本声明。
	 * 原文链接：https://blog.csdn.net/qq_26465035/article/details/103164167
	 *
	 *
	 */

	@Test
	public void test1() {
		Set<String> set = new HashSet<String>();
		set=test2();
		System.out.println(set.size());
		set.add("a");
		set.add("a");
		set.add("a");
		set.add("a");
		// 这个可以得到一个集合的镜像，它的返回结果不可直接被改变，否则会
		Collections.unmodifiableCollection(set);
		set.add("b");
		set.add(null);
		set.add(null);

		System.out.println(set.remove("a"));
		System.out.println(set.size());
		System.out.println(set.contains(""));//false
		System.out.println(set.contains(null));//true

	}


	public Set<String> test2() {
		Set<String> set = new HashSet<String>();
		set.add("1111");
		if ("C".equals(null)) {
			System.out.println("aa");
		}else {
			System.out.println("bb");
		}
		String name=null;
		if(name==null) {
			System.out.println("1111");
		}

		return set;
	}


	@Test
	public void test3() {

		Set<String> set=returnSet();
		System.out.println(set.size());
		System.out.println(set);
		System.out.println(set=set);

	}

	public Set<String>  returnSet(){
		Set<String> set=new HashSet<String>();
		set.add("1");
		set.add("2");
		set.add("3");
		return set;
	}







}
