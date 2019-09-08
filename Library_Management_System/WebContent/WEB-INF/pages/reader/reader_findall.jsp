<%@page import="com.czhy.lms.pojo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<%
	User user = (User)request.getAttribute("user");
%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if("manager".equals(user.getUser_competence())){ %>
<a href="../Manager_controller/manager_index">返回管理主界面<br></a>
<a href="../Reader_controller/reader_regist">注册读者<br></a>
<%
	List<Reader> list = (List<Reader>)request.getAttribute("list");
Iterator<Reader> it = list.listIterator();
%>
<table border="1" align="center">
<tr>
<td>---------------用户名---------------</td>
<td>---------------密码---------------</td>
<td>操作</td>
<td>操作</td>
</tr>
<%
	while(it.hasNext()){
%>
	<tr>
	<%
		Reader this_reader =(Reader)it.next();
	%>
	<td><a href="../Reader_controller/reader_history?user_history=<%=this_reader.getReader_history()%>"><%out.print(this_reader.getReader_name());%></a></td>
	<td><%out.print(this_reader.getReader_password());%></td>
	<td><input type="button" value="删除读者" onclick="window.location.href='../Reader_controller/reader_delete?reader_id=<%=this_reader.getReader_id()%>'"></td>
	<td><input type="button" value="编辑读者" onclick="window.location.href='../Reader_controller/reader_edit?reader_id=<%=this_reader.getReader_id()%>'"></td>
	</tr>
	<%}}%>
</table>
</body>
</html>