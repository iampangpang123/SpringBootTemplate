package src.test.designpattern.builder;

public class BuilderPattern {
	 public static void main(String[] args) {
		  Builder builder = new ConcreteBuilder();//创建一个具体 的装机人员
	        Director director = new Director();//创建装机过程-

	        director.Construct(builder);//--，是装机的动作--谁装机--装那些东西
	        Computer computer = builder.getComputer();
	        computer.print();
	    }

}
