<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>header</title>

<script type="application/x-javascript">
	
	
	
	
	
	
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 











</script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<link
	href="${pageContext.request.contextPath}/resources/admin/css/bootstrap.css"
	rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link
	href="${pageContext.request.contextPath}/resources/admin/css/style.css"
	rel='stylesheet' type='text/css' />
<!--js-->
<script
	src="${pageContext.request.contextPath}/resources/admin/js/jquery-2.1.1.min.js"></script>
<!--icons-css-->
<link
	href="${pageContext.request.contextPath}/resources/admin/css/font-awesome.css"
	rel="stylesheet" type="text/css" />
<!--Google Fonts-->
<link href='//fonts.googleapis.com/css?family=Carrois+Gothic'
	rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Work+Sans:400,500,600'
	rel='stylesheet' type='text/css'>
<!--static chart-->
<script
	src="${pageContext.request.contextPath}/resources/admin/js/Chart.min.js"></script>
<!--//charts-->
<!-- geo chart -->
<script
	src="${pageContext.request.contextPath}/resources/admin/js/modernizr.min.js"
	type="text/javascript"></script>
<script>
	window.modernizr
			|| document
					.write('<script src="lib/modernizr/modernizr-custom.js"><\/script>')
</script>
<!--<script src="lib/html5shiv/html5shiv.js"></script>-->
<!-- Chartinator  -->
<script
	src="${pageContext.request.contextPath}/resources/admin/js/chartinator.js"></script>
<script type="text/javascript">
	jQuery(function($) {

		var chart3 = $('#geoChart').chartinator(
				{
					tableSel : '.geoChart',

					columns : [ {
						role : 'tooltip',
						type : 'string'
					} ],

					colIndexes : [ 2 ],

					rows : [ [ 'China - 2015' ], [ 'Colombia - 2015' ],
							[ 'France - 2015' ], [ 'Italy - 2015' ],
							[ 'Japan - 2015' ], [ 'Kazakhstan - 2015' ],
							[ 'Mexico - 2015' ], [ 'Poland - 2015' ],
							[ 'Russia - 2015' ], [ 'Spain - 2015' ],
							[ 'Tanzania - 2015' ], [ 'Turkey - 2015' ] ],

					ignoreCol : [ 2 ],

					chartType : 'GeoChart',

					chartAspectRatio : 1.5,

					chartZoom : 1.75,

					chartOffset : [ -12, 0 ],

					chartOptions : {

						width : null,

						backgroundColor : '#fff',

						datalessRegionColor : '#F5F5F5',

						region : 'world',

						resolution : 'countries',

						legend : 'none',

						colorAxis : {

							colors : [ '#679CCA', '#337AB7' ]
						},
						tooltip : {

							trigger : 'focus',

							isHtml : true
						}
					}

				});
	});
</script>

<script
	src="${pageContext.request.contextPath}/resources/admin/js/skycons.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/resources/admin/js/jquery.nicescroll.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/admin/js/scripts.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/resources/admin/js/bootstrap.js"></script>
<base href="${pageContext.servletContext.contextPath }/">
</head>
<body>

	<div class="header-main">
		<div class="header-left">
			<div class="logo-name">
				<a href="admin/index.htm">
					<h1>ShopLap</h1> <!--<img id="logo" src="" alt="Logo"/>-->
				</a>
			</div>
			<!--search-box-->

			<!--//end-search-box-->
			<div class="clearfix"></div>
		</div>
		<div class="header-right">
			<div class="profile_details_left">
				<!--notifications of menu start -->
				<ul class="nofitications-dropdown">
					<li class="dropdown head-dpdn"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"
						aria-expanded="false"><i class="fa fa-envelope"></i><span
							class="badge">${sizeMessage }</span></a>
						<ul class="dropdown-menu">
							<li>
								<div class="notification_header">
									<h3>You have ${sizeMessage } new messages</h3>
								</div>
							</li>
							<c:forEach var="item" items="${listMessage }">
								<li><a href="#">
										<div class="user_img">
											<img src="images/p4.png" alt="">
										</div>
										<div class="notification_desc">
											<p>Tin nhắn mới từ ${item.email }</p>
											<p>
												<span>${item.subject }</span>
											</p>
										</div>
										<div class="clearfix"></div>
								</a></li>
							</c:forEach>



							<li>
								<div class="notification_bottom">
									<a href="#">See all messages</a>
								</div>
							</li>
						</ul></li>
					<li class="dropdown head-dpdn"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"
						aria-expanded="false"><i class="fa fa-bell"></i><span
							class="badge blue">${size }</span></a>
						<ul class="dropdown-menu">
							<li>
								<div class="notification_header">
									<h3>You have ${size } new notification</h3>
								</div>
							</li>
							<c:forEach var="item" items="${listNull }">
								<li><a
									href="${pageContext.request.contextPath}/admin/bill/detail.htm?id=${item.idOrdered}">
										<div class="user_img">
											<img src="images/p5.png" alt="">
										</div>
										<div class="notification_desc">
											<p>Mã đơn hàng: ${item.idOrdered}</p>
											<p>
												<span>Chưa kiểm duyệt</span>
											</p>
										</div>
										<div class="clearfix"></div>
								</a></li>
							</c:forEach>



							<li>
								<div class="notification_bottom">
									<a
										href="${pageContext.request.contextPath}/admin/bill.htm?page=1">See
										all notifications</a>
								</div>
							</li>
						</ul></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<!--notification menu end -->
			<div class="profile_details">
				<ul>
					<li class="dropdown profile_details_drop"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"
						aria-expanded="false">
							<div class="profile_img">
								<span> <img src="resources/admin/images/p1.png" alt="">
								</span>

								<div class="user-name">
									<p>${sessionScope.adminsession.username}</p>
									<span>${sessionScope.adminsession.fullname}</span>
								</div>
								<i class="fa fa-angle-down lnr"></i> <i
									class="fa fa-angle-up lnr"></i>
								<div class="clearfix"></div>
							</div>
					</a>
						<ul class="dropdown-menu drp-mnu">

							<li><a
								href="${pageContext.request.contextPath}/admin/logout.htm"><i
									class="fa fa-sign-out"></i> Logout</a></li>
							<li><a
								href="${pageContext.request.contextPath}/admin/change-password.htm"><i
									class="fa fa-sign-out"></i> Change Password</a></li>
						</ul></li>
				</ul>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
	</div>
	<!--heder end here-->
	<!-- script-for sticky-nav -->
	<script>
		$(document).ready(function() {
			var navoffeset = $(".header-main").offset().top;
			$(window).scroll(function() {
				var scrollpos = $(window).scrollTop();
				if (scrollpos >= navoffeset) {
					$(".header-main").addClass("fixed");
				} else {
					$(".header-main").removeClass("fixed");
				}
			});

		});
	</script>

</body>
</html>
