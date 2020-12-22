package com.springboottemplate.mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

public class JdbcUtil {
	public static void main(String[] args) {
		JdbcUtil.getConnection();
	}
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	private static Properties properties = new Properties();

	@Test
   public static Connection getConnection(){
	   Connection conn=null;
		try {

			properties.load(JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
			Class.forName(driver);
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("获取数据库连接对象成功");
			Connection connection = DriverManager.getConnection(url,username,password);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("连接数据库失败");
		}
	   return conn;

   }
	// 释放资源
	@Test
public static void free(ResultSet rs,Statement st,Connection conn){

	if(st!=null){
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("st关闭失败");
		}
	}
	if(conn!=null){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block、
			System.out.println("conn关闭失败");
			e.printStackTrace();
		}
	}
	if(rs!=null){
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("rs关闭失败");
			e.printStackTrace();
		}
	}


}

}
