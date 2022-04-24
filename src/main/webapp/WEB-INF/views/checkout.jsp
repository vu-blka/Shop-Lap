<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<base href="${pageContext.servletContext.contextPath}/">
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
						<h2>Checkout</h2>
						<ul>
							<li><a href="/SHOPLAP/index.htm">Home</a></li>
							<li>Checkout</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Page Banner -->

	<!-- Start Checkout Area -->
	<section class="checkout-area ptb-100">
		<div class="container">
			<form:form
				action="user/cart/confirm-checkout.htm?subtotal=${subtotal }&sale=${sale }">
				<div class="row">
					<div class="col-lg-8 col-md-12">
						<div class="user-actions">
							<i class="bx bx-log-in"></i> <span>Returning customer? <a
								href="#">Click here to login</a>
							</span>
						</div>

						<div class="billing-details">
							<h3 class="title">Billing Details</h3>

							<div class="row">
								<div class="col-lg-12 col-md-12">
									<div class="form-group">
										<label>Fullname <span class="required">*</span></label> <input
											type="text" class="form-control" name="fullname" required />
									</div>
								</div>

								<div class="col-lg-12 col-md-12">
									<div class="form-group">
										<label>Phone<span class="required">*</span></label> <input
											type="text" class="form-control" name="phone" required />
									</div>
								</div>

								<div class="col-lg-12 col-md-12">
									<div class="form-group">
										<label>Email Address <span class="required">*</span></label> <input
											type="email" class="form-control" name="mail" required />
									</div>
								</div>

								<div class="col-lg-12 col-md-12">
									<div class="form-group">
										<label>Address <span class="required">*</span></label> <input
											type="text" class="form-control" name="address" required />
									</div>
								</div>
								<div class="col-lg-12 col-md-12">
									<div class="form-group">
										<label>Payment Method <span class="required">*</span></label>

										<div class="select-box">
											<select name="payment" required>
												<c:forEach var="payment" items="${listPayment }">
													<option value="${payment.idPayment }">${payment.method }</option>
												</c:forEach>

											</select>
										</div>
									</div>
								</div>
								<div class="col-lg-12 col-md-12">
									<div class="form-group">
										<label>Shipping Method <span class="required">*</span></label>

										<div class="select-box">
											<select name="shipping" required>
												<c:forEach var="shipping" items="${listShipping }">

													<option value="${shipping.idShipping}">${shipping.method }</option>


												</c:forEach>

											</select>
										</div>
									</div>
								</div>

								<div class="col-lg-12 col-md-12">
									<div class="form-group">
										<textarea name="notes" id="notes" cols="30" rows="5"
											placeholder="Order Notes" class="form-control"></textarea>
									</div>
								</div>
								<a id="buttonA"style='border: none;max-width:150px; margin-left:300px;display:block; margin-top: 15px; padding: 15px 15px; width: 100%; border-radius: 5px; cursor: pointer; background-color: #d31531; color: #ffffff; -webkit-transition: 0.5s; transition: 0.5s;'
								data-toggle="modal" data-target="#confirmationid"
								onclick="showConfirmModelDialog()">Checkout Next!</a>
							
							<button class="default-btn" id="buttonId" style='display:none'
								style="margin-top: 15px; margin-left: 120px;">Checkout Next!</button>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-12">
						<div class="order-details">
							
							
						</div>
					</div>
				</div>
			</form:form>
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

							<div class="modal fade" id="confirmationid" tabindex="-1"
								role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
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
											<a type="button" class="btn btn-secondary"
												data-dismiss="modal">Cancel</a> <a id="yesId" type="button"
												class="btn btn-danger">OK</a>
										</div>
									</div>
								</div>
							</div>
	<!-- End Checkout Area -->

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