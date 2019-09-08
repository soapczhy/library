package com.czhy.lms.service.impl;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.czhy.lms.dao.Ibook_dao;
import com.czhy.lms.dao.Ireader_dao;
import com.czhy.lms.pojo.Book;
import com.czhy.lms.pojo.History;
import com.czhy.lms.pojo.Reader;
import com.czhy.lms.pojo.User;
import com.czhy.lms.service.imfc.Ireader_service;

@Service
public class Reader_service implements Ireader_service {
	@Autowired
	private Ireader_dao reader_dao;// 注入永久层接口
	@Autowired
	private User user;// 注入当前使用者信息
	@Autowired
	private Ibook_dao book_dao;//

// 注册读者信息
	public String regist_in(Model model, Reader reader) {
// 检测用户名是否输入为空
		if ("".equals(reader.getReader_name())) {
			model.addAttribute("redirect", "注册，未输入用户名");
			return null;
		}
// 检测密码是否输入为空
		if ("".equals(reader.getReader_password())) {
			model.addAttribute("redirect", "注册，未输入密码");
			return null;
		}
// 检测用户名是否已经存在，并注册用户。
		Reader find_reader = reader_dao.reader_findone(reader);
		if (find_reader != null) {
			model.addAttribute("redirect", "注册，已存在的用户名");
			return null;
		}
		reader.setReader_history(reader.getReader_name() + "_history");
		reader_dao.reader_save(reader);// 保存用户至数据库
		reader_dao.reader_create_history(reader);// 创建用户历史记录表
		model.addAttribute("redirect", "注册成功");
		return null;
	}

// 检查登陆信息
	public String check_login(Model model, Reader reader) {
		Reader check_reade = reader_dao.reader_check(reader);
		if (check_reade == null) { // 如果没有查询到读者表中的读者信息
			model.addAttribute("redirect", "登陆，该用户不存在或密码错误"); // 就返回错误信息
			return "Reader_redirect"; // 返回信息到重定向
		}
		return this.success_login(reader, model); // 调用登陆成功方法
	}

//(跳转，无法重定向)
	private String success_login(Reader reader, Model model) {
		user.setUser_name(reader.getReader_name());// 注册当前使用者的昵称
		user.setUser_competence("reader");// 注册当前使用者的权限
		user.setUser_history(reader_dao.reader_findone(reader).getReader_history());// 获得当前用户历史借阅表名称
		model.addAttribute("user", user);// 返回当前使用者
		return "reader/success_login";// 返回登陆成功界面
	}

//查询所有读者信息
	public String reader_findall(Model model) {
		List<Reader> list = reader_dao.reader_findall();// 调用永久层方法获取读者信息
		model.addAttribute("list", list);// 返回读者信息到表现层
		return null;
	}

//退出登陆
	public String reader_exit() {
		user.setUser_competence(null);// 清空权限
		user.setUser_name(null);// 清空昵称
		user.setUser_history(null);// 清空借阅信息
		return null;
	}

//删除读者
	public String reader_delete(Model model, Reader reader) {
		reader_dao.reader_delete(reader);// 调用持久层接口删除读者
		model.addAttribute("redirect", "删除读者成功");// 返回重定向信息
		return null;
	}

//更新读者
	public String reader_update(Model model, Reader reader) {
		if (reader.getReader_name() == "" || reader.getReader_password() == "") {
			model.addAttribute("redirect", "编辑读者，用户名或密码不能为空");// 返回错误信息
			model.addAttribute("this_reader", reader_dao.reader_findbyid(reader));// 修改失败，返回当前书籍信息
			return null;
		}
		Reader oldreader = reader_dao.reader_findbyid(reader);// 保留修改前数据
		reader_dao.reader_update(reader);// 更新后再查询
		List<Reader> list = reader_dao.reader_findsame(reader);// 查询是否有相同用户
		if (list.size() == 2) {// 如果有
			reader_dao.reader_update(oldreader);// 撤销修改
			model.addAttribute("redirect", "编辑读者，已存在的用户名");// 返回错误信息
			model.addAttribute("this_reader", reader_dao.reader_findbyid(reader));// 修改失败，返回当前书籍信息
			return null;
		}
		model.addAttribute("redirect", "编辑读者，修改成功");
		return null;
	}

//id查找
	public String reader_findbyid(Model model, Reader reader) {
		model.addAttribute("this_reader", reader_dao.reader_findbyid(reader));
		return null;
	}

//查询所有借阅历史
	public String reader_findall_history(Model model, User user) {
		if ("manager".equals(this.user.getUser_competence()))// 如果管理员访问记录，使用接收到的user参数,接收到的user只有user_history参数
			model.addAttribute("list", reader_dao.findall_history(user));
		if ("reader".equals(this.user.getUser_competence()))// 如果读者访问记录，使用全局变量，访问自己的记录表
			model.addAttribute("list", reader_dao.findall_history(this.user));
		model.addAttribute("user", this.user);// 返回当前访问者
		return null;
	}

//借阅图书	(前端获取mybook_id)
	public String history_add(Model model, History history) {
		// 获取当前书籍信息
		Book book = new Book();// 创建Book对象
		book.setBook_id(history.getMybook_id());// 获取book_id
		book = book_dao.findbyid(book);// 获取Book对象
		// 余量不足，借阅失败
		int number = Integer.valueOf(book.getBook_number());// 获取余量
		if (number == 0) {
			model.addAttribute("redirect", "库存不足");
			return null;
		}
		// 重复借阅
		history.setUser_history(user.getUser_history());// 获取历史表名
		List<History> list = reader_dao.book_history(history);// 查询当前书籍所有历史记录
		Iterator<History> it = list.listIterator();
		while (it.hasNext()) {
			History book_history = it.next();
			if ("未归还".equals(book_history.getMybook_state())) {// 如果有未归还的
				model.addAttribute("redirect", "请勿重复借阅");
				return null;
			}
		}
		// 借阅成功，添加历史表
		Calendar calendar = Calendar.getInstance();// 获取Calendar对象
		calendar.setTime(new Date());// 设置Calendar开始时间为当前时间
		calendar.add(Calendar.DATE, 25);// 设置借书期限
		history.setMybook_borrowtime(dateformat1().format(new Date()).toString());// 注入借出时间
		history.setMybook_returntime(dateformat2().format(calendar.getTime()).toString());// 注入归还时间
		history.setMybook_state("未归还");// 设置归还状态
		reader_dao.history_add(history);// 添加一条借书记录
		// 借阅成功，更改库存
		number--;// 余量-1
		history.setBook_number(String.valueOf(number));// 更改Book余量
		reader_dao.borrow_book(history);// 更改图书表
		model.addAttribute("redirect", "借阅成功");
		return null;
	}

//归还图书
	public String reader_returnbook(Model model, History history) {
		// 更改历史表
		history.setMybook_state("已归还");// 设置图书状态
		history.setReturn_time(dateformat1().format(new Date()).toString());// 注入归还时间
		history.setUser_history(user.getUser_history());// 获取历史表名
		reader_dao.history_updatestate(history);// 根据获取的历史条id更改历史表
		// 更新图书库
		Book book = new Book();// 创建Book对象
		book.setBook_id(history.getMybook_id());// 获取book_id
		book = book_dao.findbyid(book);// 获取Book对象
		int newnumber = Integer.valueOf(book.getBook_number()) + 1;// 余量+1
		history.setBook_number(String.valueOf(newnumber));// 更改Book余量
		reader_dao.return_book(history);// 更改图书表
		return null;
	}

//时间格式
	private DateFormat dateformat1() {
		return DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
	}

	private DateFormat dateformat2() {
		return DateFormat.getDateInstance(DateFormat.LONG);
	}
}
