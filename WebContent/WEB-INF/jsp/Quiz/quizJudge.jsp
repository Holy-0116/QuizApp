<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String judge = (String) request.getAttribute("judge");
String explanation = (String) request.getAttribute("explanation");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quizアプリ</title>
</head>
<body>
<%= judge %><br>
<p></p>
解説<br>
<%= explanation %><br>
<p></p>
<a href="/quizApp/Quiz">次へ</a>
<a href="/quizApp/Main">終了</a>
</body>
</html>