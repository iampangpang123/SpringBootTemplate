package com.springboottemplate.xsd;


import java.io.Serializable;
import java.sql.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


	/*
	 *1. @XmlRootElement将类映射为xml全局元素，也就是根元素
	 *     该注解含有name和namespace两个属性。namespace属性用于指定生成的元素所属的命名空间。
	 * name属性用于指定生成元素的名字，若不指定则默认使用类名小写作为元素名。
	 *     下面就代表根节点的名字为：JAXBproduct
	 *
	 * 2.@XmlElement该注解可以将被注解的字段(非静态)，
	 *         下面例子中，pid、pname、buyPrice、pdesc等都被映射成了<JAXBproduct>元素的子元素
	 *         name=起名字
	 *         nillable=是否可以为空
	 *         required=是否必须出现
	 * 3.XmlAccessType.FIELD
	   *             每个非静态的字段(无论访问权限如何)都会被jaxb映射为xml元素，
	   *             即使没有get/set方法对，即使没有使用@XmlElement元素，
	   *            但最好加上该@XmlElement注解以表明该字段要被映射为xml元素。
	   4.@XmlType：指定元素生成的顺序
	        注意：xmlType的propOrder必须覆盖所有属性，不然报错
	 *
	 */

@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "", propOrder = { "pid", "pname","buyPrice","creatTime"})
@XmlRootElement(name="JAXBproduct")
public class JAXBProduct  implements   Serializable {
/*                  序列化
 *    含义：
	          通常，我们new的对象都是存在jvm堆内存里面，只要该对象不被jvm虚拟机的垃圾回收器回收，我们都能通过引用复用该对象
	         但是，当jvm停止运行的时候，对象就会丢失，这时候就需要序列化，将对象持久下来，并且在需要的时候独取该对象，
 *           使用：在java中，序列化反序列化普遍应用于远程方法调用和网络传输。。
 *            1） 把对象的字节序列永久地保存到硬盘上，通常存放在一个文件中；()内存转移到硬盘
                                       2） 在网络上传送对象的字节序列。
            注意：
 *        1要实现序列化的对象，所有涉及的引用，都需要实现序列化接口才可以。
 *
 */
	private static final long serialVersionUID = 1L;
	/*
	 * 1、 在某些场合，希望类的不同版本对序列化兼容，因此需要确保类的不同版本具有相同的serialVersionUID；
	 *
	 * 2、 在某些场合，不希望类的不同版本对序列化兼容，因此需要确保类的不同版本具有不同的serialVersionUID。
	 *
	 */
	@XmlElement(name="pid",nillable=true,required=false)
	private String pid;
	@XmlElement
	private String pname;
	@XmlElement
	private double buyPrice;
	@XmlElement
	private double salePrice;
	@XmlElement
	private String pdesc;
	@XmlElement
	private String pimage;
	@XmlElement
	private String beloneto;
	@XmlElement
	private int cid2;
	@XmlElement
	private int readTimes;
	@XmlElement
	private String state;
	@XmlElement
	private String isHot;
	@XmlElement
	private String creatTime;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public String getBeloneto() {
		return beloneto;
	}
	public void setBeloneto(String beloneto) {
		this.beloneto = beloneto;
	}
	public int getCid2() {
		return cid2;
	}
	public void setCid2(int cid2) {
		this.cid2 = cid2;
	}
	public int getReadTimes() {
		return readTimes;
	}
	public void setReadTimes(int readTimes) {
		this.readTimes = readTimes;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getIsHot() {
		return isHot;
	}
	public void setIsHot(String isHot) {
		this.isHot = isHot;
	}
	public String getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}
	@Override
	public String toString() {
		return "JAXBProduct [pid=" + pid + ", pname=" + pname + ", buyPrice=" + buyPrice + ", salePrice=" + salePrice
				+ ", pdesc=" + pdesc + ", pimage=" + pimage + ", beloneto=" + beloneto + ", cid2=" + cid2
				+ ", readTimes=" + readTimes + ", state=" + state + ", isHot=" + isHot + ", creatTime=" + creatTime
				+ "]";
	}






}
