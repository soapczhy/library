package com.czhy.lms.pojo;

//读者类
public class Reader {
	private String reader_name;// 读者账号
	private String reader_password;// 读者密码
	private Integer reader_id;// 读者识别码
	private String reader_history;// 读者历史记录表

	public String getReader_history() {
		return reader_history;
	}

	public void setReader_history(String reader_history) {
		this.reader_history = reader_history;
	}

	public String getReader_name() {
		return reader_name;
	}

	public Integer getReader_id() {
		return reader_id;
	}

	public void setReader_id(Integer reader_id) {
		this.reader_id = reader_id;
	}

	public void setReader_name(String reader_name) {
		this.reader_name = reader_name;
	}

	public String getReader_password() {
		return reader_password;
	}

	public void setReader_password(String reader_password) {
		this.reader_password = reader_password;
	}

	@Override
	public String toString() {
		return "reader [reader_name=" + reader_name + ", reader_password=" + reader_password + ", reader_id="
				+ reader_id + ", reader_history=" + reader_history + "]";
	}

}
