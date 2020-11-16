package src.test.designpattern.decorator;

public class TestDecorator {
//	看起来是不是特别像？
//	对装饰者模式来说，装饰者（各种调料）和被装饰者（各种咖啡）都实现同一个接口（饮料）。
//	对代理模式来说，代理类（各种咖啡的代理）和真实处理的类（各种咖啡）也都实现同一个接口（饮料）
//	。此外，不论我们使用哪一个模式，都可以很容易地在真实对象的方法前面或者后面加上自定义的方法。
//	但是装饰者模式可以让使用者直观的看到增强了哪些功能（可以知道加了牛奶，奶泡等），而代理模式完全限制了使用者，
//	只去调用代理，至于代理里面增加了什么功能，使用者是不知道，隐藏了一个对象的具体信息。因此，当我们使用装饰器模式的时候，通
//	常将原始对象作为一个参数传给装饰者的构造器，而使用代理模式的时候，是在一个代理类中创建一个对象的实例。代理和真实对象之间的的
//	关系通常在编译时就已经确定了，而装饰者能够在运行时递归地被构造。
//	看看代码：

	public static void main(String[] args) {
		// 测试单纯的食物
//		        Food f1 = new Chicken();
//		        System.out.println(f1.getDesc());

		// System.out.println("----------------------");
		// 测试单重修饰的食物
//		         RoastFood rf = new RoastFood(f1);
//		         System.out.println(rf.getDesc());
//
//	        System.out.println("----------------------");
		// 测试多重修饰的食物
//		         SteamedFood sf = new SteamedFood(rf);
//		        System.out.println(sf.getDesc());
		Food food = new Duck();
		RoastFood roastFood = new RoastFood(food);
		System.out.println(roastFood.getDesc());
		SteamedFood steamedFood=new SteamedFood(roastFood);
		System.out.println(steamedFood.getDesc());
	}
}
