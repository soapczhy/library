<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="com.czhy.lms.pojo.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%User user=(User)request.getAttribute("user");%>
<title>登陆成功</title>
</head>
<body>
欢迎你:<%out.print(user.getUser_name()); %><br>
5秒后自动跳转到主页<br>
<a href="../Reader_controller/reader_index">若浏览器无响应，请点击此处前往</a>
<%   response.setHeader("Refresh", "5;url=../Reader_controller/reader_index"); %><!-- 重定向 -->
</body>
</html>