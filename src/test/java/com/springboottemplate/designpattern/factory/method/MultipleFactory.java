package cn.tang.web1.designpattern.factory.method;



/*
 * 因为是有接口的，所以这属于jdk的动态代理，
 */
/*
 * 工厂方法模式Factory Method：又称为多形性工厂；具体工厂模式
 *
 * 工厂提供多个方法-返回不同对象，无需传递字符串
 */
public class MultipleFactory {

public MultipleFactory() {
	// TODO Auto-generated constructor stub
}
public  static Sender getSendImpl1(){
	return new SendImpl1();

}
public  static Sender getSendImpl2(){
	return new SendImpl2();

}
}
