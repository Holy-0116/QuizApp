<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String queryNG = (String)request.getAttribute("queryNG"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quizアプリ</title>
</head>
<body>
<% if(queryNG != null){ %>
<%= queryNG %>
<% } %>
<form action="/quizApp/PostQuiz" method="post">
	<p>◉問題</p>
	<textarea name="question" cols="100" rows="3" maxlength="300" placeholder="問題文："></textarea><br>
	<p>◉答え</p>
	<strong>true:</strong><input type="radio" name="answer" value="true" checked="checked">
	<strong>false:</strong><input type="radio" name="answer" value="false">
	<p>◉解説</p>
	<textarea name="explanation" cols="100" rows="6" maxlength="240" placeholder="解説文："></textarea><br>
	<input type="submit" value="送信">
	<a href="/quizApp/Main">戻る</a>
</form>
</body>
</html>