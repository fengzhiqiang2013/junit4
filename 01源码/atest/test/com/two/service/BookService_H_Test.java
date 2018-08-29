package com.two.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.first.CustomAnswer;
import com.first.PersonPrinterAnswer;
import com.two.bean.TAuthor;
import com.two.dao.IAuthorDao;
import com.two.dao.impl.AuthorDaoImpl;
import com.two.service.impl.AuthorServiceImpl;


public class BookService_H_Test {
	@Test
	public void testAnswer1(){
		List<String> mock = Mockito.mock(List.class);  
        Mockito.doAnswer(new CustomAnswer()).when(mock).get(Mockito.anyInt());  
        mock.get(4);
        mock.get(2);
	}
	@Test
	public void testAnswer2(){
		IAuthorDao authorDao = Mockito.mock(AuthorDaoImpl.class);
		
		PersonPrinterAnswer ppa = new PersonPrinterAnswer();
        Mockito.doAnswer(ppa).when(authorDao).saveAuthor((TAuthor)Mockito.anyObject());;  
        
        IAuthorService authorService = new AuthorServiceImpl();
        //将模拟的对象注入到构造的测试类中
        ReflectionTestUtils.setField(authorService, "authorDao", authorDao);
        
        TAuthor author = new TAuthor();
        author.setId("1111111111111");
        authorService.saveAuthor(author);
        
        TAuthor author2 = ppa.getTAuthor();
        Assert.assertEquals("1111111111111", author2.getId());
	}
}
