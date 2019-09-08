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
  <a href="../Reader_controller/reader_findall">返回上一级</a>
<%
	Reader this_reader = (Reader)request.getAttribute("this_reader");
%>
<form action="../Reader_controller/reader_update">
用户名：<input type="text" name="reader_name" value=<%=this_reader.getReader_name()%>><br>
密码：<input type="text" name="reader_password" value=<%=this_reader.getReader_password()%>><br>
<input type="hidden" name="reader_id" value=<%=this_reader.getReader_id()%>>
<input type="submit"  value="保存">
</form>
</body>
</html>