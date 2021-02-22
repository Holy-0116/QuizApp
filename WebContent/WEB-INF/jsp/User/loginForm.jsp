<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String errMsg = (String) request.getAttribute("errMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quizアプリ</title>
</head>
<body>
<h1>ログインフォーム</h1>
<% if(errMsg != null) { %>
	<p><%= errMsg %></p>
<% } %>
<form action="/quizApp/Login" method="post">
<p>Eメール：<input type="text" autocapitalize="off" name="mail"></p>
<p>パスワード： <input type="password" name="pass"></p>
<input type="submit" value="送信"><br>
<p></p>
<a href="/quizApp">戻る</a>
</form>
</body>
</html>