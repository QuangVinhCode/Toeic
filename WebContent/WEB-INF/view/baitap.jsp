<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>English Quiz</title>
</head>
<body>
    <h1>English Quiz</h1>
	<h1>English Quiz</h1>
    <form action="servletBaiTap" method="post">
        <%@ page import="java.util.List" %>
        <%@ page import="model.Baitap" %>
        <%@ page import="dao.BaitapDAO" %>
        <% List<Baitap> questions = new BaitapDAO().findALL(); %>

        <% for (Baitap question : questions) { %>
            <div>
                <p><strong>Question <%= question.getMaBt() %>:</strong> <%= question.getCauHoi() %></p>
                <input type="text" name="answer_<%= question.getMaBt() %>" required>
            </div>
        <% } %>

        <br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
    