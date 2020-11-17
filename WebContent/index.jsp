<!-- トップ画面を出力するビュー -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>独り言</title>
</headr>
<body>
	<h1>独り言へようこそ</h1>
	<form action="/Soliloquy/Login" method="post">
		ユーザー名:<input type="text" name="userId"><br>
		パスワード:<input type="password" name="pass"><br>
			 <input type="submit" value="ログイン"><br>
	</form>
	<p></p>
	<a href="/Soliloquy/AccountServlet">会員登録へ</a>
</body>
</html>