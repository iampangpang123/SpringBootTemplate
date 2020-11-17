package cn.tang.web1.string;

import java.util.UUID;

import org.junit.Test;

public class StringUUID {






	/**
	 **
	 * @Description:生成32位UUID
	 * @param:
	 * @return: void
	 */
	@Test
	public void  test1() {
		String replace1 = UUID.randomUUID().toString().replace("-", "");
		String replace2 = UUID.randomUUID().toString().replace("-", "");
		String replace3 = UUID.randomUUID().toString().replace("-", "");
		System.out.println(replace1);
		System.out.println(replace2);
		System.out.println(replace3);
		System.out.println(replace1.length());
		System.out.println(replace2.length());
		System.out.println(replace3.length());

	}
}
