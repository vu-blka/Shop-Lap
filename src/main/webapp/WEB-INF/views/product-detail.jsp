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
<base href="${pageContext.servletContext.contextPath}/">
</head>

<body>
	<!-- Start header section -->
	<jsp:include page="./layouts/user/header.jsp" flush="true" />
	<!-- / header section -->

	<!-- Start Page Banner -->
	<div class="page-banner-area item-bg3">
		<div class="d-table">
			<div class="d-table-cell">
				<div class="container">
					<div class="page-banner-content">
						<h2>Products Details</h2>
						<ul>
							<li><a href="/SHOPLAP/index.htm">Home</a></li>
							<li>Products Details</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Page Banner -->

	<!-- Start Products Details Area -->
	<section class="products-details-area ptb-100">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-12">
					<div class="products-details-desc">
						<div class="row align-items-center">
							<div class="col-lg-7 col-md-6">
								<div class="main-products-image">
									<img
										src="<c:url value='/resources/assets/img/${product.img }'/>"
										alt="image">
								</div>
							</div>

							<div class="col-lg-5 col-md-6">
								<div class="product-content">
									<form:form action="user/add-to-cart.htm?id=${product.id }"
										method="post">


										<h3>${product.name }</h3>
										<p>Rate: ${product.rate }</p>
										<div class="product-review">
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
										</div>

										<div class="price">
											<span class="old-price"><fmt:formatNumber
													value="${product.price}" type="number" /></span> <span
												class="new-price">&nbsp;&nbsp;<fmt:formatNumber
													value="${product.price * (100-product.sale) /100 }"
													type="number" /> vnđ
											</span>
										</div>
										<p style="color: black;">
											Brand: <span style="color: red">${product.brand.brand }</span>
										</p>
										<p style="color: black;">
											Category: <span style="color: red">${product.category.category }</span>
										</p>
										<ul class="products-info">
											<li><span>Availability:</span> <a href="#"
												style="color: black;"> <c:choose>
														<c:when test="${product.quantity<=0 }">Out of Stock</c:when>
														<c:when test="${product.quantity>0 }">In Stock</c:when>
													</c:choose>
											</a></li>
										</ul>
										<div class="product-quantities">
											<span>Quantities:</span>

											<div class="input-counter">
												<span class="minus-btn"> <i class='bx bx-minus'></i>
												</span> <input type="text" value="1" name="quantity"> <span
													class="plus-btn"> <i class='bx bx-plus'></i>
												</span>
											</div>
										</div>

										<div class="product-add-to-cart">
											<button class="default-btn">
												<i class="flaticon-shopping-cart"></i> Add to cart <span></span>
											</button>
										</div>
									</form:form>
								</div>
							</div>
						</div>
					</div>

					<div class="products-details-tabs">
						<ul class="nav nav-tabs" id="myTab" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								id="description-tab" data-toggle="tab" href="#description"
								role="tab" aria-controls="description">Description</a></li>
							<li class="nav-item"><a class="nav-link" id="reviews-tab"
								data-toggle="tab" href="#reviews" role="tab"
								aria-controls="reviews">Reviews</a></li>
						</ul>

						<div class="tab-content" id="myTabContent">
							<div class="tab-pane fade show active" id="description"
								role="tabpanel">

								<p style="color: #9c0814; font-size: 20px; font-weight: 500">
									${product.description }</p>
								<h2>Overview</h2>

								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
									sed do eiusmod tempor incididunt ut labore et dolore magna
									aliqua. Ut enim ad minim veniam, quis nostrud exercitation
									ullamco laboris nisi ut aliquip ex ea com modo consequat. Duis
									aute irure dolor in reprehenderit in voluptate velit esse
									cillum dolore fugiat nulla pariatur. Excepteur sint occaecat
									cupidatat non proident.</p>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
									sed do eiusmod tempor incididunt ut labore et dolore magna
									aliqua. Ut enim ad minim veniam, quis nostrud exercitation
									ullamco laboris nisi ut aliquip ex ea com modo consequat. Duis
									aute irure dolor in reprehenderit in voluptate velit esse
									cillum dolore fugiat nulla pariatur.</p>

								<ul>
									<li>It has survived not only five centuries, but also the
										leap into electronic typesetting, remaining essentially
										unchanged.</li>
									<li>Contrary to popular belief, Lorem Ipsum is not simply
										random text.</li>
									<li>The point of using Lorem Ipsum is that it has a
										more-or-less normal distribution of letters.</li>
									<li>Various versions have evolved over the years,
										sometimes by accident sometimes on purpose.</li>
									<li>Duis aute irure dolor in reprehenderit in voluptate
										velit esse cillum dolore fugiat nulla pariatur.</li>
								</ul>
							</div>

							<div class="tab-pane fade" id="reviews" role="tabpanel">
								<div class="products-reviews">
									<h3>Reviews</h3>

									<div class="row">
										<div class="side">
											<div>
												5 <i class='bx bxs-star'></i>
											</div>
										</div>
										<div class="middle">
											<div class="bar-container">
												<div class="bar-5"></div>
											</div>
										</div>
										<div class="side right">
											<div>${per5 }</div>
										</div>
										<div class="side">
											<div>
												4 <i class='bx bxs-star'></i>
											</div>
										</div>
										<div class="middle">
											<div class="bar-container">
												<div class="bar-4"></div>
											</div>
										</div>
										<div class="side right">
											<div>${per4 }</div>
										</div>
										<div class="side">
											<div>
												3 <i class='bx bxs-star'></i>
											</div>
										</div>
										<div class="middle">
											<div class="bar-container">
												<div class="bar-3"></div>
											</div>
										</div>
										<div class="side right">
											<div>${per3 }</div>
										</div>
										<div class="side">
											<div>
												2 <i class='bx bxs-star'></i>
											</div>
										</div>
										<div class="middle">
											<div class="bar-container">
												<div class="bar-2"></div>
											</div>
										</div>
										<div class="side right">
											<div>${per2 }</div>
										</div>
										<div class="side">
											<div>
												1 <i class='bx bxs-star'></i>
											</div>
										</div>
										<div class="middle">
											<div class="bar-container">
												<div class="bar-1"></div>
											</div>
										</div>
										<div class="side right">
											<div>${per1 }</div>
										</div>
									</div>
								</div>

								<div class="products-review-form">
									<h3>Customer Reviews</h3>

									<div class="review-comments">
										<c:forEach var="review" items="${reviews }">
											<div class="review-item">
												<ul class="rating"
													style="list-style-type: none; display: flex;">
													<c:choose>
														<c:when test="${review.star<1 }">
															<i class='bx bxs-star-half'></i>
														</c:when>
														<c:when test="${review.star==1 }">
															<i class='bx bxs-star'></i>
														</c:when>
														<c:when test="${review.star>1 && review.star<2 }">
															<i class='bx bxs-star'></i>
															<i class='bx bxs-star-half'></i>
														</c:when>
														<c:when test="${review.star==2 }">
															<i class='bx bxs-star'></i>
															<i class='bx bxs-star'></i>
														</c:when>
														<c:when test="${review.star>2 && review.star<3 }">
															<i class='bx bxs-star'></i>
															<i class='bx bxs-star'></i>
															<i class='bx bxs-star-half'></i>
														</c:when>
														<c:when test="${review.star==3 }">
															<i class='bx bxs-star'></i>
															<i class='bx bxs-star'></i>
															<i class='bx bxs-star'></i>
														</c:when>
														<c:when test="${review.star>3 && review.star<4 }">
															<i class='bx bxs-star'></i>
															<i class='bx bxs-star'></i>
															<i class='bx bxs-star'></i>
															<i class='bx bxs-star-half'></i>
														</c:when>
														<c:when test="${review.star==4 }">
															<i class='bx bxs-star'></i>
															<i class='bx bxs-star'></i>
															<i class='bx bxs-star'></i>
															<i class='bx bxs-star'></i>
														</c:when>
														<c:when test="${review.star>4 && review.star<5 }">
															<i class='bx bxs-star'></i>
															<i class='bx bxs-star'></i>
															<i class='bx bxs-star'></i>
															<i class='bx bxs-star'></i>
															<i class='bx bxs-star-half'></i>
														</c:when>
														<c:when test="${review.star==5 }">
															<i class='bx bxs-star'></i>
															<i class='bx bxs-star'></i>
															<i class='bx bxs-star'></i>
															<i class='bx bxs-star'></i>
															<i class='bx bxs-star'></i>
														</c:when>
													</c:choose>
												</ul>
												<h3>${review.title }</h3>
												<span><strong>${review.username }</strong> on <strong>${review.createAt }</strong></span>
												<p>${review.content }</p>
											</div>
										</c:forEach>

									</div>
									<c:if test="${showReviewForm==true }">
										<div class="review-form">
											<h3>Write a Review</h3>

											<form:form
												action="${pageContext.request.contextPath}/shop/add-review.htm?id=${product.id }"
												method="post">
												<div class="row">

													<div class="col-lg-12 col-md-12">

														<div class="form-group">
															<c:if test="${sessionScope.username != null}">
																<p style="color: red; font-size: 25px;">From
																	Username: ${username }</p>
															</c:if>
														</div>
													</div>
													<div class="col-lg-9 col-md-9">
														<div class="form-group">
															<input type="text" id="review-title" name="title"
																placeholder="Enter your review a title"
																class="form-control" required="required">
														</div>
													</div>
													<div class="col-lg-3 col-md-3">
														<div class="form-group">

															<select name="star" required="required">
																<option value="5">5</option>
																<option value="4">4</option>
																<option value="3">3</option>
																<option value="2">2</option>
																<option value="1">1</option>
															</select>
														</div>
													</div>
													<div class="col-lg-12 col-md-12">
														<div class="form-group">
															<textarea name="content" id="review-body" cols="30"
																rows="6" placeholder="Write your comments here"
																class="form-control" required="required"></textarea>
														</div>
													</div>



													<div class="col-lg-12 col-md-12">
														<button type="submit" class="default-btn">Submit
															Review</button>

													</div>

												</div>
											</form:form>
										</div>
									</c:if>

								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-4 col-md-12">
					<aside class="widget-area">
						<section class="widget widget_search">
							<h3 class="widget-title">Search</h3>

							<form class="search-form">
								<label> <span class="screen-reader-text">Search
										for:</span> <input type="search" class="search-field"
									placeholder="Search...">
								</label>
								<button type="submit">
									<i class='bx bx-search-alt'></i>
								</button>
							</form>
						</section>

						<section class="widget widget_categories">
							<h3 class="widget-title">Categories</h3>

							<ul>
								<c:forEach var="category" items="${categories }">
									<li><a href="#">${category.category } <i
											class='bx bx-chevron-right'></i></a></li>
								</c:forEach>


							</ul>
						</section>

						<section class="widget widget_maxon_posts_thumb">
							<h3 class="widget-title">Popular Posts</h3>

							<article class="item">
								<a href="#" class="thumb"> <span class="fullimage cover bg1"
									role="img"></span>
								</a>
								<div class="info">
									<span>June 10, 2020</span>
									<h4 class="title usmall">
										<a href="#">The Electric Car isn't Pollution-free they
											have to get there</a>
									</h4>
								</div>
							</article>

							<article class="item">
								<a href="#" class="thumb"> <span class="fullimage cover bg2"
									role="img"></span>
								</a>
								<div class="info">
									<span>June 21, 2020</span>
									<h4 class="title usmall">
										<a href="#">You Can Know That How a Car Runs a Still,
											Enjoy Trip</a>
									</h4>
								</div>
							</article>

							<article class="item">
								<a href="#" class="thumb"> <span class="fullimage cover bg3"
									role="img"></span>
								</a>
								<div class="info">
									<span>June 30, 2020</span>
									<h4 class="title usmall">
										<a href="#">What Is The Cost Of Repairing a Scratch On a
											Car?</a>
									</h4>
								</div>
							</article>
						</section>
					</aside>
				</div>
			</div>
		</div>
	</section>
	<!-- End Products Details Area -->

	<!-- Start Top Products Area -->
	<section class="top-products-area bg-color pt-100 pb-70">
		<div class="container">
			<div class="section-title">
				<h2>Recommend Brand Products</h2>
				<p>Lorem ipsum dolor sit amet consectetur adipiscing elit sed do
					eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			</div>

			<div class="row">
				<c:forEach var="product" items="${productBrand }">
					<div class="col-lg-3 col-sm-6">
						<div class="single-top-products-box">
							<div class="top-products-image">
								<a href="shop/product-detail.htm?id=${product.id }"><img
									src="<c:url value='/resources/assets/img/${product.img }'/>"
									alt="image"></a>

								<ul class="top-products-action">
									<li><a href="cart.html"> <i
											class="flaticon-shopping-cart"></i>
									</a></li>

								</ul>
							</div>

							<div class="top-products-content">
								<h3>
									<a href="products-details.html">${product.name }</a>
								</h3>
								<ul class="rating" style="list-style-type: none; display: flex;">
									<span>&nbsp;</span>
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
									<span class="old-price" style="color: black; margin-left: 70px"><fmt:formatNumber
											value="${product.price}" type="number" />vnđ</span>
								</ul>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
	</section>
	<!-- End Top Products Area -->

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