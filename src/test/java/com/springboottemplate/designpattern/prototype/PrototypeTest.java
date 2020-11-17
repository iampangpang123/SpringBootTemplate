package cn.tang.web1.designpattern.prototype;
/*
 * //原型模式的测试类
 */
public class PrototypeTest {


	public static void main(String[] args) throws CloneNotSupportedException {

		Realizetype realizetype=new Realizetype();
		Realizetype cloneRealizetype = (Realizetype) realizetype.clone();
		System.out.println(realizetype==cloneRealizetype);

	}
}
