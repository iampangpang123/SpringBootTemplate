package com.springboottemplate.designpattern.factory.abstact;

public class SendMailFactory implements Provider {

	@Override
	public Sender produce() {
	    return new MailSender();
	}

}
