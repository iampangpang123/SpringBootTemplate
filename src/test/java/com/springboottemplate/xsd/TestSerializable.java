package com.springboottemplate.xsd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.MessageFormat;

public class TestSerializable {


	    public static void main(String[] args) throws Exception {
	        SerializePerson();//序列化Person对象
	        JAXBProduct  product = DeserializePerson();//反序列Perons对象
	        System.out.println(MessageFormat.format("pname={0},buyPrice={1},pdesc={2}",
	        		product.getPname(), product.getBuyPrice(),product.getPdesc()));

	        System.out.println("toString:"+product.toString());
	    }


	    private static void SerializePerson() throws FileNotFoundException, IOException {
	    	JAXBProduct product = new JAXBProduct();
	    	product.setPname("洗衣机");
	    	product.setBuyPrice(25.00);
	    	product.setPdesc("格力洗衣机");
	    	product.setBeloneto("唐涛");
	        // ObjectOutputStream 对象输出流，将Person对象存储到E盘的Person.txt文件中，完成对Person对象的序列化操作
	        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("G:\\WebService\\jaxb.txt")));
	        oo.writeObject(product);
	        System.out.println("Person对象序列化成功！");
	        oo.close();
	    }

	    private static JAXBProduct DeserializePerson() throws Exception, IOException {
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("G:\\WebService\\jaxb.txt")));
	        JAXBProduct product = (JAXBProduct) ois.readObject();
	        System.out.println("Person对象反序列化成功！");
	        return product;
	    }


}
