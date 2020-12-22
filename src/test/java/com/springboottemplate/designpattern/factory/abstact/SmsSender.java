package com.springboottemplate.designpattern.factory.abstact;

public class SmsSender implements Sender {
	  public void Send() {
	        System.out.println("This is sms sender...");
	    }
}
