<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
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
<style type="text/css">
</style>
</head>

<body>

	<!-- Start header section -->
	<!-- Start Preloader Area -->
	<div class="preloader">
		<div class="loader">
			<div class="sbl-half-circle-spin">
				<div></div>
			</div>
		</div>
	</div>
	<!-- End Preloader Area -->

	<!-- Start Top Header Area -->
	<div class="top-header-area">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-6 col-md-12">
					<ul class="top-header-information">
						<li><i class="flaticon-clock"></i> Monday 8:00 AM - 12:00 PM</li>
					</ul>
				</div>

				<div class="col-lg-6 col-md-12">
					<ul class="top-header-optional">
						<li>Currency: <b>USD</b></li>

						<li>
							<div class="dropdown language-switcher d-inline-block">
								<button class="dropdown-toggle" type="button"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">
									<span>Language <i class='bx bx-chevron-down'></i></span>
								</button>

								<div class="dropdown-menu">
									<a href="#" class="dropdown-item d-flex align-items-center">
										<img src="<c:url value='/resources/assets/img/english.png'/>"
										class="shadow-sm" alt="flag"> <span>English</span>
									</a> <a href="#" class="dropdown-item d-flex align-items-center">
										<img src="<c:url value='/resources/assets/img/english.png'/>"
										class="shadow-sm" alt="flag"> <span>Vietnam</span>
									</a>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End Top Header Area -->

	<!-- Start Middle Header Area -->
	<div class="middle-header-area">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-2">
					<div class="middle-header-logo">
						<a href="${pageContext.request.contextPath}/index.htm"><img
							src="<c:url value='/resources/assets/img/logo.png'/>" alt="logo"></a>
					</div>
				</div>

				<div class="col-lg-3">
					<div class="middle-header-search">
						<form class="search-form"
							action="${pageContext.request.contextPath}/shop/search.htm">
							<input name="page" value="1" style="display: none" /> <label>
								<span class="screen-reader-text">Search for:</span> <input
								type="search" class="search-field"
								placeholder="Search the entire store here" name="keyword">
							</label>

							<button type="submit">
								<i class='bx bx-search-alt'></i>
							</button>
						</form>
					</div>
				</div>

				<div class="col-lg-7">
					<ul class="middle-header-optional">
						<li><a
							href="${pageContext.request.contextPath}/user/cart.htm"><i
								class="flaticon-shopping-cart"><span>${quantityInCart }</span></i>
								Add to Cart</a></li>

						<c:if test="${sessionScope.username == null}">
							<li><a href="/SHOPLAP/user/login.htm" class="user-btn"><i
									class='flaticon-enter'></i>Login</a></li>
							<li><a href="/SHOPLAP/user/register.htm" class="user-btn"><i
									class='flaticon-enter'></i>Register</a></li>
						</c:if>
						<c:if test="${sessionScope.username != null}">
							<li><a><strong>Chào &nbsp</strong> ${username }</a></li>

							<li><a
								href="${pageContext.request.contextPath}/user/logout.htm"
								class="user-btn"><i class='flaticon-enter'></i>Đăng Xuất</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End Middle Header Area -->

	<!-- Start Navbar Area -->
	<div class="navbar-area">
		<div class="main-responsive-nav">
			<div class="container">
				<div class="main-responsive-menu">
					<div class="logo">
						<a href="${pageContext.request.contextPath}/index.htm"> <img
							src="<c:url value='/resources/assets/img/logo.png'/>" alt="image">
						</a>
					</div>
				</div>
			</div>
		</div>

		<div class="main-navbar">
			<div class="container">
				<nav class="navbar navbar-expand-md navbar-light">
					<div class="navbar-category">
						<div class="category-title">
							<a href="${pageContext.request.contextPath}/shop.htm?page=1">Shop
								Department</a>
						</div>
						<!-- Start Load List Category -->
						<div class="navbar-category-dropdown">
							<ul class="category-list">




							</ul>
						</div>
						<!-- End Load List Category -->
					</div>

					<a class="navbar-brand"
						href="${pageContext.request.contextPath}/index.htm"> <img
						src="<c:url value='/resources/assets/img/logo-2.png'/>"
						alt="image">
					</a>

					<div class="collapse navbar-collapse mean-menu"
						id="navbarSupportedContent">
						<ul class="navbar-nav m-auto">
							<li class="nav-item"><a
								href="${pageContext.request.contextPath}/index.htm"
								class="nav-link active"> Home </a></li>
							<li class="nav-item"><a
								href="${pageContext.request.contextPath}/shop.htm?page=1"
								class="nav-link"> Shop </a></li>
							<li class="nav-item"><a
								href="${pageContext.request.contextPath}/user/my-account.htm"
								class="nav-link"> My account </a></li>
							<li class="nav-item"><a
								href="${pageContext.request.contextPath}/user/ordered.htm"
								class="nav-link"> Ordered </a></li>
							<li class="nav-item"><a
								href="${pageContext.request.contextPath}/contact.htm"
								class="nav-link"> Contact </a></li>
						</ul>

						<div class="others-option d-flex align-items-center">
							<div class="option-item"></div>
						</div>
					</div>
				</nav>
			</div>
		</div>

		<div class="others-option-for-responsive">
			<div class="container">
				<div class="dot-menu">
					<div class="inner">
						<div class="circle circle-one"></div>
						<div class="circle circle-two"></div>
						<div class="circle circle-three"></div>
					</div>
				</div>

				<div class="container">
					<div class="option-inner">
						<div class="others-option d-flex align-items-center">
							<div class="option-item"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- / header section -->

	<!-- Start Page Banner -->
	<div class="page-banner-area item-bg4">
		<div class="d-table">
			<div class="d-table-cell">
				<div class="container">
					<div class="page-banner-content">
						<h2>${title }</h2>
						<ul>
							<li><a href="/SHOPLAP/index.htm">Home</a></li>
							<li>${title }</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Page Banner -->

	<!-- Start Shop Area -->
	<section class="shop-area ptb-100">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-12">
					<div class="shop-category">
						<div class="category-title">
							<a href="${pageContext.request.contextPath}/shop.htm?page=1">Shop
								Department</a>
						</div>

						<div class="shop-category-menu">
							<ul class="category-list">
								<c:if test="${showb!=0 }">
									<c:forEach var="category" items="${categories}">
										<li><a
											href="${pageContext.request.contextPath}/shop/filter.htm?page=1&IdCategory=${category.id }&IdBrand=${idbrand } ">Category:
												${category.category }</a></li>
									</c:forEach>
									<c:forEach var="brand" items="${brandList}">
										<li><a
											href="${pageContext.request.contextPath}/shop/filter.htm?page=1&IdBrand=${brand.id }&IdCategory=${idcategory } ">Brand:
												${brand.brand }</a></li>
									</c:forEach>
								</c:if>
								<c:if test="${showb==0 }">
									<c:forEach var="category" items="${categories}">
										<li><a
											href="${pageContext.request.contextPath}/shop/filter.htm?page=1&IdCategory=${category.id }&IdBrand=${idbrand } ">Category:
												${category.category }</a></li>
									</c:forEach>
									<c:forEach var="brand" items="${brandList}">
										<li><a
											href="${pageContext.request.contextPath}/shop/filter.htm?page=1&IdBrand=${brand.id }&IdCategory=${idcategory } ">Brand:
												${brand.brand }</a></li>
									</c:forEach>
								</c:if>

							</ul>
						</div>
					</div>


				</div>

				<div class="col-lg-9 col-md-12">
					<c:if test="${listSize==0 }">
						<p style="color: black; font-size: 30px">
							<b>Hiện không có sản phẩm!!!</b>
						</p>
					</c:if>
					<c:forEach var="product" items="${listShow }">
						<div class="shop-item-box">
							<div class="row align-items-center">
								<div class="col-lg-3 col-sm-3">
									<div class="shop-image">
										<a
											href="${pageContext.request.contextPath}/shop/product-detail.htm?id=${product.id }">
											<img
											src="<c:url value='/resources/assets/img/${product.img }'/>"
											alt="image">
										</a>
									</div>
								</div>

								<div class="col-lg-6 col-sm-6">
									<div class="shop-content">
										<h3>
											<a
												href="${pageContext.request.contextPath}/shop/product-detail.htm?id=${product.id }">${product.name }</a>
										</h3>
										<div class="rating">
											<ul class="rating"
												style="list-style-type: none; display: flex;">
												<c:choose>
													<c:when test="${product.rate<1 }">
														<li><i class='bx bxs-star-half'></i></li>
													</c:when>
													<c:when test="${product.rate==1 }">
														<li><i class='bx bxs-star'></i></li>
													</c:when>
													<c:when test="${product.rate>1 && product.rate<2 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star-half'></i></li>
													</c:when>
													<c:when test="${product.rate==2 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
													</c:when>
													<c:when test="${product.rate>2 && product.rate<3 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star-half'></i></li>
													</c:when>
													<c:when test="${product.rate==3 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
													</c:when>
													<c:when test="${product.rate>3 && product.rate<4 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star-half'></i></li>
													</c:when>
													<c:when test="${product.rate==4 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
													</c:when>
													<c:when test="${product.rate>4 && product.rate<5 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star-half'></i></li>
													</c:when>
													<c:when test="${product.rate==5 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
													</c:when>
												</c:choose>
											</ul>
											Sold: ${product.quantitySold }</a>
										</div>

										<ul class="shop-list" style="color: black; font-weight: 500">
											<li>Category: ${product.category.category }</li>
											<li>Description: ${product.description }</li>
											<li>Price: <fmt:formatNumber value="${product.price}"
													type="number" />vnđ
											</li>
											<li>Sale: ${product.sale }%</li>
											<li>Quantity: ${product.quantity }</li>
										</ul>
									</div>
								</div>

								<div class="col-lg-3 col-sm-3">
									<ul class="shop-btn-list">
										<li><span class="old-price"
											style="text-decoration-line: line-through; color: gray; font-size: 13px;"><fmt:formatNumber
													value="${product.price}" type="number" /></span> <span
											class="new-price">&nbsp;<fmt:formatNumber
													value="${product.price * (100-product.sale) /100 }"
													type="number" /> vnđ
										</span></li>
										<li><a href="user/add-to-cart.htm?id=${product.id }">Add
												To Cart</a></li>

									</ul>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<c:if test="${listSize!=0 }">
			<div class="col-lg-12 col-md-12">
				<div class="pagination-area">

					<c:if test="${page!=1 }">
						<c:if test="${shown==0 }">
							<a
								href="${pageContext.request.contextPath}/shop/filter.htm?page=${page-1 }&IdBrand=${idbrand }&IdCategory=${idcategory } "
								class="prev page-numbers"> <i class='bx bxs-chevron-left'></i>
							</a>
						</c:if>
						<c:if test="${shown!=0 }">
							<a
								href="${pageContext.request.contextPath}/shop.htm?page=${page-1 }&keyword=${keyword}"
								class="prev page-numbers"> <i class='bx bxs-chevron-left'></i>
							</a>
						</c:if>

					</c:if>
					<span class="page-numbers current" aria-current="page"
						style="cursor: pointer">${page }</span>
					<c:if test="${totalPage!=page }">
						<c:if test="${shown!=0 }">
							<a
								href="${pageContext.request.contextPath}/shop.htm?page=${page+1}&keyword=${keyword}"
								class="page-numbers">${page+1 }</a>
							<a
								href="${pageContext.request.contextPath}/shop.htm?page=${page+1}&keyword=${keyword}"
								class="next page-numbers"> <i class='bx bxs-chevron-right'></i>
							</a>
						</c:if>
						<c:if test="${shown==0 }">
							<a
								href="${pageContext.request.contextPath}/shop/filter.htm?page=${page+1 }&IdBrand=${idbrand }&IdCategory=${idcategory }"
								class="page-numbers">${page+1 }</a>
							<a
								href="${pageContext.request.contextPath}/shop/filter.htm?page=${page+1 }&IdBrand=${idbrand }&IdCategory=${idcategory }"
								class="next page-numbers"> <i class='bx bxs-chevron-right'></i>
							</a>
						</c:if>
					</c:if>


				</div>
			</div>
		</c:if>


	</section>
	<!-- End Shop Area -->

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