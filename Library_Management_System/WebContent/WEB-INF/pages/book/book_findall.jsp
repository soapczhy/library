<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="com.czhy.lms.pojo.*"%>
<!DOCTYPE html>
<html>
<head>
<!-- 想要进入此页面的控制器必须返回一个名为“user”的user对象 -->
<%
	User user = (User)request.getAttribute("user");
%>
<meta charset="UTF-8">
<title>findall</title>
</head>
<body>
<form action="../Book_controller/book_findone" method="post">
输入书名：<input type="text" name="book_name">
<input type="submit" value="查询">
<%
if("reader".equals(user.getUser_competence())){
	%>
	<a href="../Reader_controller/reader_index">返回我的主页<br></a>
	<% 
}
if("manager".equals(user.getUser_competence())){
	%>
	<input type="button" value="添加图书" onclick="window.location.href='../Book_controller/tobook_add'">
	<a href="../Manager_controller/manager_index">返回管理主页<br></a>
	<%
}
if(user.getUser_competence()==null){
	%>
	<a href="../">返回主页<br></a>
	<%
}
%>
</form>
  <%
  	List<Book> list = (List<Book>)request.getAttribute("list");
       Iterator<Book> it = list.listIterator();
       while(it.hasNext()){
      	 Book this_book = it.next();
      	 out.print("ID:"+this_book.getBook_id());
  %>
    	 书名：<a href="../Book_controller/find_book_message?book_id=<%=this_book.getBook_id()%>"><%out.print(this_book.getBook_name()); %><br></a>
    	 <% 
     }
  %>
</body>
</html>