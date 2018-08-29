package com.two.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
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
 * expected = Exception.class 吃掉异常
 * @author aran
 *
 */

public class BookService_F_Test {
	@Test
	public void testSaveBook() throws Exception{
	}
}
