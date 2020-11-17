//package cn.tang.web1.poi;
//
//import java.io.File;
//import java.io.FileOutputStream;
//
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.junit.Test;
//
//public class Poi1 {
///*
// *
//<dependency>
//
//    <groupId>org.apache.poi</groupId>
//
//    <artifactId>poi</artifactId>
//
//    <version>3.17</version>
//
//</dependency>
// */
//	public static void main(String[] args) {
//
//	}
//
//	/**
//	 **
//	 * @Description:(1)创建一个excle表
//	 * @param: @throws Exception
//	 * @return: void
//	 */
//	@Test
//	public void createWorkbookAndSheet() throws Exception {
//		String filePath="F:\\JavaIO\\testExcel.xls";//文件路径
//		 HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel文件(Workbook)
//		 HSSFSheet sheet = workbook.createSheet();//创建工作表(Sheet)
//		sheet = workbook.createSheet("Test");//创建工作表(Sheet)
//		 FileOutputStream out = new FileOutputStream(filePath);
//		workbook.write(out);//保存Excel文件
//		out.close();//关闭文件流
//		 System.out.println("OK!");
//	}
//
//	/**
//	 **
//	 * @Description:创建一个excle表并且写入二行数据
//	 * @param: @throws Exception
//	 * @return: void
//	 */
//	@Test
//	public void excelWrite() throws Exception {
//		// 获得Excel文件输出流
//		FileOutputStream out = new FileOutputStream(new File("F:\\JavaIO\\testExcel1.xls"));
//		// 创建excel工作簿对象
//		HSSFWorkbook wb = new HSSFWorkbook();
//		// 创建excel页
//		HSSFSheet sheet = wb.createSheet("POI导出测试");
//		// 创建表头
//		HSSFRow row1 = sheet.createRow(0);
//		// 创建表头的单元格-------------------------------
//		HSSFCell cell1_1 = row1.createCell(0);
//		cell1_1.setCellValue("学号");
//		HSSFCell cell1_2 = row1.createCell(1);
//		cell1_2.setCellValue("姓名");
//		HSSFCell cell1_3 = row1.createCell(2);
//		cell1_3.setCellValue("年级");
//		HSSFCell cell1_4 = row1.createCell(3);
//		cell1_4.setCellValue("年龄");
//		HSSFCell cell1_5 = row1.createCell(4);
//		cell1_5.setCellValue("性别");
//		// --------------------------------------------
//		// 写入一行内容：
//		HSSFRow row2 = sheet.createRow(1);//1代表第二行
//		HSSFCell cell2_1 = row2.createCell(0);
//		cell2_1.setCellValue(1);
//		HSSFCell cell2_2 = row2.createCell(1);
//		cell2_2.setCellValue("阿荣");
//		HSSFCell cell2_3 = row2.createCell(2);
//		cell2_3.setCellValue("17(3)");
//		HSSFCell cell2_4 = row2.createCell(3);
//		cell2_4.setCellValue(20);
//		HSSFCell cell2_5 = row2.createCell(4);
//		cell2_5.setCellValue("男");
//
//		// 写入第三行内容：
//				HSSFRow row3 = sheet.createRow(2);//2代表第三行
//				HSSFCell cell3_1 = row3.createCell(0);
//				cell3_1.setCellValue(1);
//				HSSFCell cell3_2 = row3.createCell(1);
//				cell3_2.setCellValue("阿荣");
//				HSSFCell cell3_3 = row3.createCell(2);
//				cell3_3.setCellValue("17(3)");
//				HSSFCell cell3_4 = row3.createCell(3);
//				cell3_4.setCellValue(20);
//				HSSFCell cell3_5 = row3.createCell(4);
//				cell3_5.setCellValue("男");
//		// 输出excel的错误形式：
//		// out.write(fs.getBytes(), 0, fs.getBytes().length);
//		// 正确形式：
//		wb.write(out);
//		// 关流
//		out.close();
//
//	}
//
//
//
//}
