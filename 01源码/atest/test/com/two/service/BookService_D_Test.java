package com.two.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.two.bean.TAuthor;
import com.two.bean.TBook;
import com.two.dao.IAuthorDao;
import com.two.dao.IBookDao;
import com.two.dao.impl.AuthorDaoImpl;
import com.two.dao.impl.BookDaoImpl;
import com.two.service.impl.BookServiceImpl;
import com.two.utils.FilesUtil;
import com.two.utils.OrganizationUtil;

/**
 * PowerMockito模拟静态的 void 方法
 * @author aran
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({OrganizationUtil.class, FilesUtil.class})
public class BookService_D_Test {
	@Test
	public void testSaveBook() throws Exception{
		//准备
		TBook book =  new TBook();
		book.setId("32wei");
		book.setName("活着");
		book.setPage(220);
		book.setPrice(50.02);
				
		TAuthor author = new TAuthor();
		author.setId("123456");
		author.setName("黄");
		
		String authorId = "123456";
		
		String userId = "user123456789";
		
		List<File> files = new ArrayList<File>();
		File file1 = new File("D:/单元.doc");
		File file2 = new File("D:/测试.txt");
		files.add(file1);
		files.add(file2);
		
		//模拟内部的bookDao对象，authorDao对象
		IBookDao bookDao = Mockito.mock(BookDaoImpl.class);
		IAuthorDao authorDao = Mockito.mock(AuthorDaoImpl.class);
		
		//模拟内部的saveBook(book)方法，queryAuthorById(id)方法
		//静态OrganizationUtil.getCurrUserId()方法,静态FilesUtil.saveFiles(files)方法
		Mockito.doReturn(author).when(authorDao).queryAuthorById(authorId);
		Mockito.doNothing().when(bookDao).saveBook((TBook) Mockito.anyObject());
		
		//要用到PowerMockito
		PowerMockito.mockStatic(OrganizationUtil.class);
		PowerMockito.when(OrganizationUtil.getCurrUserId()).thenReturn(userId);
		//模拟静态的 void 方法
		PowerMockito.mockStatic(FilesUtil.class);
		PowerMockito.doNothing().when(FilesUtil.class, "saveFiles", Mockito.anyList());
		
		//构造测试类
		IBookService bookService = new BookServiceImpl();
		
		//将模拟的对象注入到构造的测试类中
		ReflectionTestUtils.setField(bookService, "bookDao", bookDao);
		ReflectionTestUtils.setField(bookService, "authorDao", authorDao);
		
		//执行
		String id = bookService.saveBook_D(book, authorId, files);

		//断言id
		Assert.assertEquals("32wei", id);
		//断言断言保存的值
		Assert.assertEquals("32wei", book.getId());
		Assert.assertEquals("活着", book.getName());
		Assert.assertEquals(author.getName(), book.getAuthor());
		Assert.assertEquals(userId, book.getUser());
		Assert.assertTrue(220 == book.getPage());
		Assert.assertTrue(50.02 == book.getPrice());
	}
}
