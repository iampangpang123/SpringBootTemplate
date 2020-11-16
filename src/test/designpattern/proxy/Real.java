package src.test.designpattern.proxy;

public class Real implements Network{// 真实的上网操作
	 public void browse() { // 覆写抽象方法
	        System.out.println("上网浏览信息！");
	    }
}
