package com.czhy.lms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.czhy.lms.pojo.Book;

@Repository
public interface Ibook_dao {
	// 查询所有书籍
	@Select("select * from book")
	public List<Book> book_findall();

	// id查询
	@Select("select * from book where book_id = #{book_id}")
	public Book findbyid(Book book);

	// 模糊查询书籍
	@Select("SELECT * FROM book where book_name LIKE #{book_name}")
	public List<Book> book_findones(Book book);

	// 删除图书
	@Delete("delete from book where book_id = #{book_id}")
	public void book_delete(Book book);

	// 添加图书
	@Insert("insert into book(book_name,book_synopsis,book_author,book_price,book_type,book_number) values (#{book_name},#{book_synopsis},#{book_author},#{book_price},#{book_type},#{book_number})")
	public void book_add(Book book);

	// 修改图书
	@Update("update book set book_name=#{book_name},book_author=#{book_author},book_type=#{book_type},book_synopsis=#{book_synopsis},book_price=#{book_price},book_number=#{book_number} where book_id=#{book_id}")
	public void book_update(Book book);

	// 查询相同
	@Select("Select * from book where book_name = #{book_name}")
	public List<Book> book_findsame(Book book);

}
