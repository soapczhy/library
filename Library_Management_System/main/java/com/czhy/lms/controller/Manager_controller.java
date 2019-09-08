package com.czhy.lms.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.czhy.lms.pojo.Manager;
import com.czhy.lms.pojo.User;
import com.czhy.lms.service.imfc.Imanager_service;

//有关管理员操作的控制器
@Controller
@RequestMapping("/Manager_controller") // 跳转至管理员登陆界面
public class Manager_controller {
	@Autowired // 注入服务层接口
	private Imanager_service newmanager_service;
	@Autowired // 注入当前使用者信息
	private User user;

//跳转管理员登陆界面(跳转，无法重定向)
	@RequestMapping("/manager_login")
	public String login() {
		return "manager/manager_login";// 跳转到manager_login页面
	}

//检查登陆信息(已完成)
	@RequestMapping("/check_login")
	public String check_login(Model model, Manager manager) {
		return newmanager_service.check_login(model, manager);// 调用服务层验证方法，根据返回的结果跳转页面
	}

//跳转到管理员主界面(跳转，无法重定向)
	@RequestMapping("/manager_index")
	public String manager_index(Model model) {
		model.addAttribute("user", user);// 返回当前使用者信息
		return "manager/manager_index";// 跳转到manager_index页面
	}

//清空登陆信息(没有重定向的必要)
	@RequestMapping("/manager_exit")
	public String manager_exit() {
		newmanager_service.manager_exit();// 调用服务层方法清空当前使用者信息
		return "index";// 返回到主界面
	}
}
