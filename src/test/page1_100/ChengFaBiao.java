package src.test.page1_100;

import org.junit.Test;

public class ChengFaBiao {

	@Test
	public void test1() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {

                  System.out.print(j+"*"+i+"="+i*j+" ");
                  if(i==j) {
      				System.out.println("  ");
      			}
			}

		}
	}
}
