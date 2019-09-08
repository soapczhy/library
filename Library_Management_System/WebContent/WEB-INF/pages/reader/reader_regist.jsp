<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
我是注册页面
<form action="../Reader_controller/reader_regist_in" method="post">
用户名：<input type="text" name="reader_name"/><br>
密码：<input type="password" name="reader_password"/><br>
<input type="submit" value="注册"/>
</form>
<a href="../">返回主界面</a>

</body>
</html>