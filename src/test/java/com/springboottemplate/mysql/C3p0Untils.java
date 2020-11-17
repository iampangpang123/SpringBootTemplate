//package cn.tang.web1.mysql;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import javax.sql.DataSource;
//
//import com.mchange.v2.c3p0.ComboPooledDataSource;
//
//public class C3p0Untils {
//
//	private static ComboPooledDataSource dataSource=new ComboPooledDataSource();
//
//
//	public static Connection getConnection() throws SQLException{
//		/*     这个是默认配置。要求你必须给一个c3p0-config.xml文件
//		 * 这个方法:使用连接池返回一个连接对象
//		 */
//		return dataSource.getConnection();
//	}
//
//
//	public static DataSource getDataSource(){
//
//		//返回连接池对象>>>导入包：：import javax.sql.DataSource;
//
//		return dataSource;
//	}
//}
