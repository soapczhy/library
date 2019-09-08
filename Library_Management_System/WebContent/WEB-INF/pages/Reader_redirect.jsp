<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="com.czhy.lms.pojo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String redirect=(String)request.getAttribute("redirect");//获取转发来的重定向信息
Reader reader = (Reader)request.getAttribute("this_reader");//获取转发来的读者信息
//借阅成功后重定向到借阅记录
if("借阅成功".equals(redirect)){
	 %><script language="javascript">alert("借阅成功");window.location="../Reader_controller/reader_history"</script><% 
} 
//借阅失败后重定向到借阅记录
if("库存不足".equals(redirect)){
	 %><script language="javascript">alert("库存不足");window.location="../Reader_controller/reader_history"</script><% 
} 
if("请勿重复借阅".equals(redirect)){
	 %><script language="javascript">alert("请勿重复借阅");window.location="../Reader_controller/reader_history"</script><% 
} 
//注册失败后重定向到注册页面
if("注册，未输入用户名".equals(redirect)){
	 %><script language="javascript">alert("未输入用户名");window.location="../Reader_controller/reader_regist"</script><% 
}
if("注册，未输入密码".equals(redirect)){
	 %><script language="javascript">alert("未输入密码");window.location="../Reader_controller/reader_regist"</script><% 
}
if("注册，已存在的用户名".equals(redirect)){
	 %><script language="javascript">alert("已存在的用户名");window.location="../Reader_controller/reader_regist"</script><% 
}
//注册成功后重定向到登陆页面
if("注册成功".equals(redirect)){
	 %><script language="javascript">alert("注册成功，返回登陆页面");window.location="../Reader_controller/reader_login"</script><% 
}
//登陆失败后重定向到登陆页面
if("登陆，该用户不存在或密码错误".equals(redirect)){
	 %><script language="javascript">alert("该用户不存在或密码错误");window.location="../Reader_controller/reader_login"</script><% 
}
//删除成功后重定向到查询所有读者
if("删除读者成功".equals(redirect)){
	 %><script language="javascript">alert("删除读者成功");window.location="../Reader_controller/reader_findall"</script><% 
}
//更新读者信息失败后重定向到编辑读者
if("编辑读者，用户名或密码不能为空".equals(redirect)){
	 %><script language="javascript">alert("用户名或密码不能为空");window.location="../Reader_controller/reader_edit?reader_id=<%=reader.getReader_id()%>"</script><% 
}
if("编辑读者，已存在的用户名".equals(redirect)){
	 %><script language="javascript">alert("已存在的用户名");window.location="../Reader_controller/reader_edit?reader_id=<%=reader.getReader_id()%>"</script><% 
}
//更新读者信息成功后重定向到查询所有读者
if("编辑读者，修改成功".equals(redirect)){
	 %><script language="javascript">alert("修改成功");window.location="../Reader_controller/reader_findall"</script><% 
}
//归还图书成功后重定向到查询所有历史记录
if("归还图书".equals(redirect)){
	 %><script language="javascript">alert("归还成功");window.location="../Reader_controller/reader_history"</script><% 
}
%>


</body>
</html>