package src.test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

/*
 * 先test数据库user2数据表随机写入uer数据
 */
public class MysqlUser2 {
	public MysqlUser2() {
		// TODO Auto-generated constructor stub
	}

	static Connection connection = null;

	static PreparedStatement preparedStatement = null;
	{
		connection = JdbcUtil.getConnection();
	}

	@Test
	public void test1() {

		try {

			for (int i = 0; i < 97; i++) {
				String sql = "insert into user2(username,address,sex,no1,no2) values(?,?,?,?,?)";
				preparedStatement = connection.prepareStatement(sql);
				User2 user = new User2(test2(), "null", test3(), test4(), test4());
				preparedStatement.setString(1, user.getUsername());
				preparedStatement.setString(2, user.getAddrss());
				preparedStatement.setString(3, user.sex);
				preparedStatement.setInt(4, user.getNo1());
				preparedStatement.setInt(5, user.getNo2());
				preparedStatement.executeUpdate();

			}

		} catch (Exception e) {
			System.out.println("添加失败");
			e.printStackTrace();
		} finally {
			JdbcUtil.free(null, preparedStatement, connection);
		}
	}

	public static String test2() {// 生成随机的姓名
		int random1 = (int) (Math.random() * 10);
		int random2 = (int) (Math.random() * 30);
		int random3 = (int) (Math.random() * 30);
		String str = "赵钱孙李周吴朱何唐张";
		String str1 = "康大家爱上了见到老师交流发电机傻大姐啊实打实你觉得的骄傲手机打开拉萨的撒大苏打";
		char cname1 = str.charAt(random1);
		String sname1 = String.valueOf(cname1);

		char cname2 = str1.charAt(random2);
		String sname2 = String.valueOf(cname2);

		char cname3 = str1.charAt(random3);
		String sname3 = String.valueOf(cname3);

		return sname1 + sname2 + sname3;

	}

	public static String test3() {// 生成姓别
		String sex = null;
		for (int i = 0; i < 50; i++) {
			int random = (int) (Math.random() * 10);
			String str = "男女";

			if (random > 5) {// 大于5就是男
				sex = String.valueOf(str.charAt(0));
			} else {
				sex = String.valueOf(str.charAt(1));
			}
		}
		return sex;
	}

	/**
	 * @return 年龄
	 */
	public static int test4() {// 随机返回0-100的数字。这个方法是多此一举
		// int random=(int)(Math.random()*100);这个就是随机返回0-100的数字了
		int[] arr = new int[100];
		for (int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}
		int random = (int) (Math.random() * 100);
		return arr[random];

	}
}
