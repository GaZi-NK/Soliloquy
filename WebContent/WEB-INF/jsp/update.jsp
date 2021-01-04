<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="model.User, model.Mutter, model.UpdateMutter, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>独り言編集</title>
</head>
<body>
	<h1>独り言</h1>
	<p>${sessionScope.loginUser.userId}さん、ログイン中</p>

	<p>
		<c:out value="変更前"></c:out>
		<c:out value="${mutter.text }"></c:out>
	</p>
	<p>
		<c:out value="変更後"></c:out>
	<form action="/Soliloquy/MainUpdete" method="post">
		<input type="text" name="toText">
		<input type="hidden" name="userId" value="${mutter.userId}">
		<input type="hidden" name="text" value="${mutter.text}">
		<input type="hidden" name="dateTime" value="${mutter.dateTime}">
		<input type="submit"value="変更">
	</form>
	</p>


</body>
</html>