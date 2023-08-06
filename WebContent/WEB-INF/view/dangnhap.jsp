<%@page import="org.eclipse.jdt.internal.compiler.parser.NLSTag"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
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
<style type="text/css">
.red {
	color: red;
}
</style>

</head>
<% String baoloi = request.getAttribute("baoloi") + ""; 
	if (baoloi.equals("null"))
	{
		baoloi="";
	}
%>	


<body>
	
	<main class="form-signin w-100 m-auto">
		<form class="text-center" action="servletDangNhap" method="post">
			<img class="mb-4" src="./images/logo.png"
				alt="" width="200">
			<h1 class="h3 mb-3 fw-normal">Please sign in</h1>
			
			<h3 class="text-center red"><%= baoloi%></h3>
			<div class="form-floating">
				<input type="text" class="form-control" id="TenDangNhap"
					placeholder="Login" name="TenDangNhap"> <label for="TenDangNhap">Tên đăng nhập:</label>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control" id="MatKhau"
					placeholder="Password" name="MatKhau"> <label for="MatKhau">Mật khẩu:</label>
			</div>

			<div class="form-check text-start my-3">
				<input class="form-check-input" type="checkbox" value="remember-me"
					id="flexCheckDefault"> <label class="form-check-label"
					for="flexCheckDefault"> Ghi nhớ </label>
			</div>
			<button class="btn btn-primary w-100 py-2" type="submit">Đăng nhập</button>
			<a href="servletHienThi?action=dangky">Đăng ký tài khoản mới</a>
			<p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2023</p>
		</form>
	</main>
</body>
</html>