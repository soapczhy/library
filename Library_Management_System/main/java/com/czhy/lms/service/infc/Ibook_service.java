package com.czhy.lms.service.imfc;

import org.springframework.ui.Model;

import com.czhy.lms.pojo.Book;

//书籍服务层接口
public interface Ibook_service {
	public String book_findall(Model model);// 查询所有书籍

	public String book_findone(Model model, Book book);// 模糊查询书籍

	public String find_book_message(Model model, Book book);// 查询书籍信息

	public String book_delete(Model model, Book book);// 删除图书

	public String book_add(Model model, Book book);// 添加图书

	public String book_edit(Model model, Book book);// 跳转编辑图书页面

	public String book_update(Model model, Book book);// 更新图书信息

}
