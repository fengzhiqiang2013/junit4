package com.two.service;

import java.io.File;
import java.util.List;

import com.two.bean.TBook;

/**
 * 
 * @author aran
 *
 */
public interface IBookService {
	/**
	 * 保存book
	 * @param book
	 * @return
	 */
	public String saveBook_A(TBook book);
	/**
	 * 保存book
	 * @param book 书本bean
	 * @param authorId 作者id
	 * @return
	 */
	public String saveBook_B(TBook book, String authorId);
	
	/**
	 * 保存book 
	 * @param book 书本bean
	 * @param authorId 作者id
	 * @return
	 */
	public String saveBook_C(TBook book, String authorId);
	
	/**
	 * 保存book 
	 * @param book 书本bean
	 * @param authorId 作者id
	 * @param files 文件
	 * @return
	 */
	public String saveBook_D(TBook book, String authorId, List<File> files);
	
	/**
	 * 保存book 
	 * @param book 书本bean
	 * @param authorId 作者id
	 * @param files 文件
	 * @return
	 */
	public String saveBook_E(TBook book, String authorId, List<File> files);
	
	/**
	 * 保存book
	 * @param book
	 * @param authorId
	 * @param files
	 * @return
	 * @throws FileNotFoundException
	 * @throws StoreException
	 */
	public String saveBook_F(TBook book, String authorId, List<File> files);
	
	/**
	 * 保存book
	 * @param book
	 * @param authorId
	 * @param files
	 * @return
	 * @throws FileNotFoundException
	 * @throws StoreException
	 */
	public String saveBook_G(TBook book, String authorId, List<File> files);
	
}
