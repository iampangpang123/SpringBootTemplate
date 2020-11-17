package cn.tang.web1.designpattern.prototype.demo;

public class ProtoTypeCitation {
	 public static void main(String[] args) throws CloneNotSupportedException
	    {
	        Citation obj1=new Citation("张三","同学：在2016学年第一学期中表现优秀，被评为三好学生。","韶关学院");
	        obj1.display();
	        Citation obj2=(Citation) obj1.clone();
	        obj2.setName("李四");
	        obj2.display();
	    }
}
