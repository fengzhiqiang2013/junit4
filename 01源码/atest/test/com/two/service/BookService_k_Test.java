package com.two.service;

import static org.mockito.Mockito.reset;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class BookService_k_Test {
	@Test(expected = IndexOutOfBoundsException.class)
    public void spy_on_real_objects(){
        List list = new LinkedList();
        List spy = Mockito.spy(list);
        //使用doReturn-when可以避免when-thenReturn调用真实对象api
        Mockito.doReturn(999).when(spy).get(999);
        //预设size()期望值
        Mockito.when(spy.size()).thenReturn(100);
        //调用真实对象的api
        spy.add(1);
        spy.add(2);
        Assert.assertEquals(100, spy.size());
        Assert.assertEquals(1, spy.get(0));
        Assert.assertEquals(2, spy.get(1));
        Assert.assertEquals(999, spy.get(999));
        
        Mockito.verify(spy).add(1);
        Mockito.verify(spy).add(2);
        
    }
	@Test  
	public void spyTest2() {  
	    List list = new LinkedList();  
	    List spy = Mockito.spy(list);  
  
	    Mockito.when(spy.size()).thenReturn(100);  
 
	    spy.add("one");  
	    spy.add("two");  
 
	    System.out.println(spy.get(0));  
	    System.out.println(spy.size());  
	     
	    Mockito.verify(spy).add("one");  
	    Mockito.verify(spy).add("two");   
	    
	}  
}
