package com.springboottemplate.designpattern.factory.abstact;

public class SendSsmFactory  implements Provider{

	@Override
	public Sender produce() {

		return new SmsSender();
	}

}
