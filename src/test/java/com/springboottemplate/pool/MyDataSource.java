package com.springboottemplate.pool;

import com.springboottemplate.mysql.JdbcUtil;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;


/**
 * @Description:
 * @author: 唐涛
 * @date: 2019年12月27日 上午11:28:31 手写连接池，思路如下
 *
 *        1.首先继承DataSource接口，实现getConnection()方法
 *        2.然后，新建成员变量LinkedList<Connection> dataSources，用来存放连接
 *        3.构造器里面初始化n个连接放在LinkedList<Connection> dataSources集合里面
 *        4.下面就是借出连接，别人归还连接
 *        4.1：remove()；调用这个方法表示借出连接，里面集合dataSources.removeFirst()；方法，表示删除链表第一个连接，
 *        4.2：add()：表示归还连接，dataSources。add();表示连接归还。此时，根本不用考虑归还的连接是不是我们借出去的
 *        原因如下：1.首先，我们借出的是Connection类型的，它还给我们的必须是Connnection类型的，不然集合编译的时候会报错
 *        2.还有，我们设计连接池，我们考虑的是核心在于空闲连接数得到最大限度的高可用，而不是，别人还不还我们借出的连接，
 *        ·不管它自己连接时怎么得到的，还给我的时Connectio类型连接就行
 *        缺电：MyDataSource应该设计成单列模式，防止外部直接new此对象
 *
 *
 */
public class MyDataSource implements DataSource {
	// 链表实现栈结构
	private LinkedList<Connection> dataSources = new LinkedList<Connection>();
	private static MyDataSource myDataSource;

	// 无参构造器,初始化连接数量
	private MyDataSource() {
		// 一次性创建10个连接
		for (int i = 0; i < 10; i++) {
			try {
				// 1、获取数据库连接对象
				Connection conn = JdbcUtil.getConnection();
				// 2、将连接加入连接池中
				dataSources.add(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Connection getConnection() throws SQLException {
		// 取出连接池中一个连接
		final Connection conn = dataSources.removeFirst(); // 删除第一个连接返回
		return conn;
	}

	// 将连接放回连接池
	public void releaseConnection(Connection conn) {
		dataSources.add(conn);
	}

	public static void getMyDataSource() {
		/*
		 * 使用双重检测同步延迟加载去创建单例的做法是一个非常优秀的做法，其不但保证了单例，而且切实提高了程序运行效率 如代码中所示，我们进行了两次if
		 * (singleton == null)检查，这样就可以保证线程安全了。 这样，实例化代码只用执行一次，后面再次访问时，判断if (singleton ==
		 * null)，直接return实例化对象。
		 *
		 */

		if (myDataSource == null) {

			synchronized (myDataSource) {// 加锁，饱汉式存在线程安全问题
				if (myDataSource == null) {
					myDataSource = new MyDataSource();
				}
			}
		}

	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
