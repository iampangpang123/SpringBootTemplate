package com.springboottemplate.designpattern.proxy;

public class Proxy implements Network {// 代理上网
	private Network netWork;

	public Proxy(Network netWork) {// 设置代理的真实操作
		this.netWork=netWork;// 设置代理的真实操作
	}

    public void check() { // 身份验证操作
        System.out.println("检查用户是否合法！");
    }
	@Override
	public void browse() {
		this.check();// 调用具体的代理业务操作  ;增加一些业务
		this.netWork.browse();// 调用真实的上网操作

	}

}
