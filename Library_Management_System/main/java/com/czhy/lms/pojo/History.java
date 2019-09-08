package com.czhy.lms.pojo;

public class History {
	// 书籍信息
	private Integer mybook_id;// 书籍识别码
	private String mybook_name;// 书名
	private String book_number;// 书籍余量
	// 记录信息
	private Integer history_id;// 历史记录识别码
	private String mybook_state;// 状态
	private String mybook_borrowtime;// 借出时间
	private String mybook_returntime;// 归还期限
	private String return_time;// 归还时间
	// 使用者信息
	private String user_history;// 当前使用者的历史表名

	public String getReturn_time() {
		return return_time;
	}

	public void setReturn_time(String return_time) {
		this.return_time = return_time;
	}

	public Integer getMybook_id() {
		return mybook_id;
	}

	public void setMybook_id(Integer mybook_id) {
		this.mybook_id = mybook_id;
	}

	public String getMybook_name() {
		return mybook_name;
	}

	public void setMybook_name(String mybook_name) {
		this.mybook_name = mybook_name;
	}

	public String getMybook_state() {
		return mybook_state;
	}

	public void setMybook_state(String mybook_state) {
		this.mybook_state = mybook_state;
	}

	public String getMybook_borrowtime() {
		return mybook_borrowtime;
	}

	public void setMybook_borrowtime(String mybook_borrowtime) {
		this.mybook_borrowtime = mybook_borrowtime;
	}

	public String getMybook_returntime() {
		return mybook_returntime;
	}

	public void setMybook_returntime(String mybook_returntime) {
		this.mybook_returntime = mybook_returntime;
	}

	public String getUser_history() {
		return user_history;
	}

	public void setUser_history(String user_history) {
		this.user_history = user_history;
	}

	public String getBook_number() {
		return book_number;
	}

	public void setBook_number(String book_number) {
		this.book_number = book_number;
	}

	public Integer getHistory_id() {
		return history_id;
	}

	public void setHistory_id(Integer history_id) {
		this.history_id = history_id;
	}

	@Override
	public String toString() {
		return "History [history_id=" + history_id + ", mybook_id=" + mybook_id + ", mybook_name=" + mybook_name
				+ ", mybook_state=" + mybook_state + ", mybook_borrowtime=" + mybook_borrowtime + ", mybook_returntime="
				+ mybook_returntime + ", user_history=" + user_history + ", book_number=" + book_number
				+ ", return_time=" + return_time + "]";
	}

}
