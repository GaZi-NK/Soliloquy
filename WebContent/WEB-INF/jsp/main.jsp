<!-- メイン画面(つぶやき一覧)を出力するビュー -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User, model.Mutter, java.util.List"%>

<%--　～～通常の書き方～～
<%
//セッションスコープに保存されたユーザー情報を取得
User loginUser = (User) session.getAttribute("loginUser");

//アプリケーションスコープに保存されたつぶやきリストを取得
List<Mutter> mutterList = (List<Mutter>) request.getAttribute("mutterList");

//リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>
　　　～～ここまで～～　--%>

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

	<%--
<% if(errorMsg != null){ %>
	<p><%= errorMsg %></p>
<% } %>
<% for(Mutter mutter : mutterList) { %>
	<p><%= mutter.getUserName() %>:<%= mutter.getText() %></p>
<% } %>
--%>

	<c:if test="${human.age >= 20}">
		<p>${errorMsg }</p>
	</c:if>
	<c:forEach var="mutter" items="${mutterList }">
		<p>
			<c:out value="${mutter.userName }"></c:out>
			:
			<c:out value="${mutter.text }"></c:out>
	</c:forEach>

</body>
</html>