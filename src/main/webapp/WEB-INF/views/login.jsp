<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/bootstrap.min.css'/>" />
<!-- Animate CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/animate.min.css'/>" />
<!-- Meanmenu CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/meanmenu.css'/>" />
<!-- Boxicons CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/boxicons.min.css'/>" />
<!-- Flaticon CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/flaticon.css'/>" />
<!-- Owl Carousel CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/owl.carousel.min.css'/>" />
<!-- Owl Theme Default CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/owl.theme.default.min.css'/>" />
<!-- Odometer CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/odometer.min.css'/>" />
<!-- Nice Select CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/nice-select.min.css'/>" />
<!-- Magnific Popup CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/magnific-popup.min.css'/>" />
<!-- Imagelightbox CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/imagelightbox.min.css'/>" />
<!-- Style CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/style.css'/>" />
<!-- Responsive CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/responsive.css'/>" />

<title>Maxon - Automobile Parts Shop HTML Template</title>

<link rel="icon" type="image/png"
	href="<c:url value='/resources/assets/img/favicon.png'/>" />
</head>

<body>
	<!-- Start header section -->
	<jsp:include page="./layouts/user/header.jsp" flush="true" />
	<!-- / header section -->
	<!-- Start Page Banner -->
	<div class="page-banner-area">
		<div class="d-table">
			<div class="d-table-cell">
				<div class="container">
					<div class="page-banner-content">
						<h2>LOGIN</h2>
						<ul>
							<li><a href="/SHOPLAP/index.htm">Home</a></li>
							<li>LOGIN</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Page Banner -->

	<!-- Start My Account Area -->
	<div class="container">
		<p
			style="color: red; font-size: 20px; margin-left: 35vw; margin-top: 10px; font-weight: 500">${message }</p>
	</div>
	<section class="my-account-area ptb-100">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-6"></div>
				<div class="col-lg-6 col-md-12">
					<div class="login-form mb-30">
						<h2>Login</h2>
						<p>${message }</p>
						<form:form
							action="${pageContext.request.contextPath}/user/login.htm"
							method="post">
							<div class="form-group">

								<input type="text" class="form-control" placeholder="Username"
									name="username" required="required" />
							</div>
							<div class="form-group">

								<input type="password" class="form-control"
									placeholder="Password" name="password" required="required"/>
							</div>

							<div class="row align-items-center">
								<div class="col-lg-6 col-md-6 col-sm-6">
									<div class="form-check">
										<input type="checkbox" class="form-check-input" id="checkme"
											name="remember" /> <label class="form-check-label"
											for="checkme">Remember me</label>
									</div>
								</div>

								<div class="col-lg-6 col-md-6 col-sm-6 lost-your-password">
									<a href="/SHOPLAP/user/reset-password.htm"
										class="lost-your-password">Forgot your password?</a>
								</div>
							</div>
							<button type="submit">Login</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End My Account Area -->

	<!-- Start footer section -->
	<jsp:include page="./layouts/user/footer.jsp" flush="true" />
	<!-- / footer section -->

	<!-- Jquery Slim JS -->
	<script src="<c:url value='/resources/assets/js/jquery.min.js'/>"></script>
	<!-- Popper JS -->
	<script src="<c:url value='/resources/assets/js/popper.min.js'/>"></script>
	<!-- Bootstrap JS -->
	<script src="<c:url value='/resources/assets/js/bootstrap.min.js'/>"></script>
	<!-- Meanmenu JS -->
	<script src="<c:url value='/resources/assets/js/jquery.meanmenu.js'/>"></script>
	<!-- Owl Carousel JS -->
	<script src="<c:url value='/resources/assets/js/owl.carousel.min.js'/>"></script>
	<!-- Magnific Popup JS -->
	<script
		src="<c:url value='/resources/assets/js/jquery.magnific-popup.min.js'/>"></script>
	<!-- Imagelightbox JS -->
	<script
		src="<c:url value='/resources/assets/js/imagelightbox.min.js'/>"></script>
	<!-- Odometer JS -->
	<script src="<c:url value='/resources/assets/js/odometer.min.js'/>"></script>
	<!-- Jquery Nice Select JS -->
	<script
		src="<c:url value='/resources/assets/js/jquery.nice-select.min.js'/>"></script>
	<!-- Jquery Appear JS -->
	<script
		src="<c:url value='/resources/assets/js/jquery.appear.min.js'/>"></script>
	<!-- Ajaxchimp JS -->
	<script
		src="<c:url value='/resources/assets/js/jquery.ajaxchimp.min.js'/>"></script>
	<!-- Form Validator JS -->
	<script
		src="<c:url value='/resources/assets/js/form-validator.min.js'/>"></script>
	<!-- Contact JS -->
	<script
		src="<c:url value='/resources/assets/js/contact-form-script.js'/>"></script>
	<!-- Wow JS -->
	<script src="<c:url value='/resources/assets/js/wow.min.js'/>"></script>
	<!-- Custom JS -->
	<script src="<c:url value='/resources/assets/js/main.js'/>"></script>
</body>
</html>