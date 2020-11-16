package src.test.designpattern.builder;

/*
 * 工厂类模式提供的是创建单个类的模式，而建造者模式则是将各种产品集中起来管理，用来创建复合对象，所谓复合对象就是指某个类具有不同的属性。
 */
public abstract class Builder {
	/**
	 * 第一步：装CPU
	 */
	public abstract void buildCPU();

	/**
	 * 第二步：装主板
	 */
	public abstract void buildMainBoard();

	/**
	 * 第三步：装硬盘
	 */
	public abstract void buildHD();

	/**
	 * 获得组装好的电脑
	 *
	 * @return
	 */
	public abstract Computer getComputer();

}
