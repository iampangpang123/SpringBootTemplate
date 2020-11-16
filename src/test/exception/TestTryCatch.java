package src.test.exception;

import org.junit.Test;

public class TestTryCatch {

	/**
	 **
	 * @Description:看看抛出代码后，代码的执行过程
	 * @param:
	 * @return: void
	 */
	@Test
	public void main() {
		System.out.println(test1());
		System.out.println("得到返回值之后打印BBB");
		try {
			test2();// 主动抛出异常
			System.out.println("CCCCCCCCC");
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("DDDDDDD");
	}

	String test1() {

		try {

			String aa = null;
			aa.charAt(0);// 这里肯定会产生空指针

			System.out.println("空指针之后打印AA");
		} catch (Exception e) {
			// TODO: handle exception
			return "抛出异常返回张三";
		}

		return "不抛出异常返回李四";

	}

	/**
	 **
	 * @Description:测试Throw自己抛出异常代码执行的过程
	 * @param: @return
	 * @return: String
	 */
	String test2() {
		System.out.println("test2抛出异常前：AAAAAAAAAA");
		try {
			throw new NullPointerException();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	String test3() {

		throw new NullPointerException();

	}

	void test4() {

		test3();

		System.out.println("AAAAA");
	}

}
