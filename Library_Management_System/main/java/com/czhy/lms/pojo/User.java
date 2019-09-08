package com.czhy.lms.pojo;

import org.springframework.stereotype.Service;

//当前使用者类
@Service
public class User {
	private String user_name = null;;
	private String user_competence = null;
	private String user_history = null;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_competence() {
		return user_competence;
	}

	public void setUser_competence(String user_competence) {
		this.user_competence = user_competence;
	}

	public String getUser_history() {
		return user_history;
	}

	public void setUser_history(String user_history) {
		this.user_history = user_history;
	}

	@Override
	public String toString() {
		return "User [user_name=" + user_name + ", user_competence=" + user_competence + ", user_history="
				+ user_history + "]";
	}

}
