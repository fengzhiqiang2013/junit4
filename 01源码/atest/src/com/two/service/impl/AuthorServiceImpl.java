package com.two.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.two.bean.TAuthor;
import com.two.dao.IAuthorDao;
import com.two.service.IAuthorService;

/**
 * 
 * @author aran
 *
 */
@Service
public class AuthorServiceImpl implements IAuthorService{

	@Autowired
	private IAuthorDao authorDao;
	
	@Override
	public void saveAuthor(TAuthor author) {
		Integer co = author.getCount();
		if (co == null) {
			co = 1;
		} else {
			co = co + 1;
		}
		author.setCount(co);
		authorDao.saveAuthor(author);
	}
}
