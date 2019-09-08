package com.czhy.lms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.czhy.lms.pojo.History;
import com.czhy.lms.pojo.Reader;
import com.czhy.lms.pojo.User;

@Repository
public interface Ireader_dao {
	// 注册读者信息
	@Insert("Insert into reader(reader_name,reader_password,reader_history) values (#{reader_name},#{reader_password},#{reader_history})")
	public void reader_save(Reader reader);

	// 验证查找读者信息
	@Select("Select * from reader where reader_name=#{reader_name} and reader_password=#{reader_password}")
	public Reader reader_check(Reader reader);

	// 查询所有读者信息
	@Select("Select * from reader")
	public List<Reader> reader_findall();

	// id查找读者信息
	@Select("Select * from reader where reader_id=#{reader_id}")
	public Reader reader_findbyid(Reader reader);

	// id删除读者
	@Select("Delete from reader where reader_id=#{reader_id}")
	public void reader_delete(Reader reader);

	// 更新读者信息
	@Select("Update reader set reader_name=#{reader_name},reader_password=#{reader_password} where reader_id=#{reader_id}")
	public void reader_update(Reader reader);

	// 匹配查找
	@Select("Select * from reader where reader_name=#{reader_name}")
	public Reader reader_findone(Reader reader);

	// 创建用户历史记录表
	@Update("create table ${reader_history} " + "(mybook_id INT(11)," + "mybook_name VARCHAR(50),"
			+ "history_id INT(11) AUTO_INCREMENT," + "return_time VARCHAR(50)," + "mybook_state VARCHAR(50),"
			+ "mybook_borrowtime VARCHAR(50)," + "mybook_returntime VARCHAR(50),PRIMARY KEY(history_id))"
			+ "CHARACTER SET utf8")
	public void reader_create_history(Reader reader);

	// 查询历史记录
	@Select("Select * from ${user_history}")
	public List<History> findall_history(User user);

	// 查询相同的用户名
	@Select("Select * from reader where reader_name = #{reader_name}")
	public List<Reader> reader_findsame(Reader reader);

	// 添加借书记录
	@Insert("insert into ${user_history}(mybook_id,mybook_name,mybook_borrowtime,mybook_returntime,mybook_state)value(#{mybook_id},#{mybook_name},#{mybook_borrowtime},#{mybook_returntime},#{mybook_state})")
	public void history_add(History history);

	// 归还图书，更改借书记录
	@Update("Update ${user_history} set mybook_state=#{mybook_state},return_time=#{return_time} where history_id=#{history_id}")
	public void history_updatestate(History history);

	// 图书数量+1
	@Update("Update book set book_number = ${book_number} where book_id=#{mybook_id}")
	public void return_book(History history);

	// 图书数量-1
	@Update("Update book set book_number = ${book_number} where book_id=#{mybook_id}")
	public void borrow_book(History history);

	// 获取借阅表中当前图书
	@Select("Select * from ${user_history} where mybook_id = #{mybook_id}")
	public List<History> book_history(History history);
}
