package com.czhy.lms.service.imfc;

import org.springframework.ui.Model;

import com.czhy.lms.pojo.Manager;

//管理员服务层接口
public interface Imanager_service {

	public String check_login(Model model, Manager manager);// 检查登录信息

	public String manager_exit();// 退出登陆
}
