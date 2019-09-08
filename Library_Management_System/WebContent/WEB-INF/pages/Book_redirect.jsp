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
Book book = (Book)request.getAttribute("this_book");//获取转发来的书籍信息
//删除图书成功后重定向到查询所有图书
 if("删除图书成功".equals(redirect)){
	 %><script language="javascript">alert("删除图书成功");window.location="../Book_controller/book_findall"</script><% 
 }
//更新图书失败后重定向到编辑图书页面
 if("更新书籍，信息不完整，请重新添加".equals(redirect)){
	 %><script language="javascript">alert("信息不完整，请重新添加");window.location="../Book_controller/book_edit?book_id=<%=book.getBook_id()%>"</script><%
 }
 if("更新书籍，价格请输入数字".equals(redirect)){
	 %><script language="javascript">alert("价格请输入数字");window.location="../Book_controller/book_edit?book_id=<%=book.getBook_id()%>"</script><% 
 }
 if("更新书籍，已存在的图书名".equals(redirect)){
	 %><script language="javascript">alert("已存在的图书名");window.location="../Book_controller/book_edit?book_id=<%=book.getBook_id()%>"</script><% 
 }
 //更新图书成功后重定向到查询所有图书
 if("修改图书成功".equals(redirect)){
	 %><script language="javascript">alert("修改图书成功");window.location="../Book_controller/book_findall"</script><% 
 }
 //添加图书失败后重定向到添加图书页面
 if("添加书籍，信息不完整，请重新添加".equals(redirect)){
	 %><script language="javascript">alert("信息不完整，请重新添加");window.location="../Book_controller/tobook_add"</script><% 
 }
 if("添加书籍，书籍已存在,请勿重复添加".equals(redirect)){
	 %><script language="javascript">alert("书籍已存在,请勿重复添加");window.location="../Book_controller/tobook_add"</script><% 
 }
 if("添加书籍，价格请输入数字".equals(redirect)){
	 %><script language="javascript">alert("价格请输入数字");window.location="../Book_controller/tobook_add"</script><% 
 }
 //添加图书成功后重定向到查询所有图书
 if("添加书籍成功".equals(redirect)){
	 %><script language="javascript">alert("书籍添加成功");window.location="../Book_controller/book_findall"</script><% 
 }
%>
</body>
</html>