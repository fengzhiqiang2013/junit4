package com.two.service;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.two.bean.TBook;
import com.two.dao.IBookDao;
import com.two.dao.impl.BookDaoImpl;
import com.two.service.impl.BookServiceImpl;

/**
 * 测试类
 * @author aran
 *
 */
public class BookService_A_Test {
	/**
	 * 
	 * 最简单的模拟 dao
	 */
	@Test
	public void testSaveBook_A(){
		//模拟BookDao对象
		IBookDao bookDao = Mockito.mock(BookDaoImpl.class);
		//模拟内部的saveBook(book)方法
		Mockito.doNothing().when(bookDao).saveBook((TBook)Mockito.anyObject());
		//测试类对象
		IBookService bookService = new BookServiceImpl();
		//将模拟的对象注入到构造的测试类中
		ReflectionTestUtils.setField(bookService, "bookDao", bookDao);
		
		//测试用例1:价格是一个非0数字（50.02）
		TBook book =  new TBook();
		book.setId("32wei");
		book.setName("活着");
		book.setAuthor("柴");
		book.setPage(220);
		book.setPrice(50.02);
		//执行
		String id = bookService.saveBook_A(book);
		//断言
		Assert.assertEquals("32wei", id);
		Assert.assertTrue(50.02 == book.getPrice());
		
		
		//测试用例2:价格是一个null
		TBook book2 =  new TBook();
		book2.setId("32wei");
		book2.setName("活着");
		book2.setAuthor("柴");
		book2.setPage(220);
		book2.setPrice(null);
		//执行
		String id2 = bookService.saveBook_A(book2);
		//断言
		Assert.assertEquals("32wei", id2);
		Assert.assertTrue(0d == book2.getPrice());
		
		
		//测试用例3:价格是0（0d）
		TBook book3 =  new TBook();
		book3.setId("32wei");
		book3.setName("活着");
		book3.setAuthor("柴");
		book3.setPage(220);
		book3.setPrice(null);
		//执行
		String id3 = bookService.saveBook_A(book3);
		//断言
		Assert.assertEquals("32wei", id3);
		Assert.assertTrue(0d == book3.getPrice());
		
	}
}
