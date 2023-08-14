<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz Result</title>
</head>
<body>
    <h1>Quiz Result</h1>
    <%-- Get the total correct answers and total score from request --%>
    <%@ page import="java.util.Map" %>
    <%@ page import="java.util.HashMap" %>
    <% Map<String, Object> quizResult = (HashMap<String, Object>) request.getAttribute("quizResult"); %>
    <% int totalCorrectAnswers = (int) quizResult.get("totalCorrectAnswers"); %>
    <% int totalScore = (int) quizResult.get("totalScore"); 
    	session.setAttribute("totalScore", totalScore);
    %>

    <p>Total Correct Answers: <%= totalCorrectAnswers %> points</p>
    <p>Total Score: <%= totalScore %> points</p>
    <a href="servletHienThi?action=baitapchude">Xác nhận</a>
</body>
</html>
