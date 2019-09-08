package com.czhy.lms.pojo;

//Book类
public class Book {
	private Integer book_id;// 书籍识别码
	private String book_picture_address;// 书籍图片地址
	private String book_synopsis;// 书籍简介
	private String book_name;// 书名
	private String book_author;// 作者
	private String book_type;// 类型
	private String book_price;// 价格
	private String book_number;// 余量

	public Integer getBook_id() {
		return book_id;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}

	public String getBook_picture_address() {
		return book_picture_address;
	}

	public void setBook_picture_address(String book_picture_address) {
		this.book_picture_address = book_picture_address;
	}

	public String getBook_synopsis() {
		return book_synopsis;
	}

	public void setBook_synopsis(String book_synopsis) {
		this.book_synopsis = book_synopsis;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public String getBook_type() {
		return book_type;
	}

	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}

	public String getBook_price() {
		return book_price;
	}

	public void setBook_price(String book_price) {
		this.book_price = book_price;
	}

	public String getBook_number() {
		return book_number;
	}

	public void setBook_number(String book_number) {
		this.book_number = book_number;
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_picture_address=" + book_picture_address + ", book_synopsis="
				+ book_synopsis + ", book_name=" + book_name + ", book_author=" + book_author + ", book_type="
				+ book_type + ", book_price=" + book_price + ", book_number=" + book_number + ", getBook_id()="
				+ getBook_id() + ", getBook_picture_address()=" + getBook_picture_address() + ", getBook_synopsis()="
				+ getBook_synopsis() + ", getBook_name()=" + getBook_name() + ", getBook_author()=" + getBook_author()
				+ ", getBook_type()=" + getBook_type() + ", getBook_price()=" + getBook_price() + ", getBook_number()="
				+ getBook_number() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
