package com.first;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * ---@FixMethodOrder(MethodSorters.JVM)//指定测试方法按定义的顺序执行 
 * ---@FixMethodOrder(MethodSorters.DEFAULT)//以确定系统默认但不可预期的顺序执行 
 * ---@FixMethodOrder(MethodSorters.NAME_ASCENDING)//按方法名字母顺序执行
 * @author aran
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//按方法名字母顺序执行
public class OperateTest_FixMethodOrder {
	
	/**
	 * 测试两数字相加
	 */
	@Test
	public void testAdd_b(){
		Operate op = new Operate();
		//测试用例1：1 + 1 = 2；
		Assert.assertEquals(2, op.add(1, 1));
		//测试用例2：-1 + 2 = 1；
		Assert.assertEquals(1, op.add(-1, 2));
		//测试用例3：0 + 2 = 2；
		Assert.assertEquals(2, op.add(0, 2));
		System.out.println("Add_b");
	}
	/**
	 * 测试两数字相加
	 */
	@Test
	public void testAdd_a(){
		Operate op = new Operate();
		//测试用例1：1 + 1 = 2；
		Assert.assertEquals(2, op.add(1, 1));
		//测试用例2：-1 + 2 = 1；
		Assert.assertEquals(1, op.add(-1, 2));
		//测试用例3：0 + 2 = 2；
		Assert.assertEquals(2, op.add(0, 2));
		System.out.println("Add_a");
	}
	/**
	 * 测试两数字相乘
	 */
	@Test
	public void testMultiply(){
		Operate op = new Operate();
		//测试用例1：1 * 2 = 2；
		Assert.assertEquals(2, op.multiply(1, 2));
		//测试用例2：-1 * 2 = -2；
		Assert.assertEquals(-2, op.multiply(-1, 2));
		//测试用例3：0 + 2 = 2；
		Assert.assertEquals(0, op.multiply(0, 2));
		System.out.println("multiply");
	}
}
