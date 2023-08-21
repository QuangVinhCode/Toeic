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
<title>Chi Tiết Bài Tập</title>
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
	<div class="container" style="margin-top: 10px">
		<div class="row"
			style="border: 1px darkgrey solid; border-radius: 10px; width: 50%; margin: 0 auto; padding: 20px">
			<div class="col-sm-12">
				<h2 class="myclass">Bài tập</h2>
				<form action="servletQLBaiTap?action=${ACTION }" method="post"
					enctype="multipart/form-data" accept-charset="UTF-8">
					<div class="form-group">
						<label>Mã bài tập</label> <input type="text" class="form-control"
							name="id" id="id" value="${baitap.maBt }" readonly>
					</div>
					<div class="form-group">
						<label>Câu hỏi</label> <input type="text" class="form-control"
							name="name" id="name" value="${baitap.cauHoi }">
					</div>
					<div class="form-group">
						<label>Gợi ý</label> <input type="text" class="form-control"
							name="suggest" id="suggest" value="${baitap.goiY }">
					</div>
					<div class="form-group">
						<label>Đáp án</label> <input type="text" class="form-control"
							name="answer" id="answer" value="${baitap.dapAn }">
					</div>
					<div class="form-group">
						<label>Điểm số</label> <input type="text" class="form-control"
							name="number" id="number" value="${baitap.diemSo }">
					</div>
					<div class="form-group" style="padding-top: 10px;">
						<label>Thuộc chủ đề</label> <select class="form-control"
							name="option" id="option">
							<option></option>
							<c:forEach items="${listchude }" var="c">
								<option value="${c.maCd}"
									<c:if test="${baitap.chude.maCd eq c.maCd}">selected='selected'</c:if>>${c.tenCd}</option>
							</c:forEach>

						</select>
					</div>
					<button type="submit" class="btn btn-primary">Lưu</button>
					<button type="reset" class="btn btn-primary">Hủy</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	window.addEventListener('load', function() {
		var inputElement = document.querySelector('input[name="id"]');

		if (inputElement && !inputElement.value.trim()) {
			var randomNumber = Math.floor(Math.random() * 10000000) + 1;
			var newValue = 'BT' + randomNumber;
			inputElement.value = newValue;
			inputElement.readOnly = true;
		}
	});
</script>
