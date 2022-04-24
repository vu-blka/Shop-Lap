<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
						<h2>My Account</h2>
						<ul>
							<li><a href="/SHOPLAP/index.htm">Home</a></li>
							<li>My Account</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Page Banner -->

	<!-- Start My Account Area -->
	<section class="my-account-area ptb-100">
		<div class="container">
			<p style="font-weight: bold; font-size: 20px; margin-left: 40%;">${msg }</p>
			<div class="row">

				<div class="col-lg-3 col-md-6"></div>
				<div class="col-lg-5 col-md-6">
					<form:form
						action="${pageContext.request.contextPath}/user/update.htm"
						method="post" modelAttribute="updateAccount">
						<p style="color: red; font-size: 20px">THÔNG TIN CÁ NHÂN</p>
						<label for="id_name"><b>Họ và tên</b> </label>
						<p>
							<input id="id_name" value="${user.fullname }" name="fullname"
								required style="width: 300px" />
						</p>
						<form:errors path="fullname" />


						<label for="id_phone"><b>Phone</b> </label>
						<p>
							<input id="id_phone" value="${user.phone }" name="phone" required
								style="width: 300px" />
						</p>
						<form:errors path="phone" />


						<label for="id_mail"><b>Mail</b> </label>
						<p>
							<input id="id_mail" value="${user.email }" name="email" required
								style="width: 300px" />
						</p>
						<form:errors path="email" />


						<a id="buttonA"
							style='border: none; display: block; max-width: 100px; margin-left: 25px; margin-top: 25px; padding: 10px 10px; width: 100%; border-radius: 5px; cursor: pointer; background-color: #d31531; color: #ffffff; -webkit-transition: 0.5s; transition: 0.5s;'
							data-toggle="modal" data-target="#confirmationid"
							onclick="showConfirmModelDialog()">Cập nhật</a>
						<button id="buttonId" style='display: none' type="submit">Cập
							nhật</button>
					</form:form>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="col-lg-3 col-md-6">
						<button
							style='border: none; display: block; margin-left: 30px; margin-top: 25px; padding: 10px 10px; border-radius: 5px; cursor: pointer; background-color:; color: #ffffff; -webkit-transition: 0.5s; transition: 0.5s;'>
							<a style='display: block; min-width: 130px'
								href="user/change-password.htm">Change Password</a>
						</button>

					</div>


				</div>
	</section>
	<script>
		function showConfirmModelDialog() {
			//$('#confirmationid').modal('show');

			$("#yesId").click(function() {
				$("#buttonId").click();
			})
		}
	</script>

	<div class="modal fade" id="confirmationid" tabindex="-1" role="dialog"
		aria-labelledby="modelTitleId" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">confirmation</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Bạn có muốn tiếp tục ?</div>
				<div class="modal-footer">
					<a type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</a>
					<a id="yesId" type="button" class="btn btn-danger">OK</a>
				</div>
			</div>
		</div>
	</div>

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