<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Đăng ký</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
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
<body>
	<%
		String baoloi = request.getAttribute("baoloi") + "";
		baoloi = (baoloi.equals("null")) ? "" : baoloi;
		String TenDangNhap = request.getAttribute("TenDangNhap") + "";
		TenDangNhap = (TenDangNhap.equals("null")) ? "" : TenDangNhap;
		String HoTen = request.getAttribute("HoTen") + "";
		HoTen = (HoTen.equals("null")) ? "" : HoTen;
		String NamSinh = request.getAttribute("NamSinh") + "";
		NamSinh = (NamSinh.equals("null")) ? "" : NamSinh;
		String GioiTinh = request.getAttribute("GioiTinh") + "";
		GioiTinh = (GioiTinh.equals("null")) ? "" : GioiTinh;
		String QueQuan = request.getAttribute("QueQuan") + "";
		QueQuan = (QueQuan.equals("null")) ? "" : QueQuan;
		String Email = request.getAttribute("Email") + "";
		Email = (Email.equals("null")) ? "" : Email;
		String DongYNhanEmail = request.getAttribute("DongYNhanEmail") + "";
		DongYNhanEmail = (DongYNhanEmail.equals("null")) ? "" : DongYNhanEmail;
	
	%>
	<div class="text-center">
		<h1>THÔNG TIN TÀI KHOẢN</h1>
	</div>
	<h3 class="text-center red"><%=baoloi %></h3>
	<div class="container">
		<form class="form" action="servletDangKy" method="post">
			<div class="row">
				<div class="col">
					<div class="mb-3">
						<label for="exampleInputPassword1" class="form-label">Tên
							đăng nhập<span class="red">*</span>
						</label> <input type="text" class="form-control" id="TenDangNhap"
							required="required" name="TenDangNhap" value="<%= TenDangNhap %>">
					</div>
					<div class="mb-3">
						<label for="MatKhau" class="form-label">Mật khẩu<span
							class="red">*</span><span class="red" id="msgMatKhau"></span></label> <input
							type="password" class="form-control" id="MatKhau" name="MatKhau"
							required="required" onkeyup="KiemTraMatKhau()">
						<button class="btn btn-outline-secondary" type="button"
							onclick="TogglePasswordVisibility('MatKhau')">
							<i class="bi bi-eye"></i>
						</button>
						hiển thị
					</div>
					<div class="mb-3">
						<label for="NhapLaiMatKhau" class="form-label">Nhập lại
							mật khẩu<span class="red">*</span><span class="red"
							id="msgNhapLaiMatKhau"></span>
						</label> <input type="password" class="form-control" id="NhapLaiMatKhau"
							name="NhapLaiMatKhau" required="required"
							onkeyup="KiemTraMatKhau()">
						<button class="btn btn-outline-secondary" type="button"
							onclick="TogglePasswordVisibility('NhapLaiMatKhau')">
							<i class="bi bi-eye"></i>
						</button>
						hiển thị
					</div>
					<div class="mb-3">
						<label for="Email" class="form-label">Email<span
							class="red">*</span></label> <input type="email" class="form-control"
							id="Email" name="Email" required="required" value="<%= Email %>">
					</div>
				</div>
				<div class="col">
					<div class="mb-3">
						<label for="HoTen" class="form-label">Họ và tên<span
							class="red">*</span><span class="red" id="msg"></span>
						</label> <input type="text" class="form-control" id="HoTen" name="HoTen"
							required="required" value="<%= HoTen %>">
					</div>
					<div class="mb-3">
						<label for="NamSinh" class="form-label">Năm sinh<span
							class="red">*</span><span class="red" id="msg"></span>
						</label> <input type="date" class="form-control" id="NamSinh"
							name="NamSinh" required="required" value="<%= NamSinh %>">
					</div>
					<br>
					<div class="mb-3">
						<label for="GioiTinh" class="form-label">Giới tính<span
							class="red">*</span></label> <select class="form-control" id="GioiTinh"
							name="GioiTinh" required="required">
							<option></option>
							<option value="Nam" <%=(GioiTinh.equals("Nam")) ? "selected='selected'" : "" %>>Nam</option>
							<option value="Nữ" <%=(GioiTinh.equals("Nữ")) ? "selected='selected'" : "" %>>Nữ</option>
							<option value="Khác" <%=(GioiTinh.equals("Khác")) ? "selected='selected'" : "" %>>Khác</option>
						</select>
					</div>
					<br>
					<div class="mb-3">
						<label for="QueQuan" class="form-label">Quê quán<span
							class="red">*</span></label> <input type="text" class="form-control"
							id="QueQuan" name="QueQuan" required="required" value="<%= QueQuan %>">
					</div>
				</div>
				<div class="mb-3">
					<label class="form-label" for="DongYDieuKhoan">Đồng ý điều
						khoản<span class="red">*</span>
					</label> <input type="checkbox" class="form-check-input"
						id="DongYDieuKhoan" name="DongYDieuKhoan" onchange="XyLyDongY()">
				</div>
				<div class="mb-3">
					<label class="form-label" for="DongYNhanEmail">Đồng ý nhận
						email</label> <input type="checkbox" class="form-check-input"
						id="DongYNhanEmail" name="DongYNhanEmail" value="=<%= DongYNhanEmail %>">
				</div>
			</div>
			<input type="submit" class="btn btn-primary form-control"
				name="submit" id="submit" value="Đăng ký"
				style="visibility: hidden;" />
		</form>
	</div>
</body>

<script>
	function KiemTraMatKhau() {
		var matkhau = document.getElementById("MatKhau").value;
		var matkhaunhaplai = document.getElementById("NhapLaiMatKhau").value;
		var msgMatKhau = document.getElementById("msgMatKhau");
		var msgNhapLaiMatKhau = document.getElementById("msgNhapLaiMatKhau");

		if (matkhau !== matkhaunhaplai) {
			msgMatKhau.innerHTML = "Mật khẩu không khớp";
			msgNhapLaiMatKhau.innerHTML = "Mật khẩu không khớp";
			return false;
		} else {
			msgMatKhau.innerHTML = "";
			msgNhapLaiMatKhau.innerHTML = "";
			return true;
		}
	}
	function TogglePasswordVisibility(inputId) {
		var input = document.getElementById(inputId);
		if (input.type === "password") {
			input.type = "text";
		} else {
			input.type = "password";
		}
	}
	function XyLyDongY() {
		var dongydieukhoan = document.getElementById("DongYDieuKhoan");
		if (dongydieukhoan.checked == true) {
			document.getElementById("submit").style.visibility = "visible";
		} else {
			document.getElementById("submit").style.visibility = "hidden";
		}

	}
</script>

</html>