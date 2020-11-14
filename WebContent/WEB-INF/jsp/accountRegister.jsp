<!-- アカウント登録画面を表示するビュー -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>独り言-アカウント登録</title>
</head>
<body>
<form action="/Soliloquy/AccountServlet" method="post">
ユーザーID:<input type="text" name="userId"><br>
パスワード:<input type="password" name="pass"><br>
メールアドレス:<input type="text" name="mail"><br>
名前:<input type="text" name="name"><br>
年齢:<input type="number" name="age">
<input type="submit" value="登録"><br>
</form>
<a href="/Soliloquy/index.jsp">ログイン画面へ</a>
</body>
</html>