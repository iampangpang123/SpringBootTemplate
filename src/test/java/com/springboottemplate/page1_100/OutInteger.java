package cn.tang.web1.page1_100;

import org.junit.Test;

public class OutInteger {

	/**
	 * @Description: 打印随机产生100个1-10的整数
	 * @return void 返回类型
	 */
	@Test
	public void test () {
		int i;//局部变量知只是没有默认初始值，使用的时候需要提前赋值，不然无法使用，不是创建的时候必须初始化
		double count1=0;
		double count2=0;
		double count3=0;
		double count4=0;
		double count5=0;
		double count6=0;
		double count7=0;
		double count8=0;
		double count9=0;
		double count10=0;
		double countOther=0;
		for (i = 0; i <= 99; i++) {// 【0-99】；【1-100】是一百个数
			int a = (int) (Math.random() * 10 + 1);
			System.out.println(a);
			switch (a) {
			case 1:
                count1+=1;
				break;
			case 2:
                count2+=1;
				break;
			case 3:
				count3+=1;
				break;
			case 4:
				count4+=1;
				break;
			case 5:
				count5+=1;
				break;
			case 6:
				count6+=1;
				break;
			case 7:
				count7+=1;
				break;
			case 8:
				count8+=1;
				break;
			case 9:
				count9+=1;
				break;
			case 10:
				count10+=1;
				break;

			default:
				countOther+=1;
				break;
			}
		}

		System.out.println(count1/100+"  "+count2/100+"  "+count3/100+"  "+count4/100+"  "+count5/100+"  "+count6/100+"  "+count7/100+"  "+count8/100+"  "+count9/100+"  "+count10/100+"  "+countOther/100);
	}

	/**
	 * @Description: 打印随机产生100个0-9的整数
	 * @return void 返回类型
	 */
	@Test
	public void test2() {
		for (int i = 0; i <= 99; i++) {// 【0-99】；【1-100】是一百个数
			int a = (int) (Math.random() * 10);
			System.out.println(a);

		}
	}

}
