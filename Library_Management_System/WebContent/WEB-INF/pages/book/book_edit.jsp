<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="com.czhy.lms.pojo.*"%>
<!DOCTYPE html>
<html>
<head>
<%
	Book this_book = (Book)request.getAttribute("this_book");
%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <a href="../Book_controller/book_findall">返回目录</a>
<form action="../Book_controller/book_update" method="post">
书名：<input type="text" name="book_name" value=<%=this_book.getBook_name() %>><br>
简介：<input type="text" name="book_synopsis" value=<%=this_book.getBook_synopsis() %>><br>
作者：<input type="text" name="book_author" value=<%=this_book.getBook_author() %>><br>
价格：<input type="text" name="book_price" value=<%=this_book.getBook_price() %>><br>
类型：<input type="text" name="book_type" value=<%=this_book.getBook_type() %>><br>
余量：<input type="text" name="book_number" value=<%=this_book.getBook_number() %>><br>
<input type="hidden" name="book_id" value=<%=this_book.getBook_id()%>><br>
<input type="submit" value="保存">
</form>
</body>
</html>