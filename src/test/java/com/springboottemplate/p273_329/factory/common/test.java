package cn.tang.web1.p273_329.factory.common;

public class test {
	public static void main(String[] args) {
		CommonFactory commonFactory=CommonFactory.getCommonFactory();
		Sender sender1=commonFactory.getSender("1");
		sender1.show();//这是SendImpl1
		Sender sender2=commonFactory.getSender("2");
		sender2.show();//这是SendImpl2
	}

}
