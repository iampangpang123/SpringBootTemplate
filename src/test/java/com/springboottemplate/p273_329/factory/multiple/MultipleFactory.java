package com.springboottemplate.p273_329.factory.multiple;



/*
 * 因为是有接口的，所以这属于jdk的动态代理，
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
