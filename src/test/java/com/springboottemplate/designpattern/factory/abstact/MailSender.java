package cn.tang.web1.designpattern.factory.abstact;

/*
 * 工厂方法模式有一个问题就是，类的创建依赖工厂类，也就是说，如果想要扩展程序，必须对工厂类进行修改，这违背了闭包原则，所以，从设计角度考虑，有一定的问题，如何解决？
那么这就用到了抽象工厂模式，创建多个工厂类，这样一旦需要增加新的功能，直接增加新的工厂类就可以了，不需要修改之前的代码
---------------------
作者：LiuWang_1122
来源：CSDN
原文：https://blog.csdn.net/yubujian_l/article/details/81455524
版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public class MailSender implements Sender {
	public void Send() {
		System.out.println("This is mail sender...");
	}
}
