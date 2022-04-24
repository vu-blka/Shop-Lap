<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ĐỒ ÁN WEB</title>
<link rel="stylesheet" href="<c:url value='/resources/welcome/css/index.css'/>">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,500;1,100&display=swap"
	rel="stylesheet">
</head>
<body>

	<div class="left-container">
		<div class="icon-middle">
			<img src="<c:url value='/resources/welcome/img/N18DCCN145_PhamPhongPon.jpg'/>">
			<h4></h4>
		</div>
		<nav>
			<ul>
				<li><a href=""><i class="fas fa-home"></i><span>Home</span></a></li>
				<li><a href="#perform"><i class="fas fa-user"></i><span>perform</span></a></li>
				<li><a href="index.htm"><i class="fas fa-user"></i><span>Page
							index</span></a></li>
				<li><a href="admin/login.htm"><i class="fas fa-user"></i><span>Page
							admin</span></a></li>
				

			</ul>
		</nav>
	</div>

	<div class="container">

		<div class="content">
			<div class="ptit">HỌC VIỆN CÔNG NGHỆ BƯU CHÍNH VIỄN THÔNG CƠ SỞ
				TẠI THÀNH PHỐ HỒ CHÍ MINH</div>

			<div class="title">
				<p>Môn : Lập Trình Web</p>
				<p>ĐỀ TÀI: WEBSITE BÁN LAPTOP</p>
				<h2>Giảng viên hướng dẫn : ThS. NGUYỄN TRUNG HIẾU</h2>
			</div>
			<nav>
				<ul>
					<li><img src="" alt=""></li>
				</ul>
			</nav>
		</div>
		<div class="perform" id="perform">
			<div class="student">
				<div class="avatar">
					<img src="<c:url value='/resources/welcome/img/N18DCCN145_PhamPhongPon.jpg'/>" >
				</div>
				<div class="about">
					<div class="name">
						NAME: <span> Phạm Phong Pôn</span>
					</div>
					<div class="mssv">
						MSSV: <span> N18DCCN145</span>
					</div>
					<div class="class">
						CLASS: <span> D18CQCP02</span>
					</div>
				</div>

			</div>
			<div class="student">
				<div class="avatar">
					<img src="<c:url value='/resources/welcome/img/vu.jpg'/>" >
					<div class="about">
						<div class="name">
							NAME: <span> Nguyễn Lương vũ</span>
						</div>
						<div class="mssv">
							MSSV: <span> N18DCCN247</span>
						</div>
						<div class="class">
							CLASS: <span> D18CQCP02</span>
						</div>
					</div>
				</div>
			</div>
			<div class="student">
				<div class="avatar">
					<img src="<c:url value='/resources/welcome/img/quoc.jpg'/>" >
					<div class="about">
						<div class="name">
							NAME: <span> Trần Anh Quốc</span>
						</div>
						<div class="mssv">
							MSSV: <span> N18DCCN166</span>
						</div>
						<div class="class">
							CLASS: <span> D18CQCP02</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>