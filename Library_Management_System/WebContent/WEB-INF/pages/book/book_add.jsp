<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加图书</title>
</head>
<body>

<a href="../Book_controller/book_findall">返回上一级</a>
<form action="../Book_controller/book_add" method="post">
书名：<input type="text" name="book_name"><br>
简介：<input type="text" name="book_synopsis"><br>
作者：<input type="text" name="book_author"><br>
价格：<input type="text" name="book_price"><br>
类型：<input type="text" name="book_type"><br>
余量：<input type="text" name="book_number"><br>
<input type="submit" value="保存">
</form>
</body>
</html>