<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dashboard</title>
</head>
<body>
	<div class="page-container">

		<div class="left-content">

			<div class="mother-grid-inner">

				<jsp:include page="header.jsp"></jsp:include>

				<div class="inner-block">
					<div class="inbox">
						<h2>Cập nhật Phương thức Thanh toán</h2>
						<div class="col-md-12 compose-right">
							<div class="inbox-details-default">
								<div class="inbox-details-heading">Form chỉnh sửa thông
									tin phương thức thanh toán</div>
								<div class="inbox-details-body">
									<div class="alert alert-info">${message}</div>
									<form class="com-mail"
										action="admin/payment/update.htm?id=${payment.idPayment}"
										method="POST">
										<label>Mã phương thức</label> <input type="text" name="id"
											value="${payment.idPayment}" readonly /> <label>Tên
											sản phẩm</label> <input type="text" name="method"
											value="${payment.method}" /> <br>
										<button type="submit">Cập nhật</button>
									</form>
								</div>
							</div>
						</div>

						<div class="clearfix"></div>
					</div>
				</div>

				<jsp:include page="footer.jsp"></jsp:include>

			</div>

		</div>

		<jsp:include page="navigation.jsp"></jsp:include>

	</div>
</body>
</html>
