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
ユーザーID:<input type="text" name="userId">※登録済みのユーザーIDは登録できません<br>
パスワード:<input type="password" name="pass">※使用可能な文字は半角英数字で、最初の文字に数字は使えません<br>
メールアドレス:<input type="text" name="mail">※登録済みのメールアドレスは登録できません<br>
名前:<input type="text" name="name"><br>
年齢:<input type="text" name="age" >
<input type="submit" value="登録"><br>
</form>
<a href="/Soliloquy/index.jsp">ログイン画面へ</a>
</body>
</html>