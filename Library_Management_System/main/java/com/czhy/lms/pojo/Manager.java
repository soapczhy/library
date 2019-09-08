package com.czhy.lms.pojo;

public class Manager {
	private String manager_name;// 管理者账号
	private String manager_password;// 管理者密码

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	public String getManager_password() {
		return manager_password;
	}

	public void setManager_password(String manager_password) {
		this.manager_password = manager_password;
	}

	@Override
	public String toString() {
		return "manager [manager_name=" + manager_name + ", manager_password=" + manager_password + "]";
	}

}
