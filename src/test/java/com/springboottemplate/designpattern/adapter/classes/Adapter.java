package com.springboottemplate.designpattern.adapter.classes;

public class Adapter extends Source implements Targetable {
	 @Override
	    public void method2() {
	        System.out.println("This is the targetable method...");
	    }
}
