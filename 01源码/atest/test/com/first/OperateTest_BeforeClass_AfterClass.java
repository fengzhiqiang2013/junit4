package com.first;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * ----@BeforeClass---@AfterClass----
 * 1、被声明为@BeforeClass与@AfterClass的方法必须是public static void。
 * 2、
 * 即使@BeforeClass中发生了异常，@AfterClass方法仍会执行，保证资源的释放（使用者操作） - 
 * 一个测试类是允许声明多个@BeforeClass与@AfterClass，但是执行的顺序是不确定的
 * @author aran
 *
 */
public class OperateTest_BeforeClass_AfterClass {
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
		op = new Operate();
		System.out.println("@Before-------------");
	}
	@After
	public void testSubAfter(){
		op = null;
		System.out.println("@After-------------");
	}
	@BeforeClass
	public static void testSubBeforeClass(){
		System.out.println("@BeforeClass-------------");
	}
	
	@AfterClass
	public static void testSubAfterClass(){
		System.out.println("@AfterClass--------------");
	}
}
