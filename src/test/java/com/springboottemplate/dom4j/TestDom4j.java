//package cn.tang.web1.dom4j;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.util.List;
//
//
//
//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.Element;
//import org.dom4j.io.OutputFormat;
//import org.dom4j.io.SAXReader;
//import org.dom4j.io.XMLWriter;
//import org.junit.Test;
//
//public class TestDom4j {
//	/*  ss
//	 * 查询
//	 */
//	@Test
//	public void find() throws DocumentException {
//		SAXReader reader = new SAXReader();
//		Document document = reader.read("WebContent/WEB-INF/testdom4j.xml");
//		Element root = document.getRootElement();
//		Element list = root.element("p1");
//
//		Element name1 = list.element("name");
//		Element name2 = list.element("age");
//		Element name3 = list.element("sex");
//		Element name4 = list.element("school");
//		System.out.println(name1.getText());
//		System.out.println(name2.getText());
//		System.out.println(name3.getText());
//		System.out.println(name4.getText());
//	}
//	/*
//	 * add
//	 */
//	@Test
//	public void add() throws Exception {
//		SAXReader reader = new SAXReader();
//		Document document = reader.read("WebContent/WEB-INF/testdom4j.xml");
//       Element root =document.getRootElement();//得到根目标签，也就是Person标签
//        Element element=root.addElement("p1");
//        element.addElement("name").setText("小翠");
//        element.addElement("age").setText("18");
//        element.addElement("sex").setText("女");
//        element.addElement("school").setText("郑大");
//        XMLWriter writer=new XMLWriter(new FileOutputStream("WebContent/WEB-INF/testdom4j.xml"),OutputFormat.createPrettyPrint());
//		writer.write(document);
//		writer.close();
//	}
//	/*
//	 * 删除.
//	 * 支了个通过夫标签删除子标签
//	 */
//	@Test
//	public void delete() throws Exception{
//		SAXReader reader=new SAXReader();
//
//		Document document=reader.read("WebContent/WEB-INF/testdom4j.xml");
//		Element root=document.getRootElement();
//		Element p3= (Element) root.elements("p1").get(2);
//		System.out.println(p3.element("name").getText());;
//		root.remove(p3);
//		 XMLWriter writer=new XMLWriter(new FileOutputStream("WebContent/WEB-INF/testdom4j.xml"),OutputFormat.createPrettyPrint());
//			writer.write(document);
//			writer.close();
//
//	}
//
//	@Test
//	public void update() throws Exception{
//		SAXReader reader=new SAXReader();
//		Document document=reader.read("WebContent/WEB-INF/testdom4j.xml");
//		Element root=document.getRootElement();
//		Element p2= (Element) root.elements("p1").get(1);
//		Element name=p2.element("name");
//		name.setText("lisi");
//
//		 XMLWriter writer=new XMLWriter(new FileOutputStream("WebContent/WEB-INF/testdom4j.xml"),OutputFormat.createPrettyPrint());
//			writer.write(document);
//			writer.close();
//
//	}
//}
