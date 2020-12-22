package com.springboottemplate.designpattern.builder;
/**
 * 装机人员装机
 */
public class Director {
	public void Construct(Builder builder) {
        builder.buildCPU();
        builder.buildMainBoard();
        builder.buildHD();
    }
}
