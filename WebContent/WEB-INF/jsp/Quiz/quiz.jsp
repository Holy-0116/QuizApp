<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*, java.util.*" %>
<%
ArrayList<Quiz> quizzes = (ArrayList<Quiz>) request.getAttribute("quizzes");
Random random = new Random();
int randomValue = random.nextInt(quizzes.size());
Quiz quiz =quizzes.get(randomValue);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quizアプリ</title>
</head>
<body>
<p>問題</p>
<form action="/quizApp/Quiz" method="post">
<%= quiz.getQuestion() %><br>
<p></p>
<input type="hidden" name="quizId" value=<%= randomValue %> >
<input type="submit" name="resultAnswer" value="マル">
<input type="submit" name="resultAnswer" value="バツ"><br>
<p></p>
<a href="/quizApp/Main">終了</a>
</form>
</body>
</html>