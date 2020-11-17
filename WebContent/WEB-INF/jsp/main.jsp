<!-- メイン画面(独り言一覧)を出力するビュー -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User, model.Mutter, java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
	<h1>どこつぶメイン</h1>
	<p>
		${sessionScope.loginUser.userId}さん、ログイン中
		<a href="/Soliloquy/Logout">ログアウト</a>
	</p>
	<p>
		<a href="/Soliloquy/Main">更新</a>
	<form action="/Soliloquy/Main" method="post">
		<input type="text" name="text"> <input type="submit"
			value="つぶやく">
	</form>

	<c:forEach var="mutter" items="${mutterList }">
		<p>
			<c:out value="${mutter.userId }"></c:out>:
			<c:out value="${mutter.text }"></c:out>
			<c:out value="${mutter.dateTime }"></c:out>
	</c:forEach>
</body>
</html>