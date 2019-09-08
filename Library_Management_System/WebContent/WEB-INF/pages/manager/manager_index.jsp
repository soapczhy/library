<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    import="com.czhy.lms.pojo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	User user=(User)request.getAttribute("user");
%>
<title>管理员主页</title>
</head>
<body>
管理员操作主界面
<input type="button" value="所有图书" onclick="window.location.href='../Book_controller/book_findall'">
<input type="button" value="管理读者" onclick="window.location.href='../Reader_controller/reader_findall'">
<input type="button" value="退出登陆" onclick="window.location.href='../Manager_controller/manager_exit'">
<br><%
out.println("欢迎你，管理员"+user.getUser_name());
%>
</body>
</html>