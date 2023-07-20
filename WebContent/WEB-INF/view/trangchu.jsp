<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<c:forEach items="${listchude }" var="c">
		<a href="servletHienThiTuVung?id=${c.maCd }">
			<div class="container">
				<div class="chude">
					<div class="hinhanhcd">
						<img src="./images/${c.hinhAnhCd }" alt="Error">
					</div>
					<div class="noidungcd">
						<h1>${c.tenCd }</h1>
					</div>
				</div>
			</div>
		</a>
	</c:forEach>
	
</body>
</html>

