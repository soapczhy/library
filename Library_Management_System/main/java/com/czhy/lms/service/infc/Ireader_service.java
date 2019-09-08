package com.czhy.lms.service.imfc;

import org.springframework.ui.Model;

import com.czhy.lms.pojo.History;
import com.czhy.lms.pojo.Reader;
import com.czhy.lms.pojo.User;

//读者服务层接口
public interface Ireader_service {

	public String regist_in(Model model, Reader reader);// 注册读者

	public String check_login(Model model, Reader reader);// 验证登陆

	public String reader_findall(Model model);// 查询所有用户

	public String reader_exit();// 清空用户信息

	public String reader_delete(Model model, Reader reader);// 删除读者

	public String reader_update(Model model, Reader reader);// 更新读者

	public String reader_findbyid(Model model, Reader reader);// id查找

	public String reader_findall_history(Model model, User user);// 查询所有借阅历史

	public String history_add(Model model, History history);// 添加借书历史

	public String reader_returnbook(Model model, History history);// 归还图书
}
