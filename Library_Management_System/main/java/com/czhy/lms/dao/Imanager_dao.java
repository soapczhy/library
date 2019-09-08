package com.czhy.lms.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.czhy.lms.pojo.Manager;

@Repository
public interface Imanager_dao {
	// 验证查找管理员信息
	@Select("Select * from manager where manager_name=#{manager_name} and manager_password=#{manager_password}")
	public Manager manager_check(Manager manager);
}
