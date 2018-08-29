package com.first;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;
/**
 * ---@Rule
 * @author aran
 *
 */
public class OperateTest_Rule {
	/**
	 * 循环testAdd循环执行
	 */
	@Rule
	public MethodRule rule = new RepeatableRule(5, new String[]{"testAdd"});
	
	/**
	 * 测试两数字相加
	 */
	@Test
	public void testAdd(){
		System.out.println("rule------------");
	}
	/**
	 * 测试两数字相加
	 */
	@Test
	public void testSub(){
		System.out.println("rule------------");
	}
}
