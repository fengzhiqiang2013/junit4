package com.first;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * 1、@Before在@Test之前执行，@After在@Test之后执行
 * @author aran
 *
 */
public class OperateTest_Befre_After2 {
	Operate op = null;
	/**
	 * 测试两数字相加
	 */
	@Test
	public void testAdd(){
		//测试用例1：1 + 1 = 2；
		Assert.assertEquals(2, op.add(1, 1));
		//测试用例2：-1 + 2 = 1；
		Assert.assertEquals(1, op.add(-1, 2));
		//测试用例3：0 + 2 = 2；
		Assert.assertEquals(2, op.add(0, 2));
	}
	
	@Before
	public void testSubBefore(){
		op = new Operate();
		System.out.println("@Before1-----------");
	}
	@Before
	public void testSubBefo(){
		System.out.println("@Before-----------");
	}
	@After
	public void testSubAfter(){
		op = null;
		System.out.println("@After-----------");
	}
	@After
	public void testSubAfter2(){
		System.out.println("@After2-----------");
	}
}
