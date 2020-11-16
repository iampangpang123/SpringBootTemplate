package src.test.jihe;

import org.junit.Test;

public class TestString {

	// 截取字符串，，制作跑马灯效果
	@Test
	public void test() throws InterruptedException {

		String str = "欢迎到本超市购物";//到本超市购
		System.out.println(str.substring(2, 7));//说明下表也是从零开始
		 while(true) {
		System.out.println(str);
		Thread.sleep(1000);
		String start=str.substring(0, 1);// 欢
		String end=str.substring(1);// 迎到本超市购物
		str=end+start;
		}
	}
	@Test
	public void test1() {
		/*
		 * 4
		 * 0-1
		 * 0-2
		 * 0-3
		 * 1-2
		 * 2-3
		 */
		for(int i=0;i<4;i++) {
			System.out.println(0+"+"+i);
		}
		for(int i=1;i<4;i++) {
			System.out.println(i+"+"+(i+1));
		}


	}

}
