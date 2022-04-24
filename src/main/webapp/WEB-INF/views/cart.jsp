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
						<h2>Cart</h2>
						<ul>
							<li><a href="${pageContext.request.contextPath}/index.htm">Home</a></li>
							<li>Cart</li>


						</ul>
						<h2>${message }</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Page Banner -->

	<!-- Start Cart Area -->
	<section class="cart-area ptb-100">
		<div class="container">

			<div class="row">
				<div class="col-lg-8 col-md-12">
					<div>
						<div class="cart-table table-responsive">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th scope="col">Product</th>
										<th scope="col">Name</th>
										<th scope="col">Price</th>
										<th scope="col">Quantity</th>
										<th scope="col">Total</th>
										<th scope="col"></th>
									</tr>
								</thead>

								<tbody>
									<c:forEach var="cart" items="${listCart }">
										<tr class="top-class">
											<td class="product-thumbnail"><a
												href="${pageContext.request.contextPath}/user/cart/delete.htm?delete=${cart.product.id }"
												class="remove"><i class="bx bx-x"></i></a> <a href="#">
													<img
													src="<c:url value='/resources/assets/img/${cart.product.img }'/>"
													alt="item" />
											</a></td>

											<td class="product-name"><a
												href="${pageContext.request.contextPath}/shop/product-detail.htm?id=${cart.product.id }">${cart.product.name }</a></td>

											<td class="product-price"><span class="unit-amount"><fmt:formatNumber
														value="${cart.product.price }" type="number" /> vnđ</span></td>

											<td class="product-quantity">
												<div class="input-counter">
													<span class="minus-btn"><i class="bx bx-minus"></i></span>
													<form:form
														action="${pageContext.request.contextPath}/user/cart/update-cart.htm?id=${cart.product.id }"
														method="post">
														<input type="text" value="${cart.quantity }"
															name="quantity" />
															
														<a id="buttonA"style='border: none;display:block; margin-top: 10px; padding: 5px 5px; width: 100%; border-radius: 5px; cursor: pointer; background-color: #d31531; color: #ffffff; -webkit-transition: 0.5s; transition: 0.5s;'
								data-toggle="modal" data-target="#confirmationid" onclick="show('${cart.product.id }')">Cập nhật</a>	
														<button style='display:none'  id="buttonId${cart.product.id }" type="submit">Cập nhật</button>
													</form:form>
													<span class="plus-btn"><i class="bx bx-plus"></i></span>
												</div>
											</td>

											<td class="product-subtotal"><span
												class="subtotal-amount"><fmt:formatNumber
														value="${cart.product.price*cart.quantity }" type="number" />
													vnđ</span></td>

										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>

				<div class="col-lg-4 col-md-12">
					<div class="cart-totals">
						<h3>Cart Totals</h3>

						<ul>
							<li>Subtotal <span><fmt:formatNumber
										value="${subtotal }" type="number" /> vnđ</span></li>
							<li>Sale <span><fmt:formatNumber value="${sale }"
										type="number" /> vnđ</span></li>
							<li>Total <span><fmt:formatNumber value="${total }"
										type="number" /> vnđ</span></li>
							<li>Payable Total <span><fmt:formatNumber
										value="${total }" type="number" /> vnđ</span></li>
						</ul>
						<c:if test="${listCart.size()!=0 }">
							<a
								href="${pageContext.request.contextPath}/user/cart/checkout.htm?subtotal=${subtotal }&sale=${sale}&total=${total}"
								class="default-btn"> Proceed to Checkout </a>
						</c:if>

					</div>
				</div>
			</div>
		</div>
	</section>
	<script>
	function show(a) {
		
		$("#yesId").click(function() {
			$("#buttonId"+a).click();
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
	<!-- End Cart Area -->

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