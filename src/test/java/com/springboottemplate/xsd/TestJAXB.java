package com.springboottemplate.xsd;



import java.io.File;

import javax.xml.bind.JAXB;

import org.junit.Test;

public class TestJAXB {

	/**
	 **
	 * @Description:把java对象转换成xml
	 * @param:
	 * @return: void
	 */
	@Test
	public void generateXML() {
		JAXBProduct product = new JAXBProduct();
		product.setBeloneto("唐涛");
		product.setBuyPrice(10.00);
		product.setCreatTime("2015-01-01");
		File file = new File("G:\\WebService\\jaxb\\jaxbproduct.xml");
		JAXB.marshal(product, file);
	}

	/**
	 **
	 * @Description:把xml转成java文件
	 * @param:
	 * @return: void
	 */
	@Test
	public void generateBean() {
		File file = new File("G:\\WebService\\jaxb\\jaxbproduct.xml");
		JAXBProduct product = JAXB.unmarshal(file, JAXBProduct.class);
		System.out.println(product);
	}

	/**
	 **
	 * @Descriptio：把xsd文件转换成javaBean
	 * @param:
	 * @return: void
	 */
	public  void xsdToJavaBean() {
//		1.打开控制台
//		2.进入到xsd文件所在目录
//		3.输入下面命令。
//		      指定生成的 java 文件的包名： xjc -p com.traing.bean book.xsd 可以在生成的文件E:/JAXB/com/traing/book/Book.java
//		      xjc xxxxx.xsd -d  e:\JAXB\com（文件夹名称） ：指定java文件生成的目录。
//		      xjc *.xsd -p  （文件夹名称）  xxxxx.bean   将所有xsd文件生成java文件并保存在指定目录
	}

	public void  test(int a,int b) {

		int c=a+b;
		System.out.println("---------");
		System.out.println("结果"+a+b);
	}

}


