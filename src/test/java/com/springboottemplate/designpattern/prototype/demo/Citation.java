package cn.tang.web1.designpattern.prototype.demo;

public class Citation implements Cloneable {
	String name;
	String info;
	String college;

	Citation(String name, String info, String college) {
		this.name = name;
		this.info = info;
		this.college = college;
		System.out.println("奖状创建成功！");
	}

	void setName(String name) {
		this.name = name;
	}

	String getName() {
		return (this.name);
	}

	void display() {
		System.out.println(name + info + college);
	}

	public Object clone() throws CloneNotSupportedException {
		System.out.println("奖状拷贝成功！");
		return (Citation) super.clone();
	}
}
