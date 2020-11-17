package cn.tang.web1.p273_329.factory.multiple;

public interface Sender {
	/*
	 * 因为是有接口的，所以这属于jdk的动态代理，
	 */

	public abstract void show();// 接口中不能有静态方法因为静态方法无法被重写
	/*
	 * 静态方法是类在加载时就被加载到内存中的方法，在整个运行过程中保持不变，因而不能重写。但非静态方法是在对象实例化时才单独申请内存空间，
	 * 为每一个实例分配独立的运行内存，因而可以重写
	 */
}
