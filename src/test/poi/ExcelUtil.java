package src.test.poi;//package cn.tang.web1.poi;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.junit.Test;
//
//
//public class ExcelUtil {
//
//	/**
//	 **
//	 * @Description:根据存在的excel模板，导出到excle表格
//	 * @param: @throws Exception
//	 * @return: void
//	 * @throws IOException
//	 */
//	@Test
//	public void sqlUserToExcel3() throws IOException  {
//		int   count=5;
//        //读取excel模板
//	     FileInputStream inStream = new FileInputStream(new File("F:\\JavaIO\\文化事业应税服务扣除清单.xls"));
//		HSSFWorkbook wb = new HSSFWorkbook(inStream);
//        //读取了模板内所有sheet内容
//		HSSFSheet sheet = wb.getSheet("应税服务减除项目清单");
//
//		for(int i=4;i<10;i++) {
//			HSSFRow row=sheet.createRow(i);//第二行開始記錄，下次遍歷開始count++
//			HSSFCell cell0 = row.createCell(0);//第一个单元格，下表从0开始。
//			cell0.setCellValue("111");
//
//			HSSFCell cell1 = row.createCell(1);//第二个单元格
//			cell1.setCellValue("111");
//
//			HSSFCell cell2 = row.createCell(2);//第3个单元格
//			cell2.setCellValue("111");
//
//			HSSFCell cell3 = row.createCell(3);//第4个单元格
//			cell3.setCellValue("2|财政票据");
//
//			HSSFCell cell4 = row.createCell(4);//第5个单元格
//			cell4.setCellValue("111");
//			HSSFCell cell5 = row.createCell(5);//第6个单元格
//			cell5.setCellValue("1111");
//			count++;//因为count++代表下行开始，不加数据就覆盖了
//		}
//
//		FileOutputStream out = new FileOutputStream(new File("F:\\JavaIO\\文化事业应税服务扣除清单new.xls"));
//		wb.write(out);
//		// 关流
//		out.flush();
//		out.close();
//
//	}
//
//
//	/**
//	 **
//	 * @Description:根据存在的excel模板，导出到excle表格
//	 * @param: @throws Exception
//	 * @return: void
//	 */
//	@Test
//	public void sqlUserToExcel2() throws Exception {
//		int   count=60;
//        //读取excel模板
//	     FileInputStream inStream = new FileInputStream(new File("F:\\JavaIO\\user.xls"));
//		HSSFWorkbook wb = new HSSFWorkbook(inStream);
//        //读取了模板内所有sheet内容
//		HSSFSheet sheet = wb.getSheet("POI导出测试");
//
//		for(int i=60;i<70;i++) {
//			HSSFRow row=sheet.createRow(i);//第二行開始記錄，下次遍歷開始count++
//			HSSFCell cell0 = row.createCell(0);//第一个单元格，下表从0开始。
//			cell0.setCellValue("111");
//
//			HSSFCell cell1 = row.createCell(1);//第二个单元格
//			cell1.setCellValue("111");
//
//			HSSFCell cell2 = row.createCell(2);//第3个单元格
//			cell2.setCellValue("111");
//
//			HSSFCell cell3 = row.createCell(3);//第4个单元格
//			cell3.setCellValue("2|财政票据");
//
//			HSSFCell cell4 = row.createCell(4);//第5个单元格
//			cell4.setCellValue("111");
//			HSSFCell cell5 = row.createCell(5);//第6个单元格
//			cell5.setCellValue("1111");
//			count++;//因为count++代表下行开始，不加数据就覆盖了
//		}
//
//		FileOutputStream out = new FileOutputStream(new File("F:\\JavaIO\\usernew.xls"));
//		wb.write(out);
//		// 关流
//		out.flush();
//		out.close();
//
//	}
//
//	/**
//	 **
//	 * @Description:根据user表的数据，到处到excle表格
//	 * @param: @throws Exception
//	 * @return: void
//	 */
//	@Test
//	public void sqlUserToExcel() throws Exception {
//		int   count=10;
//		// 获得Excel文件输出流
//		FileOutputStream out = new FileOutputStream(new File("F:\\JavaIO\\User.xls"));
//		// 创建excel工作簿对象
//		HSSFWorkbook wb = new HSSFWorkbook();
//		// 创建excel页
//		HSSFSheet sheet = wb.createSheet("POI导出测试");
//		// 创建表头
//		HSSFRow row1 = sheet.createRow(0);
//		// 创建表头的单元格-------------------------------
//		HSSFCell cell1_1 = row1.createCell(0);
//		cell1_1.setCellValue("sid");
//
//		HSSFCell cell1_2 = row1.createCell(1);
//		cell1_2.setCellValue("sname");
//
//		HSSFCell cell1_6 = row1.createCell(2);
//		cell1_6.setCellValue("age");
//
//		HSSFCell cell1_3 = row1.createCell(3);
//		cell1_3.setCellValue("gander");
//
//		HSSFCell cell1_4 = row1.createCell(4);
//		cell1_4.setCellValue("province");
//
//		HSSFCell cell1_5 = row1.createCell(5);
//		cell1_5.setCellValue("money");
//
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "123");
//		System.out.println(conn);
//		String sql = "select * from stu";
//		PreparedStatement prepareStatement = conn.prepareStatement(sql);
//		ResultSet rs = prepareStatement.executeQuery();
//		while (rs.next()) {
//			HSSFRow row=sheet.createRow(count);//第二行開始記錄，下次遍歷開始count++
//
//			HSSFCell cell0 = row.createCell(0);//第一个单元格，下表从0开始。
//			cell0.setCellValue(rs.getInt(1));
//
//			HSSFCell cell1 = row.createCell(1);//第二个单元格
//			cell1.setCellValue(rs.getString(2));
//
//			HSSFCell cell2 = row.createCell(2);
//			cell2.setCellValue(rs.getInt(3));
//
//			HSSFCell cell3 = row.createCell(3);
//			cell3.setCellValue(rs.getString(4));
//
//			HSSFCell cell4 = row.createCell(4);
//			cell4.setCellValue(rs.getString(5));
//
//			HSSFCell cell5 = row.createCell(5);
//			cell5.setCellValue(rs.getInt(6));
//			count++;//因为count++代表下行开始，不加数据就覆盖了
//		}
//		wb.write(out);
//		// 关流
//		out.close();
//
//	}
//}
