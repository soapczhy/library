package com.czhy.lms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.czhy.lms.dao.Imanager_dao;
import com.czhy.lms.pojo.Manager;
import com.czhy.lms.pojo.User;
import com.czhy.lms.service.imfc.Imanager_service;

@Service
public class Manager_service implements Imanager_service {
	@Autowired
	private Imanager_dao manager_dao;// 注入永久层接口
	@Autowired
	private User user;// 注入当前使用者信息

// 检查登陆信息
	public String check_login(Model model, Manager manager) {
		Manager check_manager = manager_dao.manager_check(manager);// 获取查询到的信息
		if (check_manager == null) {// 如果没有查询到
			model.addAttribute("redirect", "登陆，该用户不存在或密码错误");// 返回错误信息
			return "Reader_redirect";// 返回重定向页面
		}
		return this.success_login(manager, model);// 如果查询到，调用自身登陆成功方法
	}

// 登陆成功，注册管理员信息，跳转登陆成功页面
	private String success_login(Manager manager, Model model) {
		user.setUser_name(manager.getManager_name());// 设置使用者的昵称
		user.setUser_competence("manager");// 设置使用者的权限
		model.addAttribute("user", user);// 向表现层返回使用者
		return "manager/success_login";// 返回登陆成功页面
	}

// 清空登陆信息
	public String manager_exit() {
		user.setUser_competence(null);// 清空使用者权限
		user.setUser_name(null);// 清空使用者昵称
		user.setUser_history(null);
		return null;
	}
}
