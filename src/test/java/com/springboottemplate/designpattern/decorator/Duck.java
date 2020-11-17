package cn.tang.web1.designpattern.decorator;

public class Duck  extends Food{

	public Duck() {
		// TODO Auto-generated constructor stub
		this.desc="我是鸭肉";
	}
	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return desc;
	}

}
