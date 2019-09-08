<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
普通用户登陆界面    <a href="../">返回主页</a>
<br>
<form action="../Reader_controller/check_login" method="post">
用户名：<input type="text" name="reader_name"/><br>
密码：<input type="password" name="reader_password"/><br>
<input type="submit" value="登陆"/>
</form>
<input type="button" value="注册" onclick="window.location.href='../Reader_controller/reader_regist'">
<br>修改密码请联系管理员
</body>
</html>