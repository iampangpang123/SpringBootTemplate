package src.test.suanfa;

import org.junit.Test;

/**
 * @Description：递归。 @author: 唐涛
 * @date: 2019年7月9日 上午9:05:50
 *
 */
public class TestRecursion {
	int t1 = 0;// 用于统计次数

	public static void main(String[] args) {
		TestRecursion recursion = new TestRecursion();
		System.out.println(recursion.test1(9));

	}

	/**
	 **
	 * @Description:爬楼梯的问题，一共n层，每次爬1或者两层，有几种爬法
	 * @param: 注意，这跟动态规划有点类似，因为动态规划、递归、迭代，三者类似，尽量用动态规划，递归太消耗栈空间
	 * @return: void
	 */
	public int test1(int n) {
		// n是楼梯的层数
		int i = 1;
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;

		} else if (n == 2) {
			i++;
			return i;
		} else {
			return test1(n - 1) + test1(n - 2);
		}

	}

	/**
	 **
	 * @Description:斐波那契数列(兔子数列。)刚开始，有1对幼兔，兔子总对数为1； 经过一个月后，幼兔长为小兔，兔子总对数为1；
	 *                                              经过二个月后，幼兔长大为成年兔子，并生出1对幼兔，兔子总对数为2对；
	 *                                              经过三个月后，成年兔子兔子再生出1对幼兔，幼兔长大为小兔，兔子总对数达到3对；
	 *                                              在数学上，斐波纳契数列以如下被以递推的方法定义：F(1)=1，F(2)=1,
	 *                                              F(n)=F(n-1)+F(n-2)（n>=3，n∈N*），
	 * @param: @param n
	 * @param: @return
	 * @return: int
	 */

	public int test2(int n) {
		t1++;

		if (n < 3)

			return 1;

		return test2(n - 1) + test2(n - 2);
	}
}
