package com.two.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.two.bean.TAuthor;
import com.two.bean.TBook;
import com.two.dao.IAuthorDao;
import com.two.dao.IBookDao;
import com.two.service.IAuthorService;
import com.two.service.IBookService;
import com.two.utils.FilesUtil;
import com.two.utils.OrganizationUtil;

/**
 * 
 * @author aran
 *
 */
@Service
public class BookServiceImpl implements IBookService{

	@Autowired
	private IBookDao bookDao;
	@Autowired
	private IAuthorDao authorDao;
	@Autowired
	private IAuthorService authorService;
	/**
	 * dao模拟
	 * bookDao.saveBook(book);
	 */
	@Override
	public String saveBook_A(TBook book) {
		if(book.getPrice() == null){
			book.setPrice(0d);
		}
		bookDao.saveBook(book);
		return book.getId();
	}
	/**
	 * 内部dao获取的对象模拟
	 * TAuthor author = authorDao.queryAuthorById(authorId);
	 */
	@Override
	public String saveBook_B(TBook book, String authorId) {
		TAuthor author = authorDao.queryAuthorById(authorId);
		
		book.setAuthor(author.getName());
		if(book.getPrice() == null){
			book.setPrice(0d);
		}
		
		bookDao.saveBook(book);
		
		return book.getId();
	}
	/**
	 * 测试调用静态方法，比如静态方法获取的是session的内容，
	 * 但是测试的时候获取不到session里的内容
	 * String userId = OrganizationUtil.getCurrUserId();
	 */
	@Override
	public String saveBook_C(TBook book, String authorId) {
		TAuthor author = authorDao.queryAuthorById(authorId);
		book.setAuthor(author.getName());
		
		if(book.getPrice() == 0){
			book.setPrice(null);
		}
		
		String userId = OrganizationUtil.getCurrUserId();
		book.setUser(userId);
		
		bookDao.saveBook(book);
		
		return book.getId();
	}

	@Override
	public String saveBook_D(TBook book, String authorId, List<File> files) {
		TAuthor author = authorDao.queryAuthorById(authorId);
		book.setAuthor(author.getName());
		
		if(book.getPrice() == null){
			book.setPrice(0d);
		}
		
		String userId = OrganizationUtil.getCurrUserId();
		book.setUser(userId);
		
		bookDao.saveBook(book);
		
		FilesUtil.saveFiles(files);
		
		return book.getId();
	}

	@Override
	public String saveBook_E(TBook book, String authorId, List<File> files) {
		Date date = new Date();
		TAuthor author = authorDao.queryAuthorByIdAndDate(authorId, date);
		book.setAuthor(author.getName());
		
		if(book.getPrice() == 0){
			book.setPrice(null);
		}
		
		String userId = OrganizationUtil.getCurrUserId();
		book.setUser(userId);
		
		bookDao.saveBook(book);
		
		FilesUtil.saveFiles(files);
		
		return book.getId();
	}

	@Override
	public String saveBook_F(TBook book, String authorId, List<File> files){
		Date date = new Date();
		TAuthor author = authorDao.queryAuthorByIdAndDate(authorId, date);
		book.setAuthor(author.getName());
		
		if(book.getPrice() == 0){
			book.setPrice(null);
		}
		
		int p = 1000 / book.getPage();
		book.setPage(p);
		
		String userId = OrganizationUtil.getCurrUserId();
		book.setUser(userId);
		
		bookDao.saveBook(book);
		
		FilesUtil.saveFiles(files);
		
		return book.getId();
	}

	@Override
	public String saveBook_G(TBook book, String authorId, List<File> files) {
		Date date = new Date();
		TAuthor author = authorDao.queryAuthorByIdAndDate(authorId, date);
		book.setAuthor(author.getName());
		
		if(book.getPrice() == null){
			book.setPrice(0d);
		}
		
		String userId = OrganizationUtil.getCurrUserId();
		book.setUser(userId);
		
		bookDao.saveBook(book);
		
		authorService.saveAuthor(author);
		
		FilesUtil.saveFiles(files);
		
		return book.getId();
	}

}
