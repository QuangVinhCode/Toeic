<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<c:forEach items="${listtuvung }" var="c">
		<a href="https://www.youtube.com/">
			<div class="container">
				<div class="chude">
					<div class="hinhanhcd">
						<img src="./images/${c.hinhAnhTv }" alt="Error">
					</div>
					<div class="noidungcd">
						<h1>${c.tenTuVung }</h1>
						<h1>Dịch : ${c.dichTv }</h1>
					</div>
				</div>
			</div>
		</a>
	</c:forEach>
</body>
</html>

