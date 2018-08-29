package com.two.service;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class BookService_J_Test {
	@Test
    public void verify_behaviour(){
        //模拟创建一个List对象
        List mock = Mockito.mock(List.class);
        //使用mock的对象
        mock.add(1);
        mock.clear();
        //验证add(1)和clear()行为是否发生
        Mockito.verify(mock).add(1);
        Mockito.verify(mock).clear();
    }
//	@Test
//	  public void testAssertArrayEquals() {
//	    byte[] expected = "trial".getBytes();
//	    byte[] actual = "trial".getBytes();
//	    org.junit.Assert.assertArrayEquals(expected, actual);
//	}
}
