<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/bootstrap.min.css'/>">
<!-- Animate CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/animate.min.css'/>">
<!-- Meanmenu CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/meanmenu.css'/>">
<!-- Boxicons CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/boxicons.min.css'/>">
<!-- Flaticon CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/flaticon.css'/>">
<!-- Owl Carousel CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/owl.carousel.min.css'/>">
<!-- Owl Theme Default CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/owl.theme.default.min.css'/>">
<!-- Odometer CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/odometer.min.css'/>">
<!-- Nice Select CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/nice-select.min.css'/>">
<!-- Magnific Popup CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/magnific-popup.min.css'/>">
<!-- Imagelightbox CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/imagelightbox.min.css'/>">
<!-- Style CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/style.css'/>">
<!-- Responsive CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/responsive.css'/>">

<title>Maxon - Automobile Parts Shop HTML Template</title>

<link rel="icon" type="image/png"
	href="<c:url value='/resources/assets/img/favicon.png'/>">
</head>

<body>

	<!-- Start header section -->
	<jsp:include page="./layouts/user/header.jsp" flush="true" />
	<!-- / header section -->

	<!-- Start Page Banner -->
	<div class="page-banner-area item-bg2">
		<div class="d-table">
			<div class="d-table-cell">
				<div class="container">
					<div class="page-banner-content">
						<h2>Contact Us</h2>
						<ul>
							<li><a href="/SHOPLAP/index.htm">Home</a></li>
							<li>Contact Us</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Page Banner -->

	<!-- Start Contact Info Area -->
	<section class="contact-info-area pt-100 pb-70">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-md-6 col-sm-6">
					<div class="contact-info-box">
						<div class="icon">
							<i class='bx bx-envelope'></i>
						</div>

						<h3>Email Here</h3>
						<p>
							<a href="mailto:${contact.mail1 }">${contact.mail1 }</a>
						</p>
						<p>
							<a href="mailto:${contact.mail2 }">${contact.mail2 }</a>
						</p>
					</div>
				</div>

				<div class="col-lg-4 col-md-6 col-sm-6">
					<div class="contact-info-box">
						<div class="icon">
							<i class='bx bx-map'></i>
						</div>

						<h3>Location Here</h3>
						<p>${contact.location }</p>
					</div>
				</div>

				<div class="col-lg-4 col-md-6 col-sm-6">
					<div class="contact-info-box">
						<div class="icon">
							<i class='bx bxs-phone-call'></i>
						</div>

						<h3>Call Here</h3>
						<p>
							<a href="tel:1234567890">${contact.phone1 }</a>
						</p>
						<p>
							<a href="tel:2414524526">${contact.phone2 }</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End Contact Info Area -->

	<!-- Start Contact Area -->
	<section class="contact-area pb-100">
		<div class="container">
			<div class="section-title">
				<h2>Ready To Get Started?</h2>
				<p>${messagePara }</p>
			</div>

			<div class="contact-form">
				<form:form action="contact/send.htm" method="post"
					modelAttribute="message">
					<div class="row">
						<div class="col-lg-6 col-md-6">
							<div class="form-group">
								<label>Name</label> <input type="text" name="name"
									class="form-control" required
									data-error="Please enter your name" value="${contact4.name }">
								<form:errors path="name" />
								<div class="help-block with-errors"></div>
							</div>
						</div>

						<div class="col-lg-6 col-md-6">
							<div class="form-group">
								<label>Email</label> <input type="email" name="email" id="email"
									class="form-control" required
									data-error="Please enter your email" value="${contact4.email }">
								<form:errors path="email" />
								<div class="help-block with-errors"></div>
							</div>
						</div>

						<div class="col-lg-6 col-md-6">
							<div class="form-group">
								<label>Phone</label> <input type="text" name="phone"
									id="phone_number" required
									data-error="Please enter your number" class="form-control"
									value="${contact4.phone }">
								<form:errors path="phone" />
								<div class="help-block with-errors"></div>
							</div>
						</div>

						<div class="col-lg-6 col-md-6">
							<div class="form-group">
								<label>Subject</label> <input type="text" name="subject"
									id="msg_subject" class="form-control" required
									data-error="Please enter your subject"
									value="${contact4.subject }">
								<form:errors path="subject" />
								<div class="help-block with-errors"></div>
							</div>
						</div>

						<div class="col-lg-12 col-md-12">
							<div class="form-group">
								<label>Message</label>
								<textarea name="msg" class="form-control" id="message"
									cols="30" rows="6" required data-error="Write your message"
									value="${contact4.msg }"></textarea>
								<form:errors path="message" />
								<div class="help-block with-errors"></div>
							</div>
						</div>

						<div class="col-lg-12 col-md-12">
							<button type="submit" class="default-btn">Send Message</button>

							<div id="msgSubmit" class="h3 text-center hidden"></div>
							<div class="clearfix"></div>
						</div>
					</div>

				</form:form>
			</div>
		</div>
	</section>
	<!-- End Contact Area -->

	<!-- Start Map Area -->
	<div id="map">
		<iframe src="${contact.map }" width="600" height="450"
			style="border: 0;" allowfullscreen="" loading="lazy"></iframe>
	</div>
	<!-- End Map Area -->

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