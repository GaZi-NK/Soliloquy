<!-- アカウント登録完了画面を表示させるビュー -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>独り言-アカウント登録結果</title>
</head>
<body>
	<h3>会員登録結果</h3>

		<c:if test="${not empty account}">
			<p>
				ユーザー名:<c:out value="${account.userId}" /><br>
				メールアドレス:<c:out value="${account.mail}" />
			</p>
		</c:if>

		<c:if test= "${empty account }">
			<p>
			アカウント登録に失敗しました。<br>
			${errorMsg}<br>
			<a href="/Soliloquy/AccountServlet">会員登録へ</a>
			</p>
		</c:if>

	<a href="/Soliloquy/index.jsp">ログイン画面へ</a>
</body>
</html>