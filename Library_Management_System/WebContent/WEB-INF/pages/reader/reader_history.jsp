<%@page import="com.czhy.lms.pojo.User"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.czhy.lms.pojo.History"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%User user = (User)request.getAttribute("user");
if("reader".equals(user.getUser_competence())){
%>
借阅历史  <a href="../Book_controller/book_findall">返回浏览全部</a>
<%	} 
if("manager".equals(user.getUser_competence())){%>
借阅历史<a href="../Reader_controller/reader_findall">返回浏览全部</a> 	
<%}
%>

<table border="1" align="center">
<tr>
<td>ID
<td>书名
<td>借书时间
<td>归还期限
<td>状态
<td>备注
</tr>
<%
List<History> list = (List<History>)request.getAttribute("list");
Iterator it = list.listIterator();
while(it.hasNext()){
%><tr><%
	History this_history = (History)it.next();
    %><td><%out.print(this_history.getMybook_id());
	%><td><%out.print(this_history.getMybook_name());
	%><td><%out.print(this_history.getMybook_borrowtime());
	%><td><%out.print(this_history.getMybook_returntime());
	%><td><%out.print(this_history.getMybook_state());
	%><td><%
	if("未归还".equals(this_history.getMybook_state())){
		%>
		<form action="../Reader_controller/reader_returnbook" method="post">
		<input type="hidden" name="history_id" value=<%=this_history.getHistory_id()%>>
		<input type="hidden" name="mybook_id" value=<%=this_history.getMybook_id()%>>
		<input type="submit" value="归还图书"> 
		</form>
		<% 
	}
	else{
		out.print("归还时间："+this_history.getReturn_time());
	}
	%></tr><%
}
%>
</table>
</body>
</html>