package com.springboottemplate.designpattern.factory.method;

public class test {
	public static void main(String[] args) {
		Sender sender1=MultipleFactory.getSendImpl1();
		sender1.show();
		Sender sender2=MultipleFactory.getSendImpl2();
		sender2.show();
	}

}
