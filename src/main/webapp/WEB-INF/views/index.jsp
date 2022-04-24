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
<title>Maxon - AutomobilePartsShopHTMLTemplate</title>

<link rel="icon" type="image/png"
	href="<c:url value='/resources/assets/img/favicon.png'/>" />
</head>

<body>
	<!-- Start header section -->
	<jsp:include page="./layouts/user/header.jsp" flush="true" />
	<!-- / header section -->
	<!-- Start Main Slides Area -->
	<div class="main-slides">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-12"></div>

				<div class="col-lg-9 col-md-12">
					<div class="home-slides owl-carousel owl-theme">
						<div class="main-slides-item item-one">
							<div class="main-slides-content">
								<span>Get 30% Off</span>
								<h1>Automobile Trends Collections</h1>

								<div class="slides-btn">
									<a href="shop.htm?page=1" class="default-btn">Shop Now</a> <a
										href="contact.htm" class="optional-btn">Contact Us</a>
								</div>
							</div>
						</div>

						<div class="main-slides-item item-two">
							<div class="main-slides-content">
								<span>Get 30% Off</span>
								<h1>Modern Top Classic Auto Parts Shop</h1>

								<div class="slides-btn">
									<a href="shop.htm?page=1" " class="default-btn">Shop Now</a> <a
										href="contact.htm" class="optional-btn">Contact Us</a>
								</div>
							</div>
						</div>

						<div class="main-slides-item item-three">
							<div class="main-slides-content">
								<span>Get 30% Off</span>
								<h1>Mega Sale Body Parts Shop For Any Vehicle</h1>

								<div class="slides-btn">
									<a href="shop.htm?page=1" class="default-btn">Shop Now</a> <a
										href="contact.htm" class="optional-btn">Contact Us</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Main Slides Area -->

	<!-- Start Support Area -->
	<section class="support-area">
		<div class="container">
			<div class="custom-row">
				<div class="custom-item">
					<div class="single-support">
						<div class="icon">
							<i class="flaticon-free-delivery"></i>
						</div>

						<div class="support-content">
							<h3>Free Delivery</h3>
							<span>World Wide</span>
						</div>
					</div>
				</div>

				<div class="custom-item">
					<div class="single-support">
						<div class="icon">
							<i class="flaticon-return-of-investment"></i>
						</div>

						<div class="support-content">
							<h3>Easy Returns</h3>
							<span>World Wide</span>
						</div>
					</div>
				</div>

				<div class="custom-item">
					<div class="single-support">
						<div class="icon">
							<i class="flaticon-online-payment"></i>
						</div>

						<div class="support-content">
							<h3>Payment Comfort</h3>
							<span>World Wide</span>
						</div>
					</div>
				</div>

				<div class="custom-item">
					<div class="single-support">
						<div class="icon">
							<i class="flaticon-online-support"></i>
						</div>

						<div class="support-content">
							<h3>Online Support</h3>
							<span>World Wide</span>
						</div>
					</div>
				</div>

				<div class="custom-item">
					<div class="single-support">
						<div class="icon">
							<i class="flaticon-award"></i>
						</div>

						<div class="support-content">
							<h3>Quality Product</h3>
							<span>World Wide</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End Support Area -->

	<!-- Start Products Area -->
	<section class="products-area pt-100 pb-70">
		<div class="container">
			<div class="section-title">
				<h2>Best Selling Products</h2>
				<p>Lorem ipsum dolor sit amet consectetur adipiscing elit sed do
					eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			</div>

			<div class="tab products-list-tab">
				<ul class="tabs">
					<li><a href="#">On Sale</a></li>
					<li><a href="#">Trending</a></li>
				</ul>

				<div class="tab_content">
					<div class="tabs_item">
						<div class="row">
							<c:forEach var="products" items="${productsOnSale }">
								<div class="col-lg-3 col-sm-6">
									<div class="single-products">
										<div class="products-image">
											<a href="shop/product-detail.htm?id=${products.id }"><img
												src="<c:url value='/resources/assets/img/${products.img }'/>"
												alt="image"></a>
											<div class="tag">Sale ${products.sale }%</div>
											<ul class="products-action">
												<li><a href="user/add-to-cart.htm?id=${products.id }">
														<i class="flaticon-shopping-cart"></i>
												</a></li>

											</ul>
										</div>

										<div class="products-content">
											<h3>
												<a href="shop/product-detail.htm?id=${products.id }"
													style="font-size: 20px;">${products.name }</a>
											</h3>
											<ul class="rating">
												<c:choose>
													<c:when test="${products.rate<1 }">
														<li><i class='bx bxs-star-half'></i></li>
													</c:when>
													<c:when test="${products.rate==1 }">
														<li><i class='bx bxs-star'></i></li>
													</c:when>
													<c:when test="${products.rate>1 && products.rate<2 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star-half'></i></li>
													</c:when>
													<c:when test="${products.rate==2 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
													</c:when>
													<c:when test="${products.rate>2 && products.rate<3 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star-half'></i></li>
													</c:when>
													<c:when test="${products.rate==3 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
													</c:when>
													<c:when test="${products.rate>3 && products.rate<4 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star-half'></i></li>
													</c:when>
													<c:when test="${products.rate==4 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
													</c:when>
													<c:when test="${products.rate>4 && products.rate<5 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star-half'></i></li>
													</c:when>
													<c:when test="${products.rate==5 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
													</c:when>
												</c:choose>
											</ul>
											<span style="color: red;">Giá gốc: </span> <span
												style="color: gray; font-weight: 400"><fmt:formatNumber
													value="${products.price }" type="number" /> vnđ</span>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="tabs_item">
						<div class="row">
							<c:forEach var="products" items="${productsTrending }">
								<div class="col-lg-3 col-sm-6">
									<div class="single-products">
										<div class="products-image">
											<a href="shop/product-detail.htm?id=${products.id }"><img
												src="<c:url value='/resources/assets/img/${products.img }'/>"
												alt="image"></a>
											<div class="tag">Sale ${products.sale }%</div>
											<ul class="products-action">
												<li><a href="user/add-to-cart.htm?id=${products.id }">
														<i class="flaticon-shopping-cart"></i>
												</a></li>

											</ul>
										</div>

										<div class="products-content">
											<h3>
												<a href="shop/product-detail.htm?id=${products.id }"
													style="font-size: 20px;">${products.name }</a>
											</h3>
											<ul class="rating">
												<c:choose>
													<c:when test="${products.rate<1 }">
														<li><i class='bx bxs-star-half'></i></li>
													</c:when>
													<c:when test="${products.rate==1 }">
														<li><i class='bx bxs-star'></i></li>
													</c:when>
													<c:when test="${products.rate>1 && products.rate<2 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star-half'></i></li>
													</c:when>
													<c:when test="${products.rate==2 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
													</c:when>
													<c:when test="${products.rate>2 && products.rate<3 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star-half'></i></li>
													</c:when>
													<c:when test="${products.rate==3 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
													</c:when>
													<c:when test="${products.rate>3 && products.rate<4 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star-half'></i></li>
													</c:when>
													<c:when test="${products.rate==4 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
													</c:when>
													<c:when test="${products.rate>4 && products.rate<5 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star-half'></i></li>
													</c:when>
													<c:when test="${products.rate==5 }">
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
														<li><i class='bx bxs-star'></i></li>
													</c:when>
												</c:choose>
											</ul>
											<span style="color: red;">Giá gốc: </span> <span
												style="color: gray; font-weight: 400"><fmt:formatNumber
													value="${products.price }" type="number" /> vnđ</span>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End Products Area -->

	<!-- Start Coming Soon Area -->
	<section class="coming-soon-area ptb-100"></section>
	<!-- End Coming Soon Area -->

	<!-- Start Top Products Area -->
	<section class="top-products-area pt-100 pb-70">
		<div class="container">
			<div class="section-title">
				<h2>Top Products</h2>
				<p>Lorem ipsum dolor sit amet consectetur adipiscing elit sed do
					eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			</div>

			<div class="row">
				<c:forEach var="product" items="${topProducts }">
					<div class="col-lg-3 col-sm-6">
						<div class="single-top-products">
							<div class="top-products-image">
								<a href="shop/product-detail.htm?id=${product.id }"><img
									src="<c:url value='/resources/assets/img/${product.img }'/>"
									alt="image"></a>

								<ul class="top-products-action">
									<li><a href="user/add-to-cart.htm?id=${product.id }">
											<i class="flaticon-shopping-cart"></i>
									</a></li>

								</ul>
							</div>

							<div class="top-products-content">
								<h3>
									<a href="shop/product-detail.htm?id=${product.id }">${product.name }</a>
								</h3>
								<ul class="rating">
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
								<span style="color: red;">Giá gốc: </span> <span
									style="color: gray; font-weight: 400"><fmt:formatNumber
										value="${product.price }" type="number" /> vnđ</span>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>

		<div class="overview-item">
			<div class="container">
				<div class="row">
					<div class="col-lg-6 col-sm-6">
						<div class="overview-image">
							<img
								src="<c:url value='/resources/assets/img/top-product1.jpg'/>"
								alt="image">
						</div>
					</div>

					<div class="col-lg-6 col-sm-6">
						<div class="overview-image">
							<img
								src="<c:url value='/resources/assets/img/top-product2.jpg'/>"
								alt="image">
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End Top Products Area -->

	<!-- Start Categories Area -->
	<section class="categories-area pb-100">
		<div class="container">
			<div class="categories-box">
				<div class="categories-title">
					<h2>Popular Brand</h2>
				</div>

				<div class="categories-row">

					<div class="categories-item">
						<div class="single-categories">
							<div class="categories-image">
								<a
									href="${pageContext.request.contextPath}/shop/filter.htm?page=1&IdBrand=10"">
									<img src="<c:url value='/resources/assets/img/apple.jpg'/>"
									alt="image">
								</a>
							</div>

							<div class="categories-content">
								<h3>
									<a
										href="${pageContext.request.contextPath}/shop/filter.htm?page=1&IdBrand=10">APPLE</a>
								</h3>
							</div>
						</div>
					</div>
					<c:forEach var="brand" items="${ popularBrands }">
						<div class="categories-item">
							<div class="single-categories">
								<div class="categories-image">
									<a
										href="${pageContext.request.contextPath}/shop/filter.htm?page=1&IdBrand=${brand.id }">
										<img
										src="<c:url value='/resources/assets/img/${brand.img }'/>"
										alt="image">
									</a>
								</div>

								<div class="categories-content">
									<h3>
										<a href="shop/product-detail.htm?id=${product.id }">${brand.brand }</a>
									</h3>
								</div>
							</div>
						</div>
					</c:forEach>

				</div>
			</div>
	</section>
	<!-- End Categories Area -->
	<!-- Start f Products Area -->
	<section class="trending-products-area pt-100 pb-100">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-12">
					<div class="trending-products-box">
						<div class="products-box-title">
							<span>For Any Vehicles</span>
							<h2>Body Parts Collection</h2>

							<div class="box-btn">
								<a href="shop.htm?page=1">Shop Now</a>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-9 col-md-12">
					<div class="trending-products-title">
						<h3>Top Trending Products</h3>
					</div>

					<div class="row">
						<c:forEach var="product" items="${topTrendingProducts }">
							<div class="col-lg-3 col-sm-6">
								<div class="single-trending-products">
									<div class="trending-products-image">
										<a href="shop/product-detail.htm?id=${product.id }"> <img
											src="<c:url value='/resources/assets/img/${product.img }'/>"
											alt="image">
										</a>
									</div>

									<div class="trending-products-content">
										<h3>
											<a href="shop/product-detail.htm?id=${product.id }">${product.name }</a>
										</h3>

										<ul class="rating">
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
										<span><fmt:formatNumber value="${product.price }"
												type="number" /> vnđ</span>
									</div>
								</div>
							</div>
						</c:forEach>

					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End Trending Products Area -->

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