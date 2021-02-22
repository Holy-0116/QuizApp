<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User logedinUser = (User)session.getAttribute("logedinUser");
String queryOK = (String)request.getAttribute("queryOK");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quizアプリ</title>
</head>
<body>
<% if (queryOK != null) { %>
	<p><%= queryOK %></p>
<% } %>
<h1>Quizアプリようこそ</h1>
<% if (logedinUser != null) { %>
	<strong><%= logedinUser.getName() %></strong>
<% } %>
<span><a href="/quizApp/Logout">ログアウト</a></span>
<p><a href="/quizApp/Quiz">Quizを始める！</a>
<p><a href="/quizApp/PostQuiz">Quizを投稿する</a>
</body>
</html>