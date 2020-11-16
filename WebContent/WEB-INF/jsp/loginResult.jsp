<!-- ログイン結果画面を表示するビュー -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
//セッションスコープからユーザー情報を取得
User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>独り言ログイン</h1>
<% if(loginUser != null) { %>
	<p>ログインに成功しました</p>
	<p>ようこそ<%= loginUser.getUserId() %>さん</p>
	<a href="/Soliloquy/Main">つぶやき投稿・閲覧へ</a>
<% } else { %>
	<p>ログインに失敗しました</p>
	<a href="/Soliloquy/">TOPへ</a>
<% } %>
</body>
</html>