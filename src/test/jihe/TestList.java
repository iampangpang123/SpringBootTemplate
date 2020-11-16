package src.test.jihe;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import cn.tang.web1.mysql.User2;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import cn.tang.web1.page1_100.jicheng.Person;

/*
 * list 是有序的，可以重复的
 *     ：有序是指的放入元素的顺序是有序的：比如放：1  5 6 7 9 8，打印出来还是 1  5 6 7 9 8
 *     ：不是指：里面数字大小是有序的。
 *
 *set:也是一样，指的是放入元素的顺序
 *
 *
 *
 */
public class TestList {



	@Test
	public void test12() {
		List<User2> list = new ArrayList<>();

			User2 user2=new User2();
			user2.setUsername("111111");
			list.add(user2);
		user2.setUsername("22222");
		System.out.println(list.toString());

	}

	@Test
	public void test13() throws InvocationTargetException, IllegalAccessException {
		List<User2> list = new ArrayList<>();

		User2 user1=new User2();
		user1.setUsername("111111");
		User2 temp=new User2();
		temp.setUsername("111");
		BeanUtils.copyProperties(temp,user1);
		list.add(temp);
		User2 user2=new User2();
		user2.setUsername("22222");
		temp=new User2();
		temp.setUsername("222");
		BeanUtils.copyProperties(temp,user2);
		list.add(temp);


		System.out.println(list.toString());

	}

	@Test
	public void test11() {
		List<User2> list = new ArrayList<>();

		for(int i=0;i<=10;i++){
			User2 user2=new User2();
			user2.setUsername("111111");
			list.add(user2);
			user2.setUsername("2222");
        }
		System.out.println(list.size());

		System.out.println(list.toString());

	}


	@Test
	public void test10() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(4);
		list.add(5);
		list.add(3);
		int count = 0;
		for (Integer integer : list) {
			if (!list.contains(65455)) {
				count++;
			}
		}
		System.out.println(list.size());
		System.out.println(count);
	}

	/**
	 **
	 * @Description:增强for遍历空集合会不会报错
	 *
	 * 								综上所述：普通for。增强for遍历空集合都不会报错
	 */
	@Test
	public void test9() {

		List list = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
		}
		System.out.println("普通for循环遍历空集合不会报错");
		for (Object object : list) {
			System.out.println(object);
		}

		System.out.println("增强for循环遍历空集合不会报错");
		List list2 = null;

		for (int i = 0; i < list.size(); i++) {
			System.out.println(i);
		}
		System.out.println("普通for循环遍历null集合不会报错");
		for (Object object : list) {
			System.out.println(object);
		}
		System.out.println("增强for循环遍历null集合不会报错");

	}

	/**
	 * 测试结果：ArrayList.add()方法添加一个为null的对象不会产生空指针。而且list长度也会增加。
	 * 但是，为了防止产生问题，尽量不要添加空对象，先对对象做null判断
	 *
	 * @Description:测试空集合的空指针问题
	 * @param:
	 * @return: void
	 */
	@Test
	public void test8() {

		List list = new ArrayList();
		List list1 = new ArrayList();
		list.add("张三");
		list.add("12");
		list.add("男");
		list = null;
		/*
		 * 集合是nulL,会报空指针下面这行代码 for (int i = 0; i < list.size(); i++) {
		 * System.out.println(list.get(i)); }
		 */
		// 下面也报空指针
		// list.get(0);
		// 下面不会报空指针
		list1.add(list);
		Person p = null;
		// 下面也不会报null异常
		list1.add(p);
		System.out.println("**************");
		List list2 = new ArrayList();
		list2.add(null);
		list2.add(null);
		list2.add(null);
		System.out.println(list2.size());
		System.out.println(list2.isEmpty());
		System.out.println(CollectionUtils.isEmpty(list2));
		System.out.println(list2.contains(null));
	}

	/**
	 **
	 * @Description:此集合可以用来实现，手写连接池，线程池
	 * @param:
	 * @return: void
	 */
	@Test
	public void test7() {
		LinkedList<String> list = new LinkedList<String>();
		list.add("aa");
		list.add("aa");

		list.add("aa");
		list.add("aa");
		list.removeFirst();

	}

	@Test
	public void test1() {
		List list = new ArrayList();
		list.add("张三");
		list.add("12");
		list.add("男");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		for (Object object : list) {
			System.out.println(object.toString());
			;
		}
	}

	@Test
	public void test2() {
		List list = new ArrayList();
		list.add("张三");
		list.add("12");
		list.add("男");
		System.out.println(list.get(0));// 张三
		System.out.println(list.indexOf("12"));
		;// 1
		System.out.println("****************");
		list.set(0, "lisi");
		list.add(6, "wanwu");
		for (Object object : list) {
			System.out.println(object);
		}
	}

	/**
	 **
	 * @Description:如何遍历集合
	 * @param:
	 * @return: void
	 */
	@Test
	public void test() {
		List list = new ArrayList<>();
		Person person = new Person();
		// Collection<> collection=new LinkedList<>();
		list.add("aaa");
		list.add("bb");
		list.add("123");
		list.add(person);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		list.remove(0);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		for (Object object : list) {

		}
	}

	/**
	 ** 如何获取集合中的某个值
	 *
	 * @Description:
	 * @param:
	 * @return: void
	 */
	@Test
	public void test3() {
		List<String> list = new ArrayList<String>();
		list.add("张三");
		list.add("李四");
		list.add("王五");
		System.out.println(list.toString());

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("张三")) {
				System.out.println(i);
			}
		}
	}

	// 排序
	@Test
	public void test4() {
		List<User> list = new ArrayList<User>();
		User u1 = new User((Integer) 1, "1+1", "小明", (Integer) 0, "123456");
		User u2 = new User((Integer) 2, "1+2", "小红", (Integer) 1, "123456");
		User u3 = new User((Integer) 3, "1+3", "小转", (Integer) 0, "123456");
		User u4 = new User((Integer) 4, "1+4", "小黑", (Integer) 1, "654321");
		User u5 = new User((Integer) 5, "1+5", "小兵", (Integer) 0, "666666");
		User u6 = new User((Integer) 6, "1+6", "小太阳", (Integer) 1, "888888");
		list.add(u1);
		list.add(u5);
		list.add(u4);
		list.add(u3);
		list.add(u6);
		list.add(u2);
		System.out.println(list.toString());// [id:1,userName:小明, id:5,userName:小兵, id:4,userName:小黑, id:3,userName:小转,
											// id:6,userName:小太阳, id:2,userName:小红]
		// 因为user的tostring我只写了两个
		// 排序
		list.sort(new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				// 这里是根据ID来排序，所以它为空的要剔除掉
				if (o1.getId() == null || o2.getId() == null)
					return 0;
				return o1.getId().compareTo(o2.getId());// 这正序;
			//	return o2.getId().compareTo(o1.getId());// 这是倒序;
			}

		});
		System.out.println("下面是排好序的樣子");
		System.out.println(list);
	}

	@Test
	public void test5() {
		List<String> list1 = new ArrayList<String>();

		List<String> list2 = new ArrayList<String>();

		list1 = null;
		list2 = null;

		System.out.println("aaaa");

	}

}
