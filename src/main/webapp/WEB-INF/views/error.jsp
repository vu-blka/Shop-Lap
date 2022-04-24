<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<c:url value='/resources/assets/css/bootstrap.min.css'/>" />
    <!-- Animate CSS -->
    <link rel="stylesheet" href="<c:url value='/resources/assets/css/animate.min.css'/>" />
    <!-- Meanmenu CSS -->
    <link rel="stylesheet" href="<c:url value='/resources/assets/css/meanmenu.css'/>" />
    <!-- Boxicons CSS -->
    <link rel="stylesheet" href="<c:url value='/resources/assets/css/boxicons.min.css'/>" />
    <!-- Flaticon CSS -->
    <link rel="stylesheet" href="<c:url value='/resources/assets/css/flaticon.css'/>" />
    <!-- Owl Carousel CSS -->
    <link rel="stylesheet" href="<c:url value='/resources/assets/css/owl.carousel.min.css'/>" />
    <!-- Owl Theme Default CSS -->
    <link rel="stylesheet" href="<c:url value='/resources/assets/css/owl.theme.default.min.css'/>" />
    <!-- Odometer CSS -->
    <link rel="stylesheet" href="<c:url value='/resources/assets/css/odometer.min.css'/>" />
    <!-- Nice Select CSS -->
    <link rel="stylesheet" href="<c:url value='/resources/assets/css/nice-select.min.css'/>" />
    <!-- Magnific Popup CSS -->
    <link rel="stylesheet" href="<c:url value='/resources/assets/css/magnific-popup.min.css'/>" />
    <!-- Imagelightbox CSS -->
    <link rel="stylesheet" href="<c:url value='/resources/assets/css/imagelightbox.min.css'/>" />
    <!-- Style CSS -->
    <link rel="stylesheet" href="<c:url value='/resources/assets/css/style.css'/>" />
    <!-- Responsive CSS -->
    <link rel="stylesheet" href="<c:url value='/resources/assets/css/responsive.css'/>" />

    <title>Maxon - Automobile Parts Shop HTML Template</title>

    <link rel="icon" type="image/png" href="<c:url value='/resources/assets/img/favicon.png'/>" />
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
              <h2>Error Page</h2>
              <ul>
                <li>
                  <a href="index.html">Home</a>
                </li>
                <li>Error Page</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- End Page Banner -->

    <!-- Start Error Area -->
    <section class="error-area ptb-100">
      <div class="d-table">
        <div class="d-table-cell">
          <div class="container">
            <div class="error-content">
              <img src="<c:url value='/resources/assets/img/404.png'/>" alt="error" />

              <h3>Error 404 : page not found</h3>
              <p>
                The page you are looking for might have been removed had its
                name changed or is temporarily unavailable.
              </p>

              <a href="${pageContext.request.contextPath}/index.htm" class="default-btn">Go To Home</a>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- End Error Area -->

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
    <script src="<c:url value='/resources/assets/js/jquery.magnific-popup.min.js'/>"></script>
    <!-- Imagelightbox JS -->
    <script src="<c:url value='/resources/assets/js/imagelightbox.min.js'/>"></script>
    <!-- Odometer JS -->
    <script src="<c:url value='/resources/assets/js/odometer.min.js'/>"></script>
    <!-- Jquery Nice Select JS -->
    <script src="<c:url value='/resources/assets/js/jquery.nice-select.min.js'/>"></script>
    <!-- Jquery Appear JS -->
    <script src="<c:url value='/resources/assets/js/jquery.appear.min.js'/>"></script>
    <!-- Ajaxchimp JS -->
    <script src="<c:url value='/resources/assets/js/jquery.ajaxchimp.min.js'/>"></script>
    <!-- Form Validator JS -->
    <script src="<c:url value='/resources/assets/js/form-validator.min.js'/>"></script>
    <!-- Contact JS -->
    <script src="<c:url value='/resources/assets/js/contact-form-script.js'/>"></script>
    <!-- Wow JS -->
    <script src="<c:url value='/resources/assets/js/wow.min.js'/>"></script>
    <!-- Custom JS -->
    <script src="<c:url value='/resources/assets/js/main.js'/>"></script>
  </body>
</html>