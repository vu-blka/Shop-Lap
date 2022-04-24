<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>navigation</title>
</head>
<body>

	<div class="sidebar-menu">
		<div class="menu">
			<ul id="menu">
	
				<li><a
					href="${pageContext.request.contextPath}/admin/category.htm"><i
						class="fa fa-tags"></i><span>Category</span></a></li>
				<li><a
					href="${pageContext.request.contextPath}/admin/brand.htm"><i
						class="fa fa-tags"></i><span>Brand</span></a></li>
				<li><a
					href="${pageContext.request.contextPath}/admin/product.htm?page=1"><i
						class="fa fa-copy"></i><span>Product</span></a></li>
				<li><a
					href="${pageContext.request.contextPath}/admin/user.htm?page=1"><i
						class="fa fa-users"></i><span>User</span></a></li>
				<li><a
					href="${pageContext.request.contextPath}/admin/admin.htm?page=1"><i
						class="fa fa-users"></i><span>Admin</span></a></li>
				<li><a href="${pageContext.request.contextPath}/admin/bill.htm?page=1"><i
						class="fa fa-money"></i><span>Bill</span></a></li>
						<li><a href="${pageContext.request.contextPath}/admin/payment.htm"><i
						class="fa fa-money"></i><span>Payment</span></a></li>
						<li><a href="${pageContext.request.contextPath}/admin/shipping.htm"><i
						class="fa fa-money"></i><span>Shipping</span></a></li>
						<li><a href="${pageContext.request.contextPath}/admin/message.htm"><i
						class="fa fa-money"></i><span>Message</span></a></li>
			</ul>
		</div>
	</div>
	<div class="clearfix"></div>

	<!--slide bar menu end here-->
	<script>
		var toggle = true;

		$(".sidebar-icon").click(
				function() {
					if (toggle) {
						$(".page-container").addClass("sidebar-collapsed")
								.removeClass("sidebar-collapsed-back");
						$("#menu span").css({
							"position" : "absolute"
						});
					} else {
						$(".page-container").removeClass("sidebar-collapsed")
								.addClass("sidebar-collapsed-back");
						setTimeout(function() {
							$("#menu span").css({
								"position" : "relative"
							});
						}, 400);
					}
					toggle = !toggle;
				});
	</script>

</body>
</html>
