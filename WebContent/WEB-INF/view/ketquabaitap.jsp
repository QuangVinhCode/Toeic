<%@page import="model.Taikhoan"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Kết Quả Bài Tập</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="servletHienThi?action=hienthi">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="servletHienThi?action=xephang">Rank</a></li>
				</ul>
				<div class="d-flex">
					<%
						Object obj = session.getAttribute("Taikhoan");
					Taikhoan taikhoan = null;
					if (obj != null) {
						taikhoan = (Taikhoan) obj;
					}
					if (taikhoan == null) {
					%>
					<a class="btn btn-primary" href="servletHienThi?action=dangnhap">Đăng
						nhập</a>
					<%
						} else {
					%>
					Xin chào <b><%=taikhoan.getTenTk()%></b> <br>
					<div class="d-flex">
						<a href="servletHienThi?action=dangxuat">Đăng xuất</a>
					</div>
					<%
						}
					%>

				</div>
			</div>
		</div>
	</nav>
    <h1>Kế quả bài tập</h1>
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
