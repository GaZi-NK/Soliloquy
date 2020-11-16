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
パスワード:<input type="password" name="pass"
			pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="8文字以上の半角英数字、半角英数を最低１文字以上"><br>
メールアドレス:<input type="text" name="mail"
				pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="xxxxxx@ドメイン">※登録済みのメールアドレスは登録できません<br>
名前:<input type="text" name="name"><br>
年齢:<input type="text" name="age" pattern="\d{1,3}" title="半角数字,3文字まで"	>
<input type="submit" value="登録"><br>
</form>
<a href="/Soliloquy/index.jsp">ログイン画面へ</a>
</body>
</html>