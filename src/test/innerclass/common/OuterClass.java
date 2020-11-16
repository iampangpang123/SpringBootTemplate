package src.test.innerclass.common;

public class OuterClass {// 外围类

//	（1）成员内部类可以访问外围类的所有成员，包括私有成员；
//	（2）成员内部类是不可以声明静态成员（包括静态变量、静态方法、静态成员类、嵌套接口），但有个例外—可以声明 static final的变量，
	// 这是因为编译器对final类型的特殊处理，是直接将值写入字节码；
//	（3）成员内部类对象都隐式地保存了一个引用，指向创建它的外部类对象；或者说，成员内部类的入口是由外围类的对象保持着
	// （静态内部类的入口，则直接由外围类保持着）
	public int aa; // 实例成员

	private static float f = 1.5f;// private的静态成员

	public void initInnerClass() {
		System.out.println("内部类的初始化方法");
	}

	public void createInnerClass() {//
		// 外围类的成员方法中创建成员内部类对象
		InnerClass innerClass = new InnerClass();
	}

	class InnerClass {// 成员内部类
		private double aa; // 与围类的变量aa的名字重复

		public InnerClass() {
			this.aa = OuterClass.this.aa + f;// 明确指定两个aa的所属
			initInnerClass();
		}
	}
}

//其他类
class OtherClass {
	public static void main(String[] args) {
		// 其他类中创建成员内部类
		OuterClass oc = new OuterClass();// 外部类对象
		// 创建内部类对象
		OuterClass.InnerClass innerClass = oc.new InnerClass();
	}
}
