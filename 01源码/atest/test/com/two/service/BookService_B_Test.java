package com.two.service;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.two.bean.TAuthor;
import com.two.bean.TBook;
import com.two.dao.IAuthorDao;
import com.two.dao.IBookDao;
import com.two.dao.impl.AuthorDaoImpl;
import com.two.dao.impl.BookDaoImpl;
import com.two.service.impl.BookServiceImpl;

/**
 * 
 * @author aran
 *
 */
public class BookService_B_Test {
	
	/**
	 * 测试注入到，模拟 返回到返回的对象
	 */
	@Test
	public void testSaveBook(){
		//测试用例1:价格是一个非0数字（50.02）
		TBook book =  new TBook();
		book.setId("32wei");
		book.setName("活着");
		book.setAuthor("柴");
		book.setPage(220);
		book.setPrice(50.02);
		
		TAuthor author = new TAuthor();
		author.setId("123456");
		author.setName("黄");
		
		String authorId = "123456";
		//模拟内部的bookDao对象，authorDao对象
		IBookDao bookDao = Mockito.mock(BookDaoImpl.class);
		IAuthorDao authorDao = Mockito.mock(AuthorDaoImpl.class);
		
		//模拟内部的saveBook(book)方法，queryAuthorById(id)方法
		Mockito.doReturn(author).when(authorDao).queryAuthorById(Mockito.anyString());
		Mockito.doNothing().when(bookDao).saveBook((TBook) Mockito.anyObject());
		
		//构造测试类
		IBookService bookService = new BookServiceImpl();
		
		//将模拟的对象注入到构造的测试类中
		ReflectionTestUtils.setField(bookService, "bookDao", bookDao);
		ReflectionTestUtils.setField(bookService, "authorDao", authorDao);
		
		//执行
		String id = bookService.saveBook_B(book, authorId);
		//断言
		Assert.assertEquals("32wei", id);
		Assert.assertTrue(50.02 == book.getPrice());
		Assert.assertEquals(book.getAuthor(), author.getName());
	}
}
