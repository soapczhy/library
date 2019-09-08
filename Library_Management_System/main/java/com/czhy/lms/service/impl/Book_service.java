package com.czhy.lms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.czhy.lms.dao.Ibook_dao;
import com.czhy.lms.pojo.Book;
import com.czhy.lms.service.imfc.Ibook_service;

@Service
public class Book_service implements Ibook_service {
	@Autowired
	private Ibook_dao book_dao;// 注入永久层接口

// 查询所有图书
	public String book_findall(Model model) {
		List<Book> list = book_dao.book_findall();// 调用永久层"查询所有书籍"方法
		model.addAttribute("list", list);// 向表现层返回"查询所有书籍"的结果
		return null;
	}

// 模糊查询图书
	public String book_findone(Model model, Book book) {
		String book_name = book.getBook_name();// 使用获得查询字段
		String find_book_name = "%" + book_name + "%";// 使用模糊查询
		book.setBook_name(find_book_name);// 重新设置查询字段
		List<Book> list = book_dao.book_findones(book);// 获得模糊查询结果
		model.addAttribute("list", list);// 向表现层返回模糊查询的结构
		return null;
	}

//查询书籍详细信息
	public String find_book_message(Model model, Book book) {
		model.addAttribute("book", book_dao.findbyid(book));// 向表现层返回详细查询结果
		return null;
	}

//删除图书
	public String book_delete(Model model, Book book) {
		book_dao.book_delete(book);// 调用持久层删除图书
		return null;
	}

//添加图书
	public String book_add(Model model, Book book) {
		if (book.getBook_author() == "" || book.getBook_name() == "" || book.getBook_price() == ""
				|| book.getBook_synopsis() == "" || book.getBook_type() == "" || book.getBook_number() == "") {
			model.addAttribute("redirect", "添加书籍，信息不完整，请重新添加");// 返回错误信息
			return null;
		}
		List list = book_dao.book_findsame(book);
		if (list.size() != 0) {
			model.addAttribute("redirect", "添加书籍，书籍已存在,请勿重复添加");// 返回错误信息
			return null;
		}
		if (isnumber(book)) {
			model.addAttribute("redirect", "添加书籍，价格请输入数字");// 返回错误信息
			return null;
		}
		book_dao.book_add(book);// 调用永久层方法保存输入的图书信息
		model.addAttribute("redirect", "添加书籍成功");// 返回成功信息
		return null;
	}

//跳转编辑图书
	public String book_edit(Model model, Book book) {
		Book this_book = book_dao.findbyid(book);// id查找书籍信息
		model.addAttribute("this_book", this_book);// 返回书籍信息
		return null;
	}

//更新图书信息
	public String book_update(Model model, Book book) {
		// 检测是否有输入为空
		if (book.getBook_author() == "" || book.getBook_name() == "" || book.getBook_price() == ""
				|| book.getBook_synopsis() == "" || book.getBook_type() == "") {
			model.addAttribute("this_book", book_dao.findbyid(book));// 修改失败，返回当前图书信息
			model.addAttribute("redirect", "更新书籍，信息不完整，请重新添加");// 返回错误信息
			return null;
		}
		// 检测价格是否输入了其他类型
		if (isnumber(book)) {
			model.addAttribute("this_book", book_dao.findbyid(book));// 修改失败，返回当前图书信息
			model.addAttribute("redirect", "更新书籍，价格请输入数字");// 返回错误信息
			return null;
		}
		Book oldbook = book_dao.findbyid(book);// 暂存当前书籍信息
		book_dao.book_update(book);// 更新书籍
		List<Book> list = book_dao.book_findsame(book);// 查询更新后持否存在两本书名相同的书
		if (list.size() == 2) {// 如果有
			book_dao.book_update(oldbook);// 撤回修改
			model.addAttribute("this_book", book_dao.findbyid(book));// 返回当前书籍信息
			model.addAttribute("redirect", "更新书籍，已存在的图书名");// 返回错误信息
			return null;
		}
		model.addAttribute("redirect", "修改图书成功");
		return null;
	}

//判断数字
	private boolean isnumber(Book book) {
		String price = book.getBook_price();
		char price_array[] = price.toCharArray();
		for (int i = 0; i < price_array.length; i++) {
			if (!(Character.isDigit(price_array[i])))
				return true;
		}
		return false;
	}

}
