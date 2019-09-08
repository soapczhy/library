package com.czhy.lms.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.czhy.lms.pojo.Book;
import com.czhy.lms.pojo.User;
import com.czhy.lms.service.imfc.Ibook_service;

//有关书籍操作的控制器
@Controller
@RequestMapping("/Book_controller")
public class Book_controller {
	@Autowired
	private Ibook_service book_service;// 注入书籍操作的服务层
	@Autowired
	private User user;// 注入当前使用者信息

// 查找所有书籍(跳转,无法重定向)
	@RequestMapping("/book_findall")
	public String book_findAll(Model model) {
		book_service.book_findall(model);// 调用服务层查询所有方法
		model.addAttribute("user", user);// 向表现层返回当前使用者
		return "book/book_findall";// 结果返回到book_findall页面
	}

// 查找书籍详细信息(跳转,无法重定向)
	@RequestMapping("/find_book_message")
	public String find_book_message(Model model, Book book) {
		book_service.find_book_message(model, book);// 调用服务层详细查询方法
		model.addAttribute("user", user);// 向表现层返回使用者
		return "book/book_message";// 结果返回到book_message页面
	};

// 模糊查询图书(跳转,无法重定向)
	@RequestMapping("/book_findone")
	public String book_findone(Model model, Book book) {
		book_service.book_findone(model, book);// 调用服务层模糊查询方法
		model.addAttribute("user", user);// 向表现层返回当前使用者
		return "book/book_findone";// 结果返回到book_findone页面
	}

//删除图书(已完成)
	@RequestMapping("/book_delete")
	public String book_delete(Model model, Book book) {
		book_service.book_delete(model, book);// 向服务层请求删除图书
		model.addAttribute("redirect", "删除图书成功");// 返回重定向信息
		return "Book_redirect";// 返回到重定向页面
	}

//跳转添加图书页面(跳转,无法重定向)
	@RequestMapping("/tobook_add")
	public String tobook_add() {
		return "book/book_add";
	}

//添加图书(已完成)
	@RequestMapping("/book_add")
	public String book_add(Model model, Book book) {
		book_service.book_add(model, book);
		return "Book_redirect";// 信息返回至重定向页面
	}

//跳转编辑图书(跳转,无法重定向)(从前端book_message页面的编辑图书按钮获取book_id)
	@RequestMapping("/book_edit")
	public String book_edit(Model model, Book book) {
		book_service.book_edit(model, book);
		return "book/book_edit";
	}

//更新图书信息(已完成)
	@RequestMapping("/book_update")
	public String book_update(Model model, Book book) {
		book_service.book_update(model, book);
		return "Book_redirect";// 信息返回至重定向页面
	}

}
