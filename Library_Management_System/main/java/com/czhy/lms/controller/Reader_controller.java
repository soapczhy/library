package com.czhy.lms.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.czhy.lms.pojo.History;
import com.czhy.lms.pojo.Reader;
import com.czhy.lms.pojo.User;
import com.czhy.lms.service.imfc.Ireader_service;

//有关读者操作的控制器
@Controller
@RequestMapping("/Reader_controller")

public class Reader_controller {
	@Autowired // 注入读者操作的服务层
	private Ireader_service reader_servic;

	@Autowired
	private User user;

// 跳转至读者登录界面(跳转，无法重定向)
	@RequestMapping("/reader_login")
	public String login() {
		return "reader/reader_login";// 返回到reader_login页面
	}

// 跳转至注册界面(跳转，无法重定向)
	@RequestMapping("/reader_regist")
	public String regist() {
		return "reader/reader_regist";// 返回到reader_regist页面
	}

// 封装注册信息，请求服务层操作(已完成)
	@RequestMapping("/reader_regist_in")
	public String regist_in(Reader reader, Model model) {
		reader_servic.regist_in(model, reader);
		return "Reader_redirect";// 返回重定向页面
	}

// 验证登录信息，请求服务层操作(已完成)
	@RequestMapping("/check_login")
	public String check_loggin(Reader reader, Model model) {
		return reader_servic.check_login(model, reader);
	}

// 跳转到用户主操作界面(跳转，无法重定向)
	@RequestMapping("/reader_index")
	public String reader_index(Model model) {
		model.addAttribute("user", user);
		return "reader/reader_index";// 返回到reader_index页面
	}

// 查询所有用户(跳转，无法重定向)
	@RequestMapping("/reader_findall")
	public String reader_findall(Model model) {
		reader_servic.reader_findall(model);
		model.addAttribute("user", user);
		return "reader/reader_findall";
	}

// 用户退出登陆(没有重定向的必要)
	@RequestMapping("/reader_exit")
	public String reader_exit() {
		reader_servic.reader_exit();// 调用服务层方法，清空登陆信息
		return "index";// 返回主界面
	}

//删除用户(已完成)
	@RequestMapping("/reader_delete")
	public String reader_delete(Model model, Reader reader) {
		reader_servic.reader_delete(model, reader);
		return "Reader_redirect";// 返回重定向页面
	}

//跳转编辑用户(跳转，无法重定向)
	@RequestMapping("/reader_edit")
	public String reader_edit(Model model, Reader reader) {
		reader_servic.reader_findbyid(model, reader);
		return "reader/reader_edit";
	}

//更新用户(已完成)
	@RequestMapping("/reader_update")
	public String reader_update(Model model, Reader reader) {
		reader_servic.reader_update(model, reader);
		return "Reader_redirect";// 返回重定向页面
	}

//跳转借阅历史(跳转，无法重定向)
	@RequestMapping("/reader_history")
	public String reader_history(Model model, User user) {
		reader_servic.reader_findall_history(model, user);
		return "reader/reader_history";
	}

// 借阅图书(已完成)
	@RequestMapping("/reader_borrow")
	public String reader_borrow(Model model, History history) {
		reader_servic.history_add(model, history);// 添加历史记录
		return "Reader_redirect";// 返回重定向页面
	}

//归还图书(已完成)
	@RequestMapping("/reader_returnbook")
	public String reader_returnbook(Model model, History history) {
		// 图书库存+1
		// 改变读者历史记录表，图书状态设置已归还
		reader_servic.reader_returnbook(model, history);
		model.addAttribute("redirect", "归还图书");
		return "Reader_redirect";
	}
}
