package com.two.dao;

import java.util.Date;

import com.two.bean.TAuthor;

/**
 * 作者dao
 * @author aran
 *
 */
public interface IAuthorDao {
	/**
	 * 查询作者
	 * @param id
	 * @return
	 */
	public TAuthor queryAuthorById(String id);
	/**
	 * 查询作者
	 * @param id
	 * @param date
	 */
	public TAuthor queryAuthorByIdAndDate(String id, Date date);
	
	/**
	 * 保存作者
	 * @param author
	 */
	public void saveAuthor(TAuthor author);
}
