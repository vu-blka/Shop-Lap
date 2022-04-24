<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<title>Maxon - AutomobilePartsShopHTMLTemplate</title>

<link rel="icon" type="image/png"
	href="<c:url value='/resources/assets/img/favicon.png'/>" />
<base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
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
						<li><i class="flaticon-clock"></i>STORE: EVERYDAY 7:00 AM -
							10:00 PM</li>
					</ul>
				</div>

				<div class="col-lg-6 col-md-12">
					<ul class="top-header-optional">
						<li>Currency: <b>VND</b></li>

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
							<li><a><strong>Chào &nbsp</strong> <span
									style="color: red"> <b>${ sessionScope.username}</b>
								</span> </a></li>

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
						<a href="index.htm"> <img
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

								<c:forEach var="category" items="${categories}">
									<li><a
										href="${pageContext.request.contextPath}/shop/filter.htm?page=1&IdCategory=${category.id }&&IdBrand=">Category:
											${category.category }</a></li>
								</c:forEach>
								<c:forEach var="brand" items="${brands}">
									<li><a
										href="${pageContext.request.contextPath}/shop/filter.htm?page=1&IdBrand=${brand.id }&IdCategory=">Brand:
											${brand.brand }</a></li>
								</c:forEach>


							</ul>
						</div>
						<!-- End Load List Category -->
					</div>

					<a class="navbar-brand" href="index.htm"> <img
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
								class="nav-link"> My Account </a></li>
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
	<!-- End Navbar Area -->
</body>
</html>