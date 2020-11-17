package cn.tang.web1.designpattern.proxy;

public class TestProxy {

	public static void main(String[] args) {
		Real real = new Real();
		Network network = new Proxy(real);
		network.browse();

	}















}
