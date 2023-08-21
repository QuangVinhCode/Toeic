<%@page import="model.Taikhoan"%>
<%@page import="model.Chude"%>
<%@page import="java.util.List"%>
<%@page import="dao.ChudeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách bài tập</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
	integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.15.0/font/bootstrap-icons.css"
	rel="stylesheet">
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
						aria-current="page" href="servletHienThi?action=hienthiadmin">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="servletHienThi?action=xephang">Rank</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Quản lý </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="servletQLChuDe">Chủ đề</a></li>
							<li><a class="dropdown-item" href="servletQLTuVung">Từ Vựng</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="servletQLBaiTap">Bài Tập</a></li>
						</ul></li>
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
	<%
		ChudeDAO dao = new ChudeDAO();
	List<Chude> listchude = dao.findALL();
	%>
	<div class="dropdown">
		<a class="btn btn-secondary dropdown-toggle" href="#" role="button"
			data-bs-toggle="dropdown" aria-expanded="false"> Danh sách chủ đề
		</a>
		<ul class="dropdown-menu">
			<%
				for (Chude cd : listchude) {
			%>
			<li><a class="dropdown-item"
				href="servletQLBaiTap?cd=<%=cd.getMaCd()%>"><%=cd.getTenCd()%></a></li>
			<%
				}
			%>
		</ul>
	</div>
	<div class="container">
		<h2 class="text-center">Danh sách bài tập</h2>
		<p>
			<a class="btn btn-success" href="servletQLBaiTap?action=add">Thêm
				bài tập mới</a>
		</p>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Mã Bài Tập</th>
					<th>Câu Hỏi</th>
					<th>Gợi Ý</th>
					<th>Câu Trả Lời</th>
					<th>Điểm Số</th>
					<th>Thuộc Chủ Đề</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listbaitap }" var="c">
					<tr>
						<td>${c.maBt }</td>
						<td>${c.cauHoi }</td>
						<td>${c.goiY }</td>
						<td>${c.dapAn }</td>
						<td>${c.diemSo }</td>
						<td>${c.chude.tenCd }</td>
						<td><a class="btn btn-primary btn-sm"
							href="servletQLBaiTap?action=add&id=${c.maBt }">Edit</a> <a
							class="btn btn-danger btn-sm"
							href="servletQLBaiTap?action=delete&id=${c.maBt }">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
