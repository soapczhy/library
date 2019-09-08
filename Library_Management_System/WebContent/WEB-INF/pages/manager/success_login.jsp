<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    import="com.czhy.lms.pojo.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	User user=(User)request.getAttribute("user");
%>
<title>Insert title here</title>
</head>
<body>
欢迎你：管理员<%out.print(user.getUser_name()); %><br>
5秒后自动跳转到管理员主页<br>
<a href="../Manager_controller/manager_index">若浏览器无响应，请点击此处前往</a>
<%response.setHeader("Refresh", "5;url=../Manager_controller/manager_index"); %><!-- 重定向 -->
</body>
</html>