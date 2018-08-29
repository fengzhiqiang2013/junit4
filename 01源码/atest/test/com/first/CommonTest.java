package com.first;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.first.Common;

/**
 *  测试类
 * @author aran
 *
 */
public class CommonTest {
	/*
	1，首先，这个程序要保证一个list，如{7,8,9}，可以把9输出出来 
	2，然后呢，上面给了一个顺序的list，不失一般性，这个程序不应该是顺序敏感的，所以{7,9,8}，{9,8,7}等也要输出9 
	3，我发现，上面的list都是正数，那么负数和0呢？{-7，-8，-9}应该返回-7吧。 
	4，等等，如果list里面有重复项呢？{7,9,8,9}应该只返回一个9就可以了 
	5，那么，如果list里面只有一个元素呢？{9}当然是返回9了 
	6，考虑完了？空值呢？如果list为空，{ }要怎么处理呢？ 
	总结：1+2+5->注意上下界；3->max的初始值应为一个数型最小值；4->记录且return一个max；6->抛个异常 
	*/
	@Test
    public void testGetMaxNumByList_1() {
        //general test
        assertEquals(9, Common.getMaxNumByList(new int[] {7,8,9}));
        //order test
        assertEquals(9, Common.getMaxNumByList(new int[] {7,9,8}));
        assertEquals(9, Common.getMaxNumByList(new int[] {9,8,7}));
        //repetition test
        assertEquals(9, Common.getMaxNumByList(new int[] {7,9,8,9}));
        //single test
        assertEquals(9, Common.getMaxNumByList(new int[] {9}));
        //negative test
        assertEquals(-7, Common.getMaxNumByList(new int[] {-7,-8,-9}));
    }
	@Test
    public void testGetMaxNumByList_2() {
        try {
        	Common.getMaxNumByList(new int[] {});
            fail("An exception should been thrown!");
        }catch(RuntimeException e) {
            assertTrue(true);
        }
        try {
        	Common.getMaxNumByList(null);
            fail("An exception should been thrown!");
        }catch(RuntimeException e) {
            assertTrue(true);
        }
    }
	
}
 