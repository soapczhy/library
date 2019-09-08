<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page language="java" contentType="text/html; charset=UTF-8"
    import="com.czhy.lms.pojo.*"%>
     
<!DOCTYPE html>
<html>
<head>
<%
	User user=(User)request.getAttribute("user");
%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
管理员登陆界面<br>
<form action="../Manager_controller/check_login" method="post">
用户名：<input type="text" name="manager_name"/><br>
密码：<input type="password" name="manager_password"/><br>
<input type="submit" value="登陆"/>
</form>

</body>
</html>