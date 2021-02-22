<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String errMsg = (String)request.getAttribute("errMsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quizアプリ</title>
</head>
<body>
<h1>新規登録</h1>
<% if(errMsg != null) { %>
	<p><%= errMsg %></p>
<% } %>
<form action="/quizApp/Logon" method="post">
<p>ユーザー名：<input type="text" autocapitalize="off" name="name"></p>
<p>Eメール：<input type="text" autocapitalize="off" name="mail"></p>
<p>パスワード：<input type="password" name="pass"></p>
<input type="submit" value="送信">
<p></p>
<a href="/quizApp">戻る</a><br>
</form>
</body>
</html>