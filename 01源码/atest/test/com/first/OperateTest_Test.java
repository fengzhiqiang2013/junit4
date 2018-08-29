package com.first;

import org.junit.Assert;
import org.junit.Test;
/**
 * @Test
 * @author aran
 *
 */
public class OperateTest_Test {
	/**
	 * 测试两数字相加
	 */
	@Test
	public void testAdd(){
		Operate op = new Operate();
		//测试用例1：1 + 1 = 2；
		Assert.assertEquals(2, op.add(1, 1));
		//测试用例2：-1 + 2 = 1；
		Assert.assertEquals(1, op.add(-1, 2));
		//测试用例3：0 + 2 = 2；
		Assert.assertEquals(2, op.add(0, 2));
	}
}
