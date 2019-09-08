<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String redirect=(String)request.getAttribute("redirect");//获取转发来的重定向信息
//登陆失败后重定向到登陆页面
if("登陆，该用户不存在或密码错误".equals(redirect)){
	 %><script language="javascript">alert("该用户不存在或密码错误");window.location="../Manager_controller/manager_login"</script><% 
}
%>
</body>
</html>