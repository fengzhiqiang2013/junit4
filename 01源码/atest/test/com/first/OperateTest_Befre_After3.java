package com.first;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * --------@Before-->@Test-->@After-------
 * 每执行一个@Test 就会执行一次 @Before和@After
 * @author aran
 *
 */
public class OperateTest_Befre_After3 {
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
		Assert.assertEquals(2, op.multiply(1, 2));
		//测试用例2：-1 * 2 = -2；
		Assert.assertEquals(-2, op.multiply(-1, 2));
		//测试用例3：0 + 2 = 2；
		Assert.assertEquals(0, op.multiply(0, 2));
	}
	
	
	@Before
	public void testSubBefore(){
		System.out.println("@Before---------------");
	}
	@After
	public void testSubAfter(){
		System.out.println("@After---------------");
	}
}
