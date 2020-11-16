package src.test.designpattern.decorator;

public class Chicken  extends Food{


	public Chicken() {
		// TODO Auto-generated constructor stub
		this.desc="我是鸡肉";
	}
	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return desc;
	}

}
