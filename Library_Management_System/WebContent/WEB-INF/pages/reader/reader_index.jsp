<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
读者操作主界面

<input type="button" value="所有图书" onclick="window.location.href='../Book_controller/book_findall'">
<input type="button" value="借阅记录" onclick="window.location.href='../Reader_controller/reader_history'">
<input type="button" value="退出登陆" onclick="window.location.href='../Reader_controller/reader_exit'">


</body>
</html>