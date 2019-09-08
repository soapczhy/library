<%@page import="org.apache.ibatis.jdbc.Null"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="com.czhy.lms.pojo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	User user = (User)request.getAttribute("user");
%>
<meta charset="UTF-8">
<title>详细信息</title>
</head>
<body>
<a href="../Book_controller/book_findall">返回上一级<br></a>
<%
Book book = (Book)request.getAttribute("book");
out.print("书名："+book.getBook_name());
%><br>
<% out.print("作者："+book.getBook_author());%><br> 
<%out.print("价格："+book.getBook_price());%><br>
<% out.print("简介："+book.getBook_synopsis());%><br>
<% out.print("类型："+book.getBook_type());%><br>
<% out.print("余量："+book.getBook_number());%><br>

<%if("manager".equals(user.getUser_competence())){%>
	<input type="button" value="删除图书" onclick="window.location.href='../Book_controller/book_delete?book_id=<%=book.getBook_id()%>'">
	<input type="button" value="编辑图书" onclick="window.location.href='../Book_controller/book_edit?book_id=<%=book.getBook_id()%>'">
<%}
if("reader".equals(user.getUser_competence())){%>
<form action="../Reader_controller/reader_borrow" method="post">
<input type="hidden" name="mybook_id" value=<%=book.getBook_id()%>>
<input type="submit" value="借阅图书" >
</form>
<%}
if(user.getUser_competence()==null){%>
	<input type="button" value="借阅图书" onclick="window.location.href='../Reader_controller/reader_login'">
<%}%>

</body>
</html>