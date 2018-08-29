package com.first;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @Ignore
 * @Ignore 用法很简单, 如果你的测试用例还没有准备好而不想被执行, 
 * 又不想删掉或注释掉, 可以使用 @Ignore 标注来忽略测试
 * @author aran
 *
 */
public class OperateTest_BeforeClass_Ignore {
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
	/**
	 * 测试两数字相乘
	 */
	@Test
	public void test(){
		Operate op = new Operate();
		//测试用例1：1 * 2 = 2；
		Assert.assertEquals(1000, op.multiply(1, 2));
		//测试用例2：-1 * 2 = -2；
		Assert.assertEquals(1000, op.multiply(-1, 2));
		//测试用例3：0 + 2 = 2；
		Assert.assertEquals(1000, op.multiply(0, 2));
	}
}
