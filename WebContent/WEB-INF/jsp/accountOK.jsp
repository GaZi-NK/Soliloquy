<!-- アカウント登録完了画面を表示させるビュー -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>独り言-アカウント登録完了</title>
</head>
<body>
	<h3>会員登録が完了しました。</h3>
	<p>
		ユーザー名:<c:out value="${userId}" /><br>
		メールアドレス:<c:out value="${mail}"/>
	</p>
	<a href="/Soliloquy/index.jsp">ログイン画面へ</a>
</body>
</html>